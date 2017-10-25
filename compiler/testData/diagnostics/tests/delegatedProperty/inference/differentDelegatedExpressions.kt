// WITH_NEW_INFERENCE

package baz

import kotlin.reflect.KProperty

class A(outer: Outer) {
    var i: String by  + getMyConcreteProperty()
    var d: String by  getMyConcreteProperty() - 1
    var c: String by  O.getMyProperty()
    var g: String by  outer.getContainer().getMyProperty()


    var b: String by  foo(<!TYPE_INFERENCE_NO_INFORMATION_FOR_PARAMETER!>getMyProperty<!>())
    var r: String by  foo(outer.getContainer().<!TYPE_INFERENCE_NO_INFORMATION_FOR_PARAMETER!>getMyProperty<!>())
    var e: String by  <!NI;DELEGATE_SPECIAL_FUNCTION_RETURN_TYPE_MISMATCH!><!DEBUG_INFO_ELEMENT_WITH_ERROR_TYPE!>+<!> <!TYPE_INFERENCE_NO_INFORMATION_FOR_PARAMETER!>foo<!>(<!TYPE_INFERENCE_NO_INFORMATION_FOR_PARAMETER!>getMyProperty<!>())<!>
    var f: String by  <!NI;DELEGATE_SPECIAL_FUNCTION_RETURN_TYPE_MISMATCH!><!TYPE_INFERENCE_NO_INFORMATION_FOR_PARAMETER!>foo<!>(<!TYPE_INFERENCE_NO_INFORMATION_FOR_PARAMETER!>getMyProperty<!>()) <!DEBUG_INFO_ELEMENT_WITH_ERROR_TYPE!>-<!> 1<!>
}

fun <A, B> foo(<!NI;UNUSED_PARAMETER!><!UNUSED_PARAMETER!>a<!><!>: Any?) = MyProperty<A, B>()

fun <A, B> getMyProperty() = MyProperty<A, B>()

fun getMyConcreteProperty() = MyProperty<Any?, String>()

class MyProperty<R, T> {

    operator fun getValue(thisRef: R, desc: KProperty<*>): T {
        println("get $thisRef ${desc.name}")
        return null <!NI;UNCHECKED_CAST!><!UNCHECKED_CAST!>as T<!><!>
    }

    operator fun setValue(thisRef: R, desc: KProperty<*>, value: T) {
        println("set $thisRef ${desc.name} $value")
    }
}

operator fun <R, T> MyProperty<R, T>.unaryPlus() = MyProperty<R, T>()
operator fun <R, T> MyProperty<R, T>.minus(<!NI;UNUSED_PARAMETER!><!UNUSED_PARAMETER!>i<!><!>: Int) = MyProperty<R, T>()

object O {
    fun <A, B> getMyProperty() = MyProperty<A, B>()
}

interface MyPropertyContainer {
    fun <R, T> getMyProperty(): MyProperty<R, T>
}

interface Outer {
    fun getContainer(): MyPropertyContainer
}

// -----------------
fun println(a: Any?) = a
