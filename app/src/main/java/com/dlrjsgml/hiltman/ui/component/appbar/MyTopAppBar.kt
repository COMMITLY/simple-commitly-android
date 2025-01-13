package com.dlrjsgml.hiltman.ui.component.appbar

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.dlrjsgml.hiltman.R
import com.dlrjsgml.hiltman.ui.component.button.MyIconButton
import com.dlrjsgml.hiltman.ui.theme.White

private val paddingValues = PaddingValues(top = 10.dp, start = 15.dp, bottom = 0.dp, end = 15.dp)

enum class TopAppBarType {
    DEFAULT, SMALL
}

@Composable
fun MyTopAppBar(
    modifier: Modifier = Modifier,
    backgroundColor: Color = White,
    type: TopAppBarType = TopAppBarType.DEFAULT,
    title: String,
    onBackClick: () -> Unit = {},
    content: @Composable (PaddingValues) -> Unit,
) {
    Column {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(54.dp)
                .background(backgroundColor)
                .statusBarsPadding()
        ) {
            if (type == TopAppBarType.SMALL) {
                Spacer(modifier = Modifier.width(10.dp))
                MyIconButton(
                    modifier = Modifier.align(Alignment.CenterVertically),
                    content = painterResource(R.drawable.ic_baseline_arrow_back_ios_new_24),
                    onClick = onBackClick
                )
                Spacer(modifier = Modifier.width(4.dp))

            }
            if(type == TopAppBarType.DEFAULT){
                Spacer(modifier = Modifier.width(14.dp))
            }

            Text(modifier = Modifier.align(Alignment.CenterVertically), text = title, style = when(type){
                TopAppBarType.DEFAULT -> com.dlrjsgml.hiltman.ui.theme.heading2_medium
                TopAppBarType.SMALL -> com.dlrjsgml.hiltman.ui.theme.heading3_medium

            })
        }
        Box(modifier = Modifier.weight(1f)) {
            content(paddingValues)
        }
    }
}

@Preview
@Composable
private fun MyTopAppBarPreView(){
    MyTopAppBar(
        title = "로그인",
        type = TopAppBarType.DEFAULT,
        content = {}
    )
}