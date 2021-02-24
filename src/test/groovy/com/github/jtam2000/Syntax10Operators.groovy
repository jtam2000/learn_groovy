package com.github.jtam2000

import org.junit.Test

import java.nio.file.Files
import java.nio.file.Path

class Syntax10Operators {

    @Test
    void identicalOperator() {

        def var1 = ['a', 'b', 'c']
        def var1Copy = var1

        def var2 = ['a', 'b', 'c']
        def var2Copy = var2

        assert var1 == var2

        //learning: identical operator (triple equal) : ===
        assert var1 === var1
        assert var1 == var1Copy
        //learning: same as calling is() method
        assert var1.is(var1)

        //learning: NOT identical operator: !==  (Notice TWO equal sign)
        assert var1 == var2     //content equal
        assert var1 !== var2
    }

    @Test
    void elvisOperatorIsShortHandTernaryOperatorWithoutTruePart() {

        def bool = false

        //learning: you don't have to repeat the true part
        def endBool = bool ?: 'Not True'

        assert endBool == 'Not True'
    }

    @Test
    void elvisAssignmentOperatorAssignsValueToVariableIfVariableNotDefinedOrFalse() {
        //case 1: var is false
        def var = false
        var ?= 'variable defined because var is not defined or false'
        assert var == 'variable defined because var is not defined or false'

        //case 2: var is true, variable is NOT changed
        var = true
        var ?= 'variable defined because var is not defined or false'
        assert var == true

        //case 3: var is not defined
        var = null
        var ?= 'variable defined because var is not defined or false'
        assert var == 'variable defined because var is not defined or false'

        //case 4: var is defined: variable is NOT CHANGED
        var = 'define'
        var ?= 'variable defined because var is not defined or false'
        assert var == 'define'
    }

    @Test
    void safeNavigationOperator_AvoidNullPointerException() {

        //learning: ?. is the safe navigation operator
        def var = null

        //learning: ?. prevents exception if property/method does not exist
        def accessNonProperty = var?.bogusProperty

        assert accessNonProperty == null
    }

    static def someFunction(String str) {
        return str.toUpperCase()
    }

    static def someFunction(Integer value) {
        return value**2
    }

    @Test
    void methodPointerOperator() {

        def list = "abc"
        //learning: .& is the method reference operator, it gets the method as a closure
        //  the closure can then be used anywhere a closure is required
        //  definition: the operator returns a reference to a method of a variable
        // it is bound by 1. the variable and 2. the method
        def reverseFunction = list.&reverse
        println reverseFunction()

        //overloaded functions will disambiguate by method parameters
        def overloadedFunct = this.&someFunction

        assert overloadedFunct("hello") == "HELLO"
        assert overloadedFunct(7) == 49

    }

    @Test
    void methodPointerOperatorForConstructors() {

        def bigIntConstructor = BigInteger.&new
        def myBigInt = bigIntConstructor '42'
        assert myBigInt == 42G
    }

    @Test
    void methodReferenceOperatorHasSameFunctionalityAsMethodPointerOperator() {

        //learning: method reference operator is same as java "::" (2 colons)
        // here were are referencing BigInteger::add
        assert 6G == [1G, 2G, 3G].stream().reduce(0G, BigInteger::add)
    }

    class Component {
        Long id
        String name
    }

    @Test
    void spreadOperatorOnListMakeListOfAttributeOfObject() {

        def myComponents = [
                new Component(name: "jason"),
                new Component(name: "linda"),
                new Component(id: 3, name: "colleen"),
        ]

        //LEARNING: Spread Operator(on list) =>    *.
        // will make a list of all the [name] attributes in the variable calling the operator
        // definition: equivalent to calling action on each item and collecting the result into a list
        assert myComponents*.name == ["jason", "linda", "colleen"]

        // Learning: Spread Operator is null-pointer safe
        assert myComponents*.id == [null, null, 3]

    }

    @Test
    void spreadOperatorOnMapExpandsOutTheContentOfTheMap() {
        def myMapForInsert = [jason: 2, lobster: 5, salad: 223]

        //learning apply spread operator on the map to de-reference the map
        // important: notice the ":" before the * =>        e.g.:  *:myMapForInsert
        def myMap = [mammia: 100, *: myMapForInsert]
        assert myMap == [mammia: 100, jason: 2, lobster: 5, salad: 223]

        //learning: Notice after the Spread operator the map that was expanded can be redefined after the spread Operator
        // notice here: key [lobster: 5] has been redefined to [lobster: 200]
        def myMap2 = [mammia: 100, *: myMapForInsert, lobster: 200]
        assert myMap2 == [mammia: 100, jason: 2, lobster: 200, salad: 223]
    }

    @Test
    void rangeOperator() {
        def range = 2..10
        assert range == [2, 3, 4, 5, 6, 7, 8, 9, 10]

        assert range.size() == 9

        def alphaRange = 'a'..'z'
        alphaRange.with {
            assert contains('b') &&
                    contains('x') &&
                    contains('g')
        }
    }

    @Test
    void safeIndexOperatorPreventsOutOfRangeException() {

        def myRange = [1,2,3]
        def getNum = myRange?[5]
        assert getNum==null
    }

    @Test
    void listMembershipOperatorIn() {

        def list = 'g'..'n'
        assert !('a'  in list)

    }

    @Test
    void test() {

        assert !Files.isDirectory(Path.of("src/main/does_not_exist"))
    }

}
