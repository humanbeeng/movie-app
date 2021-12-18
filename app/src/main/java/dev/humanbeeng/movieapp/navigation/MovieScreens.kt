package dev.humanbeeng.movieapp.navigation


sealed class MovieScreens(val route: String) {
    object HomeScreen : MovieScreens("home")
    object DetailsScreen : MovieScreens("details")
}

