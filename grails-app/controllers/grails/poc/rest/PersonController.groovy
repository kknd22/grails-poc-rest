package grails.poc.rest

import grails.converters.JSON
import grails.plugin.gson.converters.GSON
import grails.transaction.Transactional
import static org.springframework.http.HttpStatus.*

//import static org.springframework.http.HttpMethod.*

class PersonController {

	def list(Integer max) {
		println("in PersonController index() params: [$params]")
		//params.max = Math.min(max ?: 10, 100)
		//respond Person.list(params), model:[personCount: Person.count()]
		def ps =  Person.list()
		
		println(ps)
		response.contentType = "application/json"
		render ps as GSON
	}

	def read(Integer id) {
		println("in PersonController show()")
		def ps =  Person.get(id)
		
		println(ps)
		response.contentType = "application/json"
		render ps as GSON
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
