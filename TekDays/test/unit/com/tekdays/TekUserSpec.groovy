package com.tekdays

import grails.test.mixin.TestFor
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(TekUser)
class TekUserSpec extends Specification {

    def setup() {
    }

    def cleanup() {
    }

    void "test toString"() {
        when: "a user has a full name"
        def user = new TekUser(fullName: "John Smith")
        
        then: "this will be the toString() result"
        "John Smith" == user.toString()
    }
}
