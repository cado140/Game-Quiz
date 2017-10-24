package gameQuiz;

import com.db4o.Db4o;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;

public class AtualizaDados {

	public void atualiza() {
		ObjectContainer db = Db4o.openFile("c:/teste/quiz.yap");
		try {
			Questoes qt = new Questoes(AtualizaEntrada.atual[0], null,null,null,null,null,null,null);
			ObjectSet result = db.get(qt);
			qt = (Questoes) result.next();
			qt.setNumero(AtualizaEntrada.atual[0]);
			qt.setQuestao(AtualizaEntrada.atual[1]);
			qt.setResposta1(AtualizaEntrada.atual[2]);
			qt.setResposta2(AtualizaEntrada.atual[3]);
			qt.setResposta3(AtualizaEntrada.atual[4]); 
			qt.setResposta4(AtualizaEntrada.atual[5]);
			qt.setResposta5(AtualizaEntrada.atual[6]);
			qt.setCorreta(AtualizaEntrada.atual[7]);
			db.set(qt);
			
		} finally {
			db.close();
		}
		
		/*
		
			Cliente proto = new Cliente(codigo, null);
			
			proto =(Cliente) result.next();
			proto.setNome(nome);
			db.set(proto);
			System.out.println("Dados atualizado com sucesso!! ");
		
		ld.list();*/
	}

}
