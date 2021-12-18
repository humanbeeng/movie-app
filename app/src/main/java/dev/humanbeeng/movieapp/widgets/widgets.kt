package dev.humanbeeng.movieapp.widgets

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import dev.humanbeeng.movieapp.model.Movie
import dev.humanbeeng.movieapp.model.getMovies


@Preview
@Composable
fun MovieRow(movie: Movie = getMovies()[0], onClickAction: (String) -> Unit = {}) {
    Card(
        modifier = Modifier
            .padding(4.dp)
            .clickable {
                onClickAction(movie.id)
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
            Column(modifier = Modifier.padding(16.dp)) {

                Text(text = movie.title, style = MaterialTheme.typography.h6)
                Text(text = movie.director, style = MaterialTheme.typography.caption)
                Text(text = movie.year, style = MaterialTheme.typography.caption)

            }

        }

    }

}