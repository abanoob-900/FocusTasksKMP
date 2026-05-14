package com.bob.focustasks.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Close
import androidx.compose.material3.Icon
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.bob.focustasks.ui.theme.AppColors
import focustasks.composeapp.generated.resources.Res
import focustasks.composeapp.generated.resources.icon_save
import org.jetbrains.compose.resources.painterResource

@Composable
fun AddTaskScreen(onBackClick: () -> Unit = {}) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(AppColors.Background)
    ) {

        Column(
            modifier = Modifier
                .padding(
                    top = 16.dp,
                )
                .fillMaxSize()
        ) {
            AddTaskHeader(onBackClick = onBackClick)

            Column(
                modifier = Modifier
                    .padding(
                        start = 8.dp,
                        end = 8.dp,
                        top = 16.dp,
                        bottom = 98.dp
                    )
                    .fillMaxSize()
            ) {
                Spacer(modifier = Modifier.height(34.dp))

                SectionLabel("TASK IDENTIFICATION")

                Spacer(modifier = Modifier.height(14.dp))

                TaskInputBox()

                Spacer(modifier = Modifier.height(30.dp))

                SectionLabel("CLASSIFICATION")

                Spacer(modifier = Modifier.height(14.dp))

                CategorySection()

                Spacer(modifier = Modifier.height(34.dp))

                SectionLabel("TEMPORAL SCHEDULING")

                Spacer(modifier = Modifier.height(14.dp))

                SelectorRow(
                    icon = "□",
                    text = "Today, Oct 24",
                    trailing = "⌄"
                )

                Spacer(modifier = Modifier.height(12.dp))

                SelectorRow(
                    icon = "○",
                    text = "10:30 AM",
                    trailing = "⌄"
                )

                Spacer(modifier = Modifier.height(26.dp))

                PriorityCard()
            }
        }

        BottomSaveArea(
            modifier = Modifier.align(Alignment.BottomCenter)
        )
    }
}

@Composable
private fun AddTaskHeader(onBackClick: () -> Unit = {}) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 12.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box(
            modifier = Modifier
                .size(36.dp)
                .clip(CircleShape)
                .background(AppColors.PrimaryLight)
                .clickable {onBackClick()},
            contentAlignment = Alignment.Center
        ) {
            Icon(
                imageVector = Icons.Rounded.Close,
                contentDescription = "Close",
                tint = AppColors.Primary,
                modifier = Modifier.size(20.dp)
            )
        }

        Spacer(modifier = Modifier.width(12.dp))

        Text(
            text = "Add New Task",
            color = AppColors.TextPrimary,
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.weight(1f)
        )

        Box(
            modifier = Modifier
                .size(36.dp)
                .clip(CircleShape)
                .background(Color(0xFFD8D0C4)),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = "A",
                color = AppColors.TextPrimary,
                fontSize = 15.sp,
                fontWeight = FontWeight.Bold
            )
        }
    }
}

@Composable
private fun SectionLabel(text: String) {
    Text(
        text = text,
        color = AppColors.TextPrimary,
        fontSize = 11.sp,
        fontWeight = FontWeight.Bold,
        letterSpacing = 1.2.sp
    )
}

@Composable
private fun TaskInputBox() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(54.dp)
            .clip(RoundedCornerShape(10.dp))
            .background(Color(0xFFF3F4FC))
            .border(
                width = 1.dp,
                color = AppColors.Border,
                shape = RoundedCornerShape(10.dp)
            )
            .padding(horizontal = 18.dp),
        contentAlignment = Alignment.CenterStart
    ) {
        Text(
            text = "What needs to be focused on?",
            color = Color(0xFFA2A5B4),
            fontSize = 14.sp
        )
    }
}

@Composable
private fun CategorySection() {
    Column {
        Row(
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            CategoryPill(
                text = "Work",
                selected = true
            )

            CategoryPill(
                text = "Personal",
                selected = false
            )

            CategoryPill(
                text = "Deep Focus",
                selected = false
            )
        }

        Spacer(modifier = Modifier.height(10.dp))

        Row(
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            CategoryPill(
                text = "Learning",
                selected = false
            )

            AddCategoryButton()
        }
    }
}

