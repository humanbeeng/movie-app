package dev.humanbeeng.movieapp.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import dev.humanbeeng.movieapp.screens.details.DetailsScreen
import dev.humanbeeng.movieapp.screens.home.HomeScreen

/*     MovieNavigation
       This is where all the navigation routes are defined
       Like : Mux in GO or RouterComponent in React
*/


@Composable
fun MovieNavigation() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = MovieScreens.HomeScreen.route
    ) {

        composable(MovieScreens.HomeScreen.route) {
//            Here we pass which composable to render when we hit this route
            HomeScreen(navController = navController)
        }
/*
composable not only handles the route pattern matching, but also, just like in Go or Spring, we can
pass in arguments just like we pass req parameters. Keep in mind that we are not actually instantiating
arguments with data below. We are just defining that the DetailsScreen is going to receive an argument
in the route URL and it will be of the type String and the entire argument array will be StringArray.
 */

        composable(
            MovieScreens.DetailsScreen.route + "/{movie}",
            arguments = listOf(navArgument(name = "movie") {
                type = NavType.StringType
            })

        ) {
            /*
           We have access to the latest pushed entity, here, HomeScreen. In our HomeScreen when we do
           navController.navigate(route = "/details" + "spiderman"), we are essentially pushing this
           to NavigationStack and you can see that spiderman is the value for the defined argument below.
           composable will retrieve this value. We have access to this value and we can pass it onto
           our Screen, here, DetailsScreen
            */

                backStackEntry ->
            DetailsScreen(
                navController = navController,
                backStackEntry.arguments?.getString("movie")
            )
        }
    }
}