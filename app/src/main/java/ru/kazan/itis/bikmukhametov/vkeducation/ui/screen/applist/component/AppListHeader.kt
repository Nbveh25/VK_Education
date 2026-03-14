package ru.kazan.itis.bikmukhametov.vkeducation.ui.screen.applist.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ru.kazan.itis.bikmukhametov.vkeducation.R
import ru.kazan.itis.bikmukhametov.vkeducation.ui.theme.Dimens

@Composable
fun RuStoreHeader(
    onLogoClick: () -> Unit = {},
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(MaterialTheme.colorScheme.primary)
            .statusBarsPadding()
    ) {
        // 1. Верхняя часть хэдера (Лого и кнопка)
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    horizontal = Dimens.paddingMedium,
                    vertical = Dimens.paddingXLarge - Dimens.paddingMedium,
                ),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Row(
                modifier = Modifier
                    .clickable(
                        interactionSource = remember { MutableInteractionSource() },
                        indication = null,
                        onClick = onLogoClick
                    ),
                verticalAlignment = Alignment.CenterVertically
            ) {
                // Иконка RuStore
                Image(
                    imageVector = ImageVector.vectorResource(R.drawable.ic_rustore_logo),
                    contentDescription = "RuStore logo",
                    modifier = Modifier
                        .size(Dimens.appIconSmall),
                    contentScale = ContentScale.Fit,
                    alignment = Alignment.Center,
                    colorFilter = ColorFilter.tint(Color.White)
                )

                Spacer(modifier = Modifier.width(Dimens.paddingSmall + 4.dp))

                Text(
                    text = "RuStore",
                    color = Color.White,
                    fontSize = 22.sp,
                    fontWeight = FontWeight.Bold
                )
            }

            // Кнопка-сетка справа
            IconButton(
                onClick = { /* TODO */ },
                modifier = Modifier
                    .background(
                        Color.White.copy(alpha = 0.1f),
                        RoundedCornerShape(Dimens.cornerRadiusMedium),
                    )
                    .size(Dimens.appIconMedium)
            ) {
                Icon(
                    painter = painterResource(id = android.R.drawable.ic_dialog_dialer),
                    contentDescription = null,
                    tint = Color.White,
                    modifier = Modifier.size(Dimens.appIconXSmall)
                )
            }
        }


    }
}
