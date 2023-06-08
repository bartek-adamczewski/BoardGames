package edu.put.inf151764.data.api.data

import org.simpleframework.xml.Attribute
import org.simpleframework.xml.ElementList
import org.simpleframework.xml.Root

@Root(name = "items", strict = false)
data class ItemsResponse @JvmOverloads constructor(
    @field:Attribute(name = "totalitems")
    var totalItems: Int = 0,

    @field:Attribute(name = "termsofuse")
    var termsOfUse: String = "",

    @field:Attribute(name = "pubdate")
    var pubDate: String = "",

    @field:ElementList(name = "item", inline = true)
    var items: List<Item> = mutableListOf()
)









