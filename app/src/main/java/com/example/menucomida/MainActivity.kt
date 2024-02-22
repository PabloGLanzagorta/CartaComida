package com.example.menucomida

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.menucomida.ui.theme.MenuComidaTheme
import com.example.menucomida.data.DataSource
import com.example.menucomida.model.Platillo

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MenuComidaTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MenuApp()

                }
            }
        }
    }
}
@Composable
fun MenuApp(){
    MenuCardList(
        platilloList = DataSource().LoadPlatillos(),
    )
}

@Composable
fun MenuCardList( platilloList:List<Platillo>, modifier: Modifier = Modifier ){
    LazyColumn( modifier = modifier ){
        items(platilloList){
                platillo -> MenuCard(
            platillo = platillo,
            modifier= Modifier
                .padding(10.dp)
        )
        }

    }
}



@Composable
fun MenuCard(platillo: Platillo, modifier: Modifier = Modifier){
    Card(modifier = Modifier) {
        Row{
            Image(
                painter = painterResource(id = platillo.drawableResourceId),
                contentDescription = stringResource(id = platillo.stringResourceId),
                modifier = Modifier
                    .size(130.dp)
                    .clip(CircleShape),
                contentScale = ContentScale.Crop
            )
            Column {
                Text(
                    text = LocalContext.current.getString(platillo.stringResourceId),
                    textAlign = TextAlign.Center,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(1.dp)
                        .fillMaxSize(),
                    style = MaterialTheme.typography.headlineLarge
                )
                Text(
                    text = LocalContext.current.getString(platillo.stringResourceId+1),
                    textAlign = TextAlign.Center,
                    modifier = Modifier.padding(1.dp)
                        .fillMaxSize(),
                    style = MaterialTheme.typography.titleLarge
                )
                Text(
                    text = LocalContext.current.getString(platillo.stringResourceId+2),
                    color = Color.Blue,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.padding(1.dp)
                        .fillMaxSize(),
                    style = MaterialTheme.typography.labelLarge
                )
            }

        }

    }


}

@Preview(showBackground = true)
@Composable
fun MenuPlatilloPreview() {
    MenuComidaTheme {
        MenuCard(platillo = Platillo(R.string.pozolea,R.drawable.pozole) )
    }
}