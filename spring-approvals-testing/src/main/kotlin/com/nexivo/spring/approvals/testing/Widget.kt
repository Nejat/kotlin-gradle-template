package com.nexivo.spring.approvals.testing

@Suppress("MemberVisibilityCanBePrivate")
class Widget(val value: Double) {

    val double get(): Double = value * 2

    val half get (): Double = value / 2

    override fun toString(): String {
        return "$value, $double, $half"
    }
}