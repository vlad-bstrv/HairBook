package com.example.hairbook.domain.util

fun String.isValidPhoneNumber(): Boolean {

    if (this.isBlank()) return false

    if (this.length != 12) return false

    if (this[0] != '+') return false

    for (i in 1 until this.length) {

        if (!Character.isDigit(this[i])) {
            return false
        }
    }

    return true
}