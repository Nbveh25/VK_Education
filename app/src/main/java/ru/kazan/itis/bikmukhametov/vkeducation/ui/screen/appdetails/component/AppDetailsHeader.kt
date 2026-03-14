package ru.kazan.itis.bikmukhametov.vkeducation.ui.screen.appdetails.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import coil3.compose.AsyncImage
import ru.kazan.itis.bikmukhametov.vkeducation.R
import ru.kazan.itis.bikmukhametov.vkeducation.domain.appdetails.AppDetails
import ru.kazan.itis.bikmukhametov.vkeducation.domain.appdetails.Category
import ru.kazan.itis.bikmukhametov.vkeducation.ui.theme.Dimens
import ru.kazan.itis.bikmukhametov.vkeducation.ui.theme.VKEducationTheme
import kotlin.math.roundToInt

@Composable
fun AppDetailsHeader(
    appDetails: AppDetails,
    modifier: Modifier = Modifier,
) {
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically,
    ) {
        AsyncImage(
            model = appDetails.iconUrl,
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(Dimens.appIconHuge)
                .clip(RoundedCornerShape(Dimens.cornerRadiusXLarge)),
        )
        Spacer(Modifier.width(Dimens.paddingMedium))
        Column {
            Text(
                text = getCategoryText(appDetails.category),
                color = MaterialTheme.colorScheme.secondary,
                fontSize = 12.sp,
            )
            Spacer(Modifier.height(Dimens.paddingSmall / 2))
            Text(
                text = appDetails.name,
                fontWeight = FontWeight.Bold,
                style = MaterialTheme.typography.headlineSmall,
            )
            Spacer(Modifier.height(Dimens.paddingSmall / 2))
            Text(
                text = appDetails.developer,
                fontSize = 12.sp,
            )
            Spacer(Modifier.height(Dimens.paddingSmall / 2))
            Row {
                Column(Modifier.width(IntrinsicSize.Max)) {
                    Text(
                        text = "${appDetails.ageRating}+",
                        textAlign = TextAlign.Center,
                        modifier = Modifier.fillMaxWidth(),
                    )
                Spacer(Modifier.height(Dimens.paddingSmall / 2))
                    Text(text = stringResource(R.string.app_details_age))
                }
                Spacer(Modifier.width(Dimens.paddingMedium - Dimens.paddingSmall))
                Column {
                    Text(text = "${appDetails.size.roundToInt()} MB")
                    Spacer(Modifier.height(Dimens.paddingSmall / 2))
                    Text(text = stringResource(R.string.app_details_size))
                }
            }
        }
    }
}

// Используем сериализованные имена категорий, которые приходят из API
@Composable
private fun getCategoryText(category: Category): String {
    val resourceId = when (category) {
        Category.APP -> R.string.category_app
        Category.GAME -> R.string.category_game
        Category.PRODUCTIVITY -> R.string.category_productivity
        Category.SOCIAL -> R.string.category_social
        Category.EDUCATION -> R.string.category_education
        Category.ENTERTAINMENT -> R.string.category_entertainment
        Category.MUSIC -> R.string.category_music
        Category.VIDEO -> R.string.category_video
        Category.PHOTOGRAPHY -> R.string.category_photography
        Category.HEALTH -> R.string.category_health
        Category.SPORTS -> R.string.category_sports
        Category.NEWS -> R.string.category_news
        Category.BOOKS -> R.string.category_books
        Category.BUSINESS -> R.string.category_business
        Category.FINANCE -> R.string.category_finance
        Category.TRAVEL -> R.string.category_travel
        Category.MAPS -> R.string.category_maps
        Category.FOOD -> R.string.category_food
        Category.SHOPPING -> R.string.category_shopping
        Category.UTILITIES -> R.string.category_utilities
    }
    return stringResource(resourceId)
}

@Preview
@Composable
private fun Preview() {
    val appDetails = AppDetails(
        id = "fa2e31b8-1234-4cf7-9914-108a170a1b01",
        name = "Гильдия Героев: Экшен ММО РПГ",
        developer = "VK Play",
        category = Category.GAME,
        ageRating = 12,
        size = 223.7f,
        screenshotUrlList = listOf(
            "https://static.rustore.ru/imgproxy/-y8kd-4B6MQ-1OKbAbnoAIMZAzvoMMG9dSiHMpFaTBc/preset:web_scr_lnd_335/plain/https://static.rustore.ru/apk/393868735/content/SCREENSHOT/dfd33017-e90d-4990-aa8c-6f159d546788.jpg@webp",
            "https://static.rustore.ru/imgproxy/dZCvNtRKKFpzOmGlTxLszUPmwi661IhXynYZGsJQvLw/preset:web_scr_lnd_335/plain/https://static.rustore.ru/apk/393868735/content/SCREENSHOT/60ec4cbc-dcf6-4e69-aa6f-cc2da7de1af6.jpg@webp",
            "https://static.rustore.ru/imgproxy/g5whSI1uNqaL2TUO7TFfM8M63vXpWXNCm2vlX4Ahvc4/preset:web_scr_lnd_335/plain/https://static.rustore.ru/apk/393868735/content/SCREENSHOT/c2dde8bc-c4ab-482a-80a5-2789149f598d.jpg@webp",
            "https://static.rustore.ru/imgproxy/TjeurtC7BczOVJt74XhjGYuQnG1l4rx6zpDqyMb00GY/preset:web_scr_lnd_335/plain/https://static.rustore.ru/apk/393868735/content/SCREENSHOT/08318f76-7a9c-43aa-b4a7-1aa878d00861.jpg@webp",
        ),
        iconUrl = "https://static.rustore.ru/imgproxy/APsbtHxkVa4MZ0DXjnIkSwFQ_KVIcqHK9o3gHY6pvOQ/preset:web_app_icon_62/plain/https://static.rustore.ru/apk/393868735/content/ICON/3f605e3e-f5b3-434c-af4d-77bc5f38820e.png@webp",
        description = "Легендарный рейд героев в Фэнтези РПГ. Станьте героем гильдии и зразите мастера подземелья!"

    )
    VKEducationTheme {
        AppDetailsHeader(appDetails = appDetails, modifier = Modifier.fillMaxWidth())
    }
}
