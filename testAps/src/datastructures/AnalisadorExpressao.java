package datastructures;

import java.util.Stack;
import java.util.Scanner;
	
	public class AnalisadorExpressao {
		public static void main(String[] args) {
			Stack numeros = new Stack();
			Stack operadores = new Stack();
			Scanner entrada = new Scanner(System.in);
			String s;
			float resp = 0;
			System.out.print("Expressao: ");
			s = entrada.nextLine();
			int n = s.length();
			if (testaExpressao(s)) {
				for (int i = 0;i < n;i++) {
					if (s.charAt(i) == '(') {
						continue;
					}
					if ("0123456789".indexOf(s.charAt(i)) != -1) {
						char ch = s.charAt(i);
						float t = (float) ch - 48;
						numeros.push(t);
						exibePilha(numeros);
						exibePilha(operadores);
						System.out.println();
					}
					else {
						if ("+-*/".indexOf(s.charAt(i)) != -1) {
							char op = s.charAt(i);
							operadores.push(op);
						}
					}
					if (s.charAt(i) == ')') {
						Object nodo = numeros.pop();
						String st = nodo.toString();
						float y = Float.parseFloat(st);
						nodo = numeros.pop();
						st = nodo.toString();
						float x = Float.parseFloat(st);
						nodo = operadores.pop();
						String temp = nodo.toString();
						char op = temp.charAt(0);
						resp = calculaOperacao(x, y, op);
						numeros.push(resp);
						exibePilha(numeros);
						exibePilha(operadores);
					}
				}
				System.out.println();
					if (operadores.empty()) {
						Object nodo = numeros.pop();
						String st = nodo.toString();
						resp = Float.parseFloat(st);
					}
					else {
						resp = 0;
						while (!operadores.empty()) {
							Object nodo = numeros.pop();
							String st = nodo.toString();
							float y = Float.parseFloat(st);
							nodo = numeros.pop();
							st = nodo.toString();
							float x = Float.parseFloat(st);
							nodo = operadores.pop();
							String temp = nodo.toString();
							char op = temp.charAt(0);
							resp = calculaOperacao(x, y, op);
							numeros.push(resp);
							exibePilha(numeros);
							exibePilha(operadores);
						}
					}
					System.out.println("Resposta: " + resp);
			}
			else {
				System.out.println("Erro: Expressao Invalida");
			}
			System.exit(0);
		}
// ---------------------------------------- calculaOperacao
		static float calculaOperacao(float x, float y, char op) {
			float resp = 0;
			switch (op) {
			case '+': resp = x + y;
			break;
			case '-': resp = x - y;
			break;
			case '*': resp = x * y;
			break;
			case '/': if (y != 0) {
				resp = x / y;
			}
			else {
				System.out.println("Erro Fatal: Divisão por Zero");
				System.exit(0);
			}
			break;
			}
			return(resp);
		}
// ---------------------------------------- testaExpressao
		static boolean testaExpressao(String exp) {
			int abre = 0, fecha = 0;
			for (int i = 0;i < exp.length();i++) {
				if (exp.charAt(i) == '(') {
					abre++;
				}
				if (exp.charAt(i) == ')') {
					fecha++;
				}
			}
			if (abre == fecha) {
				return(true);
			}
			else
				return(false);
		}
// ---------------------------------------- exibePilha
		static void exibePilha(Stack pilha) {
			Object [] nodo = pilha.toArray();
			System.out.print("Pilha: ");
			for (int i = 0;i < nodo.length;i++) {
				System.out.print(nodo[i] + " ");
			}
			System.out.println();
		}
	}
