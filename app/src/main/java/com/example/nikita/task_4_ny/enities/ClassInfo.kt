package com.example.nikita.task_4_ny.enities

import android.graphics.Bitmap

data class ClassInfo(
    val name: String,
    val author: String? = null,
    val release: Int? = null,
    val paradigm: Array<String>? = null,
    val imageLogo: Bitmap? = null,
    val rating: String? = null,
    val link: String? = null
)