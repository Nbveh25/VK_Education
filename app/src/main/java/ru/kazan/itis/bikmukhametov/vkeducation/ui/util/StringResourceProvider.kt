package ru.kazan.itis.bikmukhametov.vkeducation.ui.util

interface StringResourceProvider {
    fun getString(id: Int): String
    fun getString(id: Int, vararg formatArgs: Any): String
}
