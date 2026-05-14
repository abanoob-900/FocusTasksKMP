package com.bob.focustasks.model

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector

data class ScheduleItem(
    val title: String,
    val time: String,
    val tag: String,
    val icon: ImageVector,
    val baseColor: Color,
    val contentColor: Color
)