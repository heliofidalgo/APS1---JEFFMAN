package datastructures;

 	public class PilhaInt {
 		final int m = 50;
 		final int SUCESSO = 0;
 		final int PILHA_CHEIA = 1;
 		final int PILHA_VAZIA = 2;
 		int topo;
 		int [] elem = new int[m];
// ---------------------------------------------- criaPilha
 		public void criaPilha() {
 			topo = -1;
}
// ---------------------------------------------- push
 		public int push(int dado) {
 			if (topo == m - 1) {
 				return(PILHA_CHEIA);
 			}
 			else {
 				topo++;
 				elem[topo] = dado;
 				return(SUCESSO);
 			}
 		}
// ---------------------------------------------- pop
 		public int pop() {
 			if (topo != -1) {
	topo--;
	return(elem[topo + 1]);
 			}
	return(0);
	}
// ---------------------------------------------- exibePilha
 		public void exibePilha() {
 			if (topo != -1) {
 				System.out.print("PilhaInt: ");
 				for (int i = topo;i >= 0;i--) {
 					System.out.print(elem[i] + " ");
 				}
 				System.out.println();
 			}
 		}
 	}
