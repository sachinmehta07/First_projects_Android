package com.example.diceroller

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button

import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.diceroller.ui.theme.DiceRollerTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DiceRollerTheme {
                DiceRollApp()
                }
            }
        }
    }


@Preview
@Composable
fun DiceRollApp(){
    //FillMaxSize layout fills the entire screen.
    //wrapContentSize() method specifies that
    // the available space should at least be as large as the components inside of it.
    DiceWithImageAndButton(modifier = Modifier
        .fillMaxSize()
        .wrapContentSize(Alignment.Center))
}

@Composable
fun DiceWithImageAndButton(modifier: Modifier = Modifier){
    var result by remember { mutableStateOf(1) }
    val imageresources = when(result){
        1 -> R.drawable.dice_1
        2 -> R.drawable.dice_2
        3 -> R.drawable.dice_3
        4 -> R.drawable.dice_4
        5 -> R.drawable.dice_5
        else -> R.drawable.dice_6
    }

        Column(modifier = Modifier,
            //This ensures that the column is centered on the device screen with respect to the width.
            horizontalAlignment = Alignment.CenterHorizontally

        )
        {
            Image(painter = painterResource(imageresources),
                contentDescription = result.toString())
            //Spacer composable between the two. A Spacer takes a Modifier as a parameter.
            // In this case, the Image is above the Button, so there needs
            // to be a vertical space between them. Therefore,
            // the Modifier's height can be set to apply to the Spacer
            Spacer(modifier = Modifier.height(16.dp))

            Button(onClick = { result = (1..6).random() }) {
                Text(text = stringResource(id = R.string.Roll)
                )

            }
        }
    }

