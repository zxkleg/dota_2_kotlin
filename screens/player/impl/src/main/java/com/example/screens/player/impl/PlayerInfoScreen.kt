package com.example.screens.player.impl

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.consumeWindowInsets
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.Scaffold
import androidx.compose.material.rememberScaffoldState
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.screens.player.impl.components.AppBar
import com.example.utils.R
import com.example.utils.ui.ExtendedDataPlayer
import com.example.utils.ui.PlayerCard

@ExperimentalLayoutApi
@Composable
fun PlayerInfoScreen(
    modifier: Modifier = Modifier,
    extendedDataPlayer: ExtendedDataPlayer,
    placeHolderDrawableRes: Int
) {
    val scaffoldState = rememberScaffoldState()
    val lazyColumnState = rememberLazyListState()
    Scaffold(modifier = modifier, scaffoldState = scaffoldState,
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
                horizontalAlignment = Alignment.CenterHorizontally,
                contentPadding = PaddingValues(12.dp, 18.dp)
            ) {
                item {
                    PlayerCard(
                        modifier = Modifier
                            .fillMaxWidth()
                            .wrapContentHeight(),
                        extendedDataPlayer = extendedDataPlayer,
                        onProfileLinkIsClicked = {},
                        onSteamProfileLinkIsClicked = {},
                        placeHolderDrawableRes = placeHolderDrawableRes
                    )
                }
            }
        }
    }
}

@ExperimentalLayoutApi
@Composable
@Preview(showSystemUi = true)
private fun PlayerInfoScreenPreview() {
    MaterialTheme {
        PlayerInfoScreen(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
                .background(color = MaterialTheme.colorScheme.surface),
            extendedDataPlayer = ExtendedDataPlayer(
                id = "133722810",
                nickname = "Yaroslav",
                avatar = null,
                hasDotaPlus = true,
                lastOnline = "2 hours ago",
                profileLink = "",
                steamProfileLink = ""
            ),
            placeHolderDrawableRes = R.drawable.dota2_icon_placeholder
        )
    }
}