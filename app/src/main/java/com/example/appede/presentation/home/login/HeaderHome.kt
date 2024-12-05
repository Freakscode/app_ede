package com.example.appede.presentation.home.login
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.TextStyle

import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.appede.ui.theme.AppEDETheme

@Composable
fun HeaderHome(
    modifier: Modifier = Modifier,
    title: String = "DAGRD - APP EDE",
    subtitle: String = "EVALUACIÓN DE DAÑOS EN EDIFICACIONES"
){
    Column(
        modifier = modifier
            .fillMaxWidth()
            .height(100.dp)
            .clip(RoundedCornerShape(bottomStart = 30.dp, bottomEnd = 30.dp))
            .background(MaterialTheme.colorScheme.primary)
            .padding(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,

    ) {

        Text(
            text = title,
            style = TextStyle(
                fontSize = 30.sp
            ),
            color = MaterialTheme.colorScheme.onPrimary,
            fontWeight = FontWeight.Bold
        )
        Text(
            text = subtitle,
            style = TextStyle(
                fontSize = 16.sp
            ),
            color = MaterialTheme.colorScheme.onPrimary,
            fontWeight = FontWeight.Normal,
            textAlign = TextAlign.Center
        )
    }

}

@Preview(
    showBackground = false,
)
@Composable
fun HeaderHomePreview() {
    AppEDETheme {
        HeaderHome()
    }
}

