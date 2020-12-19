package com.hogentessentials1.essentials.util

/**
 * resource that can be returned from sources
 *
 * @source Jens Buysse en Özgür Akin
 *
 * @param data the data that is returned from the source
 * @param message the return message
 * @param status the status of the resource (ERROR, LOADING, SUCCESS)
 */
data class Resource<out T>(val status: Status, val data: T?, val message: String?) {
    companion object {
        /**
         * creates a successful resources
         * @param data the data of the resources
         */
        fun <T> success(data: T): Resource<T> {
            return Resource(Status.SUCCESS, data, null)
        }

        /**
         * creates a errored resources
         * @param data the data of the resource
         * @param message the errormessage
         */
        fun <T> error(message: String, data: T? = null): Resource<T> {
            return Resource(Status.ERROR, data, message)
        }

        /**
         * creates a loading resources
         * @param data the data of the resource
         */
        fun <T> loading(data: T? = null): Resource<T> {
            return Resource(Status.LOADING, data, null)
        }
    }
}
