package com.example.screens.main.impl.components

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.impl.R
import com.example.screens.main.api.data.DataPlayer
import com.example.utils.Avatar

@Composable
fun SmallPlayerCard(
    dataPlayer: DataPlayer, placeHolderDrawableRes: Int
) {
    Button(
        onClick = {},
        colors = ButtonDefaults.buttonColors(
            backgroundColor = Color.White,
            contentColor = Color.Black,
            disabledBackgroundColor = Color(0xFF191C1E),
            disabledContentColor = Color.White
        ),
        contentPadding = PaddingValues(16.dp),
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .clip(shape = RoundedCornerShape(12.dp))
            .border(1.dp, Color(0xFFDFD5EC), shape = RoundedCornerShape(12.dp))
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight(),
            horizontalArrangement = Arrangement.Start,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Avatar(
                modifier = Modifier.size(60.dp),
                avatarImage = dataPlayer.avatar,
                hasDotaPlus = dataPlayer.hasDotaPlus,
                contentDescription = "",
                placeHolderDrawableRes = placeHolderDrawableRes
            )
            Spacer(modifier = Modifier.width(16.dp))
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.Start,
            ) {
                Text(
                    text = dataPlayer.nickname,
                    maxLines = 1,
                    fontSize = 20.sp,
                    fontWeight = FontWeight(500),
                    textAlign = TextAlign.Start
                )
            }
        }
    }
}

@Preview
@Composable
fun PreviewSmallPlayerCard() {
    SmallPlayerCard(
        DataPlayer(id = "133722810", nickname = "Yaroslav", avatar = null, hasDotaPlus = true),
        placeHolderDrawableRes = R.drawable.dota2_logo_icon
    )
}