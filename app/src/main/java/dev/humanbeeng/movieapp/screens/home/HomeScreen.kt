package dev.humanbeeng.movieapp.screens.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import dev.humanbeeng.movieapp.model.Movie
import dev.humanbeeng.movieapp.model.getMovies
import dev.humanbeeng.movieapp.navigation.MovieScreens
import dev.humanbeeng.movieapp.widgets.MovieRow


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
    movieList: List<Movie> = getMovies()
) {
    Surface(color = MaterialTheme.colors.background) {
        Column(modifier = Modifier.padding(16.dp)) {
            LazyColumn {
                items(items = movieList) {
                    MovieRow(movie = it) {
//                        This below block is onClickAction defined in the MovieRow composable function.
                            movie ->
                        navController.navigate(MovieScreens.DetailsScreen.route + "/$movie")
                    }
                }

            }

        }
    }


}

