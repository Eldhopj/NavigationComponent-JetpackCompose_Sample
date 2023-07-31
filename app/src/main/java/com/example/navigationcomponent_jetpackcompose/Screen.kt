package com.example.navigationcomponent_jetpackcompose

import androidx.navigation.NavType
import androidx.navigation.navArgument
import com.example.navigationcomponent_jetpackcompose.ArgumentId.DetailId
import com.example.navigationcomponent_jetpackcompose.ArgumentId.Name

/**
 * Class which represents routes for the screens
 *
 * */
sealed class Screen(val route: String) {
    object Home : Screen("Home_screen")
    object Detail : Screen(
        "Detail_Screen/" +
                "{$DetailId}" + // Mandatory
                "?$Name={$Name}" // Optional (instead of "/" its uses "?", NOTE : for multiple optionals use &?)
    ) { // nav arguments
        fun args(id: Int, name: String? = ""): String {
            return "Detail_Screen/$id?$Name=$name"
        }
    }
}

val detailArguments = listOf(
    navArgument(name = DetailId) {
        type = NavType.IntType
    },
    navArgument(name = Name) {
        type = NavType.StringType
        defaultValue = ""
    }
)

object ArgumentId {
    const val DetailId = "id"
    const val Name = "name"
}
