package ru.kazan.itis.bikmukhametov.vkeducation.ui.screen.applist

import ru.kazan.itis.bikmukhametov.vkeducation.domain.applist.AppInfo

data class AppListUiState(
    val apps: List<AppInfo> = emptyList(),
    val snackbarMessage: String? = null,
)
