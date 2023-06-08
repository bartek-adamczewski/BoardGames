package edu.put.inf151764.data.api.data.list

import org.simpleframework.xml.Attribute
import org.simpleframework.xml.Root


@Root(name = "status", strict = false)
data class Status @JvmOverloads constructor(
    @field:Attribute(name = "own")
    var own: Int = 0,

    @field:Attribute(name = "prevowned")
    var prevOwned: Int = 0,

    @field:Attribute(name = "fortrade")
    var forTrade: Int = 0,

    @field:Attribute(name = "want")
    var want: Int = 0,

    @field:Attribute(name = "wanttoplay")
    var wantToPlay: Int = 0,

    @field:Attribute(name = "wanttobuy")
    var wantToBuy: Int = 0,

    @field:Attribute(name = "wishlist")
    var wishList: Int = 0,

    @field:Attribute(name = "preordered")
    var preOrdered: Int = 0,

    @field:Attribute(name = "lastmodified")
    var lastModified: String = ""
)