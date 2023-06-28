package com.example.utils.ui

import android.graphics.Bitmap

data class ExtendedDataPlayer(
    val id: String,
    val nickname: String,
    val avatar: Bitmap?,
    val hasDotaPlus: Boolean,
    val lastOnline: String,
    val profileLink: String,
    val steamProfileLink: String
)

