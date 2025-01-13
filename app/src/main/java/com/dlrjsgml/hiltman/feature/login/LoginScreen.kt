package com.dlrjsgml.hiltman.feature.login

import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.scrollable
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
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.dlrjsgml.hiltman.ui.component.appbar.MyTopAppBar
import com.dlrjsgml.hiltman.ui.component.button.MyButton
import com.dlrjsgml.hiltman.ui.component.textfield.MyTextField
import com.dlrjsgml.hiltman.ui.component.textfield.MyTextFieldState
import com.dlrjsgml.hiltman.ui.theme.White
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@Composable
fun LoginScreen() {
    var idText by remember { mutableStateOf("") }
    var pwText by remember { mutableStateOf("") }
    var idError by remember { mutableStateOf(MyTextFieldState.DEFAULT) }
    var pwError by remember { mutableStateOf(MyTextFieldState.DEFAULT) }
    val verticalScroll = rememberScrollState()
    MyTopAppBar(
        modifier = Modifier.imePadding(),
        title = "로그인",
    ) { paddingValues ->
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
                info = "이메일",
                hint = ""
            )
            Spacer(Modifier.height(8.dp))
            MyTextField(
                modifier = Modifier.padding(horizontal = 8.dp),
                value = pwText,
                info = "비밀번호",
                onValueChange = { pwText = it
                    pwError = MyTextFieldState.DEFAULT},
                hint = ""
            )
            Spacer(modifier = Modifier.weight(1f))
            MyButton(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 16.dp),
                text = "시작하기",
                onClick = {
                    idError =MyTextFieldState.ERROR
                    pwError = MyTextFieldState.ERROR
                },
                contentPadding = PaddingValues(vertical = 17.5.dp)
            )
        }

    }
}


@Preview
@Composable
private fun LoginScreenPreview() {
    LoginScreen()
}