package edu.put.inf151764.data.api.data

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Status(
    @SerialName("own")
    val own: Int,

    @SerialName("prevowned")
    val prevOwned: Int,

    @SerialName("fortrade")
    val forTrade: Int,

    @SerialName("want")
    val want: Int,

    @SerialName("wanttoplay")
    val wantToPlay: Int,

    @SerialName("wanttobuy")
    val wantToBuy: Int,

    @SerialName("wishlist")
    val wishList: Int,

    @SerialName("preordered")
    val preOrdered: Int,

    @SerialName("lastmodified")
    val lastModified: String
)