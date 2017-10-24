package gameQuiz;

import java.util.Scanner;

public class AtualizaEntrada {

	public static String atual[];
	public static final int PERGUNTA = 1;
	public static final int ALTERNATIVA = 2;
	public static final int RESPOSTA = 3;
	public static final char A = 'a';
	public static final char B = 'b';
	public static final char C = 'c';
	public static final char D = 'd';
	public static final char E = 'e';

	public void atualiza() {
		AtualizaDados ad = new AtualizaDados();
		ListaBd lb = new ListaBd();
		atual = new String[8];
		String questao="";
		int escolha,i=0;
		boolean verifica = true, verifica1 = true;
		Scanner sc = new Scanner(System.in);
		Scanner scn = new Scanner(System.in);
		Scanner snn = new Scanner(System.in);
		System.out.printf("Digite o número da pergunta a ser alterada: ");
		questao = sc.next();
		atual[0] = ""+questao;
		lb.lista();
		while(verifica) {
			for(i=0;i<ListaBd.dados.length;i++) {
				if(questao.equals(ListaBd.dados[i])) {
					atual[1]=ListaBd.dados[i+1];
					atual[2]=ListaBd.dados[i+2];
					atual[3]=ListaBd.dados[i+3];
					atual[4]=ListaBd.dados[i+4];
					atual[5]=ListaBd.dados[i+5];
					atual[6]=ListaBd.dados[i+6];
					atual[7]=ListaBd.dados[i+7];
					verifica=false;
					break;
				}
			}
		}
		verifica = true;
		System.out.println();
		while (verifica) {
			System.out.printf(
					"Digite 1 para alterar a pergunta, 2 para alterar as alternativas ou \n"
					+ "3 para alterar a resposta ou 0 para sair: ");
			escolha = sc.nextInt();
			System.out.println();
			switch (escolha) {
			case PERGUNTA:
				System.out.println("Atual: "+atual[1]);
				System.out.printf("Digite a nova pergunta: ");
				atual[1] = scn.nextLine();
				break;
			case ALTERNATIVA:
				String alter="";
				while (verifica1) {
					alter = "";
					System.out.printf("Quais das alternativas deseja mudar(a-b-c-d-e) ou s para sair: ");
					alter = snn.next();
					switch (alter.charAt(0)) {
					case A:
						System.out.println("Atual: "+atual[2]);
						System.out.printf("Digite a nova alternativa a: ");
						atual[2] = scn.nextLine();
						break;
					case B:
						System.out.println("Atual: "+atual[3]);
						System.out.printf("Digite a nova alternativa b: ");
						atual[3] = scn.nextLine();
						break;
					case C:
						System.out.println("Atual: "+atual[4]);
						System.out.printf("Digite a nova alternativa c: ");
						atual[4] = scn.nextLine();
						break;
					case D:
						System.out.println("Atual: "+atual[5]);
						System.out.printf("Digite a nova alternativa d: ");
						atual[5] = scn.nextLine();
						break;
					case E:
						System.out.println("Atual: "+atual[6]);
						System.out.printf("Digite a nova alternativa e: ");
						atual[6] = scn.nextLine();
						break;
					default:
						verifica1 = false;
						break;
					}
				}
				break;
			case RESPOSTA:
				System.out.println("Atual: "+atual[7]);
				System.out.printf("Digite a letra da resposta correta: ");
				atual[7] = sc.next();
				break;
			default:
				verifica = false;
				break;
				
		}
		ad.atualiza();
	}
  }
}
