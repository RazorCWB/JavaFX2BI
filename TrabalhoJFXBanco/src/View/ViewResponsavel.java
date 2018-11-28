package View;


import DAO.ResponsavelDAO;
import Entidades.Responsavel;

public class ViewResponsavel {
	
	ResponsavelDAO bancoResponsavel = new ResponsavelDAO();
	private int ControleID = 0;
	
	public ViewResponsavel() {		
	
	}
		
	public Responsavel inserir(String nome, String idade) {
		
	Responsavel responsavel = new Responsavel();
	

	responsavel.setNome(nome);
	

	responsavel.setIdade(idade);
	
	responsavel.setID(ControleID);
	ControleID++;
	
	return responsavel;
	}
	
}
