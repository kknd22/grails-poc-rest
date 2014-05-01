package grails.poc.rest

class Person {
	
	String name
	String nick
	Car car
	
	static hasMany = [addresses: Address]
	
	static mapping = {
		addresses lazy: true 
	}
    static constraints = {
    }
}
