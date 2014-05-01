package grails.poc.rest

import grails.converters.JSON
import grails.plugin.gson.converters.GSON
import grails.transaction.Transactional
import dto.AddressDto
import dto.PersonDto
import util.BeanUtils

import static org.springframework.http.HttpStatus.*

//import static org.springframework.http.HttpMethod.*

class AddressController {

	def list(Integer pId, Integer max) {
		println("in AddressController list() params: $params")
		//params.max = Math.min(max ?: 10, 100)
		//respond Person.list(params), model:[personCount: Person.count()]
		def ads =  Person.get(pId).addresses 
		

		def dtos= []
		ads.each{ 
			def dto = new AddressDto()
			BeanUtils.copyProperties(it, dto)
			dtos << dto
		}
		
		println(dtos)
		response.contentType = "application/json"
		render dtos as GSON
	}

	def read(Integer pId, Integer id) {
		println("in AddressController read() params: $params")
		def a =  Person.get(pId).addresses.find{it.id == id}
		
		def dto = new AddressDto() 
		BeanUtils.copyProperties(a, dto)
		println(dto)
		response.contentType = "application/json"
		render dto as GSON
	}

	@Transactional 
	def saveOrUpdate(Integer pId) {
		def p =  Person.get(pId)

		println("in AddressController saveOrUpdate() pId: ${pId}, p.name: ${p.name}, request.GSON: ${request.GSON}")
		response.contentType = "application/json"

		def a = new Address(request.GSON)
		if (!a.id) {
			p.addToAddresses(a)
			p.save()
			render status: CREATED
		} else {
			def e =  p.addresses.find{it.id == a.id}
			if (!e) {
				render status: NOT_FOUND
			}
			else {
				a.save()
				render status: OK
			}
		}
	}
	
	@Transactional
	def delete(Integer pId, Integer id) {
		println("in AddressController delete() pId: $pId, id: $id, params: $params")
		def p = Person.get(pId)
		def a = p.addresses.find {it.id == id}
		p.removeFromAddresses(a)
		a.delete()
		
		//response.contentType = "application/json"
		render status: NO_CONTENT
	}

}
