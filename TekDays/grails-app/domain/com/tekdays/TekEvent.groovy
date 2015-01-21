package com.tekdays

import java.time.LocalDate;

class TekEvent {

    String city
    String name
    TekUser organizer
    String venue
    Date startDate
    Date endDate
    String description

    @Override
    public String toString() {
        "$name, $city"
    }

    static constraints = {
        name()
        city()
        description maxSize: 5000
        organizer()
        venue()
        startDate min: Date.parse('yyyy/MM/dd', '2014/01/01')
        endDate max: Date.parse('yyyy/MM/dd', '2100/01/01')
    }
}
