package com.example.composeit

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import kotlin.random.Random

class Compose3Activity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ColorBox(Modifier.fillMaxSize())
        }
    }
}

@Composable
fun ColorBox(modifier: Modifier = Modifier) {

    var color by remember {
        mutableStateOf(Color.Yellow)
    }

    Box(modifier = modifier
        .background(color)
        .clickable {
            //Whenever we change the color, we are basically changing the state and that will tell compose
            // that recompose every composable depending on this state,So it will recompose the colorbox and
            // will cause it to chage the color of the Box
            //Also if we use mutableStateOf without remember then when we recompose ColorBoc it will again set the state to Yellow,
            //So remember basically remember the value from the last composition.
            //tat's why mutableStateOf is not used without remember bcz it's pointless
            color = Color(Random.nextFloat(), Random.nextFloat(), Random.nextFloat(), 1f)

        }) {

    }


}