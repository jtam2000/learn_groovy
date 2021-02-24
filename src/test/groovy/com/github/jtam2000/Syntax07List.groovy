package com.github.jtam2000

import org.junit.Test

class Syntax07List {

    @Test
    void negativeIndexToGetItemFromEndOfList(){

        def heterogeneousList = ["strings", 873, false, [DictKey : "Dict Value"], 34.831]

        assert heterogeneousList[-1] == 34.831
        assert heterogeneousList[-2] == [DictKey : "Dict Value"]
    }

    @Test
    void indexRange(){
        def list = ["0", "1", "2", "3", "4", "5", "6", "7"]

        def range = list[1..3]
        assert range == ["1", "2", "3"]
        assert list[3..1] == range.reverse()

        def negRange = list[-1..-3]
        assert negRange  == ["7", "6", "5"]
        assert list[-3..-1] == negRange.reverse()

    }

    @Test
    void accessMultiDimensionalList(){
        def mdList = [ [0, 1, 2, 3, 8] , [100, 101, 102, 103, 104, 105]]

        assert mdList[1][3] == 103
        assert mdList[0][2] == 2
    }

    @Test
    void indicesFromList(){

        def list = ["0", "1", "2", "3", "4", "5", "6", "7"]
        assert list[2, 4, 6, -1] == ["2", "4", "6", "7"]
    }

    @Test
    void operatorToAppendToEndOfList(){

        //learning: "<<" append to END of the list
        def list = ["my", "name", "is", ]
        list << "jason"

        def expected =  ["my", "name", "is", "jason"]

        assert list == expected

        //learning: chaining of "<<" operator
        list << "." << "  I am glad to meet you"

        expected = ["my", "name", "is", "jason", ".", "  I am glad to meet you"]
        assert list == expected
    }

}
