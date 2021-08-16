package com.example.composeit

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ChainStyle
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.ConstraintSet
import androidx.constraintlayout.compose.Dimension
import kotlin.random.Random

class Compose3Activity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            //ColorBox(Modifier.fillMaxSize())
            Constraints()

        }
    }
}

//State
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

        })
}


//In the View system, ConstraintLayout was the recommended way to create large and complex layouts, as a flat view hierarchy
// was better for performance than nested views are. However, this is not a concern in Compose, which is able to efficiently handle deep
//layout hierarchies.
//
// Constraint
@Composable
fun Constraints(modifier: Modifier = Modifier) {
    val constraints = ConstraintSet {
        val greenBox = createRefFor("greenBox")
        val redBox = createRefFor("redBox")
        val guideline = createGuidelineFromTop(0.5f)


        constrain(greenBox) {
            //top.linkTo(parent.top)
            start.linkTo(parent.start)
            bottom.linkTo(guideline)
            width = Dimension.value(100.dp)
            height = Dimension.value(100.dp)
        }
        constrain(redBox) {
            start.linkTo(greenBox.end)
           // top.linkTo(parent.top)
            end.linkTo(parent.end)
            top.linkTo(guideline)
            width = Dimension.value(100.dp)
            height = Dimension.value(100.dp)
        }
        createHorizontalChain(greenBox, redBox, chainStyle = ChainStyle.Packed)
    }

    ConstraintLayout(constraintSet = constraints, modifier = modifier.fillMaxSize()) {
        Box(
            modifier = Modifier
                .background(Color.Green)
                .layoutId("greenBox")
        )
        Box(
            modifier = Modifier
                .background(Color.Red)
                .layoutId("redBox")
        )
    }


}




