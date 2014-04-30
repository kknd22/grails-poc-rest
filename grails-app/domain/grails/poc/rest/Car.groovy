package grails.poc.rest

class Car {
	String model
	
	static belongsTo = [Person]
    static constraints = {
    }
}
