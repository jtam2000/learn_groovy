package com.github.jtam2000

import org.junit.Test

class Syntax07List {

    @Test
    void negativeIndexToGetItemFromEndOfList() {

        def heterogeneousList = ["strings", 873, false, [DictKey: "Dict Value"], 34.831]

        assert heterogeneousList[-1] == 34.831
        assert heterogeneousList[-2] == [DictKey: "Dict Value"]
    }

    @Test
    void indexRange() {
        def list = ["0", "1", "2", "3", "4", "5", "6", "7"]

        def range = list[1..3]
        assert range == ["1", "2", "3"]
        assert list[3..1] == range.reverse()

        def negRange = list[-1..-3]
        assert negRange == ["7", "6", "5"]
        assert list[-3..-1] == negRange.reverse()

    }

    @Test
    void accessMultiDimensionalList() {
        def mdList = [[0, 1, 2, 3, 8], [100, 101, 102, 103, 104, 105]]

        assert mdList[1][3] == 103
        assert mdList[0][2] == 2
    }

    @Test
    void indicesFromList() {

        def list = ["0", "1", "2", "3", "4", "5", "6", "7"]
        assert list[2, 4, 6, -1] == ["2", "4", "6", "7"]
    }

    @Test
    void fromRangeToListUsingCollectMethod() {

        def list = ('a'..'z').collect()
        assert list.size()==26

        list = (2..5)
        assert list == [2, 3, 4, 5]
    }

    @Test
    void operatorToAppendToEndOfList() {

        //learning: "<<" append to END of the list
        def list = ["my", "name", "is",]
        list << "jason"

        def expected = ["my", "name", "is", "jason"]

        assert list == expected

        //learning: chaining of "<<" operator
        list << "." << "  I am glad to meet you"

        expected = ["my", "name", "is", "jason", ".", "  I am glad to meet you"]
        assert list == expected
    }

    def isEven = { x -> x % 2 == 0 }
    @Test
    void findAllElementUsingPredicate() {


        def list = (10..15).collect()
        //learning: find(predicate}
        assert list.findAll(isEven) == [10, 12, 14]
    }

    @Test
    void checkEveryElementSatisfyPredicate() {

        def list = [2, 4, 6, 8, 10]

        //learning: every(predicate)
        assert list.every(isEven)
    }

    @Test
    void checkIfAnyElementSatisfyPredicate() {

        def list = [1, 4, 7, 9, 17]

        //learning: every(predicate)
        assert list.any(isEven)
    }

    @Test
    void joinOrConcatAllElements(){

        def list = [718, 891, 7884]
        assert list.join('-') == '718-891-7884'

    }

    @Test
    void listIntersections() {

        def list = [718, 891, 7884]
        def list2 = [23, 7884, 2]

        assert list.intersect(list2)==[7884]

        list = [718, 891, 7884, "a", "b", "c"]
        list2 = [23, 7884, 2, "b", ["b", "c"]]
        assert list.intersect(list2) == [7884, "b"]
    }

}
