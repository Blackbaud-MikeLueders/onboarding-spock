package com.example.execution

import spock.lang.Specification

class ExecutionSpock extends Specification {

    def setupSpec() {
        println "setupSpec: ${hashCode()}"
    }

    def cleanupSpec() {
        println "cleanupSpec: ${hashCode()}"
    }

    def setup() {
        println "setup: ${hashCode()}"
    }

    def cleanup() {
        println "cleanup: ${hashCode()}"
    }

    def "test1"() {
        given:
        println "test1: ${hashCode()}"
        println id
        println closure.call()

        expect:
        true

        where:
        id                     | closure                              | whereConstruct
        "test1 where: ${hashCode()}" | { "test1 closure: ${returnId()}"}    | printWhereConstruct("test1")
    }

    def "test2"() {
        given:
        println "test2: ${hashCode()}"
        println id
        println closure.call()

        expect:
        true

        where:
        id                     | closure                              | whereConstruct
        "test2 where: ${hashCode()}" | { "test2 closure: ${returnId()}"}    | printWhereConstruct("test2")
    }

    private String returnId() {
        "${hashCode()}"
    }

    private void printWhereConstruct(String testName) {
        println "${testName} where construct: ${hashCode()}"
    }

}
