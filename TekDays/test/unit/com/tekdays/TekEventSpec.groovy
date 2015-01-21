package com.tekdays

import grails.test.mixin.TestFor
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(TekEvent)
class TekEventSpec extends Specification {

    def setup() {
    }

    def cleanup() {
    }

    void "test toString"() {
        when: "a tekEvent has a name and a city"
        def organizer = [fullName: 'John Smith'] as TekUser
        def tekEvent = new TekEvent(name: 'Groovy North', city: 'Leeds', organizer: organizer)

        then: "the toString method will combine them"
        tekEvent.toString() == 'Groovy North, Leeds'
    }
}
