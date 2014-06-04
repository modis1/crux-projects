package org.cruxframework.test.cruxtestwidgets.dataproviders;


import org.cruxframework.test.cruxtestwidgets.client.modelo.Endereco;
import org.cruxframework.test.cruxtestwidgets.client.modelo.Pessoa;
import org.cruxframework.test.cruxtestwidgets.procedure.MenuRestService;

public class RestProvider {
	
public static Object[][] restObjetoSimplesSucess() {	
		
		return new Object[][]{		
			
				{"CT001", MenuRestService.ENVIAR_INTEIRO, "1000"},
				{"CT002",MenuRestService.ENVIAR_INTEIRO, Integer.toString(Integer.MAX_VALUE)},
				{"CT003",MenuRestService.ENVIAR_INTEIRO, Integer.toString(Integer.MAX_VALUE+10)},		
				{"CT004",MenuRestService.ENVIAR_INTEIRO, Integer.toString(Integer.MIN_VALUE)},				
				{"CT005",MenuRestService.ENVIAR_DOUBLE,"2000000.6666666666666"},			
				{"CT006",MenuRestService.ENVIAR_DOUBLE,Double.toString(Double.MAX_VALUE)},	
				{"CT007",MenuRestService.ENVIAR_DOUBLE,Double.toString(Double.MIN_VALUE)},	
				{"CT008",MenuRestService.ENVIAR_STRING,"Esta é uma string gigante. %%$¨%$¨#$\\?????!!!@#!#$!#$#¨%¨¨¨#%SFGsfgz1212432."
						+ " Esta é uma string gigante. Esta é uma string gigante."},
				{"CT009",MenuRestService.ENVIAR_STRING,""},
				{"CT0010",MenuRestService.ENVIAR_CHAR, "A"},
				{"CT0011",MenuRestService.ENVIAR_CHAR, ""},		
				{"CT0012",MenuRestService.ENVIAR_CHAR, "c"},
				{"CT0013",MenuRestService.ENVIAR_CHAR, "b"},
				{"CT0014",MenuRestService.ENVIAR_CHAR, "1"},
				{"CT0015",MenuRestService.ENVIAR_CHAR, "9"},					
		};	
	}	

	
	public static Object[][] restPessoa(){
		
		return new Object[][]{
				{"CT001", new Pessoa("Guilherme", 22, "12345", new Endereco("Itabira",498.89, "Lagoinha", "Belo Horizonte"))},
				{"CT002", new Pessoa("Guilherme Natan", -33, "12345", new Endereco())},
				{"CT003", new Pessoa("", -223204, "dfadfadfadf", new Endereco("#@!#!@#",+676.23, "!@#!@#!@#", "\\230989d"))},
				{"CT004", new Pessoa()},
				{"CT005", new Pessoa("", +224, "dfadfadfadf", new Endereco("#@!#!@#",-690.0, "!@#!@#!@#", "\\230989d"))},
		};		
	}
	
	public static Object[][] restData(){
	
		return new Object[][]{		
				
				// Horario 
				{"CT001", "03/06/2014 00:00:00"},				
				{"CT002", "03/01/2014 23:59:59"},
				{"CT003", "03/01/2014 12:59:59"},
				{"CT004", "03/01/2014 01:00:01"},
				
				//Ano bissexto 
				{"CT005", "29/02/2012 00:00:00"},
				{"CT006", "29/02/1600 12:59:59"},
				{"CT007", "29/02/2000 23:59:59"},
				{"CT008", "29/02/2400 00:00:00"},
				{"CT009", "29/02/2016 00:00:00"},
							
				// Datas antigas
				{"CT010", "04/01/0001 00:00:00"},
				{"CT011", "01/01/1581 23:20:00"},
				{"CT012", "31/01/1524 23:20:00"},
				{"CT013", "28/02/1732 23:20:00"},
								
				// Datas futuras
				{"CT014", "31/01/5234 23:20:00"},
				{"CT015", "28/02/3123 23:24:50"},
				{"CT016", "31/08/2100 23:20:00"},
				{"CT017", "31/08/2300 23:20:00"},
				
		};		
		
	}

}
