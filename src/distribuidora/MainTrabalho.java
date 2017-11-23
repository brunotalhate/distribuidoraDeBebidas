package distribuidora;
import java.util.Scanner;

import dados.Item;

public class MainTrabalho {
	static Scanner scan = new Scanner(System.in);
	public static void main(String[] args) {
		
		
		
		Arvore arvore = new Arvore();
		
		
		Item novoItem1 = new Item(1, "Coca-Cola 600ml", "Coca-Cola", (float) 5.00, 8);
		Item novoItem2 = new Item(2, "Coca-Cola 1500ml", "Coca-Cola", (float) 5.59, 49);
		Item novoItem3 = new Item(3, "super-skol", "Ambev", (float) 26.00, 158);
        arvore.inserir(novoItem1);
        arvore.inserir(novoItem2);
        arvore.inserir(novoItem3);
		
		
		int valor, i;
		float valorF;
		String valorS;
		Item [] vetor= new Item[10];		
		char opcao, opcao2;
		do {
			
			opcao = menuPrincipal();
			
			switch (opcao) {
			case '1':
				do {
					
					opcao2 = menuEscolher();
					
					switch (opcao2) {
					case '1':
						System.out.println("Digite um Codigo de Barra:\n");
						valor = scan.nextInt();												
						vetor[0] = arvore.pesquisarCodeBar (valor);
						if(vetor[0] != null) {
							imprimirItem(vetor, 0);
						}else {
							System.out.println("Codigo de Barra não presente ou digitado incorretamente!\n");
						}						
						break;

					case '2':
						System.out.println("Digite o nome do produto:\n");
						valorS = scan.next();						
						vetor[0] = arvore.pesquisarNome(valorS);
						if(vetor[0] != null) {
							imprimirItem(vetor, 0);
						}else {
							System.out.println("Nome do Produto não presente ou digitado incorretamente!\n");
						}	
						break;

					case '3':
						System.out.println("Digite o nome do fabricante:\n");
						valorS = scan.next();
						vetor = arvore.pesquisarFabricante(valorS);
						i = 0;
						if(vetor[0] != null) {
							while(vetor[i] != null){
								imprimirItem(vetor, i);
								i++;
							}
						}else {
							System.out.println("Fabricante não presente ou digitado incorretamente!\n");
						}						
						break;

					case '4':
						System.out.println("Digite o Preco:\n");
						valorF = scan.nextFloat();
						vetor = arvore.pesquisarValor(valorF);
						i = 0;
						if(vetor[0] != null) {
							while(vetor[i] != null){
								imprimirItem(vetor, i);
								i++;
							}
						}else {
							System.out.println("Preço não presente ou digitado incorretamente!\n");
						}
						break;

					case '5':
						System.out.println("Digite o Estoque:\n");
						valor = scan.nextInt();
						vetor = arvore.pesquisarEstoque(valor);
						i = 0;
						if(vetor[0] != null) {
							while(vetor[i] != null){
								imprimirItem(vetor, i);
								i++;
							}
						}else {
							System.out.println("Estoque não presente ou digitado incorretamente!\n");
						}
						break;
						
					}
				}while (opcao2 != '0');
				break;
				
			 case '2':
				 // inserir item
                 String fabric;
                 int estoq;
                 
                 System.out.println("\nDigite o codigo de barras:");
                 valor = scan.nextInt();
                 scan.nextLine(); // Limpando Buffer
                 System.out.println("\nDigite o nome do produto:");
                 valorS = scan.nextLine();
                 System.out.println("\nDigite o nome do fabricante:");
                 fabric = scan.nextLine();
                 System.out.println("\nDigite o valor do produto:");
                 valorF = scan.nextFloat();
                 System.out.println("\nDigite o quantidade em estoque do produto:");
                 estoq = scan.nextInt();
                 scan.nextLine(); // Limpando Buffer
                 Item novoItem = new Item(valor, valorS, fabric, valorF, estoq);
                 arvore.inserir(novoItem);
                 System.out.println("\nProduto inserido com sucesso.\n");
                 break;
                 
			 case '3':
				 do {
					 opcao2 = menuEscolher();
					
					 switch (opcao2) {
						case '1':
							System.out.println("Digite um Codigo de Barra:\n");
							valor = scan.nextInt();		
							if(arvore.removerCodeBar(valor)) {
								System.out.println("Remoção feita com sucesso!");
							}else {
								System.out.println("Erro na remoção!");
							}
							break;

						case '2':
							System.out.println("Digite o nome do produto:\n");
							valorS = scan.next();						
							vetor[0] = arvore.pesquisarNome(valorS);
							if(arvore.removerNome(valorS)) {
								System.out.println("Remoção feita com sucesso!");
							}else {
								System.out.println("Erro na remoção!");
							}
							break;

						case '3':
							System.out.println("Digite o nome do fabricante:\n");
							valorS = scan.next();
							if(arvore.removerFabricante(valorS)) {
								System.out.println("Remoção feita com sucesso!");
							}else {
								System.out.println("Erro na remoção!");
							}		
							break;

						case '4':
							System.out.println("Digite o Preco:\n");
							valorF = scan.nextFloat();
							if(arvore.removerValor(valorF)) {
								System.out.println("Remoção feita com sucesso!");
							}else {
								System.out.println("Erro na remoção!");
							}
							break;

						case '5':
							System.out.println("Digite o Estoque:\n");
							valor = scan.nextInt();
							if(arvore.removerEstoque(valor)) {
								System.out.println("Remoção feita com sucesso!");
							}else {
								System.out.println("Erro na remoção!");
							}
							break;							
						 
					 }				 
					 
				 }while(opcao2 != '0');
				 break;
				 
			 case '4':
				 do {
					 opcao2 = menuConsulta();
					
					 switch (opcao2) {
						case '1':
							vetor = arvore.menorEstoque();
							i = 0;
							if(vetor[0] != null) {
								while(vetor[i] != null){
									imprimirItem(vetor, i);
									i++;
								}
							}else {
								System.out.println("Erro na consulta!\n");
							}
							break;			
						 
						case '2':
							vetor = arvore.maiorEstoque();
							i = 0;
							if(vetor[0] != null) {
								while(vetor[i] != null){
									imprimirItem(vetor, i);
									i++;
								}
							}else {
								System.out.println("Erro na consulta!\n");
							}
							break;	
					 }				 
					 
				 }while(opcao2 != '0');
				 break;
			
			}

		} while (opcao!='0');
		System.exit(0);

	}
	
