package com.github.jtam2000.learn_groovy.learn_language


// Purpose: Learning the Groovy Language
//
// learning source:
//  http://www.groovy-lang.org/single-page-documentation.html


// key words to learn:

//  TODO: Not obvious keywords: as, in, trait, const
// as: is use to define type/casting: as in : def myvariable = 3 as BigInteger
//    also in static import:
//          import static Calendar.getInstance as now
// in: use to check of items(s) is in a list: as in: assert ("value" in list)
def myVariable = 3 as BigInteger
assert myVariable instanceof BigInteger

//  Obvious: as I know them: catch, def, enum, for, import ,new
// super, thro®ws, while, assert class, default, extends, goto, null, switch
// break do, false, if  instanceof package this true case continue
// else finally implements interface return throw try


def section_counter = 0

def printHeading = { headingName ->

    section_counter++
    def separator = "---------------------------------------------------------------------"

    def spaceBeforeHeading = { ->
        println(String.format("%n%n"))
    }

    spaceBeforeHeading()

    println(separator)
    println("")
    println(String.format("Section %d: %s", section_counter, headingName))
    println("")
    println(separator)
    println("")

}


// IDENTIFIERS

// 1. After a dot expression
printHeading("Section: Identifier")

def dict = [:]  //creates a dictionary

def value = 'Put values here'

// Note this is value after the dot
dict."a long identifier after a dot with double quote" = "$value"

String left = dict."a long identifier after a dot with double quote"
String right = "$value"

print("value of dict.\"a long identifier after a dot with double quote\" is: ")
println(dict."a long identifier after a dot with double quote")

assert left == "$right"


// 2. Multi-line string
printHeading("Section: Multi-line string")

def multi_line = """
line one
line two 
line three
"""
println(String.format("this is a multiline string using triple quotes: %s%n", multi_line))


// 3. String Interpolation : "${variableName}"
printHeading('String Interpolation : \"${variableName}\"')
def nameLocal = 'Jason Tam'
println(String.format('this is string interpolation using ${variableName}:%s%n', "${nameLocal}"))

// 4. String interpolation of closure expressions

//  This is a Tricky language quirk, pay attention here
//
printHeading('String interpolation of closure expressions')
def numLocal = 1
def stringIsStaticUsingStringInterpolation = "numLocal value is $numLocal"
def stringIsReevaluatedUsingClosureExpression = "numLocal value is ${-> numLocal}"

numLocal = 2
println("I start with setting variable numLocal = 1")
println("I then redefined the variable numLocal to 2, the string closure expression will be reevaluated and change to 2")
println("whereas the plain String Interpolation will not update the string value, and will remain equal to 1")

println(String.format("%nstringIsStaticUsingStringInterpolation: %s%n", "$stringIsStaticUsingStringInterpolation"))
println(String.format("stringIsReevaluatedUsingClosureExpression: %s%n", "$stringIsReevaluatedUsingClosureExpression"))


// 5. Slashy Strings :"
printHeading('Slashy Strings : \"${variableName}\"')
def slashString = /hello this is a slashy string using a \/string\/ syntax/
println(slashString)



// 6. Primitive Types :"
printHeading('Primitive Types')
def integerLocal = 19I
def longLocal= 3_933_967_686_767L
def bigIntLocal = 8_680_124G
def doubleLocal = 2.34D
def floatLocal = 2.34F
def binaryLocal= 0b01110001
def octalLocal= 03247
def hexLocal=0xAFF8FA

println(/int or Integer: append "I" at the end of the value (ex: 19I): / + integerLocal)
assert 19I == new Integer(19)
println(/long or Long: append "L" at the end of the value (ex: 3_933_967_686_767L): / + longLocal)
println(/notice you can embed the "_" underscore separator into the value for ease of reading code/)
assert 3_933_967_686_767L == new Long(3933967686767)


println("\n" + / * BigInteger: append "G" at the end of the value (ex: 8_680_124G): / + bigIntLocal + "\n")

println(/double or Double: append "D" at the end of the value (ex: 2.34D): / + doubleLocal)
println(/float or Float: append "F" at the end of the value (ex: 2.34f): / + floatLocal)


println(/binary: prefix  "0b" to value (ex: 0b01110001): / + binaryLocal)
println(/octal: prefix  "0" to value (ex: 03247): / + octalLocal)
println(/hexadecimal: prefix  "0x" to value (ex: 0xAFF8FA): / + hexLocal)





// 7 List :"
printHeading('List')
println("list content can be heterogeneous")
def heteroList = ["abc", 1223, "my name is jason", true]
println(String.format("a list of heterogenous content:%s", heteroList))

println("")
println(/you can append to list with the << operator on the list, so I can do list << "my inserted element"/)
heteroList << "my inserted element"
println(String.format("list after append << operation:%s", heteroList))


// 8 'Maps / Dictionaries' :"
printHeading('Maps / Dictionaries')
def colors = [red: '#FF0000', green: '#00FF00', blue: '#0000FF']
println(/define map like this: def colors = [red: '#FF0000', green: '#00FF00', blue: '#0000FF']/)
println(/assess elements like this: colors['red'] == '#FF0000'/)
println(/ or  like this: colors.green  == '#00FF00'/)
assert colors['red'] == '#FF0000'
assert colors.green  == '#00FF00'

print("\n")
println(/if your key is from a variable, you need to put parenthesis around the variable: like this: person = [(keyVariable): "value"]/)
println(/ def map1 = [key, "jason"]/ )
def map1 = [key: "jason"]
println(map1)


print("\n")
println(/def myKey = 'key123'/ )
println(/def map2 = [(myKey): "jason"]/ )

def myKey = 'key123'
def map2 = [(myKey): "jason"]
println(map2)




// 9 'Special Operators
//
//   ?=    Elvis operator a short hand for the ternary operator, after the operator, you specify the else part
//  def myVar = someVariable?= "DefaultValue"  //if someVariable does not exist or is false, then assign DefaultValue to myVar
//                              but if someVariable does exist, then myVar=someVariable
//
//
//  ?.   Safe Navigation Operator: check if the variable is null, will not crash the program
//          def myVar = someVariable?.value   //myVar will be safely assigned to null if someVariable is a null pointer
//
//
//  ?@  Direct Field accessor
//              directly gets the value from the the value of a field in a class, instead of calling the getter method
//                  which then gets the field, this operator will force not use the getter method
//              in other words, directly get the field value

//  .& Method Pointer  operator: get the pointer to teh method in a class




/* Default import by Groovy:

The below imports are added by groovy for you:
This is done because the classes from these packages are most commonly used. By importing these boilerplate code is reduced.

import java.lang.*
import java.util.*
import java.io.*
import java.net.*
import groovy.lang.*
import groovy.util.*
import java.math.BigInteger
import java.math.BigDecimal

 */


\
// x THE END :"
printHeading('THE END of Groovy Learning Exercise script')