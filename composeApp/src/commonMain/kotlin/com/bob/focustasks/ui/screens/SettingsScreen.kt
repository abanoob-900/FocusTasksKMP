package com.bob.focustasks.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.rounded.ArrowBack
import androidx.compose.material.icons.automirrored.rounded.KeyboardArrowRight
import androidx.compose.material.icons.rounded.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.bob.focustasks.ui.theme.AppColors

@Composable
fun SettingsScreen() {
    val backgroundColor = Color(0xFFF7F7FC)
    val primaryColor = Color(0xFF4B35E8)

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(backgroundColor)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
        ) {

        HeaderSection(primaryColor = primaryColor)

        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
        ) {
            ProfileCard(primaryColor = primaryColor)

            SettingsSection(title = "PREFERENCES") {
                SettingsSwitchItem(
                    icon = Icons.Rounded.Notifications,
                    title = "Notifications",
                    isChecked = true
                )
                HorizontalDivider(
                    color = backgroundColor,
                    thickness = 1.dp,
                    modifier = Modifier.padding(start = 56.dp)
                )
                SettingsValueItem(
                    icon = Icons.Rounded.Alarm,
                    title = "Daily reminder",
                    value = "9:00 AM",
                    valueColor = primaryColor
                )
                HorizontalDivider(
                    color = backgroundColor,
                    thickness = 1.dp,
                    modifier = Modifier.padding(start = 56.dp)
                )
                SettingsSwitchItem(
                    icon = Icons.Rounded.VolumeUp,
                    title = "Sound effects",
                    isChecked = false
                )
            }

            SettingsSection(title = "TASK MANAGEMENT") {
                SettingsBadgeItem(
                    icon = Icons.Rounded.Category,
                    title = "Default category",
                    badgeText = "WORK",
                    primaryColor = primaryColor
                )
                HorizontalDivider(
                    color = backgroundColor,
                    thickness = 1.dp,
                    modifier = Modifier.padding(start = 56.dp)
                )
                SettingsValueItem(
                    icon = Icons.Rounded.FlashOn,
                    title = "Priority mode",
                    value = "Enabled",
                    valueColor = Color.Gray
                )
                HorizontalDivider(
                    color = backgroundColor,
                    thickness = 1.dp,
                    modifier = Modifier.padding(start = 56.dp)
                )
                SettingsValueItem(
                    icon = Icons.Rounded.CheckCircle,
                    title = "Completed tasks",
                    value = "Show",
                    valueColor = Color.Gray
                )
            }

            SettingsSection(title = "APPEARANCE") {
                SettingsValueItem(
                    icon = Icons.Rounded.Palette,
                    title = "Theme",
                    value = "Light",
                    valueColor = Color.Gray
                )
                HorizontalDivider(
                    color = backgroundColor,
                    thickness = 1.dp,
                    modifier = Modifier.padding(start = 56.dp)
                )
                SettingsColorItem(
                    icon = Icons.Rounded.Contrast,
                    title = "Accent color",
                    color = primaryColor
                )
            }

            SettingsSection(title = "DATA") {
                SettingsActionItem(icon = Icons.Rounded.FileDownload, title = "Export tasks")
                HorizontalDivider(
                    color = backgroundColor,
                    thickness = 1.dp,
                    modifier = Modifier.padding(start = 56.dp)
                )
                SettingsActionItem(
                    icon = Icons.Rounded.Delete,
                    title = "Clear completed tasks",
                    isDestructive = true
                )
            }

            TextButton(
                onClick = { /* Handle Sign Out */ },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 24.dp)
            ) {
                Text(
                    text = "Sign out",
                    color = Color(0xFFD32F2F),
                    fontWeight = FontWeight.Bold,
                    fontSize = 16.sp
                )
            }

            Spacer(modifier = Modifier.height(24.dp))
        }
    }
    }
}

