// !WITH_NEW_INFERENCE

// FILE: J.java

import java.io.Serializable;

public class J {
    public <T extends Cloneable & Serializable> J(T t) {}
}

// FILE: K.kt

import java.io.Serializable

fun cloneable(c: Cloneable) = J(<!NI;TYPE_MISMATCH!><!TYPE_MISMATCH!>c<!><!>)

fun serializable(s: Serializable) = J(<!NI;TYPE_MISMATCH!><!TYPE_MISMATCH!>s<!><!>)

fun <T> both(t: T) where T : Cloneable, T : Serializable = J(t)
