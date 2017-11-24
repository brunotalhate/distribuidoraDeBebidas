package distribuidora;
import java.util.Scanner;

import dados.Item;

public class MainTrabalho {
	static Scanner scan = new Scanner(System.in);
	public static void main(String[] args) {			
		
		Arvore arvore = new Arvore();		
		
		Item novoItem1 = new Item	(	1 , "Coca-Cola 600ml"	, "Coca-Cola"	, (float) 5.00	, 8		);
		Item novoItem2 = new Item	(	2 , "Coca-Cola 1500ml"	, "Coca-Cola"	, (float) 5.59	, 49	);
		Item novoItem3 = new Item	(	3 , "super-skol"		, "Ambev"		, (float) 26.00	, 158	);
        arvore.inserir(novoItem1);
        arvore.inserir(novoItem2);
        arvore.inserir(novoItem3);
		
		
		int valor, i;
		float valorF, valorF2;
		String valorS, valorS2;
		Item [] vetor= new Item[10];		
		char opcao, opcao2;
		do {
			
			opcao = menuPrincipal();
			//for (int z=0; z<50; z++) System.out.println();
			
			switch (opcao) {
			case '1':
				do {
					
					opcao2 = menuEscolher();
					
					switch (opcao2) {
					case '1':
						scan.nextLine(); // Limpando Buffer
						System.out.println("Digite um Codigo de Barra:\n");
						valor = scan.nextInt();												
						vetor[0] = arvore.pesquisarCodeBar (valor);
						if(vetor[0] != null) {
							imprimirItem(vetor, 0);
						}else {
							System.out.println("Codigo de Barra n�o presente ou digitado incorretamente!\n");
						}						
						break;

					case '2':
						scan.nextLine(); // Limpando Buffer
						System.out.println("Digite o nome do produto:\n");
						valorS = scan.nextLine();						
						vetor[0] = arvore.pesquisarNome(valorS);
						if(vetor[0] != null) {
							imprimirItem(vetor, 0);
						}else {
							System.out.println("Nome do Produto n�o presente ou digitado incorretamente!\n");
						}	
						break;

					case '3':
						scan.nextLine(); // Limpando Buffer
						System.out.println("Digite o nome do fabricante:\n");
						valorS = scan.nextLine();
						vetor = arvore.pesquisarFabricante(valorS);
						i = 0;
						if(vetor[0] != null) {
							while(vetor[i] != null){
								imprimirItem(vetor, i);
								i++;
							}
						}else {
							System.out.println("Fabricante n�o presente ou digitado incorretamente!\n");
						}						
						break;

					case '4':
						scan.nextLine(); // Limpando Buffer
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
							System.out.println("Pre�o n�o presente ou digitado incorretamente!\n");
						}
						break;

					case '5':
						scan.nextLine(); // Limpando Buffer
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
							System.out.println("Estoque n�o presente ou digitado incorretamente!\n");
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
                 if(arvore.inserir(novoItem)) {
                	 System.out.println("\nProduto inserido com sucesso.\n");
                 }else {
                	 System.out.println("Erro na inser��o!");
                 }
                 break;
                 
			 case '3':
				 do {
					 opcao2 = menuEscolher();
					
					 switch (opcao2) {
						case '1':
							scan.nextLine(); // Limpando Buffer
							System.out.println("Digite um Codigo de Barra:\n");
							valor = scan.nextInt();		
							if(arvore.removerCodeBar(valor)) {
								System.out.println("Remo��o feita com sucesso!");
							}else {
								System.out.println("Erro na remo��o!");
							}
							break;

						case '2':
							scan.nextLine(); // Limpando Buffer
							System.out.println("Digite o nome do produto:\n");
							valorS = scan.nextLine();						
							vetor[0] = arvore.pesquisarNome(valorS);
							if(arvore.removerNome(valorS)) {
								System.out.println("Remo��o feita com sucesso!");
							}else {
								System.out.println("Erro na remo��o!");
							}
							break;

						case '3':
							scan.nextLine(); // Limpando Buffer
							System.out.println("Digite o nome do fabricante:\n");
							valorS = scan.nextLine();
							if(arvore.removerFabricante(valorS)) {
								System.out.println("Remo��o feita com sucesso!");
							}else {
								System.out.println("Erro na remo��o!");
							}		
							break;

						case '4':
							scan.nextLine(); // Limpando Buffer
							System.out.println("Digite o Preco:\n");
							valorF = scan.nextFloat();
							if(arvore.removerValor(valorF)) {
								System.out.println("Remo��o feita com sucesso!");
							}else {
								System.out.println("Erro na remo��o!");
							}
							break;

						case '5':
							scan.nextLine(); // Limpando Buffer
							System.out.println("Digite o Estoque:\n");
							valor = scan.nextInt();
							if(arvore.removerEstoque(valor)) {
								System.out.println("Remo��o feita com sucesso!");
							}else {
								System.out.println("Erro na remo��o!");
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
							
						case '3':
							System.out.println("Digite parte do Nome:\n");
							valorS = scan.next();
							vetor = arvore.parteNome(valorS);
							i = 0;
							if(vetor[0] != null) {
								while(vetor[i] != null){
									imprimirItem(vetor, i);
									i++;
								}
							}else {
								System.out.println("Parte do nome n�o presente ou digitado incorretamente!\n");
							}
							break;
							
						case '4':
							System.out.println("Digite parte do Fabricante:\n");
							valorS = scan.next();
							vetor = arvore.parteFabricante(valorS);
							i = 0;
							if(vetor[0] != null) {
								while(vetor[i] != null){
									imprimirItem(vetor, i);
									i++;
								}
							}else {
								System.out.println("Parte do fabricante n�o presente ou digitado incorretamente!\n");
							}
							break;
							
						case '5':
							System.out.println("Digite valor para retornar Estoque maior:\n");
							valor = scan.nextInt();
							vetor = arvore.estoqueMaiorQue(valor);
							i = 0;
							if(vetor[0] != null) {
								while(vetor[i] != null){
									imprimirItem(vetor, i);
									i++;
								}
							}else {
								System.out.println("N�o existe estoque maior que o valor digitado!\n");
							}
							break;
							
						case '6':
							System.out.println("Digite valor para retornar Estoque menor:\n");
							valor = scan.nextInt();
							vetor = arvore.estoqueMenorQue(valor);
							i = 0;
							if(vetor[0] != null) {
								while(vetor[i] != null){
									imprimirItem(vetor, i);
									i++;
								}
							}else {
								System.out.println("N�o existe estoque menor que o valor digitado!\n");
							}
							break;
												
						case '7':
							System.out.println("Digite valor para retornar Pre�o maior:\n");
							valorF = scan.nextFloat();
							vetor = arvore.valorMaiorQue(valorF);
							i = 0;
							if(vetor[0] != null) {
								while(vetor[i] != null){
									imprimirItem(vetor, i);
									i++;
								}
							}else {
								System.out.println("N�o existe pre�o maior que o valor digitado!\n");
							}
							break;
							
						case '8':
							System.out.println("Digite valor para retornar Pre�o menor:\n");
							valorF = scan.nextFloat();
							vetor = arvore.valorMenorQue(valorF);
							i = 0;
							if(vetor[0] != null) {
								while(vetor[i] != null){
									imprimirItem(vetor, i);
									i++;
								}
							}else {
								System.out.println("N�o existe pre�o menor que o valor digitado!\n");
							}
							break;
							
						case '9':
							System.out.println("Digite valor para retornar Pre�o menor que:\n");
							valorF = scan.nextFloat();
							System.out.println("E maior que:\n");
							valorF2 = scan.nextFloat();
							vetor = arvore.valorEntre(valorF, valorF2);
							i = 0;
							if(vetor[0] != null) {
								while(vetor[i] != null){
									imprimirItem(vetor, i);
									i++;
								}
							}else {
								System.out.println("N�o existe pre�o entre os valores digitados!\n");
							}
							break;
							
							
					 }				 
					 
				 }while(opcao2 != '0');
				 break;
				 
			 case '5':
                 if(arvore.eVazia()){System.out.println("A lista est� vazia.\n");
                 break;
                 }
                 do {
                     System.out.println("\nQual dado deseja alterar ?\n");
                     opcao2 = menuEscolher();
                     
                     switch (opcao2) {
                         case '1':
                        	 scan.nextLine(); // Limpando Buffer
                             System.out.println("Digite o codigo de barras do produto a ser modificado:\n");
                             valor = scan.nextInt();
                             scan.nextLine(); // Limpando Buffer
                             System.out.println("Digite o novo valor a ser inserido:\n");
                             i = scan.nextInt();                           
                             if(arvore.alterarCodeBar(valor, i)) {
                            	 System.out.println("Dado alterado com sucesso.");
                             }else {
                            	 System.out.println("Erro na altera��o!");
                             }                             
                             break;
                         case '2':
                        	 scan.nextLine(); // Limpando Buffer
                             System.out.println("Digite o nome do produto a ser modificado:\n");
                             valorS = scan.nextLine();
                             scan.nextLine(); // Limpando Buffer
                             System.out.println("Digite o novo nome a ser inserido:\n");
                             valorS2 = scan.nextLine();
                             if(arvore.alterarNome(valorS, valorS2)) {
                            	 System.out.println("Nome alterado com sucesso.");
                             }else {
                            	 System.out.println("Erro na altera��o!");
                             }
                             break;
                         case '3':
                        	 scan.nextLine(); // Limpando Buffer
                             System.out.println("Digite o nome do fabricante a ser modificado:\n");
                             valorS = scan.nextLine();
                             scan.nextLine(); // Limpando Buffer
                             System.out.println("Digite o novo nome de fabricante a ser inserido:\n");
                             valorS2 = scan.nextLine();
                             if(arvore.alterarFabricante(valorS, valorS2)) {
                            	 System.out.println("Fabricante alterado com sucesso.");
                             }else {
                            	 System.out.println("Erro na altera��o!");
                             }
                             break;
                         case'4':
                        	 scan.nextLine(); // Limpando Buffer
                             System.out.println("Digite o valor do produto a ser modificado:\n");
                             valorF = scan.nextFloat();
                             scan.nextLine(); // Limpando Buffer
                             System.out.println("Digite o novo valor a ser inserido:\n");
                             valorF2 = scan.nextFloat();
                             if(arvore.alterarValor(valorF, valorF2)) {
                            	 System.out.println("Valor alterado com sucesso.");
                             }else {
                            	 System.out.println("Erro na altera��o!");
                             }
                             break;
                         case'5':
                        	 scan.nextLine(); // Limpando Buffer
                             System.out.println("Digite o estoque do produto a ser modificado:\n");
                             valor = scan.nextInt();
                             scan.nextLine(); // Limpando Buffer
                             System.out.println("Digite o novo estoque a ser inserido:\n");
                             i = scan.nextInt();
                             if(arvore.alterarEstoque(valor, i)) {
                            	 System.out.println("Estoque alterado com sucesso.");
                             }else {
                            	 System.out.println("Erro na altera��o!");
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
		System.out.println("Escolha uma Op��o:\n" +
				"1. Pesquisar\n"+
				"2. Inserir\n"+
				"3. Remover\n"+
				"4. Consultas\n"+
				"5. Alterar Dado\n"+
				"0. Sair\n");
		
		return scan.next().charAt(0);		
	}
	
	public static char menuEscolher() {
		System.out.println("Escolha uma Op��o:\n" +
				"1. Codigo de Barra\n"+
				"2. Nome\n"+
				"3. Fabricante\n"+
				"4. Valor\n"+
				"5. Estoque\n"+
				"0. Sair\n");
		
		return scan.next().charAt(0);
	}
	
	public static char menuConsulta() {
		System.out.println("Escolha uma Op��o:\n" +
				"1. Menor Estoque\n"+
				"2. Maior Estoque\n"+
				"3. Parte do Nome\n"+
				"4. Parte do Fabricante\n"+
				"5. Estoque Maior que\n"+
				"6. Estoque Menor que\n"+
				"7. Valor Maior que\n"+
				"8. Valor Menor que\n"+
				"9. Valor Entre\n"+
				"0. Sair\n");
		
		return scan.next().charAt(0);
	}
	
	public static void imprimirItem(Item [] vetor, int i) {		
		System.out.println(
				"Codigo de Barra:\t"    + vetor[i].getCodigoDeBarra() + "\n" +
				"Nome da Bebida:\t\t"   + vetor[i].getNome()    	  + "\n" +
				"Nome do Fabricante:\t" + vetor[i].getFabricante() 	  + "\n" +
				"Valor ou Pre�o:\t\t"   + vetor[i].getValor() 		  + "\n" +
				"Total em Estoque:\t"   + vetor[i].getEstoque() 	  + "\n\n");		

	}
	
}


