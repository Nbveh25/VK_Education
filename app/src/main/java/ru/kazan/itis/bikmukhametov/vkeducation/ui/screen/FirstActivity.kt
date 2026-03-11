package ru.kazan.itis.bikmukhametov.vkeducation.ui.screen

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
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
import androidx.core.net.toUri
import ru.kazan.itis.bikmukhametov.vkeducation.R
import ru.kazan.itis.bikmukhametov.vkeducation.ui.component.MainButton
import ru.kazan.itis.bikmukhametov.vkeducation.ui.theme.Dimens
import ru.kazan.itis.bikmukhametov.vkeducation.ui.theme.VKEducationTheme

class FirstActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            VKEducationTheme {
                var textState by rememberSaveable { mutableStateOf("") }
                val isPhoneValid = textState.matches(PHONE_REGEX)

                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->

                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(innerPadding)
                            .padding(Dimens.paddingMedium),
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
                        MainButton(
                            text = stringResource(R.string.open_second_activity),
                            onClick = {
                                val intent = Intent(this@FirstActivity, SecondActivity::class.java).apply {
                                    putExtra(EXTRA_TEXT, textState)
                                }
                                startActivity(intent)
                            }
                        )

                        // Кнопка звонка
                        MainButton(
                            text = stringResource(R.string.call_friend),
                            enabled = isPhoneValid,
                            onClick = {
                                if (isPhoneValid) {
                                    val dialIntent = Intent(Intent.ACTION_DIAL).apply {
                                        data = getString(R.string.data_tel, textState).toUri()
                                    }
                                    startActivity(dialIntent)
                                }
                            }
                        )

                        // Кнопка "Поделиться"
                        MainButton(
                            text = stringResource(R.string.share_text),
                            enabled = textState.isNotBlank(),
                            onClick = {
                                val sendIntent: Intent = Intent().apply {
                                    action = Intent.ACTION_SEND
                                    putExtra(Intent.EXTRA_TEXT, textState)
                                    type = getString(R.string.mime_text_plain)
                                }
                                startActivity(Intent.createChooser(sendIntent, null))
                            }
                        )

                    }
                }
            }
        }
    }
    
    companion object {
        const val EXTRA_TEXT = "EXTRA_TEXT"
        private val PHONE_REGEX = Regex("""^\+?[0-9\-\(\)\s]{7,15}$""")
    }
}
