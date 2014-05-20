package org.cruxframework.test.cruxtestwidgets.client;

import static org.cruxframework.test.cruxtestwidgets.client.ProcedimentosMTB.*;

import java.io.File;

import org.cruxframework.test.cruxtestwidgets.foo.ProvedorDeMassa;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class MaskedTextBox {	
	
	@BeforeMethod
	@Parameters(value = { "url", "grid" })
	public void acesso(String url, String grid) throws Exception {
		SetUp.setUP(url);
		carregarElementos(grid);
	}
	
	@DataProvider(name="Masket_TextBox.csv")
	public static Object[][] DB_MaskedTextBox() {
		ProvedorDeMassa mdp = new ProvedorDeMassa();
		return mdp.getMassaDeDados("D:\\Casos de Teste\\massaDeTeste\\Masket_TextBox.csv");
	}
	
	@Test(dataProvider="Masket_TextBox.csv",description="Testa as possiveis opções de preenchimento da mascara",enabled = true)
	public void maskedTextBox(String mascara, String valor, String expected){
		atualizarMascara(mascara);
		preencherValor(valor);
		clickNaTela();
		Assert.assertEquals(pegarValorDoCampo("valor"), expected);
	}
	
}
