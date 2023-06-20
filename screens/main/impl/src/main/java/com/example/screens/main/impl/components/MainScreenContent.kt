package com.example.screens.main.impl.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.screens.main.api.data.DataPlayer

@Composable
fun MainScreenContent(
    modifier: Modifier,
    lazyColumnState: LazyListState,
    listOfPlayers: List<DataPlayer>,
    placeHolderDrawableRes: Int
) {
    LazyColumn(
        modifier = modifier,
        state = lazyColumnState,
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally,
        contentPadding = PaddingValues(
            horizontal = 12.dp, vertical = 18.dp
        )
    ) {
        items(listOfPlayers.size, key = { index -> listOfPlayers[index].id }) { index ->
            SmallPlayerCard(
                dataPlayer = listOfPlayers[index], placeHolderDrawableRes = placeHolderDrawableRes
            )
            if (index != listOfPlayers.lastIndex) Spacer(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(8.dp)
            )
        }
    }
}