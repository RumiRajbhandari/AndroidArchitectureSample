package com.rumi.architecturesample

import com.google.gson.annotations.SerializedName

data class Photo(
    @SerializedName("id") var id: Int,
    @SerializedName("title") var title: String
) {
}