package com.example.screens.main.impl

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment.Companion.Center
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.impl.R

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyUI()
        }
    }
}

@Composable
fun MainScreen(screenWidth: Dp, screenHeight: Dp) {
    Column(
        modifier = Modifier
    ) {
        AppBar(screenWidth)
        Column(
            modifier = Modifier
                .size(screenWidth, screenHeight)
                .background(Color.White)
                .verticalScroll(rememberScrollState())
                .fillMaxSize()
                .padding(all = 10.dp)
        ) {
            repeat(20) {
                Player()
            }
        }
    }
}

@Composable
fun AppBar(screenWidth: Dp) {
    Box(
        modifier = Modifier
            .size(screenWidth, 72.dp)
            .background(Color(0xFF00668A))
    ) {
        Row(
            verticalAlignment = CenterVertically,
            modifier = Modifier
                .size(328.dp, 56.dp)
                .align(Center)
                .clip(shape = RoundedCornerShape(50))
                .background(Color.White)
                .clickable(onClick = {})
        ) {
            Box(
                modifier = Modifier
                    .size(56.dp, 56.dp)
                    .clip(shape = RoundedCornerShape(50))
                    .align(CenterVertically)
                    .clickable(onClick = {})
            ) {
                Image(
                    painter = painterResource(R.drawable.icon),
                    contentDescription = "Menu Button",
                    modifier = Modifier
                        .padding(19.dp, 22.dp)
                        .size(18.dp, 12.dp)
                )
            }
            Text(
                text = "Search for players",
                fontSize = 16.sp,
                modifier = Modifier
                    .padding(2.dp)
            )
        }
    }
}

@Composable
fun Player() {
    Row(
        verticalAlignment = CenterVertically,
        modifier = Modifier
            .padding(4.dp)
            .size(335.dp, 80.dp)
            .clip(shape = RoundedCornerShape(12.dp))
            .border(1.dp, Color(0xFFDFD5EC), shape = RoundedCornerShape(12.dp))
            .clickable(onClick = {})
    ) {
        Image(
            painter = painterResource(R.drawable.dota2_logo_icon),
            contentDescription = "Avatar Image",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .padding(16.dp, 20.dp)
                .size(40.dp)
                .clip(CircleShape)
                .border(1.dp, Color(0xFFDFD5EC), CircleShape)
                .align(CenterVertically)
        )
        Column(
            verticalArrangement = Arrangement.Center,
            modifier = Modifier
                .padding(0.dp)
                .fillMaxHeight()
        ) {
            Text(
                text = "Header",
                modifier = Modifier
                    .padding(2.dp)
            )
            Text(
                text = "Subheader",
                fontSize = 14.sp,
                modifier = Modifier
                    .padding(2.dp)
            )
        }
    }
}


@Composable
fun MyUI() {
    val configuration = LocalConfiguration.current
    val screenWidth = configuration.screenWidthDp.dp
    val screenHeight = configuration.screenHeightDp.dp
    MainScreen(screenWidth, screenHeight)
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun PreviewMyUI() {
    MyUI()
}