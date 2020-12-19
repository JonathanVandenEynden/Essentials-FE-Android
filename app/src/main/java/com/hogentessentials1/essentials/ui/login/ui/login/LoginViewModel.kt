package com.hogentessentials1.essentials.ui.login.ui.login

import android.util.Patterns
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hogentessentials1.essentials.R
import com.hogentessentials1.essentials.ui.login.data.LoginRepository
import com.hogentessentials1.essentials.ui.login.data.Result
import kotlinx.coroutines.launch

/**
 * @author Simon De Wilde
 * @author Jonathan Vanden Eynden
 */
class LoginViewModel(private val loginRepository: LoginRepository) : ViewModel() {

    private val _loginForm = MutableLiveData<LoginFormState>()
    val loginFormState: LiveData<LoginFormState> = _loginForm

    private val _loginResult = MutableLiveData<LoginResult>()
    val loginResult: LiveData<LoginResult> = _loginResult

//    private val _bearerToken = MutableLiveData<String>()
//    val bearerToken: LiveData<String>
//        get() = _bearerToken
//
//    private val _status = MutableLiveData<Status>()
//    val status: LiveData<Status>
//        get() = _status

    fun login(username: String, password: String) {
        // can be launched in a separate asynchronous job
        viewModelScope.launch {
            val result = loginRepository.login(username, password)

            if (result is Result.Success) {
                _loginResult.value =
                    LoginResult(success = LoggedInUserView(result.data.displayName))
            } else {
                _loginResult.value = LoginResult(error = R.string.login_failed)
            }
        }
    }

    fun loginDataChanged(username: String, password: String) {
        if (!isUserNameValid(username)) {
            _loginForm.value = LoginFormState(usernameError = R.string.invalid_username)
        } else if (!isPasswordValid(password)) {
            _loginForm.value = LoginFormState(passwordError = R.string.invalid_password)
        } else {
            _loginForm.value = LoginFormState(isDataValid = true)
        }
    }

    // A placeholder username validation check
    private fun isUserNameValid(username: String): Boolean {
        return if (username.contains('@')) {
            Patterns.EMAIL_ADDRESS.matcher(username).matches()
        } else {
            username.isNotBlank()
        }
    }

    // A placeholder password validation check
    private fun isPasswordValid(password: String): Boolean {
        return password.length > 5
    }

//    init {
//        viewModelScope.launch {
//            _status.value = Status.LOADING
//            Timber.e("start met ophalen")
//            try {
//                _bearerToken.value =
//                    loginRepository.login("simon.dewilde@student.hogent.be", "P@ssword1")
//                Timber.e("ophalen successvol")
//                Timber.e(changeinitiatives.value.toString())
//                _status.value = Status.SUCCESS
//            } catch (e: Exception) {
//                Timber.e("ophalen mislukt")
//                Timber.e("${e.message}")
//                _status.value = Status.ERROR
//            }
//        }
}
