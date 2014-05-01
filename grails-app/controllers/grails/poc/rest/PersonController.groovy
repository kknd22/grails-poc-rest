package grails.poc.rest

import grails.converters.JSON
import grails.plugin.gson.converters.GSON
import grails.transaction.Transactional
import util.BeanUtils
import dto.PersonDto

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import hbadapter.HibernateProxyTypeAdapter


import static org.springframework.http.HttpStatus.*

//import static org.springframework.http.HttpMethod.*

class PersonController {

	def list(Integer max) {
		println("in PersonController list() params: [$params]")
		//params.max = Math.min(max ?: 10, 100)
		//respond Person.list(params), model:[personCount: Person.count()]
		def ps =  Person.list()
		def dtos= []
		ps.each{
			def dto = new PersonDto()
			BeanUtils.copyProperties(it, dto)
			dtos << dto
		}
		
		println("dtos: ${dtos.dump()}")
		respond dtos
/*		
		response.contentType = "application/json"
		render dtos as GSON
		GsonBuilder b = new GsonBuilder();
		b.registerTypeAdapterFactory(HibernateProxyTypeAdapter.FACTORY);
		Gson gson = b.create();
		
		
		
		render gson.toJson(ps)
		render ps as GSON
*/
		
	}

	def read(Integer id) {
		println("in PersonController read()")
		def ps =  Person.get(id)
		def dto = new PersonDto()
		
		BeanUtils.copyProperties(ps, dto)
		println("dto: ${dto.dump()}")
		/*
		response.contentType = "application/json"
		render dto as GSON
		*/
		respond dto
	}

	@Transactional 
	def saveOrUpdate() {
		def p = new Person(request.GSON)
		println("in PersonController saveOrUpdate() p.id: ${p.id}, p.name: ${p.name}")
		p.save flush:true
		
		// not existing id need to return 404
		response.contentType = "application/json"
		if (!p.id)
			withFormat {
				'*' { render status: CREATED }
			}
		else
			withFormat {
				'*' { render status: OK}
			}
	}

	@Transactional
	def delete(Integer id) {
		println("in PersonController delete() id: $id")
		def p = Person.get(id)
		p.delete()
		
		//response.contentType = "application/json"
		render status: NO_CONTENT
	}

}
