package com.example.screens.main.impl

import androidx.annotation.DrawableRes
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.pullrefresh.rememberPullRefreshState
import androidx.compose.material.rememberScaffoldState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import com.example.impl.R
import com.example.screens.main.impl.components.MainScreenContent
import com.example.utils.mvi.collectInLaunchedEffect
import com.example.utils.mvi.use
import kotlinx.coroutines.launch

@Composable
@ExperimentalLayoutApi
@ExperimentalMaterialApi
@ExperimentalMaterial3Api
@ExperimentalFoundationApi
fun MainScreen(
    modifier: Modifier = Modifier,
    viewModel: MainScreenViewModel,
    @DrawableRes
    placeHolderDrawableRes: Int = R.drawable.dota2_logo_icon,
) {
    val (state, event, effect) = use(viewModel)

    val coroutineScope = rememberCoroutineScope()
    val scaffoldState = rememberScaffoldState()
    val lazyColumnState = rememberLazyListState()
    val firstVisibleItemIndex by remember {
        derivedStateOf { lazyColumnState.firstVisibleItemIndex }
    }
    val pullRefreshState = rememberPullRefreshState(
        refreshing = state.isLoading,
        onRefresh = {
            event(MainScreenContract.Event.RefreshList)
        }
    )

    effect.collectInLaunchedEffect { incomingEffect ->
        when (incomingEffect) {
            is MainScreenContract.Effect.NavigateToPlayerScreen -> {
                // TODO: Open Player info screen
            }

            is MainScreenContract.Effect.ShowPlayerCardDialog -> {
                // TODO: Open Player card dialog
            }

            MainScreenContract.Effect.ScrollListToTheTop ->
                coroutineScope.launch {
                    lazyColumnState.animateScrollToItem(0)
                }
        }
    }

    LaunchedEffect(firstVisibleItemIndex) {
        if (firstVisibleItemIndex >= 3)
            event(MainScreenContract.Event.ListWasOverScrolled)
        else
            event(MainScreenContract.Event.ListIsOnTop)
    }

    MainScreenContent(
        modifier = modifier,
        scaffoldState = scaffoldState,
        searchFieldValue = state.searchPattern,
        pullRefreshState = pullRefreshState,
        playersList = state.players,
        lazyColumnState = lazyColumnState,
        placeHolderDrawableRes = placeHolderDrawableRes,
        isRefreshing = state.isLoading,
        isFabVisible = state.isFabVisible,
        onFabIsClicked = { event(MainScreenContract.Event.FabWasClicked) },
        onSearchTextIsChanged = { event(MainScreenContract.Event.SearchPatternInput(it)) },
        onCardIsClicked = { event(MainScreenContract.Event.PlayerCardWasClicked(it)) },
        onCardLongClick = { event(MainScreenContract.Event.PlayerCardWasLongClicked(it)) }
    )
}

