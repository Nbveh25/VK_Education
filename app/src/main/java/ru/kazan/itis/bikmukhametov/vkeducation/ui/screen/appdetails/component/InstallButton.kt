package ru.kazan.itis.bikmukhametov.vkeducation.ui.screen.appdetails.component

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import ru.kazan.itis.bikmukhametov.vkeducation.R
import ru.kazan.itis.bikmukhametov.vkeducation.ui.theme.Dimens
import ru.kazan.itis.bikmukhametov.vkeducation.ui.theme.VKEducationTheme

@Composable
fun InstallButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Button(
        onClick = onClick,
        shape = RoundedCornerShape(Dimens.cornerRadiusSmall),
        contentPadding = PaddingValues(vertical = Dimens.paddingSmall + Dimens.paddingSmall / 2),
        modifier = modifier,
        colors = ButtonDefaults.buttonColors(
            containerColor = MaterialTheme.colorScheme.primary,
        ),
    ) {
        Text(text = stringResource(R.string.install))
    }
}

@Preview
@Composable
private fun Preview() {
    VKEducationTheme {
        InstallButton(
            onClick = {},
            modifier = Modifier.fillMaxWidth(),
        )
    }
}
