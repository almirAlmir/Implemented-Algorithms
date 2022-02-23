package theHuxley;
import java.util.Scanner;

public class validacaoCartao {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		
		String entradaCartao = input.next();
		
		char [] digitosCartao = entradaCartao.toCharArray();
		
		int[] digitosInteiros = new int[digitosCartao.length];

		for (int i = 0; i < digitosCartao.length; i++){
			digitosInteiros[i] = Integer.parseInt(String.valueOf(digitosCartao[i]));

		}
		
		creditcardValidation(digitosInteiros);
		
		
		input.close();
	}
	
	//Funcao que pega do penultimo digito do cartao
	//percorre de formainversa de 2 em dois multilicando por 2
	//e faz um somatorio apenas dos digitos e retorna a soma
	public static int somaMultDois(int [] digitos) {

		
		int soma = 0;
		
		for(int i = digitos.length - 2;i >= 0; i -= 2) {
			
		int aux = digitos[i];
		aux *= 2;
		
		if(aux < 10) {
			
			soma += aux;
		}else {
			
			soma += aux - 9;
		}
			
		}
		
		
		//System.out.println("Valor funcao: "+soma);
		return soma;
		
	}
	
	//funcao que retorna a soma dos digitos nao multiplicados por 2
	//que somarei ao resultado da funcao somaMultDois
	public static int somaNormal(int [] digitos) {
		
		int soma = 0;
		
		for(int i = digitos.length - 1;i >= 0; i -= 2) {
			
			int aux = digitos[i];
			
			soma += aux;
			
			
			
		}
		
		//System.out.println("Valor da funcao 2: "+ soma);
		return soma;
	}
	
	public static void creditcardValidation(int [] digitos) {
		
		int s = somaNormal(digitos) + somaMultDois(digitos);
		
		if(s % 10 == 0) {
			System.out.println("VALID");
		}else {
			System.out.println("INVALID");
		}
		
	}

}
