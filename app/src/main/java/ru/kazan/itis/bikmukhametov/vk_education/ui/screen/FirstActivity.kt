package ru.kazan.itis.bikmukhametov.vk_education.ui.screen

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import ru.kazan.itis.bikmukhametov.vk_education.R
import ru.kazan.itis.bikmukhametov.vk_education.ui.theme.VK_EducationTheme
import androidx.core.net.toUri
import ru.kazan.itis.bikmukhametov.vk_education.ui.theme.Dimens

class FirstActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            VK_EducationTheme {
                var textState by rememberSaveable { mutableStateOf("") }
                val phoneRegex = Regex("""^\+?[0-9\-\(\)\s]{7,15}$""")
                val isPhoneValid = textState.matches(phoneRegex)

                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(innerPadding)
                            .padding(Dimens.paddingMedium), // Используем Dimens
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {

                        OutlinedTextField(
                            value = textState,
                            onValueChange = { textState = it },
                            label = { Text(stringResource(R.string.enter_text)) },
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(vertical = Dimens.fieldVerticalPadding)
                        )

                        // Кнопка перехода
                        Button(
                            onClick = {
                                val intent = Intent(
                                    this@FirstActivity,
                                    SecondActivity::class.java
                                ).apply {
                                    putExtra(EXTRA_TEXT, textState)
                                }

                                startActivity(intent)
                            },
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(
                                    vertical = Dimens.paddingSmall,
                                    horizontal = Dimens.paddingLarge
                                )
                                .height(Dimens.buttonHeight)
                        ) {
                            Text(stringResource(R.string.open_second_activity))
                        }

                        // Кнопка звонка
                        Button(
                            onClick = {
                                if (isPhoneValid) {
                                    val dialIntent = Intent(Intent.ACTION_DIAL).apply {
                                        data = getString(R.string.data_tel, textState).toUri()
                                    }

                                    startActivity(dialIntent)
                                }
                            },
                            enabled = isPhoneValid,
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(
                                    vertical = Dimens.paddingSmall,
                                    horizontal = Dimens.paddingLarge
                                )
                                .height(Dimens.buttonHeight)
                        ) {
                            Text(stringResource(R.string.call_friend))
                        }

                        // Кнопка "Поделиться"
                        Button(
                            onClick = {
                                val sendIntent: Intent = Intent().apply {
                                    action = Intent.ACTION_SEND
                                    putExtra(Intent.EXTRA_TEXT, textState)
                                    type = getString(R.string.mime_text_plain)
                                }

                                startActivity(Intent.createChooser(sendIntent, null))
                            },
                            enabled = textState.isNotBlank(),
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(
                                    vertical = Dimens.paddingSmall,
                                    horizontal = Dimens.paddingLarge
                                )
                                .height(Dimens.buttonHeight)
                        ) {
                            Text(stringResource(R.string.share_text))
                        }
                    }
                }
            }
        }
    }
    
    companion object {
        const val EXTRA_TEXT = "EXTRA_TEXT"
    }
}
