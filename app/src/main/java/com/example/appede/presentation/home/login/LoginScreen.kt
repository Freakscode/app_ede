package com.example.appede.presentation.home.login

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.Alignment
import androidx.compose.ui.tooling.preview.Preview
import com.example.appede.presentation.home.FooterHome
import com.example.appede.ui.theme.AppEDETheme

@Composable
fun HomeScreen() {
    Box(
        modifier = Modifier.fillMaxSize()
    )
    {
        Column (
            modifier = Modifier.fillMaxSize()
        ){
            HeaderHome()
            LoginForm(
                modifier = Modifier.weight(1f)
            )
        }

        FooterHome(
            modifier = Modifier.align(Alignment.BottomCenter)
        )
    }
}

@Composable
@Preview(
    showBackground = true,
)
fun HomeScreenPreview() {
    AppEDETheme {
        HomeScreen()
    }
}

