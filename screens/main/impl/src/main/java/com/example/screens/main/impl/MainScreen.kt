package com.example.screens.main.impl

import android.graphics.Bitmap
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
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.consumeWindowInsets
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults.buttonColors
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.Center
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.impl.R

@ExperimentalLayoutApi
@Composable
fun MainScreen(
    modifier: Modifier = Modifier,
    listOfPlayers: List<DataPlayer>,
) {
    val scaffoldState = rememberScaffoldState()
    val lazyColumnState = rememberLazyListState()
    val placeHolderDrawableRes: Int = R.drawable.dota2_logo_icon
    Scaffold(modifier = modifier, scaffoldState = scaffoldState, topBar = {
        AppBar()
    }) { paddingValues ->
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
                items(listOfPlayers.size, key = { index -> listOfPlayers[index].id }) { index ->
                    SmallPlayerCard(
                        dataPlayer = listOfPlayers[index],
                        placeHolderDrawableRes = placeHolderDrawableRes
                    )
                    if (index != listOfPlayers.lastIndex) Spacer(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(8.dp)
                    )
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
                text = "Search for players", fontSize = 16.sp, modifier = Modifier.padding(2.dp)
            )
        }
    }
}

@Composable
fun SmallPlayerCard(
    dataPlayer: DataPlayer,
    placeHolderDrawableRes: Int
) {
    Button(
        onClick = {},
        colors = buttonColors(
            backgroundColor = Color.White,
            contentColor = Color.Black,
            disabledBackgroundColor = Color(0xFF191C1E),
            disabledContentColor = Color.White
        ),
        contentPadding = PaddingValues(16.dp),
        modifier = Modifier
            .fillMaxWidth()
            .clip(shape = RoundedCornerShape(12.dp))
            .border(1.dp, Color(0xFFDFD5EC), shape = RoundedCornerShape(12.dp))
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight(),
            horizontalArrangement = Arrangement.Start,
            verticalAlignment = CenterVertically
        ) {
            Avatar(
                modifier = Modifier
                    .padding(0.dp, 4.dp)
                    .size(40.dp),
                avatarImage = dataPlayer.avatar,
                contentDescription = "",
                placeHolderDrawableRes = placeHolderDrawableRes
            )
            Spacer(modifier = Modifier.width(16.dp))
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.Start,
            ) {
                Text(
                    text = dataPlayer.nickname, fontSize = 20.sp, modifier = Modifier.padding(2.dp)
                )
            }
        }
    }
}

@Composable
fun Avatar(
    modifier: Modifier,
    avatarImage: Bitmap?,
    contentDescription: String,
    placeHolderDrawableRes: Int
) {
    avatarImage?.asImageBitmap()?.let { imageBitmap ->
        Image(
            modifier = modifier,
            bitmap = imageBitmap,
            contentDescription = contentDescription
        )
    } ?: Image(
        modifier = modifier,
        painter = painterResource(placeHolderDrawableRes),
        contentDescription = contentDescription
    )
}

val listOfPlayers = listOf(
    DataPlayer(
        id = "13372281", nickname = "Kirill", avatar = null, hasDotaPlus = false
    ), DataPlayer(
        id = "13372282", nickname = "Nikita", avatar = null, hasDotaPlus = true
    ), DataPlayer(
        id = "13372283", nickname = "Dmitry", avatar = null, hasDotaPlus = false
    ), DataPlayer(
        id = "13372284", nickname = "Egor", avatar = null, hasDotaPlus = true
    ), DataPlayer(
        id = "13372285", nickname = "Andrey", avatar = null, hasDotaPlus = false
    ), DataPlayer(
        id = "13372286", nickname = "Ivan", avatar = null, hasDotaPlus = false
    ), DataPlayer(
        id = "13372287", nickname = "Matvey", avatar = null, hasDotaPlus = true
    ), DataPlayer(
        id = "13372288", nickname = "Ilya", avatar = null, hasDotaPlus = true
    ), DataPlayer(
        id = "13372289", nickname = "Sergey", avatar = null, hasDotaPlus = false
    ), DataPlayer(
        id = "133722810", nickname = "Yaroslav", avatar = null, hasDotaPlus = true
    ), DataPlayer(
        id = "133722811", nickname = "Vladislav", avatar = null, hasDotaPlus = false
    ), DataPlayer(
        id = "133722812", nickname = "Denis", avatar = null, hasDotaPlus = true
    ), DataPlayer(
        id = "133722813", nickname = "Evgeny", avatar = null, hasDotaPlus = false
    ), DataPlayer(
        id = "133722814", nickname = "Bogdan", avatar = null, hasDotaPlus = false
    ), DataPlayer(
        id = "133722815", nickname = "Zakhar", avatar = null, hasDotaPlus = false
    ), DataPlayer(
        id = "133722816", nickname = "Nikolai", avatar = null, hasDotaPlus = false
    ), DataPlayer(
        id = "133722817", nickname = "Pavel", avatar = null, hasDotaPlus = false
    ), DataPlayer(
        id = "133722818", nickname = "Gleb", avatar = null, hasDotaPlus = false
    ), DataPlayer(
        id = "133722819", nickname = "Arseny", avatar = null, hasDotaPlus = false
    ), DataPlayer(
        id = "133722820", nickname = "Vladimir", avatar = null, hasDotaPlus = true
    )
)

@ExperimentalLayoutApi
@Preview(showSystemUi = true, showBackground = true)
@Composable
fun MyUI() {
    MainScreen(
        modifier = Modifier.fillMaxSize(), listOfPlayers = listOfPlayers
    )
}