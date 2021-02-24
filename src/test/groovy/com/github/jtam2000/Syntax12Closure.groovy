package com.github.jtam2000

import org.junit.Test

class Syntax12Closure {
    @Test
    void closureAllowDefaultParam() {

        //learning: parameter b has default values of 10
        def myClosure = { a, b=10 -> b*2}
        assert myClosure("hello") == 20
        assert myClosure("hello", 7) == 14

    }

    @Test
    void closureHasImplicitParameterIt() {
        //learning even if you don't provide an parameter, closure will provide "it" as a default parameter
        def myClosure = { "implicit param is $it"}
        assert myClosure()== "implicit param is null"
    }

    @Test
    void closureWithNoImplicitParameterMustSaySoOnDeclaration(){

        //learning: Notice you have you to put "->" in the begin of closure
        def closeWithZeroParameters = { -> "no explict param"}

        assert closeWithZeroParameters() == "no explict param"
    }
}
