package com.dlrjsgml.hiltman.ui.component.textfield

import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.dlrjsgml.hiltman.ui.theme.Black
import com.dlrjsgml.hiltman.ui.theme.ErrorRed
import com.dlrjsgml.hiltman.ui.theme.Gray
import com.dlrjsgml.hiltman.ui.theme.Gray40
import com.dlrjsgml.hiltman.ui.theme.WhiteGray
import com.dlrjsgml.hiltman.ui.theme.body1_bold
import com.dlrjsgml.hiltman.ui.theme.body1_medium
import com.dlrjsgml.hiltman.ui.theme.body2_bold
import com.dlrjsgml.hiltman.ui.theme.body2_medium


enum class MyTextFieldState {
    ERROR, DEFAULT, FOCUS
}

@Composable
fun MyTextField(
    modifier: Modifier = Modifier,
    value: String,
    onValueChange: (String) -> Unit,
    hint: String,
    info: String = "",
    singleLine: Boolean = true,
    enabled: Boolean = true,
    state: MyTextFieldState = MyTextFieldState.DEFAULT,
    maxLines: Int = 1,
    minLines: Int = 1,
    shape: Shape = RoundedCornerShape(4.dp),
) {
    var isFocused by remember { mutableStateOf(state) } // 상태를 Compose에서 관리
    val animBorderColor by animateColorAsState(
        targetValue = when (isFocused) {
            MyTextFieldState.DEFAULT -> WhiteGray
            MyTextFieldState.ERROR -> ErrorRed
            MyTextFieldState.FOCUS -> Gray
        },
        label = "",
    )
    Column(modifier = modifier) {
        if (info.isNotEmpty()) {
            Text(info, style = body2_medium, color = Gray40)
            Spacer(modifier = Modifier.height(8.dp))
        }
        BasicTextField(modifier = Modifier
            .fillMaxWidth()
            .border(width = 1.dp, color = animBorderColor, shape = shape)
            .background(WhiteGray, shape = shape)
            .onFocusChanged { focusState ->
                isFocused = if (focusState.isFocused) {
                    MyTextFieldState.FOCUS
                } else {
                    state
                }
            }
            .padding(start = 12.dp)
            .padding(vertical = 12.dp),
            value = value,
            minLines = minLines,
            enabled = enabled,
            singleLine = singleLine,
            onValueChange = onValueChange,
            textStyle = body1_medium,
            maxLines = maxLines,
            decorationBox = { innerTextField ->
                if (value.isEmpty()) {
                    Text(
                        modifier = Modifier.padding(start = 2.dp),
                        text = hint,
                        style = body1_medium,
                        color = Black
                    )
                }
                innerTextField()
            })
    }

}

@Preview
@Composable
private fun Sjkdkja() {
    MyTextField(
        value = "",
        onValueChange = {},
        hint = "",
        info = "이메일"
    )
}
