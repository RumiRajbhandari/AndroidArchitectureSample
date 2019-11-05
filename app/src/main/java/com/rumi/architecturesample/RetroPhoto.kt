package com.rumi.architecturesample

import com.google.gson.annotations.SerializedName

data class RetroPhoto(
    @SerializedName("id") var id: Int,
    @SerializedName("title") var title: String
) {
}