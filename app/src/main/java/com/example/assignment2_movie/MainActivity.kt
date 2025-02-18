package com.example.assignment2_movie

import android.os.Bundle
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
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

//Movie data
//data class Movie(
//    val title: String,
//    val length: String,
//    val language: String,
//    val rating: Double,
//    val reviews: String,
//    val poster: Int,
//    val thumbnail: Int
//)


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            
            MovieCard("Casablanca", "1:42", "Eng", 8.5, "150k+", R.drawable.casablanca, R.drawable.casablanca, modifier = Modifier)
            
        }
    }
}

@Composable
fun MovieCard(title: String, length: String, language: String, rating: Double, reviews: String, poster: Int, thumbnail: Int, modifier: Modifier) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(520.dp)
            .padding(16.dp)
            .clip(RoundedCornerShape(12.dp))
            .background(Color.White)
            .border(1.dp, Color.Gray, RoundedCornerShape(12.dp))
    ){

            // Large Movie Poster
            Image(
                painter = painterResource(poster),
                contentDescription = "Movie Poster",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(450.dp)
                    .clip(RoundedCornerShape(topStart = 12.dp, topEnd = 12.dp))
                    .offset(0.dp,(-70).dp)
            )

            // Small Thumbnail Overlapping
            Box(
                modifier = Modifier
                    .padding(top = 30.dp, start = 16.dp)
                    .size(70.dp)
                    .offset(10.dp,300.dp)
                    .clip(RoundedCornerShape(8.dp)),
                ) {
                Image(
                    painter = painterResource(thumbnail),
                    contentDescription = "Thumbnail",
                    contentScale = ContentScale.Crop,
                )
                
            }

            Spacer(modifier = Modifier.height(8.dp))

            // Movie Title
            Text(
                modifier = Modifier.offset(130.dp,400.dp),
                text = title,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,

            )


            Spacer(modifier = Modifier.height(4.dp))

            // Star Rating
            Row(modifier = modifier.offset(125.dp,420.dp)) {
                repeat(5) {
                    Icon(Icons.Filled.Star, contentDescription = "Star", tint = Color.Yellow)
                }
            }

            Spacer(modifier = Modifier.height(8.dp))

            // Movie Details - length, lang, rating, review
            Row(
                modifier = Modifier.fillMaxWidth().offset((2).dp,445.dp),
                horizontalArrangement = Arrangement.SpaceEvenly,
                verticalAlignment = Alignment.Bottom

            ) {
                MovieDetailItem("Length", length)
                MovieDetailItem("Lang", language)
                MovieDetailItem("Rating", rating.toString())
                MovieDetailItem("Review", reviews)
            }

            Spacer(modifier = Modifier.height(16.dp))
        }

}

@Composable
fun MovieDetailItem(label: String, value: String) {
    Column(verticalArrangement = Arrangement.Bottom) {
        Text(text = label, fontSize = 14.sp, color = Color.Gray)
        Text(text = value, fontSize = 16.sp, fontWeight = FontWeight.Bold)
    }
}

// Preview Function
@Preview(showBackground = true)
@Composable
fun PreviewMovieCard() {
    MovieCard("Casablanca", "1:42", "Eng", 8.5, "150k+", R.drawable.casablanca, R.drawable.casablanca, modifier = Modifier)
}