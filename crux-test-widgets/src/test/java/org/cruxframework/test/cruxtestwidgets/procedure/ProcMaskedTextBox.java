package org.cruxframework.test.cruxtestwidgets.procedure;


import org.cruxframework.test.cruxtestwidgets.procedure.SetUp;

import br.ufmg.dcc.saotome.beholder.ui.form.Button;
import br.ufmg.dcc.saotome.beholder.ui.form.TextField;

public  class ProcMaskedTextBox {

	 private static  TextField txtMascara;
	 private static  TextField txtValor;
	 private static  Button btnAtualizarMascara;

	
	private static  void instanciarElementos(){
		txtMascara = SetUp.BUILDER.uiComponentBuilderInstance().textFieldInstance();
		txtValor =   SetUp.BUILDER.uiComponentBuilderInstance().textFieldInstance();
		btnAtualizarMascara = SetUp.BUILDER.uiComponentBuilderInstance().buttonInstance();	
	}

	public static void carregarElementos(String pathMenuGrid){
		instanciarElementos();
		Navegacao.acessarTela(pathMenuGrid);
		txtMascara.loadById("maskedTextBox_gwtTxtBoxMask");
		txtValor.loadById("_mask_1");
		btnAtualizarMascara.loadById("maskedTextBox_btnChangeMask");	
	}
	
	
	/*
	 * Procedimentos que simulam os comportamentos do usuario na tela
	 */
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
