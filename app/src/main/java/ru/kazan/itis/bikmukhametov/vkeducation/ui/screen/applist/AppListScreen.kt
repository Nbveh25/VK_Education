package ru.kazan.itis.bikmukhametov.vkeducation.ui.screen.applist

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import ru.kazan.itis.bikmukhametov.vkeducation.domain.applist.AppInfo
import ru.kazan.itis.bikmukhametov.vkeducation.ui.util.AndroidStringResourceProvider
import ru.kazan.itis.bikmukhametov.vkeducation.ui.screen.applist.component.AppCard
import ru.kazan.itis.bikmukhametov.vkeducation.ui.screen.applist.component.RuStoreHeader
import ru.kazan.itis.bikmukhametov.vkeducation.ui.theme.Dimens

@Composable
fun RuStoreScreen(
    onAppClick: (AppInfo) -> Unit,
) {
    val context = LocalContext.current.applicationContext
    val viewModel: AppListViewModel = viewModel(
        factory = remember(context) {
            AppListViewModelFactory(AndroidStringResourceProvider(context))
        }
    )
    val state by viewModel.state.collectAsState()
    val snackbarHostState = remember { SnackbarHostState() }

    LaunchedEffect(state.snackbarMessage) {
        state.snackbarMessage?.let { message ->
            snackbarHostState.showSnackbar(message)
            viewModel.clearSnackbar()
        }
    }

    Scaffold(
        topBar = {
            RuStoreHeader(onLogoClick = viewModel::onLogoClick)
        },
        snackbarHost = { SnackbarHost(snackbarHostState) },
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
            LazyColumn(
                contentPadding = PaddingValues(
                    top = Dimens.paddingMedium,
                    bottom = Dimens.paddingMedium,
                ),
            ) {
                items(state.apps, key = { it.name }) { app ->
                    AppCard(
                        app = app,
                        onClick = { onAppClick(app) },
                    )
                    HorizontalDivider(
                        modifier = Modifier.padding(horizontal = Dimens.paddingMedium),
                        color = Color.White,
                        thickness = 0.5.dp
                    )
                }
            }
        }
    }
}
