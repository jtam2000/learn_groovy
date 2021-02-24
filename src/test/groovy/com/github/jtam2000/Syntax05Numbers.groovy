package com.github.jtam2000

import org.junit.Test

class Syntax05Numbers {

    @Test
    void binaryNumberBeginsWith_0b(){
        def seven = 0b111
        assert seven ==7
    }

    @Test
    void octalNumberBeginsWith_0(){
        def nine = 011
        assert nine ==9
    }

    @Test
    void hexNumberBeginsWith_0x(){
        def seventeen = 0x11
        assert seventeen == 17
    }

    @Test
    void forceNumberTypeWithSuffix_G_is_BigInteger(){

        assert 456G == new BigInteger('456')

        //learning: other types are same as java
        // L or l for Long
        // I or i for integer
        // D or d for double
        // F or f for float
    }

    @Test
    void powerOperator_DoubleAsterisk() {

        assert 8 == 2**3

        def num = 7
        num **= 2
        assert num==49
    }

    @Test
    void divideOperatorSameAsArithmeticDivide() {
        //LEARNING / operator
        assert 2.5==5/2

        //LEARNING: /= operator
        def num =5
        num/=2
        assert num==2.5
    }

}
