package com.dlrjsgml.hiltman.ui.component.button

import androidx.compose.foundation.Image
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Paint
import androidx.compose.ui.graphics.painter.Painter
import com.dlrjsgml.hiltman.ui.component.animation.bounceClick

@Composable
fun MyIconButton(
    modifier: Modifier = Modifier,
    content: Painter,
    onClick: () -> Unit,
) {
    Image(
        modifier = modifier.bounceClick { onClick() },
        painter = content,
        contentDescription = null
    )
}