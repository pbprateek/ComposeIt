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
                        Text(text = "Activity1")
                    }

                    Spacer(modifier = Modifier.height(8.dp))

                    Button(onClick = {
                        val intent = Intent(this@MainActivity, Compose2Activity::class.java)
                        startActivity(intent)

                    }) {
                        Text(text = "Activity2")
                    }

                    Spacer(modifier = Modifier.height(8.dp))

                    Button(onClick = {
                        val intent = Intent(this@MainActivity, Compose3Activity::class.java)
                        startActivity(intent)

                    }) {
                        Text(text = "Activity3")
                    }


                }
            }
        }
    }
}