import com.google.gson.Gson
import com.google.gson.GsonBuilder
import grails.poc.rest.Book
import grails.poc.rest.Person
import grails.poc.rest.Address
import grails.poc.rest.Car
import hbadapter.HibernateProxyTypeAdapter

class BootStrap {

    def init = { servletContext ->
		
		GsonBuilder b = new GsonBuilder();
		b.registerTypeAdapterFactory(HibernateProxyTypeAdapter.FACTORY);
		Gson gson = b.create();
		
    	new Book(title:"The Stand").save()
        new Book(title:"The Shining").save()
		
		def p1 = new Person(name: "name1", nick: "nick1", addresses: [], car: new Car(model: "Mustang"))
		p1.addresses << new Address(street: "street11")
		p1.addresses << new Address(street: "street12")
		p1.save()

		def p2 = new Person(name: "name2", nick: "nick2", addresses: [], car: new Car(model: "Corvet"))
		p2.addresses << new Address(street: "street21")
		p2.addresses << new Address(street: "street22")
		p2.save()
		
		def p3 = new Person(name: "xxxxxx")
		p3.save()
    }

    def destroy = {
    }
}
