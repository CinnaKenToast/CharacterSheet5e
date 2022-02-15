package com.example.charactersheet.utils

import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

val json = Json { ignoreUnknownKeys = true }

/**
 * Will serialize a Serializable object to a String
 * will cause a crash if T is not Serializable
 */
inline fun <reified T> T.toJsonString(): String = json.encodeToString(this)

/**
 * Will deserialize a String to a Serializable object
 * will cause a crash if T is not Serializable
 */
inline fun <reified T> String.fromJsonString(): T =
    try {
        json.decodeFromString(this)
    } catch (e: Throwable) {
        throw IllegalArgumentException("Class ${T::class.java.simpleName} is not a Serializable class. \n${e.message}")
    }