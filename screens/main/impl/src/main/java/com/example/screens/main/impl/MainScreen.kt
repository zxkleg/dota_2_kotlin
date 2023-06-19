package com.example.screens.main.impl

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.consumeWindowInsets
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults.buttonColors
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment.Companion.Center
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.impl.R

@ExperimentalLayoutApi
@Composable
fun MainScreen(
    modifier: Modifier = Modifier,
    lazyColumnState: LazyListState,
) {
    val scaffoldState = rememberScaffoldState()
    Scaffold(
        modifier = modifier,
        scaffoldState = scaffoldState,
        topBar = {
            AppBar()
        }
    ) { paddingValues ->
        Surface(
            modifier = Modifier.consumeWindowInsets(paddingValues)
        ) {
            LazyColumn(
                modifier = modifier,
                state = lazyColumnState,
                verticalArrangement = Arrangement.Top,
                horizontalAlignment = CenterHorizontally,
                contentPadding = PaddingValues(
                    horizontal = 12.dp, vertical = 18.dp
                )
            ) {
                items(
                    players.size,
                    key = { index -> players[index].id }
                ){
                    Player()
                }

            }
        }
    }
}

@Composable
fun AppBar() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .background(Color(0xFF00668A))
    ) {
        Row(
            verticalAlignment = CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
                .padding(horizontal = 16.dp, vertical = 8.dp)
                .align(Center)
                .clip(shape = RoundedCornerShape(50))
                .background(Color.White)
                .clickable(onClick = {})
        ) {
            Box(
                modifier = Modifier
                    .wrapContentHeight()
                    .clip(shape = CircleShape)
                    .align(CenterVertically)
                    .clickable(onClick = {})
            ) {
                Image(
                    painter = painterResource(R.drawable.icon),
                    contentDescription = "Menu Button",
                    modifier = Modifier
                        .wrapContentSize()
                        .padding(19.dp, 22.dp)
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
    Button(
        onClick = {},
        colors = buttonColors(
            backgroundColor = Color.White,
            contentColor = Color.Black,
            disabledBackgroundColor = Color(0xFF191C1E),
            disabledContentColor = Color.White
        ),
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

@ExperimentalLayoutApi
@Preview(showSystemUi = true, showBackground = true)
@Composable
fun MyUI() {
    MainScreen(
        modifier = Modifier.fillMaxSize()
    )
}