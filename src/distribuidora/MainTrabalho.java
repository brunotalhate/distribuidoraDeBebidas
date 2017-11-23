package distribuidora;
import java.util.Scanner;

import dados.Item;

public class MainTrabalho {
	static Scanner scan = new Scanner(System.in);
	public static void main(String[] args) {
		
		
		
		Arvore arvore = new Arvore();
		
		
		Item novoItem1 = new Item(1, "Coca-Cola 600ml", "Coca-Cola", (float) 5.00, 49);
		Item novoItem2 = new Item(2, "Coca-Cola 1500ml", "Coca-Cola", (float) 5.59, 49);
		Item novoItem3 = new Item(3, "super-skol", "Ambev", (float) 26.00, 158);
        arvore.inserir(novoItem1);
        arvore.inserir(novoItem2);
        arvore.inserir(novoItem3);
		
		
		int valor;
		float valorF;
		String valorS;
		Item [] vetor= new Item[10];
		Item itemAux;
		char opcao, opcao2;
		do {
			
			opcao = menuPrincipal();
			
			switch (opcao) {
			case '1':
				do {
					
					opcao2 = menuPesquisar();
					
					switch (opcao2) {
					case '1':
						System.out.println("Digite um Codigo de Barra:\n");
						valor = scan.nextInt();												
						itemAux = arvore.pesquisarCodeBar (valor);
						imprimirItem(itemAux);
						break;

					case '2':
						System.out.println("Digite o nome do produto:\n");
						valorS = scan.next();						
						itemAux = arvore.pesquisarNome(valorS);
						imprimirItem(itemAux);
						break;

					case '3':
						System.out.println("Digite o nome do fabricante:\n");
						valorS = scan.next();
						vetor = arvore.pesquisarFabricante(valorS);
						int j = 0;
						while(vetor[j] != null){
							System.out.println(
									"Codigo de Barra:\t"  + vetor[j].getCodigoDeBarra() + "\n" +
									"Nome da Bebida:\t\t"   + vetor[j].getNome()    	  + "\n" +
									"Nome do Fabricante:\t" + vetor[j].getFabricante() 	  + "\n" +
									"Valor ou Preço:\t\t"   + vetor[j].getValor() 		  + "\n" +
									"Total em Estoque:\t" + vetor[j].getEstoque() 	  + "\n");
									j++;
						}
						break;

					case '4':
						System.out.println("Digite o Preco:\n");
						valorF = scan.nextFloat();
						vetor = arvore.pesquisarValor(valorF);
						for(int i = 0; i < 1; i++){
							System.out.println(
									"Codigo de Barra:\t"  + vetor[i].getCodigoDeBarra() + "\n" +
									"Nome da Bebida:\t\t"   + vetor[i].getNome()    	  + "\n" +
									"Nome do Fabricante:\t" + vetor[i].getFabricante() 	  + "\n" +
									"Valor ou Preço:\t\t"   + vetor[i].getValor() 		  + "\n" +
									"Total em Estoque:\t" + vetor[i].getEstoque() 	  + "\n");

						}
						break;

					case '5':
						System.out.println("Digite o Estoque:\n");
						valor = scan.nextInt();
						vetor = arvore.pesquisarEstoque(valor);
						int k = 0;
						while(vetor[k] != null){
							imprimirItemVetor(vetor, k);
							k++;
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
			
			}

		} while (opcao!='0');
		System.exit(0);

	}
	
	public static char menuPrincipal() {
		System.out.println("Escolha uma Opção:\n" +
				"1. Pesquisar\n"+
				"2. Inserir\n"+
				"0. Sair\n");
		
		return scan.next().charAt(0);		
	}
	
	public static char menuPesquisar() {
		System.out.println("Escolha uma Opção:\n" +
				"1. Codigo de Barra\n"+
				"2. Nome\n"+
				"3. Fabricante\n"+
				"4. Valor\n"+
				"5. Estoque\n"+
				"0. Sair\n");
		
		return scan.next().charAt(0);
	}
	
	public static void imprimirItemVetor(Item [] vetor, int i) {
		
		System.out.println(
				"Codigo de Barra:\t"  + vetor[i].getCodigoDeBarra() + "\n" +
				"Nome da Bebida:\t\t"   + vetor[i].getNome()    	  + "\n" +
				"Nome do Fabricante:\t" + vetor[i].getFabricante() 	  + "\n" +
				"Valor ou Preço:\t\t"   + vetor[i].getValor() 		  + "\n" +
				"Total em Estoque:\t" + vetor[i].getEstoque() 	  + "\n");

	}
	
	public static void imprimirItem(Item itemAux) {
		if(itemAux != null){
			System.out.println(
					"Codigo de Barra:\t"  + itemAux.getCodigoDeBarra()  + "\n" +
					"Nome da Bebida:\t\t"   + itemAux.getNome()    		  + "\n" +
					"Nome do Fabricante:\t" + itemAux.getFabricante() 	  + "\n" +
					"Valor ou Preço:\t\t"   + itemAux.getValor() 		  + "\n" +
					"Total em Estoque:\t" + itemAux.getEstoque() 	 	  + "\n");

		}else{
			System.out.println("Nao tem esse valor, viado!");
		}
	}
		

}

