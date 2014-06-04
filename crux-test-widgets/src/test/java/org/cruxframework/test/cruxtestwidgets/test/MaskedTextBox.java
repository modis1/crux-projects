package org.cruxframework.test.cruxtestwidgets.test;

import static org.cruxframework.test.cruxtestwidgets.procedure.ProcMaskedTextBox.atualizarMascara;
import static org.cruxframework.test.cruxtestwidgets.procedure.ProcMaskedTextBox.carregarElementos;
import static org.cruxframework.test.cruxtestwidgets.procedure.ProcMaskedTextBox.clickNaTela;
import static org.cruxframework.test.cruxtestwidgets.procedure.ProcMaskedTextBox.pegarValorDoCampo;
import static org.cruxframework.test.cruxtestwidgets.procedure.ProcMaskedTextBox.preencherValor;



import org.cruxframework.test.cruxtestwidgets.procedure.SetUp;
import org.cruxframework.test.cruxtestwidgets.util.ProvedorDeMassa;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import br.ufmg.dcc.saotome.beholder.Browser.Alert;

public class MaskedTextBox {		
	@BeforeMethod(alwaysRun=true)
	@Parameters(value = { "url", "grid" })
	public void setUp(String url, String grid) throws Exception {
		SetUp.setUP(url);
		carregarElementos(grid);
	}
	
	
	
	// PROVIDERS
	@DataProvider(name="masked_textbox.csv")
	public static Object[][] providerMaskedTextBox() {
		ProvedorDeMassa mdp = new ProvedorDeMassa("src/main/resources/test_csv/5.1/masked_textbox/masked_textbox.csv");
		return mdp.getMassa();
	}
	
	@DataProvider(name="masked_textbox_delimitadorAlert.csv")
	public static Object[][] providerDelimitadorAlert() {
		ProvedorDeMassa mdp = new ProvedorDeMassa("src/main/resources/test_csv/5.2/masked_textbox/masked_textbox_delimitadorAlert.csv");
		return mdp.getMassa();
	}
	
	@DataProvider(name="masked_textbox_delimitadorSucess.csv")
	public static Object[][] providerDelimitadorSucess() {
		ProvedorDeMassa mdp = new ProvedorDeMassa("src/main/resources/test_csv/5.2/masked_textbox/masked_textbox_delimitadorSucess.csv");
		return mdp.getMassa();
	}
	
	@DataProvider(name="masked_textbox_caracteresInvalidos.csv")
	public static Object[][] providerCaracteresInvalidos() {
		ProvedorDeMassa mdp = new ProvedorDeMassa("src/main/resources/test_csv/5.2/masked_textbox/masked_textbox_caracteresInvalidos.csv");
		return mdp.getMassa();
	}
	

	
	// TESTES
	
	// ---- VERSÃO 5.1 -----
	//	Testa as possiveis opções de preenchimento da mascara
	@Test(dataProvider="masked_textbox.csv",enabled = true, groups =  "crux_test_5.1")
	public void P001_PrenchimentoDaMascara(String ct, String mask, String value, String expected){
		atualizarMascara(mask);
		preencherValor(value);
		clickNaTela();
		Assert.assertEquals(pegarValorDoCampo("valor"), expected);
	}
	
	
	
	// ---- VERSÃO 5.2 -----
	
	// Testa as situações em que o usuário informa o delimitador (?) de forma inadequada 
	@Test(dataProvider = "masked_textbox_delimitadorAlert.csv", enabled= true, groups = "crux_test_5.2")
	public void P002_DelimitadorInvalido(String ct,String value, String expected){
		atualizarMascara(value);
		Alert alert = SetUp.BROWSER.getAlert();
		Assert.assertEquals(alert.getText(), expected);
		alert.confirm();
	}
	
	 // Tesa os casos em que o usuario informa o delimitador (?) e a mascara deve aceitar
	@Test(dataProvider = "masked_textbox_delimitadorSucess.csv", enabled= true, groups = "crux_test_5.2")
	public void P003_DelimitadorValido(String ct,String mask, String value, String expected){
		atualizarMascara(mask);
		preencherValor(value);
		clickNaTela();
		Assert.assertEquals(pegarValorDoCampo("valor"), expected);	
	}
	
	// Testa os casos em que o usuario informa algum caracter infalido para a mascara 
	@Test(dataProvider = "masked_textbox_caracteresInvalidos.csv", enabled= true, groups = "crux_test_5.2")
	public void P004_CaracteresInvalidos(String ct, String value, String expected){
		atualizarMascara(value);
		Alert alert = SetUp.BROWSER.getAlert();
		Assert.assertEquals(alert.getText(), expected);
		alert.confirm();	
	}
}
