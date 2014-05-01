import grails.rest.render.hal.HalJsonRenderer
import grails.rest.render.hal.HalJsonCollectionRenderer

// Place your Spring DSL code here

beans = {
	//special hibernate proxy adapter factory for GSON

	hibernateProxyAdapterFactory(hbadapter.HibernateProxyAdapterFactory)
	
	halPersonRenderer(HalJsonRenderer, dto.PersonDto)
	hallPersonCollectionRenderer(HalJsonCollectionRenderer,  dto.PersonDto){
		collectionName = 'people'
	}
	
	halAddressRenderer(HalJsonRenderer, grails.poc.rest.Address)
	hallAddressCollectionRenderer(HalJsonCollectionRenderer,  grails.poc.rest.Address)

	halAddressDtoRenderer(HalJsonRenderer, dto.AddressDto)
	hallAddressDtoCollectionRenderer(HalJsonCollectionRenderer,  dto.AddressDto)

	halCarRenderer(HalJsonRenderer, grails.poc.rest.Car)
		
	halBookRenderer(HalJsonRenderer, grails.poc.rest.Book)
	hallBookCollectionRenderer(HalJsonCollectionRenderer,  grails.poc.rest.Book)

	halBookChapterRenderer(HalJsonRenderer, grails.poc.rest.BookChapter)
	halBookChapterCollectionRenderer(HalJsonCollectionRenderer, grails.poc.rest.BookChapter)
	
}
