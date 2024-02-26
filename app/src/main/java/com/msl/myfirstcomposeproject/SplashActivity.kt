package com.msl.myfirstcomposeproject

import android.content.Context
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import com.msl.myfirstcomposeproject.ui.theme.MyFirstComposeProjectTheme

class SplashActivity(navController:  NavController) : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyFirstComposeProjectTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting("Android")
                }
            }
        }
    }
}

data class ListItem(val title: String, val icon: ImageVector, val imageUrl: String)

@Composable
fun CustomListItem(item: ListItem,context: Context) {
    Card(
        modifier = Modifier.padding(8.dp).width(150.dp)
    ){
        Column(
            modifier = Modifier
                .padding(8.dp)
                .clip(MaterialTheme.shapes.small)
                .background(MaterialTheme.colorScheme.surface)
                .clickable {
                    Toast.makeText(context,"item = "+item.title, Toast.LENGTH_SHORT).show()

                },
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            AsyncImage(
                model = item.imageUrl,
                contentDescription = item.title,
                modifier = Modifier.fillMaxWidth().height(150.dp)
            )
            Icon(
                imageVector = item.icon,
                contentDescription = null,
                modifier = Modifier
                    .size(38.dp)
                    .padding(8.dp)
            )
            Text(
                text = item.title,
                modifier = Modifier
                    .padding(8.dp),
                fontSize = 11.sp
            )
        }
    }

}
@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {

    val context = LocalContext.current
    val luckyItems = listOf(
        ListItem("Item 1", Icons.Default.Home,"https://i.pinimg.com/originals/d0/d6/eb/d0d6eb27e479fc72acc48f67df6df3a8.jpg"),
        ListItem("Item 2", Icons.Default.Search,"https://w0.peakpx.com/wallpaper/587/312/HD-wallpaper-indian-girl-beautiful-eyes-hair-insta-lips-model-smile.jpg"),
        ListItem("Item 3", Icons.Default.Favorite,"https://miro.medium.com/v2/resize:fit:495/0*xFuo_UNWchLZ8bqS.jpeg"),
        ListItem("Item 4", Icons.Default.Home,"https://govtexamlive.com/wp-content/uploads/2024/01/real-girl-pic49.jpg"),
        ListItem("Item 5", Icons.Default.Search,"https://mastimorning.com/wp-content/uploads/2023/07/Best-HD-girls-whatsapp-dp-Wallpaper-Pics-New-Download.jpg"),
        ListItem("Item 6", Icons.Default.Favorite,"https://i.pinimg.com/236x/f0/c8/39/f0c83947cb49df71f813e1a6c9fe51aa.jpg"),
        ListItem("Item 7", Icons.Default.Home,"https://storage.googleapis.com/pai-images/e89218fda084407e895972b0e3b90388.jpeg"),
        ListItem("Item 8", Icons.Default.Search,"https://w0.peakpx.com/wallpaper/225/259/HD-wallpaper-ladies-red-saree-look-traditional-look-indian-girl.jpg"),
        ListItem("Item 9", Icons.Default.Favorite,"https://i0.wp.com/www.grihshobha.in/wp-content/uploads/2018/04/girl-smile-hd-wallpaper-wide-desktop-asian-girls-wallpapers.jpg"),
        // Add more items as needed
    )
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.End,

        ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
                .background(Color.White)
                .border(1.dp, Color.LightGray, shape = MaterialTheme.shapes.small)
                .clickable {
                    Toast
                        .makeText(context, "Lucky Agarwal", Toast.LENGTH_SHORT)
                        .show()
                },
            contentAlignment = Alignment.Center,
        ) {
            Text(
                text = "Hello Lucky $name!",
                modifier = modifier.padding(vertical = 16.dp),
                color = Color.Black
            )
        }
        LazyRow(
            modifier = Modifier
                .fillMaxWidth()
                .background(color = Color.Gray)
                .padding(5.dp)
        ) {
            items(luckyItems) { luckyItems ->
                CustomListItem(luckyItems,context)
            }
        }
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
                .background(Color.White)
                .border(1.dp, Color.LightGray, shape = MaterialTheme.shapes.small)
                .clickable {
                    // Navigate to Screen 2 when the button is clicked

                    Toast
                        .makeText(context, "Lucky Agarwal Two", Toast.LENGTH_SHORT)
                        .show()
                },
            contentAlignment = Alignment.Center,
        ) {
            Image(
                painter = painterResource(id = R.drawable.ic_launcher_background),
                contentDescription = null, // Set a content description if needed
                modifier = Modifier
                    .size(width = 200.dp, height = 150.dp)
                    .clip(shape = MaterialTheme.shapes.medium), // Adjust the clip shape as needed
                contentScale = ContentScale.Crop
            )
            Text(
                text = "Hello Agarwal $name!",
                modifier = modifier.padding(vertical = 16.dp),
                color = Color.Black
            )
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp, 40.dp)
                .background(Color.Blue),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "This is Row",
                color = Color.White,
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(start = 20.dp)
            )
            Text(
                text = "This is my new Screen",
                color = Color.White,
                fontSize = 11.sp,
                fontWeight = FontWeight.Light,
                modifier = Modifier.padding(end = 20.dp)
            )
        }
    }

}

@Preview(showBackground = true)
@Composable
fun GreetingPreview3() {
    MyFirstComposeProjectTheme {
        Greeting("Android")
    }
}