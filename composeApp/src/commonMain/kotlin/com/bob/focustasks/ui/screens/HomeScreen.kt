package com.bob.focustasks.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.clickable
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.rounded.CheckCircle
import androidx.compose.material.icons.rounded.Menu
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.FloatingActionButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.bob.focustasks.ui.theme.AppColors

@Composable
fun HomeScreen(
    onAddTaskClick: () -> Unit
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(AppColors.Background)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(
                    top = 16.dp,
                    start = 16.dp,
                    end = 16.dp
                )
        ) {
            HomeHeader()

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .verticalScroll(rememberScrollState())
                    .padding(bottom = 16.dp)
            ) {
                Spacer(modifier = Modifier.height(36.dp))

                ProgressCard()

                Spacer(modifier = Modifier.height(28.dp))

                SectionHeader()

                Spacer(modifier = Modifier.height(12.dp))

                TaskCard(
                    title = "Review design specs",
                    subtitle = "Due today • 2:00 PM",
                    category = "Work",
                    categoryType = CategoryType.Work,
                    completed = false
                )

                Spacer(modifier = Modifier.height(14.dp))

                TaskCard(
                    title = "Buy groceries",
                    subtitle = "Organic milk, fruits, and bread",
                    category = "Personal",
                    categoryType = CategoryType.Personal,
                    completed = false
                )

                Spacer(modifier = Modifier.height(14.dp))

                TaskCard(
                    title = "Team sync meeting",
                    subtitle = "Completed at 10:30 AM",
                    category = "Work",
                    categoryType = CategoryType.Work,
                    completed = true
                )

                Spacer(modifier = Modifier.height(14.dp))

                TaskCard(
                    title = "Evening Yoga Session",
                    subtitle = "Focus on breathing and stretching",
                    category = "Health",
                    categoryType = CategoryType.Health,
                    completed = false
                )
            }
        }

        FloatingActionButton(
            onClick = onAddTaskClick,
            containerColor = AppColors.Primary,
            contentColor = Color.White,
            elevation = FloatingActionButtonDefaults.elevation(8.dp),
            modifier = Modifier
                .align(Alignment.BottomEnd)
                .padding(end = 22.dp, bottom = 16.dp)
        ) {
            Text(
                text = "+",
                fontSize = 34.sp,
                fontWeight = FontWeight.Light
            )
        }
    }
}

@Composable
private fun HomeHeader() {
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            imageVector = Icons.Default.Menu,
            contentDescription = "Home Icon",
            tint = AppColors.Primary,
            modifier = Modifier
                .size(24.dp)
        )

        Spacer(modifier = Modifier.width(16.dp))

        Column(
            modifier = Modifier.weight(1f)
        ) {
            Text(
                text = "Focus Tasks",
                color = AppColors.Primary,
                fontSize = 23.sp,
                fontWeight = FontWeight.Bold
            )

            Text(
                text = "Organize your day",
                color = AppColors.TextPrimary,
                fontSize = 13.sp
            )
        }

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
private fun ProgressCard() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(16.dp))
            .background(AppColors.Card)
            .padding(22.dp)
    ) {
        Text(
            text = "DAILY PROGRESS",
            color = AppColors.Primary,
            fontSize = 11.sp,
            fontWeight = FontWeight.Bold,
            letterSpacing = 1.2.sp
        )

        Spacer(modifier = Modifier.height(8.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "3 of 5 tasks completed",
                color = AppColors.TextPrimary,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.weight(1f)
            )

            Text(
                text = "60%",
                color = AppColors.Primary,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold
            )
        }

        Spacer(modifier = Modifier.height(18.dp))

        LinearProgressIndicator(
            progress = { 0.6f },
            color = AppColors.Primary,
            trackColor = AppColors.Border,
            modifier = Modifier
                .fillMaxWidth()
                .height(10.dp)
                .clip(RoundedCornerShape(20.dp))
        )

        Spacer(modifier = Modifier.height(18.dp))

        Text(
            text = "\"Success is the sum of small efforts repeated daily.\"",
            color = AppColors.TextSecondary,
            fontSize = 14.sp,
            fontStyle = FontStyle.Italic,
            lineHeight = 20.sp
        )
    }
}

@Composable
private fun SectionHeader() {
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = "Current Tasks",
            color = AppColors.TextPrimary,
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.weight(1f)
        )

        TextButton(onClick = {}) {
            Text(
                text = "VIEW ALL",
                color = AppColors.Primary,
                fontSize = 12.sp,
                fontWeight = FontWeight.Bold
            )
        }
    }
}

enum class CategoryType {
    Work,
    Personal,
    Health
}

@Composable
private fun TaskCard(
    title: String,
    subtitle: String,
    category: String,
    categoryType: CategoryType,
    completed: Boolean
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(76.dp)
            .clip(RoundedCornerShape(14.dp))
            .background(AppColors.Card)
            .padding(horizontal = 14.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        TaskCheckBox(completed = completed)

        Spacer(modifier = Modifier.width(14.dp))

        Column(
            modifier = Modifier.weight(1f)
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = title,
                    color = if (completed) AppColors.TextSecondary else AppColors.TextPrimary,
                    fontSize = 15.sp,
                    fontWeight = FontWeight.Medium,
                    textDecoration = if (completed) TextDecoration.LineThrough else TextDecoration.None
                )

                Spacer(modifier = Modifier.width(8.dp))

                CategoryBadge(
                    text = category,
                    type = categoryType
                )
            }

            Spacer(modifier = Modifier.height(7.dp))

            Text(
                text = subtitle,
                color = AppColors.TextSecondary,
                fontSize = 13.sp
            )
        }

        Text(
            text = "⋮",
            color = AppColors.Border,
            fontSize = 22.sp
        )
    }
}

@Composable
private fun TaskCheckBox(completed: Boolean) {
    Box(
        modifier = Modifier
            .size(23.dp)
            .clip(RoundedCornerShape(6.dp))
            .background(if (completed) Color(0xFF9E91F5) else Color.Transparent)
            .border(
                width = 2.dp,
                color = if (completed) Color(0xFF9E91F5) else AppColors.TextSecondary,
                shape = RoundedCornerShape(6.dp)
            ),
        contentAlignment = Alignment.Center
    ) {
        if (completed) {
            Text(
                text = "✓",
                color = Color.White,
                fontSize = 14.sp,
                fontWeight = FontWeight.Bold
            )
        }
    }
}

@Composable
private fun CategoryBadge(
    text: String,
    type: CategoryType
) {
    val backgroundColor = when (type) {
        CategoryType.Work -> AppColors.PrimaryLight
        CategoryType.Personal -> AppColors.PersonalBg
        CategoryType.Health -> AppColors.HealthBg
    }

    val textColor = when (type) {
        CategoryType.Work -> AppColors.Primary
        CategoryType.Personal -> AppColors.PersonalText
        CategoryType.Health -> AppColors.HealthText
    }

    Text(
        text = text,
        color = textColor,
        fontSize = 11.sp,
        fontWeight = FontWeight.Bold,
        modifier = Modifier
            .clip(RoundedCornerShape(7.dp))
            .background(backgroundColor)
            .padding(horizontal = 8.dp, vertical = 4.dp)
    )
}

@Preview
@Composable
fun HomeScreenPreview() {
    HomeScreen(
        onAddTaskClick = {}
    )
}
