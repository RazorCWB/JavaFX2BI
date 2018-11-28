package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Conexao.CNXJDBC;
import Entidades.Responsavel;

public class ResponsavelDAO {

	private final String SQL_INSERIR_RESPONSAVEL = "INSERT INTO RESPONSAVEL ("+ "NOME, IDADE)" + "VALUES (?, ?)";
	private final String SQL_ALTERAR_RESPONSAVEL = "UPDATE RESPONSAVEL SET NOME=?, IDADE=? WHERE ID=?;";
	private final String SQL_EXCLUIR_RESPONSAVEL = "DELETE FROM RESPONSAVEL WHERE ID=?";
	private final String SQL_SELECIONAR_RESPONSAVEL = "SELECT *FROM RESPONSAVEL";
	
	private PreparedStatement pst = null;
	
	public boolean inserirResponsavel(Responsavel umResponsavel) {
		boolean ret = false;
		Connection conn = CNXJDBC.conectar();
		try {
			pst = conn.prepareStatement(SQL_INSERIR_RESPONSAVEL);
			pst.setString(1, umResponsavel.getNome());
			pst.setString(2, umResponsavel.getIdade());
			ret = pst.execute();
			CNXJDBC.fecharCNX();
		} catch (SQLException e){
			System.out.println("Erro ao executar o Statement " +e.toString() );
		}
		return ret;
	}
	
	public ArrayList<Responsavel> listarTodosResponsaveis(){
		ArrayList<Responsavel> listaResponsavel = new ArrayList<Responsavel>();
		Connection conn = CNXJDBC.conectar();
		Responsavel umRPS;
		try {
			pst = conn.prepareStatement(SQL_SELECIONAR_RESPONSAVEL);
			ResultSet rs = pst.executeQuery();
			while(rs.next()) {
				umRPS = new Responsavel();
				umRPS.setID(rs.getInt("ID"));
				umRPS.setNome(rs.getString("NOME"));
				umRPS.setIdade(rs.getString("IDADE"));
				listaResponsavel.add(umRPS);
			}
			rs.close();
			pst.close();
			CNXJDBC.fecharCNX();			
		} catch (SQLException e) {
			System.out.println("Erro ao executar o Statement " +e.toString() );
		}
		return listaResponsavel;
	}
	
	public boolean alterarResponsavel(Responsavel umRPS) {
		boolean ret = false;
		Connection conn = CNXJDBC.conectar();
		try {
			pst = conn.prepareStatement(SQL_ALTERAR_RESPONSAVEL);
			pst.setString(1, umRPS.getNome());
			pst.setString(2, umRPS.getIdade());
			pst.setInt(3, umRPS.getID());
			ret = pst.execute();
			pst.close();
			CNXJDBC.fecharCNX();
		} catch (SQLException e){
			System.out.println("Erro ao executar o Statement " +e.toString() );
		}
		return ret;	
	}
	
	public boolean excluirResponsavel(Responsavel umRPS) {
		boolean ret = false;
		Connection conn = CNXJDBC.conectar();
		try {
			pst = conn.prepareStatement(SQL_EXCLUIR_RESPONSAVEL);
			pst.setInt(1, umRPS.getID());
			ret = pst.execute();
			pst.close();
			CNXJDBC.fecharCNX();
		} catch (SQLException e){
			System.out.println("Erro ao executar o Statement " +e.toString() );
		}
		return ret;	
	}
}
