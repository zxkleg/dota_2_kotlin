package com.example.screens.main.impl

import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.consumeWindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.impl.R
import com.example.screens.main.api.data.DataPlayer
import com.example.screens.main.impl.components.AppBar
import com.example.screens.main.impl.components.ListOfPlayers
import com.example.screens.main.impl.components.MainScreenContent

@ExperimentalLayoutApi
@Composable
fun MainScreen(
    modifier: Modifier = Modifier, listOfPlayers: List<DataPlayer>, placeHolderDrawableRes: Int
) {
    val scaffoldState = rememberScaffoldState()
    val lazyColumnState = rememberLazyListState()
    Scaffold(modifier = modifier, scaffoldState = scaffoldState, topBar = {
        AppBar()
    }) { paddingValues ->
        Surface(
            modifier = Modifier.consumeWindowInsets(paddingValues)
        ) {
            MainScreenContent(
                modifier = modifier,
                lazyColumnState = lazyColumnState,
                listOfPlayers = listOfPlayers,
                placeHolderDrawableRes = placeHolderDrawableRes
            )

        }
    }
}

@ExperimentalLayoutApi
@Preview(showSystemUi = true, showBackground = true)
@Composable
fun MainScreenPreview() {
    MainScreen(
        modifier = Modifier.fillMaxSize(),
        listOfPlayers = ListOfPlayers,
        placeHolderDrawableRes = R.drawable.dota2_logo_icon
    )
}