package com.timofeysin

import kotlinx.serialization.Serializable

@Serializable
data class ShringResponse(
    val id: Long,
    val name: String
)

@Serializable
data class ErrorResponse(val message: String)