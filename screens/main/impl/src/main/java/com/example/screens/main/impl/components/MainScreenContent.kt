package com.example.screens.main.impl.components

import androidx.annotation.DrawableRes
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.consumeWindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Scaffold
import androidx.compose.material.ScaffoldState
import androidx.compose.material.Surface
import androidx.compose.material.pullrefresh.PullRefreshIndicator
import androidx.compose.material.pullrefresh.PullRefreshState
import androidx.compose.material.pullrefresh.pullRefresh
import androidx.compose.material.pullrefresh.rememberPullRefreshState
import androidx.compose.material.rememberScaffoldState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.FloatingActionButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter.Companion.tint
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.impl.R
import com.example.screens.main.api.data.DataPlayer
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@ExperimentalMaterial3Api
@ExperimentalMaterialApi
@ExperimentalLayoutApi
@Composable
fun MainScreenContent(
    modifier: Modifier = Modifier,
    playersList: List<DataPlayer>,
    scaffoldState: ScaffoldState,
    searchFieldValue: TextFieldValue,
    pullRefreshState: PullRefreshState,
    lazyColumnState: LazyListState,
    @DrawableRes placeHolderDrawableRes: Int,
    isRefreshing: Boolean,
    isFabVisible: Boolean,
    onFabIsClicked: () -> Unit,
    onSearchTextIsChanged: (TextFieldValue) -> Unit,
    onCardIsClicked: (DataPlayer) -> Unit,
    onCardLongClick: (DataPlayer) -> Unit,
) {
    Scaffold(modifier = modifier, scaffoldState = scaffoldState, topBar = {
        AppBar(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight(),
            searchFieldValue = searchFieldValue,
            onSearchFieldValueChange = onSearchTextIsChanged
        )
    }, floatingActionButton = {
        AnimatedVisibility(
            visible = isFabVisible,
            enter = fadeIn(initialAlpha = 0.3f),
            exit = fadeOut(),
        ) {
            FloatingActionButton(
                modifier = Modifier.size(56.dp),
                containerColor = MaterialTheme.colorScheme.primaryContainer,
                elevation = FloatingActionButtonDefaults.elevation(),
                shape = RoundedCornerShape(16.dp),
                onClick = onFabIsClicked,
            ) {
                Image(
                    modifier = Modifier.wrapContentSize(),
                    painter = painterResource(R.drawable.arrow_upward),
                    colorFilter = tint(MaterialTheme.colorScheme.onPrimaryContainer),
                    contentDescription = "Scroll to the top"
                )
            }
        }
    }) { paddingValues ->
        Surface(
            modifier = Modifier.consumeWindowInsets(paddingValues)
        ) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .pullRefresh(pullRefreshState)
                    .background(MaterialTheme.colorScheme.onSurface)
            ) {
                if (playersList.isNotEmpty()) {
                    ListOfPlayers(
                        modifier = Modifier,
                        lazyColumnState = lazyColumnState,
                        playersList = playersList,
                        placeHolderDrawableRes = placeHolderDrawableRes
                    )
                } else {
                    EmptyListOfPlayersPlaceholder(
                        modifier = Modifier.fillMaxSize(), message = "No players found"
                    )
                }

                PullRefreshIndicator(
                    modifier = Modifier.align(Alignment.TopCenter),
                    refreshing = isRefreshing,
                    state = pullRefreshState,
                )
            }
        }
    }
}

@ExperimentalMaterial3Api
@ExperimentalMaterialApi
@ExperimentalLayoutApi
@Preview(showSystemUi = true, showBackground = true)
@Composable
private fun MainScreenContentPreview() {
    val coroutineScope = rememberCoroutineScope()
    val scaffoldState = rememberScaffoldState()
    val lazyColumnState = rememberLazyListState()

    val firstVisibleItemIndex by remember {
        derivedStateOf { lazyColumnState.firstVisibleItemIndex }
    }

    val textFieldValue = remember {
        mutableStateOf(
            TextFieldValue("")
        )
    }
    var isRefreshing by remember { mutableStateOf(false) }
    var isFabVisible by remember { mutableStateOf(true) }
    val pullRefreshState = rememberPullRefreshState(refreshing = isRefreshing, onRefresh = {
        coroutineScope.launch {
            isRefreshing = true
            delay(500L)
            isRefreshing = false
        }
    })

    MaterialTheme {
        MainScreenContent(modifier = Modifier.fillMaxSize(),
            playersList = PlayersList,
            scaffoldState = scaffoldState,
            searchFieldValue = textFieldValue.value,
            pullRefreshState = pullRefreshState,
            lazyColumnState = lazyColumnState,
            placeHolderDrawableRes = R.drawable.dota2_logo_icon,
            isRefreshing = isRefreshing,
            isFabVisible = isFabVisible,
            onFabIsClicked = {
                coroutineScope.launch {
                    lazyColumnState.animateScrollToItem(0)
                    isFabVisible = false
                }
            },
            onSearchTextIsChanged = { textFieldValue.value = it },
            onCardIsClicked = {},
            onCardLongClick = {})
    }

    LaunchedEffect(firstVisibleItemIndex) { isFabVisible = firstVisibleItemIndex >= 3 }
}

@ExperimentalMaterial3Api
@ExperimentalMaterialApi
@ExperimentalLayoutApi
@Preview(showSystemUi = true, showBackground = true)
@Composable
private fun EmptyMainScreenContentPreview() {
    val coroutineScope = rememberCoroutineScope()
    val scaffoldState = rememberScaffoldState()
    val lazyColumnState = rememberLazyListState()

    val firstVisibleItemIndex by remember {
        derivedStateOf { lazyColumnState.firstVisibleItemIndex }
    }

    val textFieldValue = remember {
        mutableStateOf(
            TextFieldValue("")
        )
    }
    var isRefreshing by remember { mutableStateOf(false) }
    var isFabVisible by remember { mutableStateOf(true) }
    val pullRefreshState = rememberPullRefreshState(refreshing = isRefreshing, onRefresh = {
        coroutineScope.launch {
            isRefreshing = true
            delay(500L)
            isRefreshing = false
        }
    })

    MaterialTheme {
        MainScreenContent(modifier = Modifier.fillMaxSize(),
            playersList = listOf(),
            scaffoldState = scaffoldState,
            searchFieldValue = textFieldValue.value,
            pullRefreshState = pullRefreshState,
            lazyColumnState = lazyColumnState,
            placeHolderDrawableRes = R.drawable.dota2_logo_icon,
            isRefreshing = isRefreshing,
            isFabVisible = isFabVisible,
            onFabIsClicked = {
                coroutineScope.launch {
                    lazyColumnState.animateScrollToItem(0)
                    isFabVisible = false
                }
            },
            onSearchTextIsChanged = { textFieldValue.value = it },
            onCardIsClicked = {},
            onCardLongClick = {})
    }

    LaunchedEffect(firstVisibleItemIndex) { isFabVisible = firstVisibleItemIndex >= 3 }
}