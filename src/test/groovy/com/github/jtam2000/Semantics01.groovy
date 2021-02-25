package com.github.jtam2000

import org.junit.Test

import java.time.LocalDate

class Semantics01 {
    @Test

    void multipleAssignment_akaTuples() {

        def startDay = 20
        def (date1, date2, date3, notAssigned) = [
                LocalDate.of(2019, 2, ++startDay),
                LocalDate.of(2019, 2, ++startDay),
                LocalDate.of(2019, 2, ++startDay),
        ]

        assert date1.toString() == "2019-02-21"
        assert date2.toString() == "2019-02-22"
        assert date3.toString() == "2019-02-23"

        //if more variables than data, extra variables have null values
        assert notAssigned == null


        //if more data than variables, extra data is ignored
        def (v1, v2) = [
                "string 1",
                "string 2",
                "this extra data is ignored"
        ]

        assert v1 == "string 1"
        assert v2 == "string 2"
    }

    @Test
    void switchStatementHasExtraFunctionality() {

        def value = 1.23

        switch (value) {

            case [2, 3, 4, "someStrings"]: {
                println "switch on list"
                break
            }

            case 12..34: {
                println "switch on range"
                break
            }

            case Integer: {
                println "switch on Type"
                break
            }

            case ~/pattern.*/: {   //convert the switch variable (x) toString() before applying RegEx match
                println "switch on Reg Ex pattern"
                break
            }

            case { -> "hello" }.call(): {
                println "switch on closure"
                break
            }

            case 1.23: {
                value = "switch on a number literal"
                println "$value"
                break
            }
            default: {
                println "default value"
                break
            }
        }

        assert value == "switch on a number literal"
    }

    @Test
    void forLoopOverRange() {

        def count = 0
        def range = 'a'..'z'

        for (i in range)
            count++

        assert count == range.size()
    }

    @Test
    void forLoopOverListOrMap() {

        def count = 0

        //over list
        def list = ["a", "b", "c"]

        for (i in list)
            count++

        assert count == list.size()

        //over map
        def map = [jason: 34, collen: 12, linda: 100]

        count=0
        for (item in map)
            count+=item.value

        assert count == (34+12+100)

        count=0
        //over map values
        for (value in map.values())
            count+=value

        assert count == (34+12+100)
    }

    @Test
    void forLoopOverString() {

        def string = "abcdefgh xyz"
        int count =0

        for (c in string)
            count+= ("wxyz".contains(c)) ? 1: 0

        assert count == 3
    }

    @Test
    void assertAlternativeOutputStopsAssertVisualDisplay() {

        def x=100
        def y=23
        def z= 123
        def w=11
        def calc = {a, b -> a*b}

        assert calc(x,y) != w*z: "Explicit Error Message for assert failures"
    }

}
