// WITH_NEW_INFERENCE

fun bar() {
    fun <<!NI;CYCLIC_GENERIC_UPPER_BOUND!><!CYCLIC_GENERIC_UPPER_BOUND!>T: T?<!><!>> foo() {}
    <!TYPE_INFERENCE_NO_INFORMATION_FOR_PARAMETER!>foo<!>()
}
