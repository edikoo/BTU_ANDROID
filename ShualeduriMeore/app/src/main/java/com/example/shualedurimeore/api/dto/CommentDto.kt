package com.example.rest.api.dto


data class CommentDto (

    var id: Long?,

    var name: String?,

    var email: String?,

    var body: String?
)

data class ReqResDataComment<T> (
    val data: T
)