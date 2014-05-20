package org.cruxframework.test.cruxtestwidgets.client;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;



public class RestService {
	

	
	@BeforeMethod
	@Parameters(value = { "url", "rest" })
	public void acesso(String url, String rest) throws Exception {
		SetUp.setUP(url);		
		ProcedimentosRS.instanciarElementos();
		ProcedimentosRS.buscaPadrao(rest);
		ProcedimentosRS.carregarElementos();
	}
	

	@Test(enabled = false)
	public void CT001_Menu(){	
		assert SetUp.BROWSER.isTextPresent("Teste Rest");
	}
	
	
	@Test(enabled = true)
	public void CT002_InformarCampo(){
		ProcedimentosRS.preencherCampo("Guilherme");		
		Assert.assertEquals(ProcedimentosRS.getValorDoCampo(),"Guilherme" );
		
	}
	
	@Test(enabled = true)
	public void CT003_Limpar(){
		ProcedimentosRS.preencherCampo("Guilherme");
		ProcedimentosRS.limpar();
		Assert.assertEquals("", ProcedimentosRS.getValorDoCampo());		
	}
	@Test(enabled = true)
	public void CT004_Enviar(){
		ProcedimentosRS.enviar("Guilherme");		
		ProcedimentosRS.confirmarMensagem();
		Assert.assertEquals("Guilherme", ProcedimentosRS.getValorDoCampo());		
	}
	@Test(enabled = true)
	public void CT005_MensagemSucess(){
		ProcedimentosRS.enviar("Guilherme");		
		Assert.assertEquals("Hello Guilherme!", ProcedimentosRS.getMensagem());	
		
	}
	@Test(enabled = true)
	public void CT006_MensagemWarn(){
		ProcedimentosRS.enviar("");
		Assert.assertEquals("Informe um valor no campo", ProcedimentosRS.getMensagem());	
	}
	
	@Test (enabled = true)
	public void CT007_LayoutBotoes(){
		ProcedimentosRS.enviar("Guilherme");
		Assert.assertEquals("crux-Button info", ProcedimentosRS.ok.getAttribute("class"));	
		
	}
	@Test (enabled = true)
	public void CT008_LayoutBotoes(){		
		Assert.assertEquals("crux-Button", ProcedimentosRS.enviar.getAttribute("class"));
		Assert.assertEquals("crux-Button", ProcedimentosRS.limpar.getAttribute("class"));
	}
	


}
