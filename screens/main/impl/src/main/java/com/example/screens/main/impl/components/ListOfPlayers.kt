package com.example.screens.main.impl.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.screens.main.api.data.DataPlayer

@Composable
internal fun ListOfPlayers(
    modifier: Modifier,
    lazyColumnState: LazyListState,
    playersList: List<DataPlayer>,
    placeHolderDrawableRes: Int
) {
    LazyColumn(
        modifier = modifier.background(MaterialTheme.colorScheme.surface),
        state = lazyColumnState,
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally,
        contentPadding = PaddingValues(
            horizontal = 12.dp, vertical = 18.dp
        )
    ) {
        items(playersList.size, key = { index -> playersList[index].id }) { index ->
            SmallPlayerCard(
                dataPlayer = playersList[index], placeHolderDrawableRes = placeHolderDrawableRes
            )
            if (index != playersList.lastIndex) Spacer(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(8.dp)
            )
        }
    }
}