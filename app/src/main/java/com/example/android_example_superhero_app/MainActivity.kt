package com.example.android_example_superhero_app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.android_example_superhero_app.data.HeroesRepository.heroes
import com.example.android_example_superhero_app.ui.theme.AndroidexamplesuperheroappTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AndroidexamplesuperheroappTheme {
                HeroApp()
            }
        }
    }
}

@Composable
fun HeroApp() {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        Scaffold(
            modifier = Modifier.fillMaxSize(),
            topBar = { HeroTopBar() }
        ) { padding ->
            LazyColumn(contentPadding = padding) {
                items(heroes) {
                    HeroScreen(
                        hero = it,
                        modifier = Modifier
                            .padding(
                                dimensionResource(R.dimen.padding_small)
                            )
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    AndroidexamplesuperheroappTheme (darkTheme = false) {
        HeroApp()
    }
}