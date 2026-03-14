package ru.kazan.itis.bikmukhametov.vkeducation.ui.screen.applist.component

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import coil3.compose.AsyncImage
import ru.kazan.itis.bikmukhametov.vkeducation.domain.applist.AppInfo
import ru.kazan.itis.bikmukhametov.vkeducation.ui.theme.Dimens

@Composable
fun AppCard(
    app: AppInfo,
    onClick: () -> Unit,
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable(onClick = onClick)
            .padding(Dimens.paddingMedium),
        verticalAlignment = Alignment.CenterVertically
    ) {
        // Иконка приложения
        AsyncImage(
            modifier = Modifier
                .size(Dimens.appIconXLarge)
                .clip(RoundedCornerShape(Dimens.cornerRadiusLarge)),
            model = app.iconUrl,
            contentDescription = app.name,
            contentScale = ContentScale.Crop
        )

        Spacer(modifier = Modifier.width(Dimens.paddingMedium))

        // Текстовая информация
        Column {
            Text(
                text = app.name,
                fontSize = 16.sp,
                fontWeight = FontWeight.Medium,
            )
            Text(
                text = app.description,
                fontSize = 14.sp,
            )
            Text(
                text = app.category,
                fontSize = 12.sp,
                color = Color.Black.copy(alpha = 0.5f)
            )
        }
    }
}
