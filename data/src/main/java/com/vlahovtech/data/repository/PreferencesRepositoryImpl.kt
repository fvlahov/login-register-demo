package com.vlahovtech.data.repository

import android.content.SharedPreferences
import androidx.core.content.edit
import com.vlahovtech.domain.repository.PreferencesRepository
import javax.inject.Inject

class PreferencesRepositoryImpl @Inject constructor(
    private val sharedPreferences: SharedPreferences
) : PreferencesRepository {

    override var authToken: String?
        get() = sharedPreferences.getString(AUTH_TOKEN_KEY, null)
        set(value) {
            sharedPreferences.edit {
                putString(AUTH_TOKEN_KEY, value)
            }
        }

    companion object {
        private const val AUTH_TOKEN_KEY = "auth_token"
    }
}