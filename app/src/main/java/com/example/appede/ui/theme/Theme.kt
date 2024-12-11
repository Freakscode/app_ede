package com.example.appede.ui.theme

import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.traceEventEnd
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import com.example.myapplication.theme.backgroundDark
import com.example.myapplication.theme.backgroundLight
import com.example.myapplication.theme.errorContainerDark
import com.example.myapplication.theme.errorContainerLight
import com.example.myapplication.theme.errorDark
import com.example.myapplication.theme.errorLight
import com.example.myapplication.theme.inverseOnSurfaceDark
import com.example.myapplication.theme.inverseOnSurfaceLight
import com.example.myapplication.theme.inversePrimaryDark
import com.example.myapplication.theme.inversePrimaryLight
import com.example.myapplication.theme.inverseSurfaceDark
import com.example.myapplication.theme.inverseSurfaceLight
import com.example.myapplication.theme.onBackgroundDark
import com.example.myapplication.theme.onBackgroundLight
import com.example.myapplication.theme.onErrorContainerDark
import com.example.myapplication.theme.onErrorContainerLight
import com.example.myapplication.theme.onErrorDark
import com.example.myapplication.theme.onErrorLight
import com.example.myapplication.theme.onPrimaryContainerDark
import com.example.myapplication.theme.onPrimaryContainerLight
import com.example.myapplication.theme.onPrimaryDark
import com.example.myapplication.theme.onPrimaryLight
import com.example.myapplication.theme.onSecondaryContainerDark
import com.example.myapplication.theme.onSecondaryContainerLight
import com.example.myapplication.theme.onSecondaryDark
import com.example.myapplication.theme.onSecondaryLight
import com.example.myapplication.theme.onSurfaceDark
import com.example.myapplication.theme.onSurfaceLight
import com.example.myapplication.theme.onSurfaceVariantDark
import com.example.myapplication.theme.onSurfaceVariantLight
import com.example.myapplication.theme.onTertiaryContainerDark
import com.example.myapplication.theme.onTertiaryContainerLight
import com.example.myapplication.theme.onTertiaryDark
import com.example.myapplication.theme.onTertiaryLight
import com.example.myapplication.theme.outlineDark
import com.example.myapplication.theme.outlineLight
import com.example.myapplication.theme.outlineVariantDark
import com.example.myapplication.theme.outlineVariantLight
import com.example.myapplication.theme.primaryContainerDark
import com.example.myapplication.theme.primaryContainerLight
import com.example.myapplication.theme.primaryDark
import com.example.myapplication.theme.primaryLight
import com.example.myapplication.theme.scrimDark
import com.example.myapplication.theme.scrimLight
import com.example.myapplication.theme.secondaryContainerDark
import com.example.myapplication.theme.secondaryContainerLight
import com.example.myapplication.theme.secondaryDark
import com.example.myapplication.theme.secondaryLight
import com.example.myapplication.theme.surfaceBrightDark
import com.example.myapplication.theme.surfaceBrightLight
import com.example.myapplication.theme.surfaceContainerDark
import com.example.myapplication.theme.surfaceContainerHighDark
import com.example.myapplication.theme.surfaceContainerHighLight
import com.example.myapplication.theme.surfaceContainerHighestDark
import com.example.myapplication.theme.surfaceContainerHighestLight
import com.example.myapplication.theme.surfaceContainerLight
import com.example.myapplication.theme.surfaceContainerLowDark
import com.example.myapplication.theme.surfaceContainerLowLight
import com.example.myapplication.theme.surfaceContainerLowestDark
import com.example.myapplication.theme.surfaceContainerLowestLight
import com.example.myapplication.theme.surfaceDark
import com.example.myapplication.theme.surfaceDimDark
import com.example.myapplication.theme.surfaceDimLight
import com.example.myapplication.theme.surfaceLight
import com.example.myapplication.theme.surfaceVariantDark
import com.example.myapplication.theme.surfaceVariantLight
import com.example.myapplication.theme.tertiaryContainerDark
import com.example.myapplication.theme.tertiaryContainerLight
import com.example.myapplication.theme.tertiaryDark
import com.example.myapplication.theme.tertiaryLight

