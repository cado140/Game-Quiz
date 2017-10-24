package gameQuiz;

import java.util.Scanner;

public class Base {
	
	public static final int SAIR = 0;
	public static final int GRAVAR = 1;
	public static final int JOGAR = 2;
	public static final int LISTAR = 3;
	public static final int ALTERAR = 4;

	public static void main(String[] args) {

		GravaBd gb = new GravaBd(); 											// estânciado a classe GravaBd
		ListaBd lb = new ListaBd(); 											// estânciado a classe ListaBd
		Jogar jg = new Jogar(); 												// estânciado a classe Jogar
		AtualizaEntrada ae = new AtualizaEntrada();

		Scanner sn = new Scanner(System.in); 									// estânciado a classe para ler os dados informados pelo usuário
		Scanner scn = new Scanner(System.in);
		Scanner snn = new Scanner(System.in);
		Scanner ssnn = new Scanner(System.in);

		String respostas[] = new String[5];										// array que armazenara as respostas
		String questao,correta,numero="";
		int i=7, j = 1;
		char alternativa;
		Boolean verifica = true;

		while (verifica) {
			System.out.printf("\nDigite 0 para sair | 1 para gravar uma nova questão e suas alternativas |\n "
					+ " Digite 2 para Jogar | 3 para listar as peguntas e respostas já gravadas \nou 4 para alterar: ");
			String choose = sn.next();
			if (choose.charAt(0)=='1') i=1;
			else if (choose.charAt(0)=='2') i=2;
			else if (choose.charAt(0)=='3') i=3;
			else if (choose.charAt(0)=='4') i=4;
			else if (choose.charAt(0)=='0') i=0;
			else {
				System.out.println("Opção digitada errada.");
			}
			switch (i) {														//verifica a opção informada pelo usuário e a executa
			case SAIR:
				System.out.println("Sistema finalizado com êxito.");
				verifica = false;
				break;
			case GRAVAR:
				alternativa = 'a';
				j = lb.listQnt() + 1;
				System.out.printf("\nDigite a pergunta numero %d: ", j);
				questao = ssnn.nextLine();
				for (i = 0; i < 5; i++) {
					System.out.printf("Digite a alternativa %c: ", alternativa);
					respostas[i] = snn.nextLine();
					alternativa++;
				}
				System.out.printf("Qual é a alternativa correta: ");
				correta = scn.next();
				numero ="" + j;
				gb.grava(numero, questao, respostas[0], respostas[1], respostas[2], respostas[3], respostas[4], correta);
				break;
			case JOGAR:
				jg.openGame();
				break;
			case LISTAR:
				lb.listaExibe();
				break;
			case ALTERAR:
				ae.atualiza();
				break;
			}
		}
	} // fim do main

} // fim da classe
