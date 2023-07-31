package com.example.navigationcomponent_jetpackcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.rememberNavController
import com.example.navigationcomponent_jetpackcompose.ui.theme.NavigationComponentJetpackComposeTheme

/**
 * NavHost : Define nav graph, inside nav host we are defining all our screens (its routes, args, start destination)
 *
 * */

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NavigationComponentJetpackComposeTheme {
                val navController =
                    rememberNavController() // Creates nav host controller which handles navigation in our app
                SampleNavHost(navController = navController)
            }
        }
    }
}