	public static char menuPrincipal() {
		System.out.println("Escolha uma Opção:\n" +
				"1. Pesquisar\n"+
				"2. Inserir\n"+
				"3. Remover\n"+
				"4. Consultas\n"+
				"0. Sair\n");
		
		return scan.next().charAt(0);		
	}
	
	public static char menuEscolher() {
		System.out.println("Escolha uma Opção:\n" +
				"1. Codigo de Barra\n"+
				"2. Nome\n"+
				"3. Fabricante\n"+
				"4. Valor\n"+
				"5. Estoque\n"+
				"0. Sair\n");
		
		return scan.next().charAt(0);
	}
	
	public static char menuConsulta() {
		System.out.println("Escolha uma Opção:\n" +
				"1. Menor Estoque\n"+
				"2. Maior Estoque\n"+
				"0. Sair\n");
		
		return scan.next().charAt(0);
	}
	
	public static void imprimirItem(Item [] vetor, int i) {		
		System.out.println(
				"Codigo de Barra:\t"    + vetor[i].getCodigoDeBarra() + "\n" +
				"Nome da Bebida:\t\t"   + vetor[i].getNome()    	  + "\n" +
				"Nome do Fabricante:\t" + vetor[i].getFabricante() 	  + "\n" +
				"Valor ou Preço:\t\t"   + vetor[i].getValor() 		  + "\n" +
				"Total em Estoque:\t"   + vetor[i].getEstoque() 	  + "\n");

	}
	
		

}

