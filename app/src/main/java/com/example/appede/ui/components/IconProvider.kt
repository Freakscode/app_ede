package com.example.appede.ui.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Done
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.ui.tooling.preview.PreviewParameterProvider

class IconProvider:PreviewParameterProvider<IconContainer> {
    override val values: Sequence<IconContainer>
        get() = sequenceOf(
            IconContainer(Icons.Default.Favorite),
            IconContainer(Icons.Default.Add),
            IconContainer(Icons.Default.Done),
            IconContainer(Icons.Default.Edit),
        )
}