package com.example.hairbook.domain.util

import org.junit.Assert.*
import org.junit.Test

class ValidationKtTest {

    @Test
    fun testEmptyPhoneNumber() {
        val phoneNumber = ""
        assertFalse(phoneNumber.isValidPhoneNumber())
    }

    @Test
    fun testPhoneNumberIsLonger() {
        val phoneNumber = "+799955566777"
        assertFalse(phoneNumber.isValidPhoneNumber())
    }

    @Test
    fun testPhoneNumberIsShorter() {
        val phoneNumber = "+7999555667"
        assertFalse(phoneNumber.isValidPhoneNumber())
    }

    @Test
    fun testPhoneNumberDoesNotStartWithPlus() {
        val phoneNumber = "79995556679"
        assertFalse(phoneNumber.isValidPhoneNumber())
    }

    @Test
    fun testPhoneNumberContainsMoreThanJustNumbers() {
        val phoneNumber = "+7999555667a"
        assertFalse(phoneNumber.isValidPhoneNumber())
    }

    @Test
    fun testPhoneNumberIsCorrect() {
        val phoneNumber = "+79995556677"
        assertTrue(phoneNumber.isValidPhoneNumber())
    }


}