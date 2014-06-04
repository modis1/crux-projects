package org.cruxframework.test.cruxtestwidgets.procedure;

import java.net.MalformedURLException;
import java.net.URL;

import br.ufmg.dcc.saotome.beholder.Browser;
import br.ufmg.dcc.saotome.beholder.builder.Builder;
import br.ufmg.dcc.saotome.beholder.selenium.SeleniumController;

/**
 * Antes dos testes executarem esta classe realiza algumas configuracoes iniciais 
 * @author guilherme.alecrim
 *
 */
public class SetUp {	
		
	  // Para realizar algumas operações no browser,  como por exemplo abrir ou pegar um alert 
	   public static Browser BROWSER; 
	   // Para pegar instâcias dos elementos na tela	   
	   public static Builder BUILDER;	   
	   // Url do sistema, será informada na configuração do arquivo testng.xml
	   public static String Url; 	

	   public static  void setUP(final String url) throws MalformedURLException{	
		   		// instancia o browser, por default o browser usado é o firefox
			   SetUp.BROWSER = SeleniumController.getBrowser();
			   // A variavel BUILDER é usada para fornecer diversas instâncias dos 
			   //elementos que estão na tela do usuario
			   SetUp.BUILDER = SeleniumController.getBuilder();
     		   SetUp.Url = url;  
     		   // Abre o firefox com a url informada no arquivo testng.xml
			   SetUp.BROWSER.open(new URL(Url));
		   }
	
	
}