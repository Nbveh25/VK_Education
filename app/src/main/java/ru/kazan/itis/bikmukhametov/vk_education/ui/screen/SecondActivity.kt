package ru.kazan.itis.bikmukhametov.vk_education.ui.screen

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import ru.kazan.itis.bikmukhametov.vk_education.R
import ru.kazan.itis.bikmukhametov.vk_education.ui.screen.FirstActivity.Companion.EXTRA_TEXT
import ru.kazan.itis.bikmukhametov.vk_education.ui.theme.VK_EducationTheme

class SecondActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val receivedText = intent.getStringExtra(EXTRA_TEXT) ?: getString(R.string.no_data_received)

        setContent {
            VK_EducationTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(innerPadding),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(text = receivedText, style = MaterialTheme.typography.headlineMedium)
                    }
                }
            }
        }
    }
}