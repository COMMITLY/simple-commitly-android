package com.dlrjsgml.hiltman.feature.commitly

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.dlrjsgml.hiltman.feature.commitly.effect.MakeCommitlyEffect
import com.dlrjsgml.hiltman.ui.component.animation.noRippleClickable
import com.dlrjsgml.hiltman.ui.component.appbar.MyTopAppBar
import com.dlrjsgml.hiltman.ui.component.button.MyButton
import com.dlrjsgml.hiltman.ui.component.datepicker.DatePickerModal
import com.dlrjsgml.hiltman.ui.component.textfield.MyTextField
import com.dlrjsgml.hiltman.ui.component.textfield.MyTextFieldState
import com.dlrjsgml.hiltman.ui.theme.White
import com.dlrjsgml.hiltman.ui.theme.heading1_medium
import dagger.hilt.android.lifecycle.HiltViewModel
import java.text.SimpleDateFormat
import java.util.Locale

@Composable
fun CommitlyScreen(
    viewModel: CommitlyViewModel = hiltViewModel()
) {
    val uiState by viewModel.uiState.collectAsState()
    var idText by remember { mutableStateOf("") }
    var pwText by remember { mutableStateOf("") }
    var idError by remember { mutableStateOf(MyTextFieldState.DEFAULT) }
    var pwError by remember { mutableStateOf(MyTextFieldState.DEFAULT) }
    val verticalScroll = rememberScrollState()
    var modalChecker by remember { mutableStateOf(false) }
    LaunchedEffect(viewModel) {
        viewModel.uiEffect.collect { effect ->
            when (effect) {
                MakeCommitlyEffect.Failed -> {
                    Log.d("하이", "실패 ${uiState.data}");}
                MakeCommitlyEffect.Success -> {Log.d("하이", "성공 ${uiState.data}");}
            }
        }

    }
    MyTopAppBar(
        modifier = Modifier.imePadding(),
        title = "내 회고록 만들기",
    ) { paddingValues ->
        if (modalChecker) {
            DatePickerModal(
                onDateSelected ={
                    val dateFormat = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())
                    pwText = dateFormat.format(it)
                    modalChecker = false
                    Log.d("로오그", "dlrjsgml44 Ok $pwText");
                },
                onDismiss = { modalChecker = false }
            )
        }
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(White)
                .padding(paddingValues)
                .verticalScroll(verticalScroll)
        ) {
            MyTextField(
                modifier = Modifier.padding(horizontal = 8.dp),
                value = idText,
                onValueChange = {
                    idText = it
                    idError = MyTextFieldState.DEFAULT
                },
                state = idError,
                info = "당신의 아이디를 적으십시오",
                hint = ""
            )
            Spacer(Modifier.height(8.dp))
            MyTextField(
                modifier = Modifier
                    .padding(horizontal = 8.dp)
                    .noRippleClickable { modalChecker = true },
                value = pwText,
                enabled = false,
                info = "언제의 회고록이 필요한지요",
                onValueChange = {
                    pwText = it
                    pwError = MyTextFieldState.DEFAULT
                },
                hint = ""
            )
            Box(modifier = Modifier.align(Alignment.CenterHorizontally)){
                if(uiState.isLoading){
                    CircularProgressIndicator()
                } else {
                    Text(text = "리스폰스: ${uiState.data?.gptResponse ?: "이날의 커밋이 없습니다이" }", style = heading1_medium)
                }

            }

            Spacer(modifier = Modifier.weight(1f))
            MyButton(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 16.dp),
                text = "시작하기",
                onClick = {
                    viewModel.getMakeCommitMessages(idText,pwText)
                },
                contentPadding = PaddingValues(vertical = 17.5.dp)
            )

        }

    }
}

@Preview
@Composable
private fun CommitlyScreenPreview() {
    CommitlyScreen()
}