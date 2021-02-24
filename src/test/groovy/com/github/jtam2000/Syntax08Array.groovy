package com.github.jtam2000

import org.junit.Test

class Syntax08Array {

    @Test
    void arrayInitializationUsingCurlyBracketLikeJava() {

        //Learning: Java style
        def primes = new int[]{2, 3, 5, 7, 11}
        assert primes.size() == 5
        assert primes.sum() == 28

        //Learning: Groovy style, with square brackets
        int[] gPrimes = [2, 3, 5, 7, 11]
        assert gPrimes.size() == 5
        assert gPrimes.sum() == 28
    }

    @Test
    void sumOfStringArraysSameAsConcatenation(){

        def stringList = ["love", "bug"]

        assert stringList.sum() == "lovebug"
    }
}
