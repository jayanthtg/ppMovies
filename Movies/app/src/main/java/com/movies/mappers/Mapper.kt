package com.swish.game.data.mappers

/**
 * @author Jayanth Tg
 *
 * interface for converting a type T to another O.
 */
interface Mapper<in T, out O> {
    fun map(item: T): O

    fun map(items: List<T>): List<O>
}