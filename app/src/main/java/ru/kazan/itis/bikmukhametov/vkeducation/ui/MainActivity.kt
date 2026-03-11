package ru.kazan.itis.bikmukhametov.vkeducation.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import ru.kazan.itis.bikmukhametov.vkeducation.ui.navigation.AppNavHost
import ru.kazan.itis.bikmukhametov.vkeducation.ui.theme.VKEducationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            VKEducationTheme {
                AppNavHost()
            }
        }

    }
}