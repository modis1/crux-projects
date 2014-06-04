package org.cruxframework.test.cruxtestwidgets.server;



import java.util.Date;

import org.cruxframework.crux.core.server.rest.annotation.RestService;
import org.cruxframework.crux.core.shared.rest.annotation.GET;
import org.cruxframework.crux.core.shared.rest.annotation.Path;
import org.cruxframework.crux.core.shared.rest.annotation.PathParam;
import org.cruxframework.crux.core.shared.rest.annotation.QueryParam;
import org.cruxframework.test.cruxtestwidgets.client.modelo.Pessoa;


@RestService("myRestService")
@Path("rest")
public class MyRestService {

	
	@GET
	@Path("inteiro/{numero}")
   public Integer enviarInteiro(@PathParam("numero") Integer numero){    	
		return numero;
    }
	
	@GET
	@Path("palavra/{palavra}")
    public String enviarString(@PathParam("palavra")String palavra){    
		return palavra; 
    }
	
	@GET
	@Path("double/{numero}")
	public Double enviarDouble(@PathParam("numero")Double numero){		
		return numero;
	}
		
	@GET
	@Path("caracter/{caracter}")
	public Character enviarChar(@PathParam("caracter")Character caracter){		
		return caracter;
	}
	
	@GET
	@Path("pessoa/{pessoa}")
	public Pessoa enviarPessoa(@QueryParam("pessoa")Pessoa pessoa){		
		return pessoa;
	}
	
	@GET
	@Path("data/{data}")
	public Date enviarData(@PathParam("data")Date data){		
		return data;
	}

}
