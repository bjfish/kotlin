// WITH_NEW_INFERENCE

fun foo(<!NI;UNUSED_PARAMETER!><!UNUSED_PARAMETER!>u<!><!> : Unit) : Int = 1

fun test() : Int {
    foo(<!NI;CONSTANT_EXPECTED_TYPE_MISMATCH!><!NI;CONSTANT_EXPECTED_TYPE_MISMATCH!><!CONSTANT_EXPECTED_TYPE_MISMATCH!>1<!><!><!>)
    val <!NI;UNUSED_VARIABLE!><!UNUSED_VARIABLE!>a<!><!> : () -> Unit = {
        foo(<!NI;CONSTANT_EXPECTED_TYPE_MISMATCH!><!NI;CONSTANT_EXPECTED_TYPE_MISMATCH!><!CONSTANT_EXPECTED_TYPE_MISMATCH!>1<!><!><!>)
    }
    return 1 <!NI;NONE_APPLICABLE!><!NONE_APPLICABLE!>-<!><!> "1"
}

class A() {
    val x : Int = <!NI;TYPE_MISMATCH!><!TYPE_MISMATCH!>foo1(<!NI;UNRESOLVED_REFERENCE!><!NI;TOO_MANY_ARGUMENTS!><!UNRESOLVED_REFERENCE!><!TOO_MANY_ARGUMENTS!>xx<!><!><!><!>)<!><!>
}

fun foo1() {}
