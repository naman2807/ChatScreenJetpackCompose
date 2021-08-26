package com.example.chatscreenjetpackcompose

import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*

import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Conversation(messages = SampleData.conversationSample)
        }
    }

    @Composable
    fun Conversation(messages: List<Message>){
        LazyColumn{
            items(messages){
                message -> MessageCard(message = message)
            }
        }
    }

    @Composable
    fun MessageCard(message: Message) {
        // Add padding around our message
        Row(modifier = Modifier.padding(all = 8.dp)) {
            Image(
                painter = painterResource(R.drawable.profile),
                contentDescription = "Contact profile picture",
                modifier = Modifier
                    // Set image size to 40 dp
                    .size(40.dp)
                    // Clip image to be shaped as a circle
                    .clip(CircleShape)
                    .border(1.5.dp, MaterialTheme.colors.secondary, CircleShape)
            )

            // Add a horizontal space between the image and the column
            Spacer(modifier = Modifier.width(8.dp))

            // We keep track if the message is expanded or not in this
            // variable
            var isExpanded by remember { mutableStateOf(false) }

            // surfaceColor will be updated gradually from one color to the other
            val surfaceColor: Color by animateColorAsState(
                if (isExpanded) MaterialTheme.colors.primary else MaterialTheme.colors.surface,
            )

            // We toggle the isExpanded variable when we click on this Column
            Column(modifier = Modifier.clickable { isExpanded = !isExpanded }) {
                Text(text = message.author,
                color = MaterialTheme.colors.primary,
                    style = MaterialTheme.typography.subtitle2
                )
                // Add a vertical space between the author and message texts
                Spacer(modifier = Modifier.height(4.dp))
                Text(text = message.content,
                style = MaterialTheme.typography.body2
                )
            }
        }
    }


    @Preview(name = "Light Mode")
    @Preview(
        uiMode = Configuration.UI_MODE_NIGHT_YES,
        showBackground = true,
        name = "Dark Mode"
    )
    @Composable
    fun PreviewMessageCard() {
        Conversation(messages = SampleData.conversationSample)

    }

    data class Message(val author: String, val content: String)

    object SampleData {
        // Sample conversation data
        val conversationSample = listOf(
            Message(
                "Colleague",
                "Test...Test...Test..."
            ),
            Message(
                "Colleague",
                "List of Android versions:\n" +
                        "Android KitKat (API 19)\n" +
                        "Android Lollipop (API 21)\n" +
                        "Android Marshmallow (API 23)\n" +
                        "Android Nougat (API 24)\n" +
                        "Android Oreo (API 26)\n" +
                        "Android Pie (API 28)\n" +
                        "Android 10 (API 29)\n" +
                        "Android 11 (API 30)\n" +
                        "Android 12 (API 31)\n"
            ),
            Message(
                "Colleague",
                "I think Kotlin is my favorite programming language.\n" +
                        "It's so much fun!"
            ),
            Message(
                "Colleague",
                "Searching for alternatives to XML layouts..."
            ),
            Message(
                "Colleague",
                "Hey, take a look at Jetpack Compose, it's great!\n" +
                        "It's the Android's modern toolkit for building native UI." +
                        "It simplifies and accelerates UI development on Android." +
                        "Less code, powerful tools, and intuitive Kotlin APIs :)"
            ),
            Message(
                "Colleague",
                "It's available from API 21+ :)"
            ),
            Message(
                "Colleague",
                "Writing Kotlin for UI seems so natural, Compose where have you been all my life?"
            ),
            Message(
                "Colleague",
                "Android Studio next version's name is Arctic Fox"
            ),
            Message(
                "Colleague",
                "Android Studio Arctic Fox tooling for Compose is top notch ^_^"
            ),
            Message(
                "Colleague",
                "I didn't know you can now run the emulator directly from Android Studio"
            ),
            Message(
                "Colleague",
                "Compose Previews are great to check quickly how a composable layout looks like"
            ),
            Message(
                "Colleague",
                "Previews are also interactive after enabling the experimental setting"
            ),
            Message(
                "Colleague",
                "Have you tried writing build.gradle with KTS?"
            ),
        )
    }
}
