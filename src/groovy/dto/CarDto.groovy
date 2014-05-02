package dto

import grails.rest.Resource
@Resource(formats=['hal', 'json', 'xml'])
class CarDto {
	Integer id
	String model
}
