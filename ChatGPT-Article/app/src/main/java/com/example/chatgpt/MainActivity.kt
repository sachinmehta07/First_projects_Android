package com.example.chatgpt

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.chatgpt.ui.theme.ChatGPTTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ChatGPTTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    ChatGptArticleApp()
                }
            }
        }
    }
}

@Composable
fun ChatGptArticleApp(){
  ArticleCard(
      //R class is automatic generated class
      //that contains ID of all resources in project
      title = stringResource(id = R.string.title_chatGpt_tutorial),
      shortDescription = stringResource(id = R.string.chatgpt_short_desc),
      longDescription = stringResource(id = R.string.chatgpt_long_desc),
      //painterResource() loads the drawable img res and takes res_ID
      imagePainter = painterResource(id = R.drawable.chatgpt)
  )
}
//COMPOSE FUN ALWAYS WRITTEN IN PASCLE CASE
//Basic building block of UI
@Composable
private fun ArticleCard(
    title: String,
    shortDescription: String,
    longDescription: String,
    imagePainter: Painter,
    modifier: Modifier = Modifier,
) {
    //modifier are used to decorate or add behaviour to compose UI_ELE
    //here column is used to place the data in vertical form on screen
    Column(modifier = modifier) {
        Image(painter = imagePainter, contentDescription = null)
        Text(
            text = title,
            fontSize = 24.sp,
            modifier = Modifier.padding(16.dp)
        )
        //
        //Justify
        //Stretch lines of text that end with a soft line
        // break to fill the width of the container.
        Text(
            text = shortDescription,
            textAlign = TextAlign.Justify,
            modifier = Modifier.padding(start = 16.dp, end = 16.dp)
        )
        Text(
            text = longDescription,
            textAlign = TextAlign.Justify,
            modifier = Modifier.padding(16.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ChatGPTTheme {
       ChatGptArticleApp()
    }
}