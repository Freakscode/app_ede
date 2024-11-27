package com.example.appede.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.unit.dp
import com.example.appede.ui.theme.AppEDETheme

@Composable
fun HelloWorld(
    modifier: Modifier = Modifier
) {

    Text(
        modifier = modifier
            .padding(16.dp),
        text = "Hello World!",
        fontWeight = FontWeight.Bold,
        color = Color.Blue
    )
}

@Preview(
    showBackground = true
)
@Composable
fun HelloWorldPreview() {
    AppEDETheme {
        HelloWorld()
    }
}

@Composable
fun IconExample(
    modifier: Modifier = Modifier,
    iconContainer: IconContainer
)
{
    Icon(
        imageVector = iconContainer.icon,
        contentDescription = "Favorite",
        modifier = modifier
            .padding(8.dp)
    )
}

@Preview(
    showBackground = true
)
@Composable
fun IconExamplePreview(
    @PreviewParameter(IconProvider::class) icon : IconContainer
) {
    AppEDETheme {
        IconExample(
            iconContainer = icon
        )
    }
}

@Composable
fun RowView(){
    Row(
        modifier = Modifier
            .background(Color.LightGray)
            .padding(8.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        HelloWorld()
        IconExample(
            iconContainer = IconContainer(
                Icons.Default.Favorite
            )
        )
    }
}

@Preview(
    showBackground = true
)
@Composable
fun RowViewPreview() {
    AppEDETheme {
        RowView()
    }
}
