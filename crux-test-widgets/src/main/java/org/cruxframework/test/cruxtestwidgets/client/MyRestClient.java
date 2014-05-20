package org.cruxframework.test.cruxtestwidgets.client;

import org.cruxframework.crux.core.client.rest.Callback;
import org.cruxframework.crux.core.client.rest.RestProxy;
import org.cruxframework.crux.core.client.rest.RestProxy.TargetRestService;

@TargetRestService("myRestService")
public interface MyRestClient extends RestProxy {
	   
     void enviarInteiro(Integer numero,Callback<Integer> callback );
    
     void enviarString(String palavra, Callback<String> callback);
     
     void enviarDouble(Double numero, Callback<Double> callback);
    
     void enviarChar(Character caracter, Callback<Character> callback);
    
}