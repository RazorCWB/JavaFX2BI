package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Conexao.CNXJDBC;
import Entidades.Aluno;

public class AlunoDAO {

	private final String SQL_INSERIR_ALUNO = "INSERT INTO ALUNO ("+ "NOME, MEDIAA, MEDIAB, MEDIAFINAL, IDRESPONSAVEL)" + "VALUES (?, ?, ?, ?, ?)";
	private final String SQL_ALTERAR_ALUNO = "UPDATE ALUNO SET NOME=?, MEDIAA=?, MEDIAB=?, MEDIAFINAL=? WHERE ID=?;";
	private final String SQL_EXCLUIR_ALUNO = "DELETE FROM ALUNO WHERE ID=?";
	private final String SQL_SELECIONAR_ALUNO = "SELECT *FROM ALUNO";
	private final String SQL_PESQUISAR_ALUNO = "SELECT DISTINCT * FROM ALUNO WHERE NOME=?";
	
private PreparedStatement pst = null;
	
	public boolean inserirAluno(Aluno umAluno) {
		boolean ret = false;
		Connection conn = CNXJDBC.conectar();
		try {
			pst = conn.prepareStatement(SQL_INSERIR_ALUNO);
			pst.setString(1, umAluno.getNome());
			pst.setDouble(2, umAluno.getMediaA());
			pst.setDouble(3, umAluno.getMediaB());
			pst.setDouble(4, umAluno.getMediaFinal());
			pst.setInt(5, umAluno.getResponsavel().getID());
			ret = pst.execute();
			CNXJDBC.fecharCNX();
		} catch (SQLException e){
			System.out.println("Erro ao executar o Statement " +e.toString() );
		}
		return ret;
	}
	
	public ArrayList<Aluno> listarAlunos(){
		ArrayList<Aluno> listaAluno = new ArrayList<Aluno>();
		Connection conn = CNXJDBC.conectar();
		Aluno umAluno;
		try {
			pst = conn.prepareStatement(SQL_SELECIONAR_ALUNO);
			ResultSet rs = pst.executeQuery();
			while(rs.next()) {
				umAluno = new Aluno();
				umAluno.setID(rs.getInt("ID"));
				umAluno.setNome(rs.getString("NOME"));
				umAluno.setMediaA(rs.getDouble("MEDIAA"));
				umAluno.setMediaB(rs.getDouble("MEDIAB"));
				umAluno.setMediaFinal(rs.getDouble("MEDIAFINAL"));			
				listaAluno.add(umAluno);
			}
			rs.close();
			pst.close();
			CNXJDBC.fecharCNX();			
		} catch (SQLException e) {
			System.out.println("Erro ao executar o Statement " +e.toString() );
		}
		return listaAluno;
	}
	
	public Aluno pesquisar(String pesquisar){
		Connection conn = CNXJDBC.conectar();
		Aluno umAluno = new Aluno();
		try {
			pst = conn.prepareStatement(SQL_PESQUISAR_ALUNO);
			pst.setString(1, pesquisar);
			ResultSet rs = pst.executeQuery();			
			while(rs.next()) {				
				umAluno.setID(rs.getInt("ID"));
				umAluno.setNome(rs.getString("NOME"));
				umAluno.setMediaA(rs.getDouble("MEDIAA"));
				umAluno.setMediaB(rs.getDouble("MEDIAB"));
				umAluno.setMediaFinal(rs.getDouble("MEDIAFINAL"));			
			}
			rs.close();
			pst.close();
			CNXJDBC.fecharCNX();			
		} catch (SQLException e) {
			System.out.println("Erro ao executar o Statement " +e.toString() );
		}
		return umAluno;
	}
	
	public boolean alterarAluno(Aluno umAluno) {
		boolean ret = false;
		Connection conn = CNXJDBC.conectar();
		try {
			pst = conn.prepareStatement(SQL_ALTERAR_ALUNO);
			pst.setString(1, umAluno.getNome());
			pst.setDouble(2, umAluno.getMediaA());
			pst.setDouble(3, umAluno.getMediaB());
			pst.setDouble(4, umAluno.getMediaFinal());
			pst.setInt(5, umAluno.getID());
			ret = pst.execute();
			pst.close();
			CNXJDBC.fecharCNX();
		} catch (SQLException e){
			System.out.println("Erro ao executar o Statement " +e.toString() );
		}
		return ret;	
	}
	
	public boolean excluirAluno(Aluno umAluno) {
		boolean ret = false;
		Connection conn = CNXJDBC.conectar();
		try {
			pst = conn.prepareStatement(SQL_EXCLUIR_ALUNO);
			pst.setInt(1, umAluno.getID());
			ret = pst.execute();
			pst.close();
			CNXJDBC.fecharCNX();
		} catch (SQLException e){
			System.out.println("Erro ao executar o Statement " +e.toString() );
		}
		return ret;	
	}
	
}
