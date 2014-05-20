package org.cruxframework.test.cruxtestwidgets.foo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


public class ProvedorDeMassa {	
	private int entradas = 0;
	private int testes = 0 ;
	private Object [][]massa; 
	

	public Object [][] getMassaDeDados(String arquivo){
		lerArquivo(arquivo);
		return massa;
	}
	
	private void lerArquivo(String arquivo) {
		try {
			BufferedReader in = new BufferedReader(new FileReader(arquivo));
			String str;
			int linha = 0;
			in.ready();
			getParametros(in.readLine());
			massa = new Object[testes][entradas];
			while (in.ready()) {
				str = in.readLine();
				for (int i = 0; i < entradas; i++) {
					massa[linha][i] = processLinha(str, i);
				}
				linha++;
			}
			in.close();
		} catch (IOException e) {
		}
	}
	
	
	private void getParametros(String str) {
		String[] s = str.split(";");
		String[] v = null;
		v = s[0].split(" ");
		this.entradas = Integer.parseInt(v[1]);
		v = s[1].split(" ");
		this.testes = Integer.parseInt(v[1]);
	}

	private String processLinha(String linha, int palavra) {
		String[] s = linha.split(";");
		if(s[palavra].equals("$")){
			s[palavra] = "";
		}
		return s[palavra];
	}
	
}
