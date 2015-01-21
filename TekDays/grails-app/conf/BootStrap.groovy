import com.tekdays.TekEvent
import com.tekdays.TekUser

class BootStrap {

    def init = { servletContext ->
        def user1 = new TekUser(
                fullName: 'John Doe',
                userName: 'jdoe',
                password: 't0ps3cr3t',
                emailAddress: 'jdoe@johnsgroovyshop.com',
                website: 'blog.johnsgroovyshop.com',
                bio: '''John has been programming for over 40 years. He has
                        worked with every programming language known to man
                        and has settled on Groovy. In his spare time, John
                        dabbles in astro physics and plays
                        shuffleboard.''').save(flush: true)
                        
        assert user1 != null
                        
        def user2 = new TekUser(
                fullName: 'John Deere',
                userName: 'tractorman',
                password: 't0ps3cr3t',
                emailAddress: 'john.deere@porkproducers.org',
                website: 'www.perl.porkproducers.org',
                bio: '''John is a top notch Perl programmer and a pretty
                        good hand around the farm. If he can't program it he
                        can plow it!''').save(flush: true)
            
        assert user2
                                    
        def event1 = new TekEvent(
                name: 'Gateway Code Camp',
                city: 'Saint Louis,  MO',
                organizer: TekUser.findByFullName('John Doe'),
                venue: 'TBD',
                description:
                '''This conference will bring coders from
                across platforms, languages and industries
                together for an exciting day of tips, tricks, 
                and tech!  Stay sharp!  Stay at the top of your 
                game!  But don't stay home!  Come and join us 
                this fall for the first annual Gateway Code Camp!''',
                startDate: Date.parse('yyyy/MM/dd', '2014/11/21'),
                endDate: Date.parse('yyyy/MM/dd', '2014/11/21')
                )

        if (!event1.save()) {
            event1.errors.allErrors.each { error-> println "An error occured with event 1: ${error}"  }
        }

        def event2 = new TekEvent(
                name: 'Perl Before Swine',
                city: 'Austin, MN',
                organizer: TekUser.findByFullName('John Deere'),
                venue: 'SPAM Museum',
                startDate: new Date('11/2/2015'),
                endDate: new Date('11/2/2015'),
                description:
                '''Join the Perl programmers of the Pork Producers
                of America as we hone our skills and ham it up
                a bit.  You can show off your programming chops
                while trying to win a year's supply of pork
                chops in our programming challenge.
                
                Come and join us in historic (and aromatic),
                Austin, Minnesota.  You'll know when you're
                there!''')
        
        if (!event2.save()){
            event2.errors.allErrors.each{error -> println "An error occured with event2: ${error}" }
        }
        
        
        def g1 = TekEvent.findByName('Gateway Code Camp')
        g1.addToVolunteers(
            new TekUser(
                fullName: 'Sarah Martin', 
                userName: 'sarah', 
                password: '54321',
                emailAddress: 'sarah@martinworld.com',
                website: 'www.martinworld.com',
                bio: 'Web designer and Grails fan'))
        
        g1.addToVolunteers(
            new TekUser(
                fullName: 'Bill Smith',
                userName: 'Mr_Bill',
                password: '12345',
                emailAddress: 'mrbill@email.com',
                website: 'www.mrbillswebsite.com',
                bio: 'Software developer, claymation artist'))

        g1.addToRespondents('joeblogs@email.com')
        g1.addToRespondents('ben@grailsmail.com')
        g1.addToRespondents('zachary@linuxgurus.com')
        g1.addToRespondents('solomon@bootstrapwelding.com')
        
        g1.save()
    }

    def destroy = {
    }
}
