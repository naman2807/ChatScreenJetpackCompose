package com.example.chatscreenjetpackcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.chatscreenjetpackcompose.ui.theme.ChatScreenJetpackComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
           MessageCard(message = Message("Colleague", "First Chat"))
        }
    }

    @Composable
    fun MessageCard(message: Message) {
        Row() {
           Image(painter = painterResource(id = R.drawable.profile), contentDescription ="profile" )
        }
        Column() {
            Text(text = "${message.author}!")
            Text(text = "${message.content}!")
        }

    }


    @Preview
    @Composable
    fun PreviewMessageCard() {
        MessageCard(message = Message("Colleague", "First Chat"))

    }

    data class Message(val author: String, val content:String)
}
