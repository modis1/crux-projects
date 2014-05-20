package org.cruxframework.test.cruxtestwidgets.server;



import org.cruxframework.crux.core.server.rest.annotation.RestService;
import org.cruxframework.crux.core.shared.rest.annotation.GET;
import org.cruxframework.crux.core.shared.rest.annotation.Path;
import org.cruxframework.crux.core.shared.rest.annotation.PathParam;

@RestService("myRestService")
@Path("rest")
public class MyRestService {

	
	@GET
	@Path("inteiro/{numero}")
   public Integer enviarInteiro(@PathParam("numero") Integer numero){    	
		return numero + 3;
    }
	
	@GET
	@Path("palavra/{palavra}")
    public String enviarString(@PathParam("palavra")String palavra){    
		return "Você enviou a palavra: " + palavra; 
    }
	
	@GET
	@Path("double/{numero}")
	public Double enviarDouble(@PathParam("numero")Double numero){		
		return numero/3;
	}
	
	
	@GET
	@Path("caracter/{char}")
	public Character enviarChar(@PathParam("char")Character caracter){		
		
		return caracter;
	}

}
