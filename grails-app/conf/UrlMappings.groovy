class UrlMappings {

	static mappings = {
		"/persons" 						(controller:"person") {action=["GET": "list", "POST": "saveOrUpdate"]}
		"/persons/$id" 					(controller:"person") {action=["GET": "read", , "DELETE" : "delete"]}
		"/persons/$pId/addresses" 		(controller:"address") {action=["GET": "list", , "POST": "saveOrUpdate"]}
		"/persons/$pId/addresses/$id"	(controller:"address") {action=["GET": "read", "DELETE" : "delete"]}
/*		 
        "/$controller/$action?/$id?(.$format)?"{
            constraints {
                // apply constraints here
            }
        }
*/
        "/"(view:"/index")
        "500"(view:'/error')
	}
}
