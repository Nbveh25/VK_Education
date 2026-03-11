package ru.kazan.itis.bikmukhametov.vkeducation.ui.screen.appdetails

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import ru.kazan.itis.bikmukhametov.vkeducation.domain.appdetails.AppDetails
import ru.kazan.itis.bikmukhametov.vkeducation.domain.appdetails.AppDetailsMocks
import ru.kazan.itis.bikmukhametov.vkeducation.ui.screen.appdetails.component.AppDescription
import ru.kazan.itis.bikmukhametov.vkeducation.ui.screen.appdetails.component.AppDetailsHeader
import ru.kazan.itis.bikmukhametov.vkeducation.ui.screen.appdetails.component.Developer
import ru.kazan.itis.bikmukhametov.vkeducation.ui.screen.appdetails.component.InstallButton
import ru.kazan.itis.bikmukhametov.vkeducation.ui.screen.appdetails.component.ScreenshotsList
import ru.kazan.itis.bikmukhametov.vkeducation.ui.screen.appdetails.component.Toolbar

@Composable
fun AppDetailsScreen(
    onBackClick: () -> Unit,
    onShareClick: () -> Unit,
    onInstallClick: () -> Unit,
    onReadMoreClick: () -> Unit,
    onDeveloperClick: () -> Unit,
    modifier: Modifier = Modifier,
) {

    // Моки данных для детального экрана
    val appDetails: AppDetails = AppDetailsMocks.heroGuild()
    var descriptionCollapsed by remember { mutableStateOf(true) }

    Column(modifier.statusBarsPadding()) {
        Toolbar(
            onBackClick = onBackClick,
            onShareClick = onShareClick,
        )
        Spacer(Modifier.height(8.dp))
        AppDetailsHeader(
            appDetails = appDetails,
            modifier = Modifier.padding(horizontal = 16.dp),
        )
        Spacer(Modifier.height(16.dp))
        InstallButton(
            onClick = onInstallClick,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp)
        )
        Spacer(Modifier.height(12.dp))
        ScreenshotsList(
            screenshotUrlList = appDetails.screenshotUrlList.orEmpty(),
            contentPadding = PaddingValues(horizontal = 16.dp),
        )
        Spacer(Modifier.height(12.dp))
        AppDescription(
            description = appDetails.description,
            collapsed = descriptionCollapsed,
            onReadMoreClick = onReadMoreClick,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
        )
        Spacer(Modifier.height(12.dp))
        HorizontalDivider(
            modifier = Modifier.padding(horizontal = 16.dp),
            color = MaterialTheme.colorScheme.outlineVariant,
        )
        Spacer(Modifier.height(12.dp))
        Developer(
            name = appDetails.developer,
            onClick = onDeveloperClick,
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 16.dp),
        )
    }
}
