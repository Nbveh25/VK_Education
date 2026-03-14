package ru.kazan.itis.bikmukhametov.vkeducation.ui.util

import android.content.Context

class AndroidStringResourceProvider(
    private val context: Context
) : StringResourceProvider {

    override fun getString(id: Int): String = context.getString(id)

    override fun getString(id: Int, vararg formatArgs: Any): String =
        context.getString(id, *formatArgs)
}
