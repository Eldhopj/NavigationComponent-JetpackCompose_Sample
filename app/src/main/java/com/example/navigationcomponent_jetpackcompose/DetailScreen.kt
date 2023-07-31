package com.example.navigationcomponent_jetpackcompose

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun DetailScreen(
    id: Int = 0,
    name: String = "",
    backToHome: () -> Unit = {}
) {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = "Detail id $id name $name",
            Modifier.clickable {
                backToHome()
            }
        )
    }
}

@Composable
@Preview
fun DetailScreenPreview() {
    DetailScreen()
}


