package edu.put.inf151764.data.db.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class ItemsResponseEntity (
    @PrimaryKey(autoGenerate = true) val id: Int,

    val totalItems: Int,

    val termsOfUse: String,

    val pubDate: String,

)
