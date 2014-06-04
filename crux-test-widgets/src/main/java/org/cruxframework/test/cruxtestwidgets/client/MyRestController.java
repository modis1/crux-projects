package org.cruxframework.test.cruxtestwidgets.client;



import java.util.Date;

import org.cruxframework.crux.core.client.controller.Controller;
import org.cruxframework.crux.core.client.controller.Expose;
import org.cruxframework.crux.core.client.ioc.Inject;
import org.cruxframework.crux.core.client.rest.Callback;
import org.cruxframework.crux.core.client.screen.views.BindView;
import org.cruxframework.crux.core.client.screen.views.WidgetAccessor;
import org.cruxframework.crux.widgets.client.dialog.FlatMessageBox;
import org.cruxframework.crux.widgets.client.dialog.FlatMessageBox.MessageType;
import org.cruxframework.test.cruxtestwidgets.client.modelo.Endereco;
import org.cruxframework.test.cruxtestwidgets.client.modelo.Pessoa;

import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.user.client.ui.Label;
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
				
					FlatMessageBox.show(""+result, MessageType.INFO);						
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
					FlatMessageBox.show(""+result, MessageType.INFO);	
				}

				@Override
				public void onError(Exception e) {
					
					FlatMessageBox.show("Falha ao receber o caracter ", MessageType.INFO);	
					e.printStackTrace();
					
				}
				
			});
			
		}
		
		@Expose
		public void enviarPessoa(){
			Pessoa p = getInformacoePessoa();

			service.enviarPessoa(p, new Callback<Pessoa>(){

				@Override
				public void onSuccess(Pessoa result) {				
					
					String end = "BAIRRO: "+result.getEndereco().getBairro() + " - "
								+"RUA: "+ result.getEndereco().getRua() + " - "
								+"CIDADE: "+ result.getEndereco().getCidade() + " - "
								+"NUMERO: "+ result.getEndereco().getNumero().toString();

					
					String pess = "NOME: " + result.getNome() + " - "
 								+ "IDADE: "  + result.getIdade() + " - "
 								+ "CPF: "  + result.getCpf() + " - " ;
	
					String msg = "SEUS DADOS: " + pess + end;	
					
				
					FlatMessageBox.show(msg, MessageType.INFO);	
					
				}

				@Override
				public void onError(Exception e) {
					e.printStackTrace();					
				}
				
			});
		}
		
		@Expose
		public void enviarData(){			
					 			
			 final DateTimeFormat formatter = DateTimeFormat.getFormat("dd/MM/yyyy HH:mm:ss");		
			 Date data = formatter.parse(restView.gwtTxtData().getText());		
			 restView.lbAntesDeEnviar().setText("Enviado: " + formatter.format((Date) data));
		
			service.enviarData(data, new Callback<Date>() {				
				@Override
				public void onSuccess(Date result) {	
					restView.lbResposta().setText("Recebido: "+ formatter.format((Date) result));	
				}
				@Override
				public void onError(Exception e) {
					e.printStackTrace();					
				}
			});
			
		}
		
		@Expose
		public void clear(){
			restView.gwtTxbObjetoSimples().setText("");	      	
			restView.gwtTxbNome().setText("");
			restView.gwtTxbIdade().setText("");
			restView.gwtTxbCPF().setText("");
			restView.gwtTxbRua().setText("");
			restView.gwtTxbNumero().setText("");
			restView.gwtTxbBairro().setText("");
			restView.gwtTxbCidade().setText("");		
			restView.gwtTxtData().setText("");	
			restView.lbAntesDeEnviar().setText("");
			restView.lbResposta().setText("");
		}
		
		
		private Pessoa getInformacoePessoa(){
			Pessoa p = new Pessoa();
			Endereco e = new Endereco();
			
			p.setNome(restView.gwtTxbNome().getText());
			p.setIdade(Integer.parseInt(restView.gwtTxbIdade().getText()));
			p.setCpf(restView.gwtTxbCPF().getText());
			
			e.setBairro(restView.gwtTxbBairro().getText());
			e.setCidade(restView.gwtTxbCidade().getText());
			e.setNumero(Double.parseDouble(restView.gwtTxbNumero().getText()));
			e.setRua(restView.gwtTxbRua().getText());

			p.setEndereco(e);
			return p;
		}
		
		
		
		
		@BindView("rest")
	    public static interface RestView extends WidgetAccessor{
	      	TextBox gwtTxbObjetoSimples();	      	
	      	TextBox gwtTxbNome();
	      	TextBox	gwtTxbIdade();
	      	TextBox gwtTxbCPF();
	      	TextBox gwtTxbRua();
	      	TextBox	gwtTxbNumero();
	      	TextBox	gwtTxbBairro();
	      	TextBox gwtTxbCidade();
	      	TextBox gwtTxtData();
	      	Label lbAntesDeEnviar();
	      	Label lbResposta();
	    }
	    

		
	    

}
