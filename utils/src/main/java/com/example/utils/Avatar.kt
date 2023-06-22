package com.example.utils

import android.graphics.Bitmap
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment.Companion.BottomEnd
import androidx.compose.ui.Alignment.Companion.Center
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


@Composable
fun Avatar(
    modifier: Modifier,
    avatarImage: Bitmap?,
    hasDotaPlus: Boolean,
    contentDescription: String,
    placeHolderDrawableRes: Int
) {
    Box(modifier = modifier) {
        Box(modifier = Modifier.align(Center)) {
            avatarImage?.asImageBitmap()?.let { imageBitmap ->
                Image(
                    modifier = Modifier,
                    bitmap = imageBitmap,
                    contentDescription = contentDescription
                )
            } ?: Image(
                modifier = Modifier,
                painter = painterResource(placeHolderDrawableRes),
                contentDescription = contentDescription
            )
        }
        if (hasDotaPlus)
            Box(
                modifier = Modifier
                    .align(BottomEnd)
                    .clip(CircleShape)
                    .matchParentSize()
                    .fillMaxSize(0.3f)
                    .background(color = Color(0xFF001E2C))
            ) {
                Image(
                    modifier = Modifier
                        .align(Center)
                        .matchParentSize()
                        .fillMaxSize(0.8f),
                    painter = painterResource(R.drawable.dota_plus_icon),
                    contentDescription = contentDescription
                )
            }
    }
}

@Preview
@Composable
private fun PreviewAvatar() {
    Avatar(
        modifier = Modifier.size(120.dp),
        avatarImage = null,
        hasDotaPlus = true,
        contentDescription = "",
        placeHolderDrawableRes = R.drawable.dota2_icon_placeholder
    )
}