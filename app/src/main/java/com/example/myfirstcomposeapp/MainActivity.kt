package com.example.myfirstcomposeapp
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.myfirstcomposeapp.ui.theme.MyFirstComposeAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyFirstComposeAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
//                    SimpleLayoutContent() // Our custom Composable
                    MyScaffoldScreen()
                }
            }
        }
    }
}

data class ListItem(
    val title: String,
    val body: String,
    val icon: ImageVector
)

@Preview(showBackground = true)
@Composable
fun ListComposable(modifier: Modifier = Modifier) {
    val items = listOf(
        ListItem("Item 1", "Description for item 1", Icons.Filled.Add),
        ListItem("Item 2", "Description for item 2", Icons.Filled.Add),
        ListItem("Item 3", "Description for item 3", Icons.Filled.Add)
    )
    Column(modifier = modifier
        .padding(16.dp)
    ) {
        items.forEach {
            item ->
                ListItemComposable(
                    title = item.title,
                    body = item.body,
                    imageIcon = item.icon
                )
                Spacer(modifier = Modifier.height(8.dp))
            }
        }
//        ListItemComposable(
//            title = "Item 1",
//            body = "Description for item 1",
//            imageIcon = Icons.Filled.Add
//        )
}

@Preview(showBackground = true)
@Composable
fun ListItemComposable(
        title: String = "Default Title",
        body: String = "Default Body",
        imageIcon: ImageVector = Icons.Filled.Add,
        modifier: Modifier = Modifier
    ) {
        Row(
            modifier = modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(16.dp))
                .background(color = Color(0xFF4285f4))
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Column {
                Text(
                    text = title,
                    style = MaterialTheme.typography.titleLarge
                )
                Text(
                    text = body,
                    style = MaterialTheme.typography.bodyMedium
                )
            }
            Image(
                imageVector = imageIcon,
                contentDescription = null,
                modifier = Modifier
                    .size(48.dp)
                    .padding(end = 16.dp)
            )
        }
}

@Preview(showBackground = true)
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyScaffoldScreen(){
    Scaffold(
        containerColor = Color.Red, // <--- Set the background color of the Scaffold here
        topBar = {
            TopAppBar(
                title = { Text("My App") },
                navigationIcon = {
                    IconButton(onClick = { /* Handle navigation icon click */ }) {
                        Icon(Icons.Filled.ArrowBack, contentDescription = "Navigate back")
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color.Green // 🔴 将顶部标题栏背景颜色改为绿色
                )
            )
        }
    ) {
        innerPadding ->
        SimpleLayoutContent(modifier = Modifier.padding(innerPadding))
        ListComposable()
    }
}

@Preview(showBackground = true)
@Composable
fun SimpleLayoutContent(modifier: Modifier = Modifier) {
    Column(modifier = modifier
        .fillMaxSize()
        .padding(16.dp)
        .background(color = Color(0xFFe8f0fe)),
    horizontalAlignment = Alignment.CenterHorizontally, // Center content horizontally
    verticalArrangement = Arrangement.Center // Center content vertically
    ) {
        Text(text = "Hello, Compose!")
        Text(text = "This is a simple layout.",
            modifier = Modifier
                .padding(top = 8.dp))
        Spacer(modifier = Modifier.height(24.dp))
        Button(onClick = { /*TODO*/ }) {
            Text("Click Me!")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun SimpleLayoutPreview() {
    MyFirstComposeAppTheme {
        MyScaffoldScreen()
    }
}

// Full screen preview
//@Preview(showBackground = true, device = "id:pixel_7_pro", showSystemUi = true) // Specific device and system UI
//@Composable
//fun FullScreenAppPreview() {
//    MyFirstComposeAppTheme {
////        SimpleLayoutContent()
//        MyScaffoldScreen()
//    }
//}
//
//// You can also create multiple previews for different configurations:
//@Preview(showBackground = true, widthDp = 360, heightDp = 640) // Custom dimensions
//@Composable
//fun SmallPhonePreview() {
//    MyFirstComposeAppTheme {
////        SimpleLayoutContent()
//        MyScaffoldScreen()
//    }
//}