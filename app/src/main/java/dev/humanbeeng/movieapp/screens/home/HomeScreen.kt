package dev.humanbeeng.movieapp.screens.home

import android.util.Log
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import dev.humanbeeng.movieapp.navigation.MovieNavigation
import dev.humanbeeng.movieapp.navigation.MovieScreens


@Composable
fun HomeScreen(navController: NavController) {
    Scaffold(topBar = {
        TopAppBar(backgroundColor = Color.Green, elevation = 4.dp) {
            Text(text = "Movies")
        }
    }
    ) {
        MainContent(navController)

    }
}

@Composable
fun MainContent(
    navController: NavController,
    movieList: List<String> = listOf("Hello", "There", "Nithin")
) {
    Surface(color = MaterialTheme.colors.background) {
        Column(modifier = Modifier.padding(16.dp)) {
            LazyColumn {
                items(items = movieList) {
                    MovieRow(movie = it) { movie ->
                        navController.navigate(MovieScreens.DetailsScreen.route + "/$movie")
                    }
                }

            }

        }
    }


}

@Composable
fun MovieRow(movie: String, onClickAction: (String) -> Unit = {}) {
    Card(
        modifier = Modifier
            .padding(4.dp)
            .clickable {
                onClickAction(movie)
            }
            .fillMaxWidth()
            .height(130.dp),
        shape = RoundedCornerShape(corner = CornerSize(16.dp)), elevation = 4.dp
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start
        ) {
            Surface(
                modifier = Modifier
                    .padding(13.dp)
                    .size(100.dp), elevation = 4.dp
            ) {
                Icon(imageVector = Icons.Default.AccountBox, contentDescription = "Account Box")

            }
            Text(text = movie)

        }

    }

}