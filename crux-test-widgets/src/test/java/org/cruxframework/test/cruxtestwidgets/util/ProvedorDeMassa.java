package org.cruxframework.test.cruxtestwidgets.util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Esta classe permite efetuar a leitura de um arquivo em csv, 
 * contendo a massa de dados para algum teste. 
 * Assume-se que cada linha do arquivo que represente um caso de teste 
 * inicia-se com CT e também que o caracter $ no arquivo representa uma string vazia
 *   
 * @author guilherme.alecrim
 *
 */

public class ProvedorDeMassa {	
	private int campos = 0;
	private int testes = 0 ;
	private Object [][]massa; 
	private String pathArquivo;

	public ProvedorDeMassa(String pathArquivo) {
		this.pathArquivo =pathArquivo;
		lerArquivoDeMassa(true);
	}
	
	
	public ProvedorDeMassa(String pathArquivo, int campos, int testes) {
		this.pathArquivo =pathArquivo;
		this.campos = campos;		
		this.testes = testes;
		massa = new Object [testes][campos];
		lerArquivoDeMassa(false);
	}
	
	
	/**
	 *  Ler um aquivo de  massa de dados, o aquivo pode 
	 *  ser parametrizado com a quantidade de testes (Linhas que se iniciam com CT)  
	 *  e a quantidade de campos que será preenchido em cada teste  
	 * @param parametrizado: Caso o arquivo seja configurado internamente com a quantidade de campos e testes usa-se true
	 * e false caso os parametros seja passado pelo construtor ProvedorDeMassa(String pathArquivo, int colunas, int testes)
	 * 
	 */
	
	private void lerArquivoDeMassa(boolean parametrizado) {
		try {		
			BufferedReader in = new BufferedReader(new FileReader(pathArquivo));
			String str;
			int linha = 0;			
			while (in.ready()) {
				str = in.readLine();
				if(parametrizado)
					setParametros(str);
				if(str.contains("CT")){
					for (int i = 0; i < campos; i++) {						
						massa[linha][i] = processLinha(str, i);
					}
		
					linha++;
				}		
			}
			in.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	
	

	private void setParametros(String str){
		if (str.matches("^parametros(.*)")){			
			String[] s = str.split(";");	
			this.campos =Integer.parseInt(s[2]);
			this.testes = Integer.parseInt(s[4]);
			massa = new Object[testes][campos];	
		}			
	
	}

	
	private String processLinha(String linha, int palavra) {
		String[] s = linha.split(";");
		if(s[palavra].equals("$")){
			s[palavra] = "";
		}
		return s[palavra];
	}
	public Object[][] getMassa() {
		return massa;
	}
	
}
