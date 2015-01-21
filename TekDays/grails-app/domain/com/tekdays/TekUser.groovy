package com.tekdays

class TekUser {

    String fullName
    String userName
    String password
    String emailAddress
    String website
    String bio
    
    @Override
    public String toString() {
        fullName
    }
    
    static constraints = {
        fullName()
        userName()
        emailAddress email: true
        website()
        bio maxSize: 5000
        password display: false
    }
}
