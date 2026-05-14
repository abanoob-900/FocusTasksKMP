package com.bob.focustasks.ui.host

import kotlinx.serialization.Serializable

sealed interface Screen {
    @Serializable
    data object Main : Screen

    @Serializable
    data object AddTask : Screen

}