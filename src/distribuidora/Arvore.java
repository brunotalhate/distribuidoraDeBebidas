package distribuidora;

import dados.Item;

public class Arvore {
	private NoArv raiz;
	private int quantNos;

	public Arvore(){
		this.quantNos=0;
		this.raiz = null;
	}
	public boolean eVazia (){
		return (this.raiz == null);
	}
	public NoArv getRaiz(){
		return this.raiz;
	}
	public int getQuantNos(){
		return this.quantNos;
	}

	
	public boolean inserir (Item elem){
	    if (pesquisar (elem.getCodigoDeBarra())){ //Pesquisar se há algum produto igual na arvore
	        return false;
	    }else{ //Se não tiver, insere
	        this.raiz = inserir (elem, this.raiz);
	        this.quantNos++;
	        return true;
	    }
	}
	private NoArv inserir (Item elem, NoArv no){
	    if (no == null){ //Se a arvore estiver vazia o novo nó é a raiz
	        NoArv novo = new NoArv(elem);
	        return novo;
	    }else { // Se nao estiver vazia
	        if (elem.getCodigoDeBarra() < no.getInfo().getCodigoDeBarra()){
	            no.setEsq(inserir(elem, no.getEsq()));
	            return no;
	        }else{
	            no.setDir(inserir(elem, no.getDir()));
	            return no;
	        }
	    }
	}
	public boolean pesquisar (int chave){
	    if (pesquisar (chave, this.raiz)!= null){
	        return true;
	    }else{
	        return false;
	    }
	}
	private NoArv pesquisar (int chave, NoArv no){
	    if (no != null){
	        if (chave < no.getInfo().getCodigoDeBarra()){
	            no = pesquisar (chave, no.getEsq());
	        }else{
	            if (chave > no.getInfo().getCodigoDeBarra()){
	                no = pesquisar (chave, no.getDir());
	            }
	        }
	    }
	    return no;
	}	
	
	
	public Item pesquisarCodeBar (int codeBar){
		NoArv aux = auxPesquisarCodeBar (codeBar, this.raiz); 
		if(aux != null)	return aux.getInfo();
		return null;	
	}	
	private NoArv auxPesquisarCodeBar (int codeBar, NoArv no){
		if (no != null){
			if (codeBar < no.getInfo().getCodigoDeBarra()){
				no = auxPesquisarCodeBar (codeBar, no.getEsq());
			}else{
				if (codeBar > no.getInfo().getCodigoDeBarra()){
					no = auxPesquisarCodeBar (codeBar, no.getDir());
				}
			}
		}
		return no;
	}
	
	
	public Item pesquisarNome(String bebida){
		if(this.raiz == null){
			return null;
		}else{
			Item aux = null;
			return (auxPesquisarNome(this.raiz, bebida, aux));			
		}
	}	
	private Item auxPesquisarNome (NoArv arv, String bebida, Item aux){
		if (arv != null && aux == null){			
			aux = auxPesquisarNome(arv.getEsq(), bebida, aux);
			
			aux = auxPesquisarNome(arv.getDir(), bebida, aux);
			
			if(arv.getInfo().getNome().equals(bebida)){
				aux = arv.getInfo();
			}			
		}
		return aux;
	}
	
	
	public Item [] pesquisarFabricante (String fabricante) {
		int []n = new int[1];
		n[0] = 0;
		Item [] vet = new Item[this.quantNos + 1];
		return auxPesquisarFabricante(this.raiz, vet, n, fabricante);
	}
	private Item [] auxPesquisarFabricante (NoArv arv, Item [] vet, int [] n, String fabric) {
		if(arv != null) {
			vet = auxPesquisarFabricante(arv.getEsq(), vet, n, fabric);
			if(arv.getInfo().getFabricante().equals(fabric)) {
				vet[n[0]] = arv.getInfo();
				n[0]++;
			}
			vet = auxPesquisarFabricante(arv.getDir(), vet, n, fabric);			
		}		
		return vet;		
	}
		
	
	public Item [] pesquisarValor (float valor) {
		int []n = new int[1];
		n[0] = 0;
		Item [] vet = new Item[this.quantNos + 1];
		return auxPesquisarValor(this.raiz, vet, n, valor);
	}
	private Item [] auxPesquisarValor (NoArv arv, Item [] vet, int [] n, float valor) {
		if(arv != null) {
			vet = auxPesquisarValor(arv.getEsq(), vet, n, valor);
			if(arv.getInfo().getValor() == valor) {
				vet[n[0]] = arv.getInfo();
				n[0]++;
			}
			vet = auxPesquisarValor(arv.getDir(), vet, n, valor);			
		}		
		return vet;		
	}
	
	
	public Item [] pesquisarEstoque (int estoque) {
		int []n = new int[1];
		n[0] = 0;
		Item [] vet = new Item[this.quantNos + 1];
		return auxPesquisarEstoque(this.raiz, vet, n, estoque);
	}
	private Item [] auxPesquisarEstoque (NoArv arv, Item [] vet, int [] n, int estoque) {
		if(arv != null) {
			vet = auxPesquisarEstoque(arv.getEsq(), vet, n, estoque);
			if(arv.getInfo().getEstoque() == estoque) {
				vet[n[0]] = arv.getInfo();
				n[0]++;
			}
			vet = auxPesquisarEstoque(arv.getDir(), vet, n, estoque);			
		}		
		return vet;		
	}
	
	
	public boolean removerCodeBar (int codeBar) {
		if(auxPesquisarCodeBar(codeBar,this.raiz) != null) {
			this.raiz = remover(codeBar, this.raiz);
			this.quantNos--;
			return true;
		}else {
			return false;
		}
	}
	