@Composable
private fun CategoryPill(
    text: String,
    selected: Boolean
) {
    Box(
        modifier = Modifier
            .height(32.dp)
            .clip(RoundedCornerShape(18.dp))
            .background(if (selected) AppColors.Primary else AppColors.PrimaryLight)
            .clickable {}
            .padding(horizontal = 20.dp),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = text,
            color = if (selected) Color.White else AppColors.TextPrimary,
            fontSize = 12.sp,
            fontWeight = FontWeight.Bold
        )
    }
}

@Composable
private fun AddCategoryButton() {
    Box(
        modifier = Modifier
            .size(34.dp)
            .clip(CircleShape)
            .background(Color.Transparent)
            .border(
                width = 1.dp,
                color = AppColors.Primary.copy(alpha = 0.35f),
                shape = CircleShape
            )
            .clickable {},
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = "+",
            color = AppColors.Primary,
            fontSize = 18.sp
        )
    }
}

@Composable
private fun SelectorRow(
    icon: String,
    text: String,
    trailing: String
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(56.dp)
            .clip(RoundedCornerShape(10.dp))
            .background(Color(0xFFF3F4FC))
            .border(
                width = 1.dp,
                color = AppColors.Border,
                shape = RoundedCornerShape(10.dp)
            )
            .padding(horizontal = 18.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = icon,
            color = AppColors.Primary,
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.width(14.dp))

        Text(
            text = text,
            color = AppColors.TextPrimary,
            fontSize = 14.sp,
            modifier = Modifier.weight(1f)
        )

        Text(
            text = trailing,
            color = AppColors.TextSecondary,
            fontSize = 16.sp
        )
    }
}

@Composable
private fun PriorityCard() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(72.dp)
            .clip(RoundedCornerShape(12.dp))
            .background(Color(0xFFF1F2FA))
            .padding(horizontal = 18.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box(
            modifier = Modifier
                .size(38.dp)
                .clip(RoundedCornerShape(8.dp))
                .background(Color(0xFFFFD8C4)),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = "!",
                color = Color(0xFFC86A32),
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold
            )
        }

        Spacer(modifier = Modifier.width(14.dp))

        Column(
            modifier = Modifier.weight(1f)
        ) {
            Text(
                text = "High Priority",
                color = AppColors.TextPrimary,
                fontSize = 15.sp,
                fontWeight = FontWeight.Bold
            )

            Spacer(modifier = Modifier.height(4.dp))

            Text(
                text = "Flag for immediate focus",
                color = AppColors.TextSecondary,
                fontSize = 12.sp
            )
        }

        Switch(
            checked = false,
            onCheckedChange = {},
            colors = SwitchDefaults.colors(
                checkedThumbColor = Color.White,
                checkedTrackColor = AppColors.Primary,
                uncheckedThumbColor = AppColors.TextSecondary,
                uncheckedTrackColor = AppColors.Border,
                uncheckedBorderColor = Color.Transparent
            )
        )
    }
}

@Composable
private fun BottomSaveArea(
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .height(92.dp)
            .background(Color(0xFFFFFFFF))
            .padding(horizontal = 22.dp, vertical = 18.dp),
        contentAlignment = Alignment.Center
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(56.dp)
                .clip(RoundedCornerShape(30.dp))
                .background(AppColors.Primary)
                .clickable {},
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                painter = painterResource(Res.drawable.icon_save),
                contentDescription = null,
                tint = Color.White
            )
            Spacer(modifier = Modifier.width(16.dp))
            Text(
                text = "Save Task",
                color = Color.White,
                fontSize = 15.sp,
                fontWeight = FontWeight.Bold
            )
        }
    }
}

@Preview
@Composable
fun AddTaskScreenPreview() {
    AddTaskScreen()
}
