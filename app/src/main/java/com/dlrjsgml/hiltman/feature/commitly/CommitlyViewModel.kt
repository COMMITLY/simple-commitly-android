package com.dlrjsgml.hiltman.feature.commitly

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dlrjsgml.hiltman.feature.commitly.effect.MakeCommitlyEffect
import com.dlrjsgml.hiltman.feature.commitly.state.CommitlyInfo
import com.dlrjsgml.hiltman.feature.commitly.state.MakeCommitlyState
import com.dlrjsgml.hiltman.network.get.GetMakeCommitMessagesService
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CommitlyViewModel @Inject constructor(private val getMakeCommitMessagesService: GetMakeCommitMessagesService) :
    ViewModel() {
    private val _uiState = MutableStateFlow(MakeCommitlyState())
    val uiState = _uiState.asStateFlow()
    private val _uiEffect = MutableSharedFlow<MakeCommitlyEffect>()
    val uiEffect = _uiEffect.asSharedFlow()
    fun getMakeCommitMessages(userName: String, date: String) {
        viewModelScope.launch(Dispatchers.IO) {
            _uiState.value = _uiState.value.copy(isLoading = true)
            try{
                val response = getMakeCommitMessagesService.getMakeCommitMessages(userName, date)
                _uiState.value = _uiState.value.copy(isLoading = false, data = CommitlyInfo(response.data.toString()))
                _uiEffect.emit(MakeCommitlyEffect.Success)
            } catch (e:Exception){
                Log.d("하이", "에러 : $e");
                _uiState.value = _uiState.value.copy(isLoading = false, data = CommitlyInfo("실패"))
                _uiEffect.emit(MakeCommitlyEffect.Failed)
            }

        }

    }

}