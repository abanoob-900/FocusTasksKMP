package com.bob.focustasks.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

object AppColors {
    val Background = Color(0xFFF7F7FC)
    val Card = Color(0xFFFFFFFF)
    val Primary = Color(0xFF4B35E8)
    val PrimaryLight = Color(0xFFECEAFF)
    val TextPrimary = Color(0xFF1B1D2A)
    val TextSecondary = Color(0xFF6F7284)
    val Border = Color(0xFFDADDEB)

    val PersonalBg = Color(0xFFFFEEE5)
    val PersonalText = Color(0xFFB45E30)

    val HealthBg = Color(0xFFFFEAEA)
    val HealthText = Color(0xFFC94848)
}

private val LightScheme = lightColorScheme(
    primary = AppColors.Primary,
    background = AppColors.Background,
    surface = AppColors.Card,
    onPrimary = Color.White,
    onBackground = AppColors.TextPrimary,
    onSurface = AppColors.TextPrimary
)

@Composable
fun FocusTasksTheme(content: @Composable () -> Unit) {
    MaterialTheme(
        colorScheme = LightScheme,
        content = content
    )
}