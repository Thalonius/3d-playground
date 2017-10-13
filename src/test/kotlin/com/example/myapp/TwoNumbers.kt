package com.example.myapp

import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertNotEquals

class TwoNumbers {

    @Test
    fun canBeAdded() {
        val adder = Adder()
        assertEquals(10, adder.add(5, 5))
    }

    @Test
    fun cannotBeAdded() {
        val adder = Adder()
        assertNotEquals(150, adder.add(5,5))
    }
}

