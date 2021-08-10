package com.example.treatjetpack

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.treatjetpack.ui.theme.TreatJetPackTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TreatJetPackTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    HomeHeaderComponent()
                }
            }
        }
    }
}


@Composable
fun HomeHeaderComponent() = Row (
    horizontalArrangement = Arrangement.SpaceBetween,
    modifier = Modifier
        .padding(horizontal = 16.dp, vertical = 8.dp)
        .fillMaxWidth()
){
    Column(
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "Delivery to -:",
            style = MaterialTheme.typography.subtitle1,
            fontWeight = FontWeight.Bold,
        )
        Row {
            Icon(
                modifier = Modifier.size(20.dp),
                painter = painterResource(id = R.drawable.ic_baseline_location_on_24),
                contentDescription = null
            )
            Text(
                text = "Gilgil,Nakuru",
                style = MaterialTheme.typography.subtitle2
            )
        }

    }
    //Profile picture
    Image(
        painter = painterResource(id = R.drawable.profile_picture),
        contentDescription = null,
        Modifier
            .size(40.dp)
            .clip(shape = CircleShape)
            .border(1.5.dp, MaterialTheme.colors.secondaryVariant, CircleShape)
    )
}

@Composable
fun SearchSectionComponent(){
    TextField(
        value = "",
        singleLine = true,
        onValueChange = {},
        shape = RoundedCornerShape(percent = 10),
        modifier= Modifier
            .padding(all = 8.dp)
            .fillMaxWidth(),
        leadingIcon = {
            Icon(
                painter = painterResource(
                    id = R.drawable.ic_baseline_search_24
                ),
                contentDescription =  null
            )
        },
        label = {Text(text = "Search Dish or Restaurant")},
        colors = TextFieldDefaults.textFieldColors(
            textColor = Color.Gray,
            backgroundColor =  Color.White,
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
            disabledIndicatorColor = Color.Transparent
        )
    )
}
data class Restaurant(
    val image:Int,
    val restaurantName:String,
    val cuisine:String,
    val rating:Int,
    val distance:Int,
    val timeArrive:Int
    )


@Composable
fun PopularNearYouSection(){

}

@Composable
fun PopularNearYouItem(){
    Card(
        modifier = Modifier.width(300.dp),
        shape = RoundedCornerShape(15.dp)
    ){
        Column {
            Image(
                modifier = Modifier.fillMaxWidth(),
                // TODO(04) How to make the image cover the full width of the card
                painter = painterResource(id = R.drawable.profile_picture),
                contentDescription = null
            )

            Column(
                modifier = Modifier.padding(horizontal = 16.dp,vertical = 16.dp)
            ) {
                Text(text = "Mc Donald's - Thai Hai")
                Text(text = "Western Cuisine, Fast Food Burger")
            }
            Row {
                //TODO(03) Add rating bar

            }
        }
    }
}

@Composable
fun DistanceChipComponent(
    icon:Int, textToDisplay:String
){
    Box (
        modifier = Modifier
            .clip(shape = RoundedCornerShape(size = 20.dp))
            .background(
                color = Color.Gray,
            )
            .padding(all = 8.dp)
    ){
        Row() {
            Icon(
                painter = painterResource(id = icon),
                contentDescription = null
            )
            Text(text = textToDisplay)
        }
    }

}

@Composable
fun CategoryItemComponent(){
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Icon(
            painter = painterResource(id = R.drawable.ic_baseline_location_on_24),
            contentDescription = null 
        )
        Text(text = "Food")
        Text(text = "238 places")
    }
}

/*
TODO(01) Create the search component
: using the the textField component
:leading icon - import a search icon vector to the project
:hint text : Search for dish or restaurant
:The singleLine should be True
:Colors use the selected colors

TODO(02) CREATE THE PROMOTION COMPONENT : Using the lazy row
: create the promotion item component
TODO(03) import the theme colors and theme typography
TODO(04) Use the scaffold component to hold the screen and the app bar for the header component
*/



@Preview( name = "Light mode", showBackground = false)
@Composable
fun DefaultPreview (){
    TreatJetPackTheme {
        CategoryItemComponent()
    }
}








