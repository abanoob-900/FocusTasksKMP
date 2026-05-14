package com.bob.focustasks.ui.screens

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowLeft
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowRight
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.sharp.Check
import androidx.compose.material.icons.sharp.Edit
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.bob.focustasks.ui.theme.AppColors

@Composable
fun FocusScreen() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(AppColors.Background)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
        ) {
            FocusHeader()

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .verticalScroll(rememberScrollState())
                    .padding(horizontal = 24.dp)
                    .padding(top = 16.dp, bottom = 56.dp)
            ) {
                Spacer(modifier = Modifier.height(22.dp))

                FocusModeSelector()

                Spacer(modifier = Modifier.height(28.dp))

                TimerCard()

                Spacer(modifier = Modifier.height(24.dp))

                Text(
                    text = "CURRENT TASK",
                    color = AppColors.TextSecondary,
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Bold,
                    letterSpacing = 1.4.sp
                )

                Spacer(modifier = Modifier.height(12.dp))

                CurrentTaskCard()

                Spacer(modifier = Modifier.height(24.dp))

                CompletedTodayCard()
            }
        }

    }
}

@Composable
private fun FocusHeader() {
    Row(
        modifier = Modifier.fillMaxWidth()
            .padding(top = 16.dp, end = 16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        TextButton(
            onClick = {},
            modifier = Modifier.padding(start = 0.dp)
        ) {
            Icon(
                imageVector = Icons.AutoMirrored.Filled.KeyboardArrowLeft,
                contentDescription = "Home Icon",
                tint = AppColors.Primary,
                modifier = Modifier
                    .size(24.dp)
            )
        }

        Column(
            modifier = Modifier.weight(1f)
        ) {
            Text(
                text = "Focus Tasks",
                color = AppColors.Primary,
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold
            )

            Text(
                text = "Stay focused",
                color = AppColors.TextSecondary,
                fontSize = 14.sp
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
private fun FocusModeSelector() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(44.dp)
            .clip(RoundedCornerShape(24.dp))
            .background(AppColors.PrimaryLight)
            .padding(3.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        FocusModeItem(
            text = "Pomodoro",
            selected = true,
            modifier = Modifier.weight(1f)
        )

        FocusModeItem(
            text = "Short Break",
            selected = false,
            modifier = Modifier.weight(1f)
        )

        FocusModeItem(
            text = "Long Break",
            selected = false,
            modifier = Modifier.weight(1f)
        )
    }
}

@Composable
private fun FocusModeItem(
    text: String,
    selected: Boolean,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .height(38.dp)
            .clip(RoundedCornerShape(22.dp))
            .background(if (selected) AppColors.Primary else Color.Transparent)
            .clickable {},
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = text,
            color = if (selected) Color.White else AppColors.TextSecondary,
            fontSize = 13.sp,
            fontWeight = FontWeight.Bold,
            letterSpacing = 1.sp
        )
    }
}

@Composable
private fun TimerCard() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(18.dp))
            .background(AppColors.Card)
            .padding(horizontal = 28.dp, vertical = 34.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        FocusTimer()

        Spacer(modifier = Modifier.height(34.dp))

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(58.dp)
                .clip(RoundedCornerShape(32.dp))
                .background(AppColors.Primary)
                .clickable {},
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = "Start Focus",
                color = Color.White,
                fontSize = 17.sp,
                fontWeight = FontWeight.Medium
            )
        }

        Spacer(modifier = Modifier.height(18.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
        ) {
            SecondaryControlButton(
                text = "Ⅱ  Pause",
                modifier = Modifier.weight(1f)
            )

            Spacer(modifier = Modifier.width(16.dp))

            SecondaryControlButton(
                text = "↻  Reset",
                modifier = Modifier.weight(1f)
            )
        }
    }
}

