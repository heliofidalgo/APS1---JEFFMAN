
package reversa;

// -------------------------------------------------- Fonte: PolonesaReversa.java

import java.util.Scanner;
	public class PolonesaReversa {
// ............................................. lista de atributos da classe
		private double x, y, resp = 0;
		private char op;
		private int erro;
// ............................................. m�todos p�blicos da classe
		public PolonesaReversa () { // construtor
			erro = 0;
		}
		public void calculaPolonesaReversa() {
			Scanner entrada = new Scanner(System.in);
			String s;
			System.out.println("Polonesa Reversa: <enter> abandonar");
			do {

				if (resp == 0) {
					s = entrada.nextLine();
					if (s.equals("")) {
						System.out.println("by Polonesa Reversa");
						System.exit(0);
					}
					x = Double.parseDouble(s);
				}
				else {
					x = resp;
				}
				s = entrada.nextLine();
				if (s.equals("")) {
					System.out.println("by Polonesa Reversa");
					System.exit(0);
				}
				y = Double.parseDouble(s);
				do {
					s = entrada.nextLine();
					if (s.equals("")) {
						System.out.println("by Polonesa Reversa");
						System.exit(0);
					}
					op = s.charAt(0);
				} while (!strChr("+-*/Pp", op));
				operaCalculadora();
				exibeCalculadora();
			} while (!s.equals(""));
		}
// ---------------------------- operaCalculadora
		private void operaCalculadora() {
			switch (op)
			{
			case '+': resp = soma(x, y);
			break;
			case '-': resp = subtracao(x, y);
			break;
			case '*': resp = multiplicacao(x, y);
			break;
			case '/': if (y == 0)
				erro = 1; // divis�o por zero
			else
				resp = divisao(x, y);
			break;
			case 'P':
			case 'p': resp = power(x, y); // pot�ncia
			break;
			}
		}
// ---------------------------- exibeCalculadora
		private void exibeCalculadora() {
			switch (erro) {
			case 1: System.out.println("Erro: Divis�o por Zero");
			break;
			case 2: System.out.println("Erro: Raiz Complexa");
			break;
			case 3: System.out.println("Erro: Tangente Inv�lida");
			break;
			default: System.out.println(resp);
			}
		}
// ................................................ m�todos privados da classe

//---------------------------- strChr
		private boolean strChr(String s, char ch) {
			for (int i = 0; i < s.length(); i++) {
				if (s.charAt(i) == ch) {
					return(true);
				}
			}
	return(false);
		}
//---------------------------- soma
		private double soma(double x, double y) {
			return(x + y);
		}
//---------------------------- subtra��o
		private double subtracao(double x, double y) {
			return(x - y);
		}
//---------------------------- multiplica��o
		private double multiplicacao(double x, double y) {
			return(x * y);
		}
//---------------------------- divis�o
		private double divisao(double x, double y) {
			if (y == 0) {
				erro = 1;
	return(-1);
			}
			return(x / y);
		}
//---------------------------- power
		private double power(double x, double y) {
			return(Math.pow(x, y));
		}
}