@Composable
private fun HeaderSection(primaryColor: Color) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 24.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            imageVector = Icons.AutoMirrored.Rounded.ArrowBack,
            contentDescription = "Back",
            tint = primaryColor,
            modifier = Modifier
                .size(28.dp)
                .clickable { /* Handle Back */ }
        )
        Spacer(modifier = Modifier.width(16.dp))
        Column(modifier = Modifier.weight(1f)) {
            Text(
                text = "Focus Tasks",
                fontSize = 22.sp,
                fontWeight = FontWeight.Bold,
                color = primaryColor
            )
            Text(
                text = "Customize your app",
                fontSize = 14.sp,
                color = Color.Gray
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
private fun ProfileCard(primaryColor: Color) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp)
            .padding(bottom = 24.dp),
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
            Box(modifier = Modifier.size(60.dp)) {
                Box(
                    modifier = Modifier
                        .size(60.dp)
                        .clip(CircleShape)
                        .background(Color.LightGray)
                )
                Box(
                    modifier = Modifier
                        .size(20.dp)
                        .clip(CircleShape)
                        .background(primaryColor)
                        .align(Alignment.BottomEnd)
                        .padding(4.dp)
                ) {
                    Icon(
                        imageVector = Icons.Rounded.Edit,
                        contentDescription = "Edit",
                        tint = Color.White,
                        modifier = Modifier.fillMaxSize()
                    )
                }
            }
            Spacer(modifier = Modifier.width(16.dp))
            Column(modifier = Modifier.weight(1f)) {
                Text(
                    text = "Alex Morgan",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.Black
                )
                Text(
                    text = "alex@example.com",
                    fontSize = 14.sp,
                    color = Color.Gray
                )
            }
            Icon(
                imageVector = Icons.AutoMirrored.Rounded.KeyboardArrowRight,
                contentDescription = "Go",
                tint = Color.Gray
            )
        }
    }
}

@Composable
private fun SettingsSection(title: String, content: @Composable ColumnScope.() -> Unit) {
    Column(modifier = Modifier.padding(bottom = 24.dp)) {
        Text(
            text = title,
            fontSize = 12.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF4B35E8).copy(alpha = 0.8f),
            modifier = Modifier.padding(horizontal = 32.dp, vertical = 8.dp)
        )
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            colors = CardDefaults.cardColors(containerColor = Color.White),
            shape = RoundedCornerShape(16.dp),
            elevation = CardDefaults.cardElevation(defaultElevation = 0.dp)
        ) {
            Column(content = content)
        }
    }
}

@Composable
private fun SettingsItemBase(
    icon: ImageVector,
    title: String,
    iconTint: Color = Color.DarkGray,
    trailingContent: @Composable () -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { /* Handle Click */ }
            .padding(horizontal = 16.dp, vertical = 14.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            imageVector = icon,
            contentDescription = title,
            tint = iconTint,
            modifier = Modifier.size(24.dp)
        )
        Spacer(modifier = Modifier.width(16.dp))
        Text(
            text = title,
            fontSize = 16.sp,
            color = Color.Black,
            modifier = Modifier.weight(1f)
        )
        trailingContent()
    }
}

@Composable
private fun SettingsSwitchItem(icon: ImageVector, title: String, isChecked: Boolean) {
    var checked by remember { mutableStateOf(isChecked) }
    SettingsItemBase(icon = icon, title = title) {
        Switch(
            checked = checked,
            onCheckedChange = { checked = it },
            colors = SwitchDefaults.colors(
                checkedThumbColor = Color.White,
                checkedTrackColor = Color(0xFF4B35E8)
            ),
            modifier = Modifier.height(24.dp)
        )
    }
}

@Composable
private fun SettingsValueItem(icon: ImageVector, title: String, value: String, valueColor: Color) {
    SettingsItemBase(icon = icon, title = title) {
        Text(text = value, color = valueColor, fontSize = 14.sp, fontWeight = FontWeight.Medium)
    }
}

@Composable
private fun SettingsBadgeItem(
    icon: ImageVector,
    title: String,
    badgeText: String,
    primaryColor: Color
) {
    SettingsItemBase(icon = icon, title = title) {
        Box(
            modifier = Modifier
                .background(primaryColor.copy(alpha = 0.1f), RoundedCornerShape(8.dp))
                .padding(horizontal = 8.dp, vertical = 4.dp)
        ) {
            Text(
                text = badgeText,
                color = primaryColor,
                fontSize = 12.sp,
                fontWeight = FontWeight.Bold
            )
        }
    }
}

@Composable
private fun SettingsColorItem(icon: ImageVector, title: String, color: Color) {
    SettingsItemBase(icon = icon, title = title) {
        Box(
            modifier = Modifier
                .size(24.dp)
                .clip(CircleShape)
                .background(color)
        )
    }
}

@Composable
private fun SettingsActionItem(icon: ImageVector, title: String, isDestructive: Boolean = false) {
    val tint = if (isDestructive) Color(0xFFD32F2F) else Color.DarkGray
    val trailingIcon =
        if (isDestructive) Icons.Rounded.Warning else Icons.AutoMirrored.Rounded.KeyboardArrowRight

    SettingsItemBase(icon = icon, title = title, iconTint = tint) {
        Icon(
            imageVector = trailingIcon,
            contentDescription = null,
            tint = tint
        )
    }
}

@Preview
@Composable
fun SettingsScreenPreview() {
    SettingsScreen()
}