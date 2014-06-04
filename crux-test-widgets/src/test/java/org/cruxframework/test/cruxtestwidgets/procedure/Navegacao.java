package org.cruxframework.test.cruxtestwidgets.procedure;

import br.ufmg.dcc.saotome.beholder.ui.form.Button;

public  class Navegacao {
	
		private static Button menu;			
		
		// option é configuradado arquivo testng.xml indica qual tela estamos acessano
		public static void acessarTela(String menuOption){
			menu = SetUp.BUILDER.uiComponentBuilderInstance().buttonInstance();
			menu.loadByXPath(menuOption);
			menu.click();
		}
}
