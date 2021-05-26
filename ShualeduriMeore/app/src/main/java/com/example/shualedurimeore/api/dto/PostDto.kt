package com.example.rest.api.dto


data class PostDto (

    var userId: Long?,

    var id: Long?,

    var title: String?,

    var body: String?
)

data class ReqResDataPost<T> (
    val data: T
)