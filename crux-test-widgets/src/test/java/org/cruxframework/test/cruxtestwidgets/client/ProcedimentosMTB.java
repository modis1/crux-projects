package org.cruxframework.test.cruxtestwidgets.client;


import br.ufmg.dcc.saotome.beholder.ui.Div;
import br.ufmg.dcc.saotome.beholder.ui.form.Button;
import br.ufmg.dcc.saotome.beholder.ui.form.TextField;

public class ProcedimentosMTB {
	  static  Button grid = SetUp.BUILDER.uiComponentBuilderInstance().buttonInstance();
	  static  TextField txtMascara;
	  static  TextField txtValor;
	  static  Button btnAtualizarMascara;

//	pathBtnGrid: configurado no arquivo testng.xml
	public static void buscaPadrao(String pathBtnGrid) {	
		grid.loadByXPath(pathBtnGrid);
		grid.click();		
	}
	
	public static void instanciarElementos(){
		txtMascara = SetUp.BUILDER.uiComponentBuilderInstance().textFieldInstance();
		txtValor =   SetUp.BUILDER.uiComponentBuilderInstance().textFieldInstance();
		btnAtualizarMascara = SetUp.BUILDER.uiComponentBuilderInstance().buttonInstance();	
	}
	
	public static void carregarElementos(String pathBtnGrid){
		instanciarElementos();
		buscaPadrao(pathBtnGrid);
		txtMascara.loadById("maskedTextBox_gwtTxtBoxMask");
		txtValor.loadById("_mask_1");
		btnAtualizarMascara.loadById("maskedTextBox_btnChangeMask");	
	}
	
	public static void atualizarMascara(String mascara){
		txtMascara.fill(mascara);
		btnAtualizarMascara.click();
	}
	
	public static void preencherValor(String valor){
		txtValor.fill(valor);		
	}
	
	public static String pegarValorDoCampo(String campo){
		if(campo.equals("mascara")){
			return txtMascara.getValue();
		}else if(campo.equals("valor")){
			return txtValor.getValue();
		}else 
			return null;		
	}
	
	public static void clickNaTela(){
		txtMascara.click();
	}
}
