package dto

import grails.rest.Resource
@Resource(formats=['hal', 'json', 'xml'])
class AddressDto {
	Integer id
	String street
	
}
