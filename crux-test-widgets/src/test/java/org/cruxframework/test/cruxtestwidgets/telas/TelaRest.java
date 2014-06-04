package org.cruxframework.test.cruxtestwidgets.telas;

import org.cruxframework.test.cruxtestwidgets.procedure.MenuRestService;
import org.cruxframework.test.cruxtestwidgets.procedure.SetUp;

import br.ufmg.dcc.saotome.beholder.ui.Div;
import br.ufmg.dcc.saotome.beholder.ui.form.Button;
import br.ufmg.dcc.saotome.beholder.ui.form.TextField;

public class TelaRest {
	


	private TextField tfNome;
	private TextField tfIdade;
	private TextField tfCPF;
	private TextField tfRua;
	private TextField tfNumero;
	private TextField tfBairro;
	private TextField tfCidade;
	private TextField tfData;	
	private TextField tfObjetoSimples;
	private Div divResposta;
	private Button btnOptionMenu;
	
	
	public  TelaRest() {
		tfNome = SetUp.BUILDER.uiComponentBuilderInstance().textFieldInstance();
		tfIdade = SetUp.BUILDER.uiComponentBuilderInstance().textFieldInstance();
		tfCPF = SetUp.BUILDER.uiComponentBuilderInstance().textFieldInstance();
		tfRua = SetUp.BUILDER.uiComponentBuilderInstance().textFieldInstance();
		tfNumero = SetUp.BUILDER.uiComponentBuilderInstance().textFieldInstance();
		tfBairro = SetUp.BUILDER.uiComponentBuilderInstance().textFieldInstance();
		tfCidade = SetUp.BUILDER.uiComponentBuilderInstance().textFieldInstance();
		tfData  = SetUp.BUILDER.uiComponentBuilderInstance().textFieldInstance();
		tfObjetoSimples= SetUp.BUILDER.uiComponentBuilderInstance().textFieldInstance();
		divResposta = SetUp.BUILDER.uiComponentBuilderInstance().divInterface();
		btnOptionMenu= SetUp.BUILDER.uiComponentBuilderInstance().buttonInstance();
	}
	
	
	public void loadyByCampos(){
		tfNome.loadById("rest_gwtTxbNome");
		tfIdade.loadById("rest_gwtTxbIdade");
		tfCPF.loadById("rest_gwtTxbCPF");
		tfRua.loadById("rest_gwtTxbRua");
		tfNumero.loadById("rest_gwtTxbNumero");
		tfBairro.loadById("rest_gwtTxbBairro");
		tfCidade.loadById("rest_gwtTxbCidade");
		tfData.loadById("rest_gwtTxtData");
		tfObjetoSimples.loadById("rest_gwtTxbObjetoSimples");
	}


	public void loadyByResposta(){
		divResposta.loadByXPath("/html/body/div[4]/div/div/div[2]/div/div");
		
	}
	public void loadyByRespostaData() {		
		divResposta.loadById("rest_lbResposta");		
	}
	
	public void loadyByMenu(MenuRestService botao){
		switch (botao) {
		case ENVIAR_INTEIRO: btnOptionMenu.loadById("rest_btnInteiro");			
			break;
		case ENVIAR_STRING: btnOptionMenu.loadById("rest_btnString");
			break;
		case ENVIAR_DOUBLE :btnOptionMenu.loadById("rest_btnDouble");
			break;
		case ENVIAR_CHAR: btnOptionMenu.loadById("rest_btnChar");
			break;
		case ENVIAR_DATA: btnOptionMenu.loadById("rest_btnData");
			break;
		case ENVIAR_PESSOA: btnOptionMenu.loadById("rest_btnPessoa");		
			break;		
		case LIMPAR_DADOS:btnOptionMenu.loadById("rest_btnLimpar");
			break;
		default:
			break;
		}
	}
	
	public TextField getTfNome() {
		return tfNome;
	}


	public TextField getTfIdade() {
		return tfIdade;
	}


	public TextField getTfCPF() {
		return tfCPF;
	}


	public TextField getTfRua() {
		return tfRua;
	}


	public TextField getTfNumero() {
		return tfNumero;
	}


	public TextField getTfBairro() {
		return tfBairro;
	}


	public TextField getTfCidade() {
		return tfCidade;
	}


	public TextField getTfData() {
		return tfData;
	}


	public TextField getTfObjetoSimples() {
		return tfObjetoSimples;
	}


	public Div getDivResposta() {
		return divResposta;
	}


	public Button getBtnOptionMenu() {
		return btnOptionMenu;
	}


}
