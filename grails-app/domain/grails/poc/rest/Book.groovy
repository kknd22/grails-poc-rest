package grails.poc.rest

import grails.rest.Resource
//@Resource(uri='/books',  formats=['json', 'xml'])
@Resource(formats=['hal', 'json', 'xml'])
//@Resource()
class Book {
	String title

	static hasMany = [chapters: BookChapter]

	
	static mapping = {
		chapters lazy: false
	}
	
    static constraints = {
    	title blank: false
    }
}
