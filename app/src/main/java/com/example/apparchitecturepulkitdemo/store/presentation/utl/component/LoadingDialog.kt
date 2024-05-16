package com.example.apparchitecturepulkitdemo.store.presentation.utl.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties

@Composable
fun LoadingDialog() {
    Dialog(
        onDismissRequest = { /*TODO*/ },
        properties = DialogProperties(
            dismissOnBackPress = false,
            dismissOnClickOutside = false
        ),
    ) {
        Box(
            modifier = Modifier
                .width(200.dp)
                .clip(RoundedCornerShape(15.dp))
                .background(color = White),
        ) {
            CircularProgressIndicator(
                modifier = Modifier
                    .padding(10.dp),
                progress =  1f

            )
        }

    }

}

@Preview(showBackground = true, locale = "en")
@Composable
fun PreviewLoadingDialog() {
    LoadingDialog()
}
