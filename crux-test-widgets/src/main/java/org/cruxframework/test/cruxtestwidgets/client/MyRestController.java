package org.cruxframework.test.cruxtestwidgets.client;

import org.cruxframework.crux.core.client.controller.Controller;
import org.cruxframework.crux.core.client.controller.Expose;
import org.cruxframework.crux.core.client.ioc.Inject;
import org.cruxframework.crux.core.client.rest.Callback;
import org.cruxframework.crux.core.client.screen.views.BindView;
import org.cruxframework.crux.core.client.screen.views.WidgetAccessor;
import org.cruxframework.crux.widgets.client.dialog.FlatMessageBox;
import org.cruxframework.crux.widgets.client.dialog.FlatMessageBox.MessageType;

import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.TextBox;

@Controller("myRestController")
public class MyRestController {
	 	
		@Inject
		private MyRestClient service;
	 	
	 	@Inject
	 	private RestView restView;
	 	
	    public void setService(MyRestClient service) {
	        this.service = service;
	    }
	    
	    public void setRestView(RestView restView) {
			this.restView = restView;
		}


		@Expose
	    public void enviarInteiro(){
			
	    		Integer in = Integer.parseInt(restView.gwtTxbObjetoSimples().getValue());   	
	    		
	    		service.enviarInteiro(in, new Callback<Integer>(){

				@Override
				public void onSuccess(Integer result) {
					String msg = Integer.toString(result);					
					FlatMessageBox.show(msg, MessageType.INFO);	
				}

				@Override
				public void onError(Exception e) {
					FlatMessageBox.show("Falha ao receber o inteiro ", MessageType.WARN);										
				}
	    		
	    	});
	    }
	    
		
		@Expose
		public void enviarString(){
			
			String palavra = restView.gwtTxbObjetoSimples().getValue();
			service.enviarString(palavra, new Callback<String>(){

				@Override
				public void onSuccess(String result) {								
					FlatMessageBox.show(result, MessageType.INFO);	
					
				}

				@Override
				public void onError(Exception e) {
					FlatMessageBox.show("Falha ao receber a palavra ", MessageType.WARN);					
				}
				
			});
		}
	    
		@Expose
		public void enviarDouble(){
			Double numero = Double.parseDouble(restView.gwtTxbObjetoSimples().getValue());		
			
				service.enviarDouble(numero, new Callback<Double>() {

				@Override
				public void onSuccess(Double result) {
					String d = Double.toString(result);					
					FlatMessageBox.show(d, MessageType.INFO);						
				}

				@Override
				public void onError(Exception e) {
					FlatMessageBox.show("Falha ao receber o double ", MessageType.WARN);	
					
				}
				
			});
		}
		
		@Expose
		public void enviarChar(){
			
			Character c = new Character(restView.gwtTxbObjetoSimples().getValue().charAt(0));				
			service.enviarChar(c, new Callback<Character>() {

				@Override
				public void onSuccess(Character result) {	
					
					FlatMessageBox.show("caracter: " + result, MessageType.INFO);	
				}

				@Override
				public void onError(Exception e) {
					FlatMessageBox.show("Falha ao receber o caracter ", MessageType.INFO);	
					e.printStackTrace();
					
				}
				
			});
			
		}
		
		
		
		@BindView("rest")
	    public static interface RestView extends WidgetAccessor{
	      	TextBox gwtTxbObjetoSimples();
	    	
	    }
	    
	   
	    

}
