package org.cruxframework.test.cruxtestwidgets.procedure;



import org.cruxframework.test.cruxtestwidgets.client.modelo.Pessoa;
import org.cruxframework.test.cruxtestwidgets.telas.TelaRest;


public class ProcRestService {
	

	private static TelaRest telaRest;	
	
	public static void carregarElementos( MenuRestService botao){	
		telaRest  = new TelaRest();	  
		telaRest.loadyByMenu(botao);
		telaRest.loadyByCampos();		
	}
	
	public static String getRespostaDoServidor(){	
		telaRest.loadyByResposta();						
		return telaRest.getDivResposta().getText();
	}
	
	public static String getRespostaDoServidorData() throws InterruptedException{
		telaRest.loadyByRespostaData();
		return telaRest.getDivResposta().getText();
	}

	public static void limparDados(){
		telaRest.loadyByMenu(MenuRestService.LIMPAR_DADOS);
		telaRest.getBtnOptionMenu().click();	
		}
	
	
	
	public static void enviarObjetoSimples(String valor){
		telaRest.getTfObjetoSimples().fill(valor);
		telaRest.getBtnOptionMenu().click();	
	}
	

	public static void enviarPessoa(Pessoa p){			
		telaRest.getTfNome().fill(p.getNome());
		telaRest.getTfIdade().fill(Integer.toString(p.getIdade()));
		telaRest.getTfBairro().fill(p.getEndereco().getBairro());
		telaRest.getTfCidade().fill(p.getEndereco().getCidade());
		telaRest.getTfRua().fill(p.getEndereco().getRua());
		telaRest.getTfNumero().fill(Double.toString(p.getEndereco().getNumero()));
		telaRest.getTfCPF().fill(p.getCpf());
		telaRest.getBtnOptionMenu().click();	
	}
	
	public static void enviarData(String data) throws InterruptedException{			 
		telaRest.getTfData().fill(data);
		telaRest.getBtnOptionMenu().click();	
		while (!SetUp.BROWSER.isTextPresent("Recebido: ")){
			SetUp.BROWSER.wait();
		}
	}
	
	
}
