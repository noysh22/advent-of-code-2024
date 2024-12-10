package advent.ofcode.libs

import java.net.URL

object ResourceLoader {
    fun loadResource(path: String): URL? {
        return javaClass.getResource(path)
    }

    fun readAsString(path: String): String? {
        return loadResource(path)?.readText()
    }

    fun readLines(path: String): String? {
        return readAsString(path)?.lines()?.joinToString("")
    }
}

// A simple extension function to get a copy of a list
// without the item in the i-th index
// Meant to keep the original list immutable
fun <T> List<T>.removeAt(index: Int): List<T> {
    return this.filterIndexed { i, _ -> i != index }
}