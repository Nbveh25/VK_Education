package ru.kazan.itis.bikmukhametov.vkeducation.ui.screen

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
import ru.kazan.itis.bikmukhametov.vkeducation.R
import ru.kazan.itis.bikmukhametov.vkeducation.ui.screen.FirstActivity.Companion.EXTRA_TEXT
import ru.kazan.itis.bikmukhametov.vkeducation.ui.theme.VKEducationTheme

class SecondActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val receivedText = intent.getStringExtra(EXTRA_TEXT) ?: getString(R.string.no_data_received)

        setContent {
            VKEducationTheme {
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
