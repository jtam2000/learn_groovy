package com.github.jtam2000

import org.junit.Test

class Syntax09Map {

    @Test
    void dictKeysCanBeInDictPropertiesNotation(){

        //learning: each key can be a property of the dictionary or accessed as a property
        def nameToAge = [brandon: 12, Colleen: 52, Natalie: 1, Zoe: 34]

        assert nameToAge.Natalie == 1
    }

    @Test
    void dictNonStandardKeyPropertiesMustBeInQuotes(){

        //learning: key properties that contain non-alpha characters such as dash, space, colon etc. are invalid
        // key properties and needs to be in quotes

        def nonStdKeyMap = ['My Name': 'jason', 'Street-address': "100 main", "a:b ratio" : "1:3"]

        assert nonStdKeyMap['My Name'] == 'jason'
    }

    @Test
    void dictKeysCanBeInArraySubscriptNotation(){

        //learning: each map entry can be accessed with Array subscript notation
        def nameToAge = [brandon: 12, Colleen: 52, Natalie: 1, Zoe: 34]

        assert nameToAge['Natalie'] == 1
        assert nameToAge['Jason'] == null

        assert nameToAge[3] == null
        assert nameToAge["Zoe"] == 34
    }

    @Test
    void addMapEntryUsingAssignmentOfNewKey(){

        def nameToAge = [brandon: 12, Colleen: 52, Natalie: 1, Zoe: 34]

        nameToAge.Linda = 42
        nameToAge['David'] = 49

        assert nameToAge.containsKey('Linda')
        assert nameToAge.containsKey('David')

        def expected = [brandon: 12, Colleen: 52, Natalie: 1, Zoe: 34, Linda: 42, David: 49]
        assert nameToAge == expected
    }

    @Test
    void keysCanBeNonStringType() {

        def numKeyDict = [1: "jason", 2: "linda", 3: "colleen", 100: "zeus"]

        assert numKeyDict[100] == 'zeus'
    }

    @Test
    void referencingKeysWithVariablesMustBeInParens() {

        def key = 'Natalie'

        //learning:  (key) means interpolation of the key variable
        def nameToAge_WithParen = [brandon: 12, Colleen: 52, (key): 1, Zoe: 34]
        assert nameToAge_WithParen['Natalie'] == 1
        assert nameToAge_WithParen.key == null

        //learning: no variable interpolation
        def nameToAge_NoParen = [brandon: 12, Colleen: 52, key: 1, Zoe: 34]
        assert nameToAge_NoParen['Natalie'] == null
        assert nameToAge_NoParen['key'] == 1

    }
}
