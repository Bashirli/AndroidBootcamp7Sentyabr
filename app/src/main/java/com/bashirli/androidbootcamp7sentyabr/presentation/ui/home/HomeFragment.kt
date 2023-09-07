package com.bashirli.androidbootcamp7sentyabr.presentation.ui.home

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import com.bashirli.androidbootcamp7sentyabr.R
import com.bashirli.androidbootcamp7sentyabr.common.BaseFragment
import com.bashirli.androidbootcamp7sentyabr.data.dto.UserDTO
import com.bashirli.androidbootcamp7sentyabr.databinding.FragmentHomeBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : BaseFragment<FragmentHomeBinding>(FragmentHomeBinding::inflate) {

        private val viewModel by viewModels<HomeMVVM>()


    override fun onViewCreateFinished() {
        observeData()
    }

    override fun setup() {
        with(binding){

            val u1=UserDTO(
                1,"A","B"
            )

            val u2=UserDTO(
                2,"C","S"
            )

            val u3=UserDTO(
                3,"F","B"
            )

            val u4=UserDTO(
                4,"Q","E"
            )



            buttonDelete.setOnClickListener {
                viewModel.deleteData(u2)
            }

            buttonInsert.setOnClickListener {
                viewModel.insertData(u1)
            }

            buttonGetData.setOnClickListener {
                viewModel.getAllData()
            }


        }
    }

    private fun observeData(){
        viewModel.liveData.observe(viewLifecycleOwner){
            when(it){
                is HomeMVVM.HomeUiState.Error -> Toast.makeText(requireContext(),it.message,Toast.LENGTH_LONG).show()
                HomeMVVM.HomeUiState.Loading -> Unit
                is HomeMVVM.HomeUiState.UserData -> Log.e("data",it.data.toString())
            }
        }

    }


}