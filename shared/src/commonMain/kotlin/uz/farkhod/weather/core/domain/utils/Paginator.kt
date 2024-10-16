package uz.farkhod.geedbro_kmm.core.domain.util

interface Paginator<Key, Item> {
    suspend fun loadNextItems()
    fun reset()
}