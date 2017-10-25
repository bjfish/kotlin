// WITH_NEW_INFERENCE

fun <T, R> Iterable<T>.map(<!NI;UNUSED_PARAMETER!><!UNUSED_PARAMETER!>transform<!><!>: (T) -> R): List<R> = null!!
fun <T> listOf(): List<T> = null!!
fun <T> listOf(vararg <!NI;UNUSED_PARAMETER!><!UNUSED_PARAMETER!>values<!><!>: T): List<T> = null!!

fun commonSystemFailed(a: List<Int>) {
    a.map {
        if (it == 0) return@map listOf(it)
        <!TYPE_INFERENCE_NO_INFORMATION_FOR_PARAMETER!>listOf<!>()
    }
    a.map {
        if (it == 0) return@map <!TYPE_INFERENCE_NO_INFORMATION_FOR_PARAMETER!>listOf<!>()
        listOf(it)
    }
    a.map {
        if (it == 0) listOf()
        else listOf(it)
    }
}