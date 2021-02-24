package com.github.jtam2000

import org.junit.Assert
import org.junit.Test


class Syntax04String {

    @Test
    void singleQuoteDoesNotApplyVariableInterpolation() {

        def var = "variable [var] has been interpolated"
        def sqString = '${var} has not been interpolated'

        def expected = '${var} has not been interpolated'
        assert expected, sqString
    }

    @Test
    void doubleQuoteApplyVariableInterpolation() {

        def var = 'variable [var] has been interpolated'
        def dqString = "${var}"

        def expected = 'variable [var] has been interpolated'
        Assert.assertEquals expected.toString(), dqString.toString()
    }

    @Test
    void tripleQuoteSpanMultipleLines() {

        def var = 'variable [var] has been interpolated'
        def tqString = """\
triple quote can
extend to
multiple lines\
"""
        def expectedNewLineCount = 2
        Assert.assertEquals expectedNewLineCount, tqString.count('\n')

        def stringWithoutNewLinesWithoutExtraSpace = tqString
                .replaceAll("  ", "")
                .replaceAll("\n", " ")
        println "collapse multi-line to single line =>" + stringWithoutNewLinesWithoutExtraSpace

    }

    @Test
    void tripleQuoteDoesNotApplyVariableInterpolation() {

        //LEARNING: use slashy string if you want multiline support and variable interpolation
        // you can think of tripleQuote String as a multiline version of single quote strings
        def var = 'variable [var] has been interpolated'

        def tqString = """${var}"""
        def expectedValueOfTqString ='${var}'

        Assert.assertNotEquals expectedValueOfTqString, var.toString()
        Assert.assertEquals var.toString(), "$var".toString()
    }

    @Test
    void slashyStringSpanMultipleLines(){

        def slashyString = / this line goes
        into multiple
        lines/

        assert slashyString.contains("\n")
    }

    @Test
    void slashyStringSuportVariableInterpolation(){

        //LEARNING: slashy String is GString with multi-line support
        def var = 123
        def slashyString = / this line goes 
        contains variable var = ${var}  $var
        into multiple
        lines/

        assert slashyString.contains("123")
    }
    @Test
    void gStringAndJavaStringHaveDifferentHashCode() {
        def stringVar ='abc'
        def gString = "${stringVar}"
        def jString = stringVar

        println "gString hashcode:" + gString.hashCode()
        println "jString hashcode:" + jString.hashCode()
        Assert.assertNotEquals gString.hashCode(), jString.hashCode()
    }

    @Test
    void doNotUseGStringAsHashKeyInDict(){

        def key = 'abc'
        def dict = ["$key": "value"]

        assert dict[key] == null
    }

}