	public boolean removerNome (String bebida) {
		if(pesquisarNome(bebida) != null) {
			this.raiz = remover(pesquisarNome(bebida).getCodigoDeBarra(),this.raiz);
			this.quantNos--;
			return true;
		}else {
			return false;
		}
	}
	
	public boolean removerFabricante (String fabricante) {
		if(pesquisarFabricante(fabricante) != null) {		
			int i = 0;
			Item [] vetor= new Item[this.quantNos + 1];
			vetor = pesquisarFabricante(fabricante);
			
			while(vetor[i] != null) {
				this.raiz = remover(vetor[i].getCodigoDeBarra(), this.raiz);
				i++;
			}
			
			this.quantNos--;
			return true;
		}else {
			return false;
		}
	}
	
	public boolean removerValor (float valor) {
		if(pesquisarValor(valor) != null) {
			int i = 0;
			Item [] vetor= new Item[this.quantNos + 1];
			vetor = pesquisarValor(valor);
			
			while(vetor[i] != null) {
				this.raiz = remover(vetor[i].getCodigoDeBarra(), this.raiz);
				i++;
			}
			
			this.quantNos--;
			return true;
		}else {
			return false;
		}
	}
	
	public boolean removerEstoque (int estoque) {
		if(pesquisarEstoque(estoque) != null) {
			int i = 0;
			Item [] vetor= new Item[this.quantNos + 1];
			vetor = pesquisarEstoque(estoque);			
			
			while(vetor[i] != null) {
				this.raiz = remover(vetor[i].getCodigoDeBarra(), this.raiz);
				i++;
			}
			
			this.quantNos--;
			return true;
		}else {
			return false;
		}
	}
	
	//mesmo codigo recursivo de remover para todos os campos, só mudara o método de chamado!!!
	private NoArv remover(int codeBar, NoArv arv) {
		if(codeBar < arv.getInfo().getCodigoDeBarra()) {
			arv.setEsq(remover(codeBar, arv.getEsq()));
		}else {
			if(codeBar > arv.getInfo().getCodigoDeBarra()) {
				arv.setDir(remover(codeBar, arv.getDir()));
			}else {
				if(arv.getDir() == null) {
					return arv.getEsq();
				}else {
					if(arv.getEsq() == null) {
						return arv.getDir();
					}else {
						arv.setEsq(Arrumar (arv, arv.getEsq()));
					}
				}
			}
		}
		return arv;
	}
	
