package ru.kazan.itis.bikmukhametov.vkeducation.ui.screen.applist

import RuStoreHeader
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import ru.kazan.itis.bikmukhametov.vkeducation.domain.applist.AppInfo
import ru.kazan.itis.bikmukhametov.vkeducation.ui.screen.applist.component.AppCard
import ru.kazan.itis.bikmukhametov.vkeducation.ui.theme.Dimens
import ru.kazan.itis.bikmukhametov.vkeducation.ui.theme.VKEducationTheme

@Composable
fun RuStoreScreen(
    onAppClick: (AppInfo) -> Unit,
) {
    Scaffold(
        topBar = {
            RuStoreHeader()
        },
        containerColor = MaterialTheme.colorScheme.primary
    ) { paddingValues ->
        Surface(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues),
            color = Color.White,
            shape = RoundedCornerShape(
                topStart = Dimens.cornerRadiusXXLarge,
                topEnd = Dimens.cornerRadiusXXLarge,
            )
        ) {
            val apps = listOf(
                AppInfo("СберБанк Онлайн", "Больше чем банк", "Финансы", "https://avatars.mds.yandex.net/i?id=14b84194cbc2eae0ae6f955ae4d74473_l-3731087-images-thumbs&n=13"),
                AppInfo("Яндекс.Браузер", "Быстрый и безопасный", "Инструменты", "https://avatars.mds.yandex.net/i?id=ca4eca7980b8dfa87a96114ae715dbfcc572d019-9066790-images-thumbs&n=13"),
                AppInfo("Почта Mail.ru", "Клиент для любых ящиков", "Инструменты", "https://yt3.googleusercontent.com/ytc/AOPolaTJMrd1rNjbUjduG3S2n0K9xM-VC3d6H_XzYrg8GA=s900-c-k-c0x00ffffff-no-rj"),
                AppInfo("Яндекс Навигатор", "Парковки и заправки", "Транспорт", "https://avatars.mds.yandex.net/i?id=b941a2edf0f30fc3d902b7c1842f4e632f50d85d-8497272-images-thumbs&n=13"),
                AppInfo("Мой МТС", "Центр экосистемы", "Инструменты", "https://assets-ru.bookmate.yandex.net/assets/users-userpics-fingerprint/4d/ed/2df84b5cc3fc771701a022e593397608-profile_big.jpg")
            )

            LazyColumn(
                contentPadding = PaddingValues(
                    top = Dimens.paddingMedium,
                    bottom = Dimens.paddingMedium,
                ),
            ) {
                items(apps.size) { index ->
                    val app = apps[index]
                    AppCard(
                        app = app,
                        onClick = { onAppClick(app) },
                    )
                    HorizontalDivider(
                        modifier = Modifier.padding(horizontal = Dimens.paddingMedium),
                        color = Color(0xFFF0F0F0),
                        thickness = 0.5.dp
                    )
                }
            }
        }

    }
}