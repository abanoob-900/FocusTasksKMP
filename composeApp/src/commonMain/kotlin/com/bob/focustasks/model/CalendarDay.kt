package com.bob.focustasks.model

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector

data class CalendarDay(
    val dayNumber: String,
    val isCurrentMonth: Boolean,
    val isSelected: Boolean = false,
    val eventColors: List<Color> = emptyList()
)
