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



/*

	public boolean inserir (Item elem){
		if (pesquisar (elem.getChave())){
			return false;
		}else{
			this.raiz = inserir (elem, this.raiz);
			this.quantNos++;
			return true;
		}
	}
	public NoArv inserir (Item elem, NoArv no){
		if (no == null){
			NoArv novo = new NoArv(elem);
			return novo;
		}else {
			if (elem.getChave() < no.getInfo().getChave()){
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
			if (chave < no.getInfo().getChave()){
				no = pesquisar (chave, no.getEsq());
			}else{
				if (chave > no.getInfo().getChave()){
					no = pesquisar (chave, no.getDir());
				}
			}
		}
		return no;
	}
	public boolean remover (int chave){
		if (pesquisar (chave, this.raiz) != null){
			this.raiz = remover (chave, this.raiz);
			this.quantNos--;
			return true;
		}
		else {
			return false;
		}
	}
	public NoArv remover (int chave, NoArv arv){
		if (chave < arv.getInfo().getChave()){
			arv.setEsq(remover (chave, arv.getEsq()));
		}else{
			if (chave > arv.getInfo().getChave()){
				arv.setDir(remover (chave, arv.getDir()));
			}else{
				if (arv.getDir()== null){
					return arv.getEsq();
				}else{
					if (arv.getEsq() == null){ 
						return arv.getDir();
					}else{
						arv.setEsq(Arrumar (arv, arv.getEsq()));
					}
				}
			}
		}
		return arv;
	}
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
	public Item [] CamCentral (){
		int []n= new int[1];
		n[0]=0;
		Item [] vet = new Item[this.quantNos];
		return (FazCamCentral (this.raiz, vet, n));
	}
	private Item [] FazCamCentral (NoArv arv, Item [] vet, int []n){
		if (arv != null) {
			vet = FazCamCentral (arv.getEsq(),vet,n);
			vet[n[0]] = arv.getInfo();
			n[0]++;
			vet = FazCamCentral (arv.getDir(),vet,n);
		}
		return vet;
	}
	public Item [] CamPreFixado (){
		int []n= new int[1];
		n[0]=0;
		Item [] vet = new Item[this.quantNos];
		return (FazCamPreFixado (this.raiz, vet, n));
	}
	private Item [] FazCamPreFixado (NoArv arv, Item [] vet, int []n){
		if (arv != null) {
			vet[n[0]] = arv.getInfo();
			n[0]++;
			vet = FazCamPreFixado (arv.getEsq(), vet,n);
			vet = FazCamPreFixado (arv.getDir(), vet,n);
		}
		return vet;
	}
	public Item [] CamPosFixado (){
		int []n= new int[1];
		n[0]=0;
		Item [] vet = new Item[this.quantNos];
		return (FazCamPosFixado (this.raiz, vet, n));
	}
	private Item [] FazCamPosFixado (NoArv arv, Item[] vet, int []n){
		if (arv != null) {
			vet = FazCamPosFixado (arv.getEsq(), vet,n);
			vet = FazCamPosFixado (arv.getDir(), vet,n);
			vet[n[0]] = arv.getInfo();
			n[0]++;
		}
		return vet;
	}
	
*/	
	
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
		Item [] vet = new Item[this.quantNos];
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
		Item [] vet = new Item[this.quantNos];
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
		Item [] vet = new Item[this.quantNos];
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
			
			Item [] vetor= new Item[this.quantNos];
			vetor = pesquisarFabricante(fabricante);
			
			for(int i = 0; i < this.quantNos; i++) {
				this.raiz = remover(vetor[i].getCodigoDeBarra(), this.raiz);
			}
			
			this.quantNos--;
			return true;
		}else {
			return false;
		}
	}
	
	public boolean removerValor (float valor) {
		if(pesquisarValor(valor) != null) {
			
			Item [] vetor= new Item[this.quantNos];
			vetor = pesquisarValor(valor);
			
			for(int i = 0; i < this.quantNos; i++) {
				this.raiz = remover(vetor[i].getCodigoDeBarra(), this.raiz);
			}
			
			this.quantNos--;
			return true;
		}else {
			return false;
		}
	}
	
	public boolean removerEstoque (int estoque) {
		if(pesquisarEstoque(estoque) != null) {
			
			Item [] vetor= new Item[this.quantNos];
			vetor = pesquisarEstoque(estoque);
			
			for(int i = 0; i < this.quantNos; i++) {
				this.raiz = remover(vetor[i].getCodigoDeBarra(), this.raiz);
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
			Item [] vet = new Item[this.quantNos];
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
			Item [] vet = new Item[this.quantNos];
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
	
	
	
	
	
	
	
}

