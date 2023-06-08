package edu.put.inf151764.data.api.data

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Item(
    @SerialName("objecttype")
    val objectType: String,

    @SerialName("objectid")
    val objectId: String,

    @SerialName("subtype")
    val subType: String,

    @SerialName("collid")
    val collId: String,

    @SerialName("name")
    val name: String,

    @SerialName("yearpublished")
    val yearPublished: Int,

    @SerialName("image")
    val image: String,

    @SerialName("thumbnail")
    val thumbnail: String,

    @SerialName("status")
    val status: Status,

    @SerialName("numplays")
    val numPlays: Int
)