package com.example.dota2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.dota2.ui.theme.Dota2Theme
import com.example.screens.main.impl.MainScreenHolder

@ExperimentalLayoutApi
@ExperimentalMaterialApi
@ExperimentalMaterial3Api
@ExperimentalFoundationApi
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Dota2Theme(dynamicColor = false) {
                // A surface container using the 'background' color from the theme
                MainScreenHolder(modifier = Modifier.fillMaxSize())
            }
        }
    }
}

@ExperimentalLayoutApi
@ExperimentalMaterialApi
@ExperimentalMaterial3Api
@ExperimentalFoundationApi
@Preview(showBackground = true, showSystemUi = true)
@Composable
fun AppPreview() {
    Dota2Theme {
        MainScreenHolder(modifier = Modifier.fillMaxSize())
    }
}