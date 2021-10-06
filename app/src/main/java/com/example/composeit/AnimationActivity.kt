package com.example.composeit

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.animateColor
import androidx.compose.animation.core.*
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composeit.ui.theme.ComposeItTheme

class AnimationActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeItTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {

                    //Animation in android also runs on a very declaritive way
                    //We are basically just changing the size or color in a way that it looks like animation.
                    //If u see below we just pass a mutable size to the view and we are just changing the value of the state
                    //which is making the compose animate

                    //Animation of Size
                    var sizeState by remember { mutableStateOf(200.dp) }
                    //This will animate towards the targetValue and if in between there is change in the value while animation
                    //is going on, it will adjust
                    //In animationSpec we tell what animation to use, tween, spring, snap or even "KeyframeSpec" for even more control
                    //which is pretty low level API and easy to use
                    val size by animateDpAsState(
                        targetValue = sizeState,
                        animationSpec = spring(
                            dampingRatio = Spring.DampingRatioHighBouncy,
                            stiffness = Spring.StiffnessLow
                        )
                    )
                    //animationSpec =tween(durationMillis = 3000, delayMillis = 300,easing = FastOutSlowInEasing )


                    //Infinite Animation on Color
                    //We can use this to animate float, value or color and it will run infinite
                    val infiniteTransition = rememberInfiniteTransition()
                    val color by infiniteTransition.animateColor(
                        initialValue = Color.Red,
                        targetValue = Color.Gray,
                        animationSpec = infiniteRepeatable(
                            animation = tween(durationMillis = 2000),
                            repeatMode = RepeatMode.Reverse
                        )
                    )



                    Box(
                        modifier = Modifier
                            .size(size)
                            .background(color = color), contentAlignment = Alignment.Center
                    ) {

                        Button(onClick = {

                            sizeState += 50.dp


                        }) {
                            Text(text = "Increase Size")
                        }

                    }


                }
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview2() {
    ComposeItTheme {

    }
}