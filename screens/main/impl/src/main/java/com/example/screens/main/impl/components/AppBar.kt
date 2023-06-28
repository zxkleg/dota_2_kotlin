package com.example.screens.main.impl.components

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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter.Companion.tint
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.impl.R


@Composable
fun AppBar(
    modifier: Modifier = Modifier,
    searchFieldValue: TextFieldValue = TextFieldValue(""),
    onSearchFieldValueChange: (TextFieldValue) -> Unit = { }
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .background(color = MaterialTheme.colorScheme.primary)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
                .padding(horizontal = 16.dp, vertical = 8.dp)
                .align(Alignment.Center)
                .clip(shape = RoundedCornerShape(50))
                .background(Color.White)
                .clickable(onClick = {})
                .background(color = MaterialTheme.colorScheme.primaryContainer)
        ) {
            Box(
                modifier = Modifier
                    .wrapContentHeight()
                    .clip(shape = CircleShape)
                    .align(Alignment.CenterVertically)
                    .clickable(onClick = {})
                    .background(color = MaterialTheme.colorScheme.primaryContainer)
            ) {
                Image(
                    painter = painterResource(R.drawable.icon),
                    contentDescription = "Menu Button",
                    colorFilter = tint(MaterialTheme.colorScheme.onPrimaryContainer),
                    modifier = Modifier
                        .wrapContentSize()
                        .padding(19.dp, 22.dp)
                        .background(color = MaterialTheme.colorScheme.primaryContainer)
                )
            }
            TextField(
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight()
                    .background(
                        color = MaterialTheme.colorScheme.primaryContainer
                    ),
                shape = RoundedCornerShape(50),
                colors = OutlinedTextFieldDefaults.colors(
                    focusedContainerColor = Color.Transparent,
                    unfocusedContainerColor = Color.Transparent,
                    disabledContainerColor = Color.Transparent,
                    focusedBorderColor = Color.Transparent,
                    unfocusedBorderColor = Color.Transparent,
                    disabledBorderColor = Color.Transparent,
                    errorBorderColor = Color.Transparent,
                ),
                singleLine = true,
                placeholder = {
                    Text(
                        text = stringResource(R.string.search_for_players),
                        color = MaterialTheme.colorScheme.onPrimaryContainer,
                        style = MaterialTheme.typography.bodyLarge
                    )
                },
                value = searchFieldValue,
                onValueChange = onSearchFieldValueChange,
            )
        }
    }
}

@ExperimentalMaterial3Api
@Preview
@Composable
private fun AppBarPreview() {
    AppBar(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
    )
}