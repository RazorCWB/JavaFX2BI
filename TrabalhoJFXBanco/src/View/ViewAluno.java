package View;


import DAO.AlunoDAO;
import Entidades.Aluno;


public class ViewAluno {
	AlunoDAO bancoAluno = new AlunoDAO();

	public ViewAluno() {
		
	}

	public Aluno inserir(String nome, String mediaA, String mediaB) {
		Aluno umAluno = new Aluno();
		
		umAluno.setNome(nome);
	
		umAluno.setMediaA(pedirNumero(mediaA));

		umAluno.setMediaB(pedirNumero(mediaB));
		
		umAluno.setMediaFinal((umAluno.getMediaA() + umAluno.getMediaB()) / 2);
					
		return umAluno;
	}

	
	public double pedirNumero(String pedido) {	
		boolean continuar = true;
		double pos = 0;
		do {
			try {
				pos = Double.parseDouble(pedido);
				if (pos >= 0 & pos <= 10) {
					continuar = false;
				}else {
					System.out.println("Digite um valor válido entre 0 e 10!");
				}
			} catch (Exception e) {
				System.out.println("Valor digitado inválido!!!");
			}
		} while (continuar);
		
		return pos;
	}

}
