// WITH_NEW_INFERENCE

package a

fun foo0(f: () -> String) = f
fun foo1(f: (Int) -> String) = f
fun foo2(f: (Int, String) -> String) = f

fun test1() {
    foo0 {
        ""
    }
    foo0 <!NI;TYPE_MISMATCH!><!NI;TYPE_MISMATCH!>{
        <!EXPECTED_PARAMETERS_NUMBER_MISMATCH!><!NI;UNUSED_ANONYMOUS_PARAMETER!><!UNUSED_ANONYMOUS_PARAMETER!>s<!><!>: String<!>-> ""
    }<!><!>
    foo0 <!NI;TYPE_MISMATCH!><!NI;TYPE_MISMATCH!>{
        <!EXPECTED_PARAMETERS_NUMBER_MISMATCH!><!NI;UNUSED_ANONYMOUS_PARAMETER!><!CANNOT_INFER_PARAMETER_TYPE!><!UNUSED_ANONYMOUS_PARAMETER!>x<!><!><!>, <!NI;UNUSED_ANONYMOUS_PARAMETER!><!CANNOT_INFER_PARAMETER_TYPE!><!UNUSED_ANONYMOUS_PARAMETER!>y<!><!><!><!> -> ""
    }<!><!>

    foo1 {
        ""
    }
    foo1 <!NI;TYPE_MISMATCH!><!NI;TYPE_MISMATCH!>{
        <!EXPECTED_PARAMETER_TYPE_MISMATCH!><!NI;UNUSED_ANONYMOUS_PARAMETER!><!UNUSED_ANONYMOUS_PARAMETER!>s<!><!>: String<!> -> ""
    }<!><!>
    foo1 <!NI;TYPE_MISMATCH!><!NI;TYPE_MISMATCH!>{
        <!EXPECTED_PARAMETERS_NUMBER_MISMATCH!><!NI;UNUSED_ANONYMOUS_PARAMETER!><!UNUSED_ANONYMOUS_PARAMETER!>x<!><!>, <!NI;UNUSED_ANONYMOUS_PARAMETER!><!CANNOT_INFER_PARAMETER_TYPE!><!UNUSED_ANONYMOUS_PARAMETER!>y<!><!><!><!> -> ""
    }<!><!>
    foo1 <!NI;TYPE_MISMATCH!><!NI;TYPE_MISMATCH!>{
        <!EXPECTED_PARAMETERS_NUMBER_MISMATCH!><!>-> <!NI;CONSTANT_EXPECTED_TYPE_MISMATCH!><!NI;CONSTANT_EXPECTED_TYPE_MISMATCH!><!CONSTANT_EXPECTED_TYPE_MISMATCH!>42<!><!><!>
    }<!><!>


    foo2 <!NI;TYPE_MISMATCH!><!NI;EXPECTED_PARAMETERS_NUMBER_MISMATCH!><!EXPECTED_PARAMETERS_NUMBER_MISMATCH!>{<!><!>
        ""
    }<!>
    foo2 <!NI;TYPE_MISMATCH!><!NI;TYPE_MISMATCH!>{
        <!EXPECTED_PARAMETERS_NUMBER_MISMATCH!><!EXPECTED_PARAMETER_TYPE_MISMATCH!><!NI;UNUSED_ANONYMOUS_PARAMETER!><!UNUSED_ANONYMOUS_PARAMETER!>s<!><!>: String<!><!> -> ""
    }<!><!>
    foo2 <!NI;TYPE_MISMATCH!><!NI;TYPE_MISMATCH!>{
        <!NI;UNUSED_ANONYMOUS_PARAMETER!><!EXPECTED_PARAMETERS_NUMBER_MISMATCH!><!UNUSED_ANONYMOUS_PARAMETER!>x<!><!><!> -> ""
    }<!><!>
    foo2 <!NI;TYPE_MISMATCH!><!NI;TYPE_MISMATCH!>{
         <!EXPECTED_PARAMETERS_NUMBER_MISMATCH!><!>-> <!NI;CONSTANT_EXPECTED_TYPE_MISMATCH!><!NI;CONSTANT_EXPECTED_TYPE_MISMATCH!><!CONSTANT_EXPECTED_TYPE_MISMATCH!>42<!><!><!>
    }<!><!>
}
