package Entidades;

public class Responsavel extends Pessoa {

	//private String nomeFilho
	private String idade;

	public Responsavel() {
		
	}

	public Responsavel(int ID, String nome, String idade) {
		super(ID, nome);
		this.idade = idade;
	}
	

	public String getIdade() {
		return idade;
	}

	public void setIdade(String idade) {
		this.idade = idade;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((idade == null) ? 0 : idade.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Responsavel other = (Responsavel) obj;
		if (idade == null) {
			if (other.idade != null)
				return false;
		} else if (!idade.equals(other.idade))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Responsável (ID = " + getID() + ", Nome = " + getNome() + ", idade= " + idade + ")";
		//"Responsável (ID =  " + getID(); + ", Nome = )" + getNome(); + ", idade= " + idade + ")";
	}

	
	
	
}
