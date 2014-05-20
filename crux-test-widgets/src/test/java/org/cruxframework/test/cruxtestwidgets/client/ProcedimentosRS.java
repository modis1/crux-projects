package org.cruxframework.test.cruxtestwidgets.client;

import br.ufmg.dcc.saotome.beholder.ui.Div;
import br.ufmg.dcc.saotome.beholder.ui.form.Button;
import br.ufmg.dcc.saotome.beholder.ui.form.TextArea;
import br.ufmg.dcc.saotome.beholder.ui.form.TextField;

public class ProcedimentosRS {
	static  Button rest;
	static Button enviar;
	static Button limpar;
	static Button ok;
	static TextField txtInput;
	static Div mensagem;
	
	public static void instanciarElementos(){
		 rest = SetUp.BUILDER.uiComponentBuilderInstance().buttonInstance();
		 txtInput = SetUp.BUILDER.uiComponentBuilderInstance().textFieldInstance();
		 enviar  = SetUp.BUILDER.uiComponentBuilderInstance().buttonInstance();
		 limpar = SetUp.BUILDER.uiComponentBuilderInstance().buttonInstance();
		 ok  = SetUp.BUILDER.uiComponentBuilderInstance().buttonInstance();	
		 mensagem =  SetUp.BUILDER.uiComponentBuilderInstance().divInterface();
	}
//	pathBtnRest : configurado no arquivo testng.xml
	public static void buscaPadrao(String pathBtnRest){
		rest.loadByXPath(pathBtnRest);
		rest.click();
	}

	public static void carregarElementos(){
		txtInput.loadByXPath("/html/body/div[2]/div/div/center/div/div/table/tbody/tr/td[2]/input");
		enviar.loadByXPath("/html/body/div[2]/div/div/center/div/div/table/tbody/tr[2]/td/button");
		limpar.loadByXPath("/html/body/div[2]/div/div/center/div/div/table/tbody/tr[3]/td/button");
	}
	
	public static void preencherCampo(String value){
		txtInput.fill(value);
		
	}
	
	public static void enviar(String value){		
		preencherCampo(value);
		enviar.click();
		ok.loadByXPath("/html/body/div[4]/div/div/div[2]/div/button");
	}
	
	public static String getMensagem(){
		mensagem.loadByXPath("/html/body/div[4]/div/div/div[2]/div/div");
		return mensagem.getText();
	}
	
	public static String getValorDoCampo(){
		return txtInput.getValue();
	}
	
	public static void limpar(){
		limpar.click();
	}
	
	public static void confirmarMensagem(){
		ok.loadByXPath("/html/body/div[4]/div/div/div[2]/div/button");
		ok.click();
	}

}
