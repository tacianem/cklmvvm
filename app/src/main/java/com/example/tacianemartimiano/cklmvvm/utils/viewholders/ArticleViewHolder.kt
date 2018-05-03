package com.example.tacianemartimiano.cklmvvm.utils.viewholders

import android.nfc.Tag
import android.widget.ImageView


class ViewHolder {

    var categoryImage: ImageView? = null
    var title: String = ""
    var website: String = ""
    var author: String = ""
    var date: String = ""
    var contents: String = ""
    var tags: List<Tag> = listOf()
    var imageUrl: String = ""

}