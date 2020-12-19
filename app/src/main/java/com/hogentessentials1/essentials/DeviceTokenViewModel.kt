package com.hogentessentials1.essentials

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hogentessentials1.essentials.data.repositories.DeviceTokenRepository
import kotlinx.coroutines.launch

/**
 * Viewmodel for the device tokens
 *
 * @author Marbod Naassens
 *
 * @property repo
 */
class DeviceTokenViewModel(private val repo: DeviceTokenRepository) : ViewModel() {

    fun post(userid: Int, token: String) {
        try {
            viewModelScope.launch {
                repo.postDeviceToken(userid, token)
            }
        } catch (e: Exception) {
        }
    }
}
