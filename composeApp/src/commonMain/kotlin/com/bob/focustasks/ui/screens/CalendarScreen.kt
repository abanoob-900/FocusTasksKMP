package com.bob.focustasks.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.bob.focustasks.model.CalendarDay
import com.bob.focustasks.model.ScheduleItem
import com.bob.focustasks.ui.theme.AppColors
import com.bob.focustasks.ui.theme.AppColors.Background
import com.bob.focustasks.ui.theme.AppColors.Primary

@Composable
fun CalendarScreen() {

    // Dummy data to match the screenshot
    val scheduleItems = listOf(
        ScheduleItem(
            title = "Review design specs", time = "2:00 PM", tag = "Work",
            icon = Icons.Rounded.WorkOutline,
            baseColor = Color(0xFFE8E5FA), contentColor = Primary
        ),
        ScheduleItem(
            title = "Focus session", time = "4:30 PM", tag = "Deep Focus",
            icon = Icons.Rounded.Adjust,
            baseColor = Color(0xFFFCEAE0), contentColor = Color(0xFFB05020)
        ),
        ScheduleItem(
            title = "Evening yoga", time = "7:00 PM", tag = "Health",
            icon = Icons.Rounded.SelfImprovement,
            baseColor = Color(0xFFEAECEF), contentColor = Color(0xFF4A4A4A)
        )
    )

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Background)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize(),
        ) {
            TopBarSection(Primary)

            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = 16.dp),
                contentPadding = PaddingValues(bottom = 56.dp)
            ) {
                item { CalendarSection(Primary) }

                item {
                    Text(
                        text = "Today's Schedule",
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.Black,
                        modifier = Modifier.padding(top = 24.dp, bottom = 16.dp)
                    )
                }

                items(scheduleItems) { item ->
                    ScheduleCard(item)
                    Spacer(modifier = Modifier.height(12.dp))
                }
            }
        }


        FloatingActionButton(
            onClick = { /* Handle Add Task */ },
            containerColor = Primary,
            contentColor = Color.White,
            shape = CircleShape,
            modifier = Modifier
                .align(Alignment.BottomEnd)
                .padding(end = 16.dp, bottom = 16.dp)
        ) {
            Icon(
                Icons.Rounded.Add,
                contentDescription = "Add Task",
                modifier = Modifier.size(28.dp)
            )
        }
    }
}

@Composable
private fun TopBarSection(Primary: Color) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            imageVector = Icons.Rounded.Menu,
            contentDescription = "Menu",
            tint = Primary,
            modifier = Modifier
                .size(28.dp)
                .clickable { }
        )
        Spacer(modifier = Modifier.width(16.dp))
        Column(modifier = Modifier.weight(1f)) {
            Text(
                text = "Focus Tasks",
                fontSize = 22.sp,
                fontWeight = FontWeight.Bold,
                color = Primary
            )
            Text(
                text = "Plan your schedule",
                fontSize = 14.sp,
                color = Color.Gray
            )
        }
        // Avatar Placeholder
        Box(
            modifier = Modifier
                .size(42.dp)
                .clip(CircleShape)
                .background(Color(0xFFD8D0C4))
                .border(
                    width = 2.dp,
                    color = AppColors.Primary,
                    shape = CircleShape
                ),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = "A",
                color = AppColors.TextPrimary,
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold
            )
        }
    }
}

