package dados;

public class Item {
	private int codigoDeBarra;
	private String nome;
	private String fabricante;
	private float valor;
	private int estoque;

	public Item(int code, String nome, String fab, float val, int est) {
		this.codigoDeBarra = code;
		this.nome = nome;
		this.fabricante = fab;
		this.valor = val;
		this.estoque = est;
	}

	public void setCodigoDeBarra(int code){
		this.codigoDeBarra = code;
	}
	public int getCodigoDeBarra(){
		return this.codigoDeBarra;
	}

	public void setNome(String nome){
		this.nome = nome;
	}
	public String getNome(){
		return this.nome;
	}

	public void setFabricante(String fab){
		this.fabricante = fab;
	}
	public String getFabricante(){
		return this.fabricante;
	}

	public void setValor(float val){
		this.valor = val;
	}
	public float getValor(){
		return this.valor;
	}

	public void setEstoque(int est){
		this.estoque = est;
	}
	public int getEstoque(){
		return this.estoque;
	}
}
