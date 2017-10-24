package gameQuiz;

import com.db4o.Db4o;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;

public class ListaBd {

	public static String dados[];
	
	public void lista() {
		ObjectContainer db = Db4o.openFile("c:/teste/quiz.yap");					//selecina o e abre o BD
		try {
			Questoes qt = new Questoes(null, null, null, null, null, null, null, null);	//envia os valores em branco para gerar a string
			ObjectSet result = db.get(qt); 											//busca no BD os dados e salva na object resultado
			listResult(result); 													//chama a fun��o listResult e encaminha o resultado
		} finally {
			db.close(); 															//fecha a comunica��o com o BD
		}
	}
	public void listaAtualiza() {
		ObjectContainer db = Db4o.openFile("c:/teste/quiz.yap");					//selecina o e abre o BD
		try {
			Questoes qt = new Questoes(AtualizaEntrada.atual[0], null, null, null, null, null, null, null);	//envia os valores em branco para gerar a string
			ObjectSet result = db.get(qt); 											//busca no BD os dados e salva na object resultado
			listResult(result); 													//chama a fun��o listResult e encaminha o resultado
		} finally {
			db.close(); 															//fecha a comunica��o com o BD
		}
	}

	public static void listResult(ObjectSet result) {
		String tipo = "", recebido = "";
		int i = 0, j=0,n=1,r=6;
		while (result.hasNext()) { 													//enquanto tiver dados na variavel resultado
			tipo = tipo + result.next().toString();									//adiciona o resultado do tipo object na vari�vel string
		}
		for (i = 0; i < tipo.length(); i++) {										
			if (tipo.charAt(i) == ';') {											//verifica se a string tipo na posi��o i tem o caracter ;
				j++;
			}
		}
		dados = new String[j];												//cria um array com o n�mero de palavras existentes
		j = 0;
		for (i = 0; i < tipo.length(); i++) {
			if (tipo.charAt(i) == ';') {											//verifica se a string tipo na posi��o i tem o caracter ;
				dados[j] = recebido;												//caso tenha, adiciona os dados separados no array na posi��o j
				recebido = "";
				j++;
			} else
				recebido = recebido + tipo.charAt(i);								//enquanto n�o acha o ; adiciona os caracteres na vari�vel recebido
		}
	}

	public static int listQnt() {
		ObjectContainer db = Db4o.openFile("c:/teste/quiz.yap"); 					//selecina o e abre o BD
		try {
			Questoes qt = new Questoes(null, null, null, null, null, null, null, null);	//envia os valores em branco para gerar a string
			ObjectSet result = db.get(qt);											//busca no BD os dados e salva na object resultado
			return result.size();													//retorna a quantidade de linhas que tem
		} finally {
			db.close(); 															//fecha a comunica��o com o BD
		}
	}
	
	public void listaExibe() {
		ObjectContainer db = Db4o.openFile("c:/teste/quiz.yap");					//selecina o e abre o BD
		try {
			Questoes qt = new Questoes(null, null, null, null, null, null, null, null);	//envia os valores em branco para gerar a string
			ObjectSet result1 = db.get(qt); 											//busca no BD os dados e salva na object resultado
			listResultExibe(result1); 													//chama a fun��o listResult e encaminha o resultado
		} finally {
			db.close(); 															//fecha a comunica��o com o BD
		}
	}
	
	public static void listResultExibe(ObjectSet result1) {
		String tipo = "", recebido = "";
		int i = 0, j=0,n=0,r=8;
		while (result1.hasNext()) { 													//enquanto tiver dados na variavel resultado
			tipo = tipo + result1.next().toString();									//adiciona o resultado do tipo object na vari�vel string
		}
		for (i = 0; i < tipo.length(); i++) {										
			if (tipo.charAt(i) == ';') {											//verifica se a string tipo na posi��o i tem o caracter ;
				j++;
			}
		}
		dados = new String[j];												//cria um array com o n�mero de palavras existentes
		j = 0;
		for (i = 0; i < tipo.length(); i++) {
			if (tipo.charAt(i) == ';') {											//verifica se a string tipo na posi��o i tem o caracter ;
				dados[j] = recebido;												//caso tenha, adiciona os dados separados no array na posi��o j
				recebido = "";
				j++;
			} else
				recebido = recebido + tipo.charAt(i);								//enquanto n�o acha o ; adiciona os caracteres na vari�vel recebido
		}
		j=0;
		for (i = 0; i < result1.size(); i++) {
			for(n=n;n<j+r;n++) {													//imprime os resultados que est�o nesse intervalo
				System.out.printf("\n %s ", dados[n]);								//imprime os dados que est�o no array na posi��o n
		}
			j=n;
			System.out.println();
		}

	}
}