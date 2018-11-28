package Entidades;

public class Aluno extends Pessoa {
	
	private double mediaA;
	private double mediaB;
	private double mediaFinal;
	private Responsavel responsavel;
	
	public double getMediaA() {
		return mediaA;
	}
	public void setMediaA(double mediaA) {
		this.mediaA = mediaA;
	}
	public double getMediaB() {
		return mediaB;
	}
	public void setMediaB(double mediaB) {
		this.mediaB = mediaB;
	}
	public double getMediaFinal() {
		return mediaFinal;
	}
	public void setMediaFinal(double mediaFinal) {
		this.mediaFinal = mediaFinal;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		long temp;
		temp = Double.doubleToLongBits(mediaA);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(mediaB);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(mediaFinal);
		result = prime * result + (int) (temp ^ (temp >>> 32));
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
		Aluno other = (Aluno) obj;
		if (Double.doubleToLongBits(mediaA) != Double.doubleToLongBits(other.mediaA))
			return false;
		if (Double.doubleToLongBits(mediaB) != Double.doubleToLongBits(other.mediaB))
			return false;
		if (Double.doubleToLongBits(mediaFinal) != Double.doubleToLongBits(other.mediaFinal))
			return false;
		return true;
	}
	
	public Aluno() {
		this.responsavel = new Responsavel();		
	}
	
	public Aluno(String nome, double mediaA, double mediaB, double mediaFinal) {
		super(0, nome);
		this.mediaA = mediaA;
		this.mediaB = mediaB;
		this.mediaFinal = mediaFinal;
		this.responsavel = new Responsavel();
	}
	
	public Aluno(int ID, String nome, double mediaA, double mediaB, double mediaFinal) {
		super(ID, nome);
		this.mediaA = mediaA;
		this.mediaB = mediaB;
		this.mediaFinal = mediaFinal;
		this.responsavel = new Responsavel();
	}
	@Override
	public String toString() {
		return "Aluno [mediaA=" + mediaA + ", mediaB=" + mediaB + ", mediaFinal=" + mediaFinal + ", responsavel="
				+ responsavel + ", getID()=" + getID() + ", getNome()=" + getNome() + "]";
	}
	public Responsavel getResponsavel() {
		return responsavel;
	}
	public void setResponsavel(Responsavel responsavel) {
		this.responsavel = responsavel;
	}
	
	public int getIDResponsavel() {
		return responsavel.getID();
	}
	public void setIDResponsavel(int ID) {
		responsavel.setID(ID);
	}
		
	}
	

