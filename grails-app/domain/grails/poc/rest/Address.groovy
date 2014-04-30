package grails.poc.rest

class Address {
	
	String street
	
	static belongsTo =[Person]
	
    static constraints = {
    }
}
