package com.example.screens.player.impl.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Text
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.ColorFilter.Companion.tint
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.screens.player.impl.R

@Composable
fun AppBar() {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .background(color = MaterialTheme.colorScheme.primary)
    ) {
        Box(
            modifier = Modifier
                .wrapContentHeight()
                .clip(shape = CircleShape)
                .align(Alignment.CenterVertically)
                .clickable(onClick = {})
                .background(color = MaterialTheme.colorScheme.primary)
        ) {
            Image(
                painter = painterResource(R.drawable.arrow_back),
                colorFilter = tint(color = MaterialTheme.colorScheme.onPrimary),
                contentDescription = "Back Button",
                modifier = Modifier
                    .wrapContentSize()
                    .padding(19.dp, 22.dp)
                    .background(color = MaterialTheme.colorScheme.primary)

            )
        }
        Text(
            text = stringResource(R.string.player_info),
            fontSize = 25.sp,
            color = MaterialTheme.colorScheme.onPrimary,
            modifier = Modifier.padding(2.dp)
        )
    }
}

@Preview
@Composable
private fun AppBarPreview() {
    AppBar()
}