@Composable
private fun FocusTimer() {
    Box(
        modifier = Modifier.size(240.dp),
        contentAlignment = Alignment.Center
    ) {
        Canvas(
            modifier = Modifier.size(220.dp)
        ) {
            drawArc(
                color = AppColors.Border.copy(alpha = 0.75f),
                startAngle = -90f,
                sweepAngle = 360f,
                useCenter = false,
                size = Size(size.width, size.height),
                style = Stroke(
                    width = 9.dp.toPx(),
                    cap = StrokeCap.Round
                )
            )

            drawArc(
                color = AppColors.Primary,
                startAngle = -92f,
                sweepAngle = 285f,
                useCenter = false,
                size = Size(size.width, size.height),
                style = Stroke(
                    width = 9.dp.toPx(),
                    cap = StrokeCap.Round
                )
            )
        }

        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "25:00",
                color = AppColors.TextPrimary,
                fontSize = 30.sp,
                fontWeight = FontWeight.Bold
            )

            Spacer(modifier = Modifier.height(4.dp))

            Text(
                text = "FOCUS SESSION",
                color = AppColors.TextSecondary,
                fontSize = 12.sp,
                fontWeight = FontWeight.Bold,
                letterSpacing = 2.sp
            )
        }
    }
}

@Composable
private fun SecondaryControlButton(
    text: String,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .height(52.dp)
            .clip(RoundedCornerShape(28.dp))
            .background(Color.White)
            .border(
                width = 1.dp,
                color = AppColors.Border,
                shape = RoundedCornerShape(28.dp)
            )
            .clickable {},
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = text,
            color = AppColors.TextPrimary,
            fontSize = 15.sp,
            fontWeight = FontWeight.Medium
        )
    }
}

@Composable
private fun CurrentTaskCard() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .defaultMinSize(minHeight = 56.dp)
            .clip(RoundedCornerShape(12.dp))
            .background(AppColors.Card)
            .border(
                width = 1.dp,
                color = AppColors.Border.copy(alpha = 0.55f),
                shape = RoundedCornerShape(12.dp)
            )
            .padding(horizontal = 16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box(
            modifier = Modifier
                .padding(top = 16.dp, bottom = 16.dp)
                .size(50.dp)
                .clip(RoundedCornerShape(8.dp))
                .background(AppColors.PrimaryLight),
            contentAlignment = Alignment.Center
        ) {
            Icon(
                imageVector = Icons.Sharp.Check,
                contentDescription = "Home Icon",
                tint = AppColors.Primary,
                modifier = Modifier
                    .size(24.dp)
            )
        }

        Spacer(modifier = Modifier.width(14.dp))

        Column(
            modifier = Modifier.weight(1f)
        ) {
            Text(
                text = "Review design specs",
                color = AppColors.TextPrimary,
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold
            )

            Spacer(modifier = Modifier.height(8.dp))

            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Box(
                    modifier = Modifier
                        .clip(RoundedCornerShape(7.dp))
                        .background(AppColors.PrimaryLight)
                        .padding(horizontal = 9.dp, vertical = 4.dp)
                ) {
                    Text(
                        text = "Work",
                        color = AppColors.TextSecondary,
                        fontSize = 11.sp,
                        fontWeight = FontWeight.Bold
                    )
                }

                Spacer(modifier = Modifier.width(10.dp))

                Text(
                    text = "○ 25 min",
                    color = AppColors.TextSecondary,
                    fontSize = 13.sp
                )
            }
        }

        Icon(
            imageVector = Icons.Sharp.Edit,
            contentDescription = "Home Icon",
            tint = AppColors.Primary,
            modifier = Modifier
                .size(24.dp)
        )
    }
}

@Composable
private fun CompletedTodayCard() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(96.dp)
            .clip(RoundedCornerShape(10.dp))
            .background(Color(0xFF6252F4))
            .padding(horizontal = 24.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column(
            modifier = Modifier.weight(1f)
        ) {
            Text(
                text = "COMPLETED TODAY",
                color = Color.White.copy(alpha = 0.72f),
                fontSize = 12.sp,
                fontWeight = FontWeight.Bold,
                letterSpacing = 1.4.sp
            )

            Spacer(modifier = Modifier.height(10.dp))

            Text(
                text = "3 sessions  ·  75 minutes",
                color = Color.White,
                fontSize = 19.sp,
                fontWeight = FontWeight.Bold
            )
        }

        Box(
            modifier = Modifier
                .size(48.dp)
                .clip(CircleShape)
                .background(Color.White.copy(alpha = 0.15f)),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = "⌁",
                color = Color.White,
                fontSize = 24.sp
            )
        }
    }
}

@Preview(heightDp = 1200)
@Composable
fun FocusScreenPreview() {
    FocusScreen()
}


