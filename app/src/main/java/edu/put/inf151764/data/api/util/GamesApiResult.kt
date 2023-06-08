package edu.put.inf151764.data.api.util

import retrofit2.HttpException

sealed class GamesApiResult<out D> {
    data class Success<out D>(val data: D) : GamesApiResult<D>()
    data class Exception<out D>(val error: GamesApiError) : GamesApiResult<D>()
}

sealed class GamesApiError {
    data class Http(val code: Int, val msg: String, val throwable: Throwable) : GamesApiError()
    data class Unknown(val msg: String?, val throwable: Throwable) : GamesApiError()
}

suspend fun <D> wrapApiCall(
    apiCall: suspend () -> D
): GamesApiResult<D> = try {
    GamesApiResult.Success(data = apiCall())
} catch (t: Throwable) {
    GamesApiResult.Exception(
        error = when (t) {
            is HttpException -> GamesApiError.Http(t.code(), t.message(), t)
            else -> GamesApiError.Unknown(t.message, t)
        }
    )
}