@Composable
private fun CalendarSection(Primary: Color) {
    Column {
        Row(
            modifier = Modifier.fillMaxWidth().padding(bottom = 16.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "October 2023",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black
            )
            Row {
                Icon(
                    imageVector = Icons.Rounded.ChevronLeft,
                    contentDescription = "Previous",
                    modifier = Modifier.clickable { }
                )
                Spacer(modifier = Modifier.width(16.dp))
                Icon(
                    imageVector = Icons.Rounded.ChevronRight,
                    contentDescription = "Next",
                    modifier = Modifier.clickable { }
                )
            }
        }

        Card(
            modifier = Modifier.fillMaxWidth(),
            colors = CardDefaults.cardColors(containerColor = Color.White),
            shape = RoundedCornerShape(16.dp),
            elevation = CardDefaults.cardElevation(defaultElevation = 0.dp)
        ) {
            Column(modifier = Modifier.padding(16.dp)) {
                // Days of week
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    listOf("S", "M", "T", "W", "T", "F", "S").forEach { day ->
                        Text(
                            text = day,
                            fontSize = 12.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color.Gray,
                            modifier = Modifier.weight(1f),
                            textAlign = TextAlign.Center
                        )
                    }
                }
                Spacer(modifier = Modifier.height(16.dp))

                // Static grid generation to match screenshot
                val weeks = listOf(
                    listOf(
                        CalendarDay("28", false),
                        CalendarDay("29", false),
                        CalendarDay("30", false),
                        CalendarDay("1", true),
                        CalendarDay("2", true),
                        CalendarDay("3", true),
                        CalendarDay("4", true)
                    ),
                    listOf(
                        CalendarDay("5", true),
                        CalendarDay("6", true),
                        CalendarDay("7", true),
                        CalendarDay("8", true),
                        CalendarDay("9", true),
                        CalendarDay("10", true),
                        CalendarDay("11", true)
                    ),
                    listOf(
                        CalendarDay("12", true, eventColors = listOf(Primary)),
                        CalendarDay(
                            "13",
                            true,
                            eventColors = listOf(Color(0xFFB05020), Primary)
                        ),
                        CalendarDay("14", true),
                        CalendarDay("15", true, isSelected = true),
                        CalendarDay("16", true),
                        CalendarDay("17", true),
                        CalendarDay("18", true)
                    )
                )

                weeks.forEach { week ->
                    Row(
                        modifier = Modifier.fillMaxWidth().padding(bottom = 12.dp),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        week.forEach { day ->
                            CalendarDayItem(
                                day = day,
                                Primary = Primary,
                                modifier = Modifier.weight(1f)
                            )
                        }
                    }
                }
            }
        }
    }
}

@Composable
private fun CalendarDayItem(day: CalendarDay, Primary: Color, modifier: Modifier) {
    Column(
        modifier = modifier.height(40.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Box(
            modifier = Modifier
                .size(32.dp)
                .clip(CircleShape)
                .background(if (day.isSelected) Primary else Color.Transparent)
                .clickable { },
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = day.dayNumber,
                color = if (day.isSelected) Color.White else if (day.isCurrentMonth) Color.Black else Color.LightGray,
                fontSize = 14.sp,
                fontWeight = if (day.isSelected || day.isCurrentMonth) FontWeight.Medium else FontWeight.Normal
            )
        }

        // Event Dots
        if (day.isSelected) {
            Row(
                horizontalArrangement = Arrangement.spacedBy(2.dp),
                modifier = Modifier.padding(top = 2.dp)
            ) {
                Box(modifier = Modifier.size(4.dp).clip(CircleShape).background(Color.White))
                Box(modifier = Modifier.size(4.dp).clip(CircleShape).background(Color.White))
            }
        } else if (day.eventColors.isNotEmpty()) {
            Row(
                horizontalArrangement = Arrangement.spacedBy(2.dp),
                modifier = Modifier.padding(top = 2.dp)
            ) {
                day.eventColors.forEach { color ->
                    Box(modifier = Modifier.size(4.dp).clip(CircleShape).background(color))
                }
            }
        } else {
            Spacer(modifier = Modifier.height(6.dp)) // Maintain alignment
        }
    }
}

@Composable
private fun ScheduleCard(item: ScheduleItem) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        shape = RoundedCornerShape(16.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 0.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            // Icon Box
            Box(
                modifier = Modifier
                    .size(48.dp)
                    .background(item.baseColor, RoundedCornerShape(12.dp)),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    imageVector = item.icon,
                    contentDescription = null,
                    tint = item.contentColor,
                    modifier = Modifier.size(24.dp)
                )
            }
            Spacer(modifier = Modifier.width(16.dp))

            // Texts
            Column(modifier = Modifier.weight(1f)) {
                Text(
                    text = item.title,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.Black
                )
                Spacer(modifier = Modifier.height(4.dp))
                // Tag Box
                Box(
                    modifier = Modifier
                        .background(item.baseColor, RoundedCornerShape(6.dp))
                        .padding(horizontal = 8.dp, vertical = 2.dp)
                ) {
                    Text(
                        text = item.tag,
                        fontSize = 10.sp,
                        fontWeight = FontWeight.Bold,
                        color = item.contentColor
                    )
                }
            }

            // Time
            Text(
                text = item.time,
                fontSize = 12.sp,
                color = Color.Gray,
                fontWeight = FontWeight.Medium
            )
        }
    }
}

@Preview
@Composable
fun CalendarScreenPreview() {
    CalendarScreen()
}