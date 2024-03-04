package com.example.composeit

import android.content.Intent
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.composeit.ui.activity.AnimProgressBarActivity
import com.example.composeit.ui.activity.BlurAlphaImageActivity
import com.example.composeit.ui.activity.MusicKnobActivity
import com.example.composeit.ui.activity.MusicKnobCompleteActivity
import com.example.composeit.ui.theme.ComposeItTheme

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeItTheme {
                Column {

                    Button(onClick = {
                        val intent = Intent(this@MainActivity, BlurAlphaImageActivity::class.java)
                        startActivity(intent)

                    }) {
                        Text(text = "Blur Image")
                    }

                    Spacer(modifier = Modifier.height(8.dp))

                    Button(onClick = {
                        val intent = Intent(this@MainActivity, AnimProgressBarActivity::class.java)
                        startActivity(intent)

                    }) {
                        Text(text = "Animation-ProgressBar")
                    }

                    Spacer(modifier = Modifier.height(8.dp))

                    Button(onClick = {
                        val intent = Intent(this@MainActivity, MusicKnobActivity::class.java)
                        startActivity(intent)

                    }) {
                        Text(text = "Music Knob")
                    }

                    Spacer(modifier = Modifier.height(8.dp))

                    Button(onClick = {
                        val intent =
                            Intent(this@MainActivity, MusicKnobCompleteActivity::class.java)
                        startActivity(intent)

                    }) {
                        Text(text = "Music Knob Complete")
                    }
                    Spacer(modifier = Modifier.height(8.dp))

                }
            }
        }
    }
}