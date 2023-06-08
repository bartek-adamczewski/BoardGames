package edu.put.inf151764.data.api.data

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ItemsResponse(
    @SerialName("totalitems")
    val totalItems: Int,

    @SerialName("termsofuse")
    val termsOfUse: String,

    @SerialName("pubdate")
    val pubDate: String,

    @SerialName("item")
    val items: List<Item>
)









