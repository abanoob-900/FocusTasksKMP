package com.bob.focustasks

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform