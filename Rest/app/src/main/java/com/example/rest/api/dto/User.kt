package com.example.rest.api.dto

import com.google.gson.annotations.SerializedName

data class User (

    var id: Long?,

    var email: String?,

    @SerializedName("first_name")
    var firsName: String?,

    @SerializedName("last_name")
    var lastName: String?,

    var avatar: String?

)

data class ReqResData<T> (

    val page: Int?,

    val data: T

)