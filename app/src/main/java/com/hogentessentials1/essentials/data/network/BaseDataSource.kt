package com.hogentessentials1.essentials.data.network

import com.hogentessentials1.essentials.util.Resource
import retrofit2.Response
import timber.log.Timber

/**
 * The base data source of the application
 *
 * @source Jens Buysse en Özgür Akin
 */
abstract class BaseDataSource {

    /**
     * get a data result from a call
     *
     * @param T
     * @param call
     * @return a resource
     */
    protected suspend fun <T> getResult(call: suspend () -> Response<T>): Resource<T> {
        try {
            val response = call()
            if (response.isSuccessful) {
                val body = response.body()
                if (body != null) return Resource.success(body)
            }
            return error(" ${response.code()} ${response.message()}")
        } catch (e: Exception) {
            return error(e.message ?: e.toString())
        }
    }

    /**
     * Creates an error resource with a message
     *
     * @param T
     * @param message
     * @return
     */
    private fun <T> error(message: String): Resource<T> {
        Timber.e(message)
        return Resource.error(
            data = null,
            message = "Network call has failed for a following reason: $message"
        )
    }
}
