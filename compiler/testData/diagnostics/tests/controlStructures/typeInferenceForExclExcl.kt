// !CHECK_TYPE
// WITH_NEW_INFERENCE
// FILE: A.java
public class A {
    public static String foo() {
        return "";
    }
}

// FILE: b.kt
fun <T: Any> exclExcl(t: T?): T = t!!

fun test11() {
    // not 'String!'
    exclExcl(A.foo()) checkType { _<String>() }
    exclExcl(A.foo()) checkType { <!UNRESOLVED_REFERENCE_WRONG_RECEIVER, DEBUG_INFO_UNRESOLVED_WITH_TARGET!>_<!><String?>() }

    // not 'String!'
    A.foo()!! checkType { _<String>() }
    A.foo()!! checkType { <!UNRESOLVED_REFERENCE_WRONG_RECEIVER, DEBUG_INFO_UNRESOLVED_WITH_TARGET!>_<!><String?>() }
}