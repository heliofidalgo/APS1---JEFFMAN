package datastructures;
 
import java.util.Scanner;
	
	public class DadosPilhas {
		
	public static void main(String[] args) {
		
		PilhaInt p1 = new PilhaInt();
		PilhaChar p2 = new PilhaChar();
		final int m = 50;
		@SuppressWarnings("resource")
		Scanner entrada = new Scanner(System.in);
		String str;
		int tipo, erro = 0;
		int [] valor = {0};
		char [] operador = {'0'};
		int v1, v2, resposta;
		System.out.println("Analisador de Expressões");
		System.out.print("Expressão: ");
		str = entrada.nextLine();
		int n = str.length();
		char [] s = new char[n];
		for (int i = 0;i < n;i++) {
			s[i] = str.charAt(i);
			}
		
			if (n > m) {
			System.out.println("ERRO: Expressão muito Longa");
		}
			else {
				if (testaExpressao(str) == true) {
					p1.criaPilha();
					p2.criaPilha();
					
			for (int i = 0;i < n;i++) {
				tipo = codifica(s[i], valor, operador);
				switch (tipo) {
				case 1: erro = p1.push(valor[0]);
				p1.exibePilha();
				break;
				case 2: erro = p2.push(operador[0]);
				p2.exibePilha();
				break;
				case 3: v2 = p1.pop();
				v1 = p1.pop();
				operador[0] = p2.pop();
				resposta = calcula(v1, v2, operador[0]);
				erro = p1.push(resposta);
				break;
		}
				}
				if (erro == 0) {
					resposta = p1.pop();
					System.out.println("Resposta: " + resposta);
				}
			}
			else {
				System.out.println("Erro: Expressão Inválida");
			}
		}
	}
// ---------------------------------------------- codificando
	static int codifica(char ch, int [] valor, char [] op) {
		int codifica = 4;
		if (ch >= '0' && ch <= '9') {
			codifica = 1;
			valor[0] = ch - 48;
		}
		if (ch == '+' || ch == '-' || ch == '*' || ch == '/') {
			codifica = 2;
			op[0] = ch;
		}
		if (ch == ')') {
			codifica = 3;
		}
		return(codifica);
	}
// -------------------------------------------- testaExpressao
	static boolean testaExpressao(String s) {
		int abre = 0,fecha = 0;
		int n = s.length();
		for (int i = 0;i < n;i++) {
			if (s.charAt(i) == '(') {
				abre++;
			}
			else {
				if (s.charAt(i) == ')') {
					fecha++;
				}
			}
		}
		if (abre == fecha) {
			return(true);
		}
		return(false);
	}
// ------------------------------------------ Calcula
	static int calcula(int v1, int v2, char op) {
		switch (op) {
		case '+': return(v1 + v2);
		case '-': return(v1 - v2);
		case '*': return(v1 * v2);
		case '/': return(v1 / v2);
		}
		return(0);
	}
}
	
	/*
	 * levei cerca de 4 dias para entender como usar o git por isso ele tem pouco commit
	 * Consegui criar as classes com a ajuda de um amigo que entende java e esta me
	 * orientado quanto a construcao das mesmas sobre
	 *  os metodos e atributos  e suas aplicacoes
	 * e me explicando a estrutura dos dados
     * e estou fazendo o trabalho sozinho sem parceiro em sala
	 * */
