package com.example.selectable

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class ThirdQuestion : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {

            var count = intent.getIntExtra("count", 0)
            val hats = listOf<Painter>(
                painterResource(id = R.drawable.one),
                painterResource(id = R.drawable.two),
                painterResource(id = R.drawable.three),
            )
            val selectedHat = remember { mutableStateOf(hats[0]) }

            Log.d("@@@", "ThirdActivity")
            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "Какая из них шапка мономаха?",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White,
                    modifier = Modifier
                        .background(Color.DarkGray, shape = CircleShape)
                        .clip(shape = CircleShape)
                        .padding(all = 16.dp)
                        .fillMaxWidth()
                )

                hats.forEach { hat ->
                    val selected = selectedHat.value == hat
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .selectable(selected = selected,
                                onClick = { selectedHat.value = hat }),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Box(
                            Modifier
                                .padding(8.dp)
                                .size(100.dp)
                                .clip(shape = RoundedCornerShape(20.dp))
                                .background(Color.White)
                                .border(
                                    width = 3.dp,
                                    color = if (selected) Color.Black else Color.Transparent,
                                    shape = RoundedCornerShape(20.dp)
                                )
                        ) {
                            Image(
                                painter = hat,
                                contentDescription = "option",
                                modifier = Modifier.padding(8.dp)
                            )
                        }
                    }
                }
                Log.d("@@@", "Selected = ${selectedHat.value}")



                Spacer(modifier = Modifier.padding(16.dp))

                Button(
                    onClick = {
                        if (selectedHat.value == hats[0]) {
                            count = count + 1

                        }

                        val intent = Intent(this@ThirdQuestion, ResultActivity::class.java)
                        intent.putExtra("count", count)
                        startActivity(Intent(intent))
                    },

                    colors = ButtonDefaults.buttonColors(
                        contentColor = Color.Black,
                        containerColor = Color.Gray
                    )
                ) {
                    Text(text = "Ответить!", fontSize = 16.sp, fontWeight = FontWeight.Bold)
                }
            }
        }
    }
}
