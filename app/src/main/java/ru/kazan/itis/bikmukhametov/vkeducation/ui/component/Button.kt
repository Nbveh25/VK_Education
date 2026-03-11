package ru.kazan.itis.bikmukhametov.vkeducation.ui.component

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import ru.kazan.itis.bikmukhametov.vkeducation.ui.theme.Dimens

@Composable
fun MainButton(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true
) {
    Button(
        onClick = onClick,
        enabled = enabled,
        modifier = modifier
            .fillMaxWidth()
            .padding(
                vertical = Dimens.paddingSmall,
                horizontal = Dimens.paddingLarge
            )
            .height(Dimens.buttonHeight)
    ) {
        Text(text = text)
    }
}
