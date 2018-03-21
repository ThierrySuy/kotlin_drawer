package com.example.biscuit.mydrawer.com.example.biscuit.mydrawer

import org.simpleframework.xml.Element
import org.simpleframework.xml.Root

@Root(name = "item", strict = false)
class Articles {

    @field:Element(name = "title")
    var title: String? = null

    @field:Element(name = "description")
    var description: String? = null


    @field:Element
    var link: String? = null

    var imageUrl: String? = null
}
