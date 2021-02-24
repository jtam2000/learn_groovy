package com.github.jtam2000

import org.junit.Test

import java.util.regex.Pattern

class Syntax11RegEx {
    @Test
    void patternOperatorIsTilda() {

        //Learning: Tilde in front of a String is casting the string to a reg ex pattern
        def pattern = ~/foo/
        assert pattern instanceof Pattern

        pattern = ~"foo"
        assert pattern instanceof Pattern
    }

    @Test
    void patternFindOperator() {
        //learning: find operator is   (~=) returns a Matcher object
        def searchText = "jason linda colleen natalie"
        def pattern = ~/colleen/

        def matchBool = searchText=~ pattern
        assert matchBool

        pattern = ~/nomatch/
        assert !(searchText=~ pattern)

        //learning: Match operator is (==~): return a boolean, not a matcher
        // important: the match has to be a STRICT match, that is why you have to put .* in the pattern
        pattern = ~'.*colleen'
        def match = searchText ==~ pattern
        assert match
    }


}
