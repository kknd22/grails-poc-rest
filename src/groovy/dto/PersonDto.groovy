package dto

import grails.poc.rest.Person;
import grails.poc.rest.Address;
import grails.poc.rest.Car;

import grails.rest.Resource
@Resource(formats=['hal', 'json', 'xml'])
class PersonDto {
	Integer id
	String name
	String nick
	List<AddressDto> addresses
	CarDto car
	
	void populated(Person p) {
		id=p.id
		name = p.name
		nick = p.nick
		if (p.car) 
			car = new CarDto(id: p.car.id, model: p.car.model)
		
		addresses=[]
		p.addresses.each {
			addresses << new AddressDto(id: it.id, street: it.street)
		}
	}
}
