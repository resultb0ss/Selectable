package com.example.selectable

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.selectable.FirstQuestion
import com.example.selectable.ui.theme.SelectableTheme

class SecondQuestion : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {

            var count = intent.getIntExtra("count",0)

            var checkedOne = remember { mutableStateOf(false) }
            var checkedTwo = remember { mutableStateOf(false) }
            var checkedThree = remember { mutableStateOf(false) }
            var checkedFour = remember { mutableStateOf(false) }

            Log.d("@@@","SecondActivity, Count = $count")
            Column(modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally) {
                Text(text = "Столица России?",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White,
                    modifier = Modifier
                        .background(Color.DarkGray, shape = CircleShape)
                        .clip(shape = CircleShape)
                        .padding(all = 16.dp))

                Row (verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Start, modifier = Modifier.fillMaxWidth())
                {
                    Checkbox(checked = checkedOne.value, onCheckedChange = {checkedOne.value = it})
                    Text(text = "1. Москва", fontSize = 18.sp)
                }

                Row (verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Start, modifier = Modifier.fillMaxWidth())
                {
                    Checkbox(checked = checkedTwo.value, onCheckedChange = {checkedTwo.value = it})
                    Text(text = "2. Пекин", fontSize = 18.sp)
                }

                Row (verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Start, modifier = Modifier.fillMaxWidth())
                {
                    Checkbox(checked = checkedThree.value, onCheckedChange = {checkedThree.value = it})
                    Text(text = "3. Лондон", fontSize = 18.sp)
                }

                Row (verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Start, modifier = Modifier.fillMaxWidth())
                {
                    Checkbox(checked = checkedFour.value, onCheckedChange = {checkedFour.value = it})
                    Text(text = "4. Таганрог", fontSize = 18.sp)
                }

                Spacer(modifier = Modifier.padding(16.dp))

                Button(onClick = {if (checkedOne.value == true && ((checkedTwo.value == false) &&
                            (checkedThree.value == false) &&
                            (checkedFour.value == false))) {
                    count = count + 1

                }

                    val intent = Intent(this@SecondQuestion, ThirdQuestion::class.java)
                    intent.putExtra("count", count)
                    startActivity(Intent(intent))
                },

                    colors = ButtonDefaults.buttonColors(
                        contentColor = Color.Black,
                        containerColor = Color.Gray)) {
                    Text(text = "Ответить!", fontSize = 16.sp, fontWeight = FontWeight.Bold)
                }
            }
        }
    }
}
