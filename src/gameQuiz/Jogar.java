package gameQuiz;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import javax.swing.JOptionPane;

import com.db4o.Db4o;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;

public class Jogar {

	public static String m[];
	public static ArrayList<Object> items;
	public static final int POSICAO=5;									//variável estática da quantidade de casas a serem passadas

	public void openGame() {
		ListaBd lb = new ListaBd();										//estância da classe ListaBd
		Scanner sc = new Scanner(System.in);
		Boolean confere = true;
		int armazena=1, counter = 1, i;
		String recebido = "";
		m = new String[lb.listQnt() + 1];								//array com a quantidade de questões no BD
		items = new ArrayList<Object>();								//array que imprimira na tela dos dados
		i = 1;
		lb.lista();
		while (i <= lb.listQnt()) {
			while (confere) {
				items.add(ListaBd.dados[counter]);						//armazena no array os dados no ponteiro
				if (counter < (POSICAO + armazena)) {
					counter++;
				} else {
					confere = false;
				}
			}
			System.out.printf("%d- %s\n\ta- %s\n\tb- %s\n\tc- %s\n\td- %s\n\te- %s\nDigite a sua opção: ", i,items.get(0),
					items.get(1), items.get(2), items.get(3), items.get(4), items.get(5));
			m[i] = sc.next();											//salva a resposta do usuário
			System.out.println();
			counter += 3;												//soma a quantidade de posições que deve ser pulada
			armazena = counter;											//armazena recebe o novo valor de counter
			confere = true;
			i++;
			items.clear();												//limpa os dados salvos no array
		}
		corrige();														//chama o metodo corrige	
	}

	public void corrige() {
		int counterRespostas=1, b = 7, counter=0;
		while(counter<(m.length-1)) {
			if(m[counterRespostas].equals(ListaBd.dados[b])) {
				System.out.printf("Parabéns você acertou a pergunta %d!!\n",counterRespostas);
			}else System.out.printf("Desculpe, você errou a pergunta %d. A resposta correta erra %s.\n",counterRespostas,ListaBd.dados[b]);
		counter++;
		counterRespostas++;
		b+=8;
		}
	}
}