private val lightScheme = lightColorScheme(
    primary = primaryLight,
    onPrimary = onPrimaryLight,
    primaryContainer = primaryContainerLight,
    onPrimaryContainer = onPrimaryContainerLight,
    secondary = secondaryLight,
    onSecondary = onSecondaryLight,
    secondaryContainer = secondaryContainerLight,
    onSecondaryContainer = onSecondaryContainerLight,
    tertiary = tertiaryLight,
    onTertiary = onTertiaryLight,
    tertiaryContainer = tertiaryContainerLight,
    onTertiaryContainer = onTertiaryContainerLight,
    error = errorLight,
    onError = onErrorLight,
    errorContainer = errorContainerLight,
    onErrorContainer = onErrorContainerLight,
    background = backgroundLight,
    onBackground = onBackgroundLight,
    surface = surfaceLight,
    onSurface = onSurfaceLight,
    surfaceVariant = surfaceVariantLight,
    onSurfaceVariant = onSurfaceVariantLight,
    outline = outlineLight,
    outlineVariant = outlineVariantLight,
    scrim = scrimLight,
    inverseSurface = inverseSurfaceLight,
    inverseOnSurface = inverseOnSurfaceLight,
    inversePrimary = inversePrimaryLight,
    surfaceDim = surfaceDimLight,
    surfaceBright = surfaceBrightLight,
    surfaceContainerLowest = surfaceContainerLowestLight,
    surfaceContainerLow = surfaceContainerLowLight,
    surfaceContainer = surfaceContainerLight,
    surfaceContainerHigh = surfaceContainerHighLight,
    surfaceContainerHighest = surfaceContainerHighestLight,
)

private val darkScheme = darkColorScheme(
    primary = primaryDark,
    onPrimary = onPrimaryDark,
    primaryContainer = primaryContainerDark,
    onPrimaryContainer = onPrimaryContainerDark,
    secondary = secondaryDark,
    onSecondary = onSecondaryDark,
    secondaryContainer = secondaryContainerDark,
    onSecondaryContainer = onSecondaryContainerDark,
    tertiary = tertiaryDark,
    onTertiary = onTertiaryDark,
    tertiaryContainer = tertiaryContainerDark,
    onTertiaryContainer = onTertiaryContainerDark,
    error = errorDark,
    onError = onErrorDark,
    errorContainer = errorContainerDark,
    onErrorContainer = onErrorContainerDark,
    background = backgroundDark,
    onBackground = onBackgroundDark,
    surface = surfaceDark,
    onSurface = onSurfaceDark,
    surfaceVariant = surfaceVariantDark,
    onSurfaceVariant = onSurfaceVariantDark,
    outline = outlineDark,
    outlineVariant = outlineVariantDark,
    scrim = scrimDark,
    inverseSurface = inverseSurfaceDark,
    inverseOnSurface = inverseOnSurfaceDark,
    inversePrimary = inversePrimaryDark,
    surfaceDim = surfaceDimDark,
    surfaceBright = surfaceBrightDark,
    surfaceContainerLowest = surfaceContainerLowestDark,
    surfaceContainerLow = surfaceContainerLowDark,
    surfaceContainer = surfaceContainerDark,
    surfaceContainerHigh = surfaceContainerHighDark,
    surfaceContainerHighest = surfaceContainerHighestDark,
)

@Immutable
data class ColorFamily(
    val color: Color,
    val onColor: Color,
    val colorContainer: Color,
    val onColorContainer: Color
)

val unspecified_scheme = ColorFamily(
    Color.Unspecified, Color.Unspecified, Color.Unspecified, Color.Unspecified
)

@Composable
fun AppEDETheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    // Dynamic color is available on Android 12+
    dynamicColor: Boolean = true,
    content: @Composable() () -> Unit
) {
  val colorScheme = when {
      dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
          val context = LocalContext.current
          if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
      }
      
      darkTheme -> darkScheme
      else -> lightScheme
  }

  MaterialTheme(
    colorScheme = colorScheme,
    typography = AppTypography,
    content = content
  )
}

