package com.bashirli.androidbootcamp7sentyabr.presentation.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bashirli.androidbootcamp7sentyabr.common.Resource
import com.bashirli.androidbootcamp7sentyabr.data.dto.UserDTO
import com.bashirli.androidbootcamp7sentyabr.domain.useCase.LocalUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeMVVM  @Inject constructor(
    private val localUseCase: LocalUseCase
) : ViewModel() {

    private val _liveData = MutableLiveData<HomeUiState>()
    val liveData : LiveData<HomeUiState> get()=_liveData

    fun insertData(userDTO: UserDTO){
            viewModelScope.launch {
                localUseCase.insertData(userDTO)
            }
    }

    fun deleteData(userDTO: UserDTO){
            viewModelScope.launch {
                localUseCase.deleteData(userDTO)
            }
    }

    fun getAllData(){
        viewModelScope.launch {
            localUseCase.getAllData().collectLatest {
                when(it){
                    is Resource.Error -> _liveData.value=HomeUiState.Error(it.message)
                    Resource.Loading -> _liveData.value=HomeUiState.Loading
                    is Resource.Success -> _liveData.value=HomeUiState.UserData(it.result ?: emptyList())
                }
            }
        }
    }


    sealed class HomeUiState(){

        data class Error(val message:String) : HomeUiState()

        object Loading : HomeUiState()

        data class UserData(val data:List<UserDTO>) : HomeUiState()


    }

}

