package com.example.screens.main.impl

import android.graphics.Bitmap

data class DataPlayer(
    val id: String,
    val nickname: String,
    val avatar: Bitmap?,
    val hasDotaPlus: Boolean
)