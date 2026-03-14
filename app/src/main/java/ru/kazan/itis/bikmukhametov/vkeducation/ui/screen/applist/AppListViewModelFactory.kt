package ru.kazan.itis.bikmukhametov.vkeducation.ui.screen.applist

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import ru.kazan.itis.bikmukhametov.vkeducation.ui.util.StringResourceProvider

class AppListViewModelFactory(
    private val stringResourceProvider: StringResourceProvider
) : ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(AppListViewModel::class.java)) {
            return AppListViewModel(stringResourceProvider) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
