package ru.kazan.itis.bikmukhametov.vkeducation.ui.screen.applist

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import ru.kazan.itis.bikmukhametov.vkeducation.R
import ru.kazan.itis.bikmukhametov.vkeducation.domain.applist.AppInfo
import ru.kazan.itis.bikmukhametov.vkeducation.ui.util.StringResourceProvider

class AppListViewModel(
    private val stringResourceProvider: StringResourceProvider
) : ViewModel() {

    private val _state = MutableStateFlow(AppListUiState(apps = defaultApps))
    val state: StateFlow<AppListUiState> = _state.asStateFlow()

    fun onLogoClick() {
        _state.update { 
            it.copy(snackbarMessage = stringResourceProvider.getString(R.string.welcome_to_rustore))
        }
    }

    fun clearSnackbar() {
        _state.update { it.copy(snackbarMessage = null) }
    }

    private companion object {
        val defaultApps = listOf(
            AppInfo(
                "СберБанк Онлайн",
                "Больше чем банк",
                "Финансы",
                "https://avatars.mds.yandex.net/i?id=14b84194cbc2eae0ae6f955ae4d74473_l-3731087-images-thumbs&n=13"
            ),
            AppInfo(
                "Яндекс.Браузер",
                "Быстрый и безопасный",
                "Инструменты",
                "https://avatars.mds.yandex.net/i?id=ca4eca7980b8dfa87a96114ae715dbfcc572d019-9066790-images-thumbs&n=13"
            ),
            AppInfo(
                "Почта Mail.ru",
                "Клиент для любых ящиков",
                "Инструменты",
                "https://yt3.googleusercontent.com/ytc/AOPolaTJMrd1rNjbUjduG3S2n0K9xM-VC3d6H_XzYrg8GA=s900-c-k-c0x00ffffff-no-rj"
            ),
            AppInfo(
                "Яндекс Навигатор",
                "Парковки и заправки",
                "Транспорт",
                "https://avatars.mds.yandex.net/i?id=b941a2edf0f30fc3d902b7c1842f4e632f50d85d-8497272-images-thumbs&n=13"
            ),
            AppInfo(
                "Мой МТС",
                "Центр экосистемы",
                "Инструменты",
                "https://assets-ru.bookmate.yandex.net/assets/users-userpics-fingerprint/4d/ed/2df84b5cc3fc771701a022e593397608-profile_big.jpg"
            )
        )
    }
}
