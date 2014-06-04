package org.cruxframework.test.cruxtestwidgets.test;

import static org.cruxframework.test.cruxtestwidgets.procedure.ProcRestService.carregarElementos;
import static org.cruxframework.test.cruxtestwidgets.procedure.ProcRestService.enviarData;
import static org.cruxframework.test.cruxtestwidgets.procedure.ProcRestService.enviarObjetoSimples;
import static org.cruxframework.test.cruxtestwidgets.procedure.ProcRestService.enviarPessoa;
import static org.cruxframework.test.cruxtestwidgets.procedure.ProcRestService.getRespostaDoServidor;
import static org.cruxframework.test.cruxtestwidgets.procedure.ProcRestService.getRespostaDoServidorData;
import static org.cruxframework.test.cruxtestwidgets.procedure.ProcRestService.limparDados;

import org.cruxframework.test.cruxtestwidgets.client.modelo.Pessoa;
import org.cruxframework.test.cruxtestwidgets.dataproviders.RestProvider;
import org.cruxframework.test.cruxtestwidgets.procedure.MenuRestService;
import org.cruxframework.test.cruxtestwidgets.procedure.Navegacao;
import org.cruxframework.test.cruxtestwidgets.procedure.SetUp;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


	
public class RestService {	
	
	private Object respostaDoServidor, valorEsperado;

	
	@BeforeMethod(alwaysRun=true)
	@Parameters(value = { "url", "rest"})
	public void setUP(String url, String rest) throws Exception {
		SetUp.setUP(url);	
		Navegacao.acessarTela(rest);
		respostaDoServidor = new Object();
		valorEsperado = new Object();		
	}

	
	// PROVIDERS 
	
	@DataProvider(name="rest_objetoSimples_sucess")
	public static Object[][] restObjetoSimplesSucess() {			
		return RestProvider.restObjetoSimplesSucess();
	}	
	
	@DataProvider(name="rest_pessoa")
	public static Object[][] restPessoa(){
		return RestProvider.restPessoa();
	}
		
	@DataProvider(name="rest_data")
	public static Object[][] restData(){
		return RestProvider.restData();
	}
	
	
	
	
	// TESTES
	
	// Testa o envio de objetos simples para o servidor 
	@Test(dataProvider = "rest_objetoSimples_sucess",enabled=true, groups =  "crux_test_5.1")
	public void P001_EnviarObjetoSimples(String ct, MenuRestService menu, String valor){
		carregarElementos(menu);
		enviarObjetoSimples(valor);			
		setResultado(menu,valor);
		Assert.assertEquals(respostaDoServidor, valorEsperado);
		limparDados();		
	} 
	
	// Testa o envio de um objeto mais complexo para o servidor
	// Uma pessoa possui nome ,cpf,idade e endereço (rua, bairro, numero) 
	@Test(dataProvider = "rest_pessoa" ,enabled=true, groups =  "crux_test_5.1")
	public void P002_EnviarPessoa(String ct, Pessoa p){
		carregarElementos(MenuRestService.ENVIAR_PESSOA);	
		enviarPessoa(p);		
		
		//Isso é necessario pq a representção em string do double "0.0" quando gerado o .war se torna 0;
		String num =  Double.toString(p.getEndereco().getNumero()).replaceAll("\\.0$", "");				
		String r = "SEUS DADOS: NOME: "+p.getNome()+" - IDADE: "+p.getIdade()+
				" - CPF: "+p.getCpf()+" - BAIRRO: "+p.getEndereco().getBairro()+
				" - RUA: "+p.getEndereco().getRua()+" - CIDADE: "+p.getEndereco().getCidade()+
				" - NUMERO: "+num;
		
		// Isso é nessario pq no war string "" se torna null; 
		String respostaEsperada = r.replaceAll(":  -", ": null -");			
		Assert.assertEquals(getRespostaDoServidor(), respostaEsperada);
	}
	
	

	

	// Testa o envio de datas para o servidor 
  @Test(dataProvider = "rest_data", enabled = true, groups =  "crux_test_5.1")
  public void P003_EnviarData(String ct, String s) throws InterruptedException{	
		carregarElementos(MenuRestService.ENVIAR_DATA);			
		enviarData(s);	
		String resposta = getRespostaDoServidorData();
		Assert.assertEquals(resposta, "Recebido: " + s);			
	}



  	// Função auxiliar que realiza o cast de acordo com o tipo retornado pelo servidor 	
	private void setResultado (MenuRestService m, String valorEsperado){
	
		switch(m){
		case ENVIAR_DOUBLE : 
			this.respostaDoServidor = Double.parseDouble(getRespostaDoServidor());
			this.valorEsperado = Double.parseDouble(valorEsperado);
			break;
		case ENVIAR_INTEIRO :
			this.respostaDoServidor = Integer.parseInt(getRespostaDoServidor());
			this.valorEsperado = Integer.parseInt(valorEsperado);
			break;
			
		case ENVIAR_STRING :
			this.respostaDoServidor = getRespostaDoServidor();
			this.valorEsperado = valorEsperado;
			break;
		case ENVIAR_CHAR: 
			this.respostaDoServidor = getRespostaDoServidor();
			this.valorEsperado = valorEsperado;
			break; 	
		default :
			break;
		
		}
	}

}
