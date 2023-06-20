package com.example.screens.main.api.data

import android.graphics.Bitmap

data class DataPlayer(
    val id: String,
    val nickname: String,
    val avatar: Bitmap?,
    val hasDotaPlus: Boolean
)