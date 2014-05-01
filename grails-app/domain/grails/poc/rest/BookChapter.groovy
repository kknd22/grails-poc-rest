package grails.poc.rest

import grails.rest.Resource

@Resource(formats=['hal', 'json', 'xml'])
class BookChapter {
	Integer pageCount
	
	//static belongsTo [Book]
	
    static constraints = {
    }
}
