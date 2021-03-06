package com.example.composeit

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.composeit.ui.theme.ComposeItTheme

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeItTheme {
                Column {
                    Button(onClick = {
                        val intent = Intent(this@MainActivity, Compose1Activity::class.java)
                        startActivity(intent)

                    }) {
                        Text(text = "List with Expand")
                    }

                    Spacer(modifier = Modifier.height(8.dp))

                    Button(onClick = {
                        val intent = Intent(this@MainActivity, Compose2Activity::class.java)
                        startActivity(intent)

                    }) {
                        Text(text = "Image Card")
                    }

                    Spacer(modifier = Modifier.height(8.dp))

                    Button(onClick = {
                        val intent = Intent(this@MainActivity, Compose3Activity::class.java)
                        startActivity(intent)

                    }) {
                        Text(text = "Constraint and State")
                    }
                    Spacer(modifier = Modifier.height(8.dp))

                    Button(onClick = {
                        val intent = Intent(this@MainActivity, AnimationActivity::class.java)
                        startActivity(intent)

                    }) {
                        Text(text = "Animation")
                    }
                    Spacer(modifier = Modifier.height(8.dp))

                    Button(onClick = {
                        val intent = Intent(this@MainActivity, Animation2Activity::class.java)
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
                        val intent = Intent(this@MainActivity, MusicKnobCompleteActivity::class.java)
                        startActivity(intent)

                    }) {
                        Text(text = "Music Knob Complete")
                    }


                }
            }
        }
    }
}