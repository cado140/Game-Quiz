package gameQuiz;

import com.db4o.Db4o;
import com.db4o.ObjectContainer;

public class GravaBd {

	public static void grava(String numero, String questao, String resposta1, String resposta2, String resposta3,
			String resposta4, String resposta5, String correta) {								//recebe os valores que o usuário informou
		ObjectContainer db = Db4o.openFile("c:/teste/quiz.yap"); 							//selecina o e abre o BD

		try {
			if((!numero.isEmpty())&&(!questao.isEmpty())&&(!resposta1.isEmpty())&&(!resposta2.isEmpty())&&
					(!resposta3.isEmpty())&&(!resposta4.isEmpty())&&(!resposta5.isEmpty())&&(!correta.isEmpty())) { 
																			//cria a string com os dados para poder gravar no BD
			Questoes qt = new Questoes(numero, questao, resposta1, resposta2, resposta3, resposta4, resposta5, correta); 
			db.set(qt); 													//envia para o BD os dados 	
			}else if((!numero.isEmpty())&&(!questao.isEmpty())&&(!resposta1.isEmpty())&&(!resposta2.isEmpty())&&
			(!resposta3.isEmpty())&&(!resposta4.isEmpty())&&(!resposta5.isEmpty())){
				Questoes qt = new Questoes(numero, questao, resposta1, resposta2, resposta3, resposta4, resposta5, "a"); 
				db.set(qt); 
			}else if((!numero.isEmpty())&&(!questao.isEmpty())&&(!resposta1.isEmpty())&&(!resposta2.isEmpty())&&
			(!resposta3.isEmpty())&&(!resposta4.isEmpty())&&(!correta.isEmpty())){
				Questoes qt = new Questoes(numero, questao, resposta1, resposta2, resposta3, resposta4, "a", correta); 
				db.set(qt); 
			}else if((!numero.isEmpty())&&(!questao.isEmpty())&&(!resposta1.isEmpty())&&(!resposta2.isEmpty())&&
			(!resposta3.isEmpty())&&(!correta.isEmpty())&&(!resposta5.isEmpty())){
				Questoes qt = new Questoes(numero, questao, resposta1, resposta2, resposta3, "a", resposta5, correta); 
				db.set(qt); 
			}else if((!numero.isEmpty())&&(!questao.isEmpty())&&(!resposta1.isEmpty())&&(!resposta2.isEmpty())&&
			(!correta.isEmpty())&&(!resposta4.isEmpty())&&(!resposta5.isEmpty())){
				Questoes qt = new Questoes(numero, questao, resposta1, resposta2, "a", resposta4, resposta5, correta); 
				db.set(qt); 
			}else if((!numero.isEmpty())&&(!questao.isEmpty())&&(!resposta1.isEmpty())&&(!resposta3.isEmpty())&&
			(!correta.isEmpty())&&(!resposta4.isEmpty())&&(!resposta5.isEmpty())){
				Questoes qt = new Questoes(numero, questao, resposta1, "a", resposta3, resposta4, resposta5, correta); 
				db.set(qt); 
			}else if((!numero.isEmpty())&&(!questao.isEmpty())&&(!resposta3.isEmpty())&&(!resposta2.isEmpty())&&
			(!correta.isEmpty())&&(!resposta4.isEmpty())&&(!resposta5.isEmpty())){
				Questoes qt = new Questoes(numero, questao, "a", resposta2, resposta3, resposta4, resposta5, correta); 
				db.set(qt); 
			}else if((!numero.isEmpty())&&(!resposta3.isEmpty())&&(!resposta1.isEmpty())&&(!resposta2.isEmpty())&&
			(!correta.isEmpty())&&(!resposta4.isEmpty())&&(!resposta5.isEmpty())){
				Questoes qt = new Questoes(numero, "a", resposta1, resposta2, resposta3, resposta4, resposta5, correta); 
				db.set(qt); 
			}else System.out.println("Impossivel gravar os dados.");
		} finally {
			db.close(); 																	//fecha a comunicação com o BD
		}
	}

}
