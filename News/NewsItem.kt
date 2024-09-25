package com.example.cryptocurrency.Model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class NewsItem(
    val title: String,
    val description: String
) : Parcelable