	//codigo da professora necessário para o remover
	private NoArv Arrumar (NoArv arv, NoArv maior){
		if (maior.getDir() != null){
			maior.setDir(Arrumar (arv, maior.getDir()));
		}
		else{
			arv.setInfo(maior.getInfo());
			maior = maior.getEsq();
		}
		return maior;
	}
	
	
	public Item [] menorEstoque() {
		if(this.raiz != null) {
			int []n= new int[1];
			n[0]=0;
			Item [] vet = new Item[this.quantNos + 1];
			int []menorEstoque = new int[1];
			menorEstoque[0] = this.raiz.getInfo().getEstoque();
			vet = auxMenorEstoque(this.raiz,vet,n,menorEstoque);
			for (int i = this.quantNos - 1; i>0; i--) {
				if(i>=n[0]) {
					vet[i] = null;
				}
			}
			return vet;
			
		}else {
			return null;
		}
	}
	private Item [] auxMenorEstoque(NoArv arv, Item [] vet, int []n, int []menorEstoque) {
		if (arv != null) {
			vet = auxMenorEstoque (arv.getEsq(),vet,n,menorEstoque);
			
			if(arv.getInfo().getEstoque() < menorEstoque[0]) {
				n[0]=0;
				vet[n[0]] = arv.getInfo();
				n[0]++;
			}else if(arv.getInfo().getEstoque() == menorEstoque[0]) {
				vet[n[0]] = arv.getInfo();
				n[0]++;
			}	
			
			vet = auxMenorEstoque (arv.getDir(),vet,n,menorEstoque);
		}
		return vet;
	}
	
	
	public Item [] maiorEstoque() {
		if(this.raiz != null) {
			int []n= new int[1];
			n[0]=0;
			Item [] vet = new Item[this.quantNos + 1];
			int []maiorEstoque = new int[1];
			maiorEstoque[0] = this.raiz.getInfo().getEstoque();
			vet = auxMaiorEstoque(this.raiz,vet,n,maiorEstoque);
			for (int i = this.quantNos - 1; i>0; i--) {
				if(i>=n[0]) {
					vet[i] = null;
				}
			}
			return vet;			
		}else {
			return null;
		}
	}	
	private Item [] auxMaiorEstoque(NoArv arv, Item [] vet, int []n, int []maiorEstoque) {
		if (arv != null) {
			vet = auxMaiorEstoque (arv.getEsq(),vet,n,maiorEstoque);
			
			if(arv.getInfo().getEstoque() > maiorEstoque[0]) {
				n[0]=0;
				vet[n[0]] = arv.getInfo();
				n[0]++;
			}else if(arv.getInfo().getEstoque() == maiorEstoque[0]) {
				vet[n[0]] = arv.getInfo();
				n[0]++;
			}	
			
			vet = auxMaiorEstoque (arv.getDir(),vet,n,maiorEstoque);
		}
		return vet;
	}
	
	
	public Item [] parteNome (String bebida){
		int []n= new int[1];
		n[0]=0;
		Item [] vet = new Item[this.quantNos + 1];
		return (auxParteNome (this.raiz, vet, n, bebida));
	}
	private Item [] auxParteNome (NoArv arv, Item [] vet, int []n, String bebida){
		if (arv != null) {
			vet = auxParteNome (arv.getEsq(),vet,n,bebida);
			
			if (arv.getInfo().getNome().contains(bebida)) {
				vet[n[0]] = arv.getInfo();
				n[0]++;
			}
			
			vet = auxParteNome (arv.getDir(),vet,n,bebida);
		}
		return vet;
	}	
	
	
	public Item [] parteFabricante (String fabric){
		int []n= new int[1];
		n[0]=0;
		Item [] vet = new Item[this.quantNos + 1];
		return (auxParteFabricante (this.raiz, vet, n, fabric));
	}
	private Item [] auxParteFabricante (NoArv arv, Item [] vet, int []n, String fabric){
		if (arv != null) {
			vet = auxParteFabricante (arv.getEsq(),vet,n,fabric);
			
			if (arv.getInfo().getFabricante().contains(fabric)) {
				vet[n[0]] = arv.getInfo();
				n[0]++;
			}
			
			vet = auxParteFabricante (arv.getDir(),vet,n,fabric);
		}
		return vet;
	}
		
	
	public Item [] estoqueMaiorQue(int estoque) {
		int []n= new int[1];
		n[0]=0;
		Item [] vet = new Item[this.quantNos + 1];
		return auxEstoqueMaiorQue(this.raiz,vet,n,estoque);
	}
	private Item [] auxEstoqueMaiorQue(NoArv arv, Item [] vet, int []n, int estoque) {
		if (arv != null) {
			vet = auxEstoqueMaiorQue (arv.getEsq(),vet,n,estoque);
			
			if(arv.getInfo().getEstoque() > estoque) {
				vet[n[0]] = arv.getInfo();
				n[0]++;
			}			
			
			vet = auxEstoqueMaiorQue (arv.getDir(),vet,n,estoque);
		}
		return vet;		
	}
	
	
	public Item [] estoqueMenorQue(int estoque) {
		int []n= new int[1];
		n[0]=0;
		Item [] vet = new Item[this.quantNos + 1];
		return auxEstoqueMenorQue(this.raiz,vet,n,estoque);
	}
	private Item [] auxEstoqueMenorQue(NoArv arv, Item [] vet, int []n, int estoque) {
		if (arv != null) {
			vet = auxEstoqueMenorQue (arv.getEsq(),vet,n,estoque);
			
			if(arv.getInfo().getEstoque() < estoque) {
				vet[n[0]] = arv.getInfo();
				n[0]++;
			}			
			
			vet = auxEstoqueMenorQue (arv.getDir(),vet,n,estoque);
		}
		return vet;		
	}
	
	
	public Item [] valorMaiorQue(float valor) {
		int []n= new int[1];
		n[0]=0;
		Item [] vet = new Item[this.quantNos + 1];
		return auxValorMaiorQue(this.raiz,vet,n,valor);
	}
	private Item [] auxValorMaiorQue(NoArv arv, Item [] vet, int []n, float valor) {
		if (arv != null) {
			vet = auxValorMaiorQue (arv.getEsq(),vet,n,valor);
			
			if(arv.getInfo().getValor() > valor) {
				vet[n[0]] = arv.getInfo();
				n[0]++;
			}			
			
			vet = auxValorMaiorQue (arv.getDir(),vet,n,valor);
		}
		return vet;
	}
	
	
	public Item [] valorMenorQue(float valor) {
		int []n= new int[1];
		n[0]=0;
		Item [] vet = new Item[this.quantNos + 1];
		return auxValorMenorQue(this.raiz,vet,n,valor);
	}
	private Item [] auxValorMenorQue(NoArv arv, Item [] vet, int []n, float valor) {
		if (arv != null) {
			vet = auxValorMenorQue (arv.getEsq(),vet,n,valor);
			
			if(arv.getInfo().getValor() < valor) {
				vet[n[0]] = arv.getInfo();
				n[0]++;
			}			
			
			vet = auxValorMenorQue (arv.getDir(),vet,n,valor);
		}
		return vet;
	}

	
	public Item [] valorEntre(float maiorValor, float menorValor) {
		int []n= new int[1];
		n[0]=0;
		Item [] vet = new Item[this.quantNos + 1];
		return auxValorEntre(this.raiz,vet,n,maiorValor,menorValor);
	}
	private Item [] auxValorEntre(NoArv arv, Item [] vet, int []n, float maiorValor, float menorValor) {
		if (arv != null) {
			vet = auxValorEntre (arv.getEsq(),vet,n,maiorValor,menorValor);
			
			if(arv.getInfo().getValor() > menorValor && arv.getInfo().getValor() < maiorValor) {
				vet[n[0]] = arv.getInfo();
				n[0]++;
			}			
			
			vet = auxValorEntre (arv.getDir(),vet,n,maiorValor,menorValor);
		}
		return vet;
	}	
	
	
	public boolean alterarCodeBar (int old, int newdado){
		if(pesquisarCodeBar(old) != null) {
			Item mod = pesquisarCodeBar(old);			
	        mod.setCodigoDeBarra(newdado);
	        return true;
		}else {
			return false;
		}        
    }
	
    
    public boolean alterarNome (String old, String newdado){
    	if(pesquisarNome(old) != null) {
    		Item mod = pesquisarNome(old);
            mod.setNome(newdado);
            return true;
    	}else {
    		return false;
    	}
        
    }
    
    
    public boolean alterarFabricante (String old, String newdado){
    	int i = 0;
    	Item [] vet = new Item[this.quantNos + 1];
		vet = pesquisarFabricante(old);
    	if(vet[0] != null) {    		
    		while(vet[i] != null) {
    			vet[i].setFabricante(newdado);
    		}    		
            return true;
    	}else {
    		return false;
    	}        
    }
    
    
    public boolean alterarValor (float old, float newdado){
    	int i = 0;
    	Item [] vet = new Item[this.quantNos + 1];
		vet = pesquisarValor(old);
    	if(vet[0] != null) {    		
    		while(vet[i] != null) {
    			vet[i].setValor(newdado);
    		}    		
            return true;
    	}else {
    		return false;
    	}       
    }
    
    
    public boolean alterarEstoque (int old, int newdado){
    	int i = 0;
    	Item [] vet = new Item[this.quantNos + 1];
		vet = pesquisarEstoque(old);
    	if(vet[0] != null) {    		
    		while(vet[i] != null) {
    			vet[i].setEstoque(newdado);
    		}    		
            return true;
    	}else {
    		return false;
    	}     
    }	
}

