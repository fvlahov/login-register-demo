package com.vlahovtech.domain.model

data class Page<T: Any>(
    val currentPage: Int,
    val totalItems: Int,
    val items: List<T>
) {
    val nextPage: Int = currentPage + 1
}
