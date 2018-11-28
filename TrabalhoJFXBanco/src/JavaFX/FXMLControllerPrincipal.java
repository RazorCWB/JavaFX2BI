package JavaFX;

import java.net.URL;
import java.util.ArrayList;
import java.util.Optional;
import java.util.ResourceBundle;

import DAO.AlunoDAO;
import DAO.ResponsavelDAO;
import Entidades.Aluno;
import Entidades.Responsavel;
import View.ViewAluno;
import View.ViewResponsavel;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;



public class FXMLControllerPrincipal implements Initializable {
	
	private ViewAluno viewCadastro = new ViewAluno();;
	AlunoDAO bancoAluno = new AlunoDAO();
    private Aluno alunoSelecionado;
    private ArrayList<Aluno> listaAluno = new ArrayList<>();
    private ArrayList<Aluno> pesquisarAluno = new ArrayList<>();
	private ViewResponsavel viewResponsavel = new ViewResponsavel();
	private ResponsavelDAO bancoResponsavel = new ResponsavelDAO();
	 @FXML
	 private TextField btnNome;

	 @FXML
	 private TextField btnMediaA;

	 @FXML
	 private TextField btnMediaB;
	 
	 @FXML
	 private TextField txtPesquisar;
	 
	 @FXML
	 private TableView<Aluno> idTable;
	    
	 @FXML
	 private TableColumn<?, ?> colunaID;

	 @FXML
	 private TableColumn<?, ?> colunaNome;

	 @FXML
	 private TableColumn<?, ?> colunaMediaA;

	 @FXML
	 private TableColumn<?, ?> colunaMediaB;

	 @FXML
	 private TableColumn<?, ?> colunaMediaFinal;

	 @FXML
	 private Button btnEditar;

	 @FXML
	 private Button btnExcluir;
	 
	 @FXML
	 private Button btnPesquisar;

	 @FXML
	 private TextField TXTPesquisar;
	 
	 @FXML
	 private TextField btnNomeRP;

	 @FXML
	 private TextField btnIdadeRP;

	 @FXML
	 private TableView<Responsavel> idTableRP;

	 @FXML
	 private TableColumn<?, ?> colunaIDRP;
	 
	 @FXML
	 private TableColumn<?, ?> colunaNomeRP;

	 @FXML
	 private TableColumn<?, ?> colunaIdadeRP;

	 @FXML
	 private TableColumn<?, ?> colunaAlunoRP;	 

	 @FXML
	 private TableColumn<?, ?> colunaResponsavelRP;

	 @FXML
	 private Button btnEditarRP;

	 @FXML
	 private Button btnExcluirRP;

	 @FXML
	 private Button btnPesquisarRP;

	 @FXML
	 private TextField TXTFieldRP;
	 
	 public void initialize(URL location, ResourceBundle resources) {
		    colunaID.setCellValueFactory(new PropertyValueFactory<>("ID"));
			colunaNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
			colunaMediaA.setCellValueFactory(new PropertyValueFactory<>("mediaA"));
			colunaMediaB.setCellValueFactory(new PropertyValueFactory<>("mediaB"));
			colunaMediaFinal.setCellValueFactory(new PropertyValueFactory<>("mediaFinal"));	
			refreshTable();

			idTable.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Aluno>() {

				@Override
				public void changed(ObservableValue<? extends Aluno> observable, Aluno oldValue, Aluno newValue) {
					alunoSelecionado = newValue;
				}
				
				
			});	
			
			btnMediaA.textProperty().addListener(new ChangeListener<String>() {
			    @Override
			    public void changed(ObservableValue<? extends String> observable, String oldValue, 
			        String newValue) {
			        if (!newValue.matches("\\d*")) {
			        	btnMediaA.setText(newValue.replaceAll("[^\\d]", ""));
			        }
			    }
			});
			
			btnMediaB.textProperty().addListener(new ChangeListener<String>() {
			    @Override
			    public void changed(ObservableValue<? extends String> observable, String oldValue, 
			        String newValue) {
			        if (!newValue.matches("\\d*")) {
			        	btnMediaB.setText(newValue.replaceAll("[^\\d]", ""));
			        }
			    }
			});
		}
	 
	 @FXML
	 private void inserirAluno(ActionEvent event) {
		 
		Aluno umAluno = viewCadastro.inserir(btnNome.getText(), btnMediaA.getText(), btnMediaB.getText());
		Responsavel responsavel = viewResponsavel.inserir(btnNomeRP.getText(), btnIdadeRP.getText());
		bancoResponsavel.inserirResponsavel(responsavel);
		umAluno.setResponsavel(responsavel);		
		bancoAluno.inserirAluno(umAluno);	
		System.out.println("Aluno Inserido com sucesso");			 
		
		refreshTable();	
		
	 }
	 @FXML
	 private void refreshTable() {
			listaAluno = new AlunoDAO().listarAlunos();
			ObservableList<Aluno> observableList = FXCollections.observableArrayList(listaAluno);
			idTable.setItems(observableList);		
		}
	 @FXML
	 private void deletarAluno() {
			new AlunoDAO().excluirAluno(alunoSelecionado);
			refreshTable();	 
	 }
	 @FXML
	 private void editarAluno() {
		 
		 alunoSelecionado.setNome(btnNome.getText());
		 		
		 double mediaA = Double.parseDouble(btnMediaA.getText());
		 alunoSelecionado.setMediaA(mediaA);
		 
		 double mediaB = Double.parseDouble(btnMediaB.getText());
		 alunoSelecionado.setMediaA(mediaB);
		 
		 alunoSelecionado.setMediaFinal((mediaA + mediaB) / 2);
		 
		 new AlunoDAO().alterarAluno(alunoSelecionado);
		 
		 refreshTable();	
	 }
	 
	 @FXML
	 private  void sair(ActionEvent event ) {
	    	Alert alert = new Alert(AlertType.CONFIRMATION);
	    	alert.setTitle("Sair");
	    	String s ="Voce quer sair mesmo?";
	    	alert.setContentText(s);
	    	
	    	Optional<ButtonType> result = alert.showAndWait();
	    	
	    	if((result.isPresent()) && (result.get() == ButtonType.OK)){
	    		System.exit(0);
	    	}
	    }
	 
	 
	 @FXML
	 private void pesquisar() {
		 
		 AlunoDAO AlunoPesquisar = new AlunoDAO();
		
		 Aluno pesquisar = new Aluno();
		 
		 pesquisar = AlunoPesquisar.pesquisar(TXTPesquisar.getText());
		 
		 pesquisarAluno.add(pesquisar);
		 		 
		 ObservableList<Aluno> observableList = FXCollections.observableArrayList(pesquisar);
		 	 
		 idTable.setItems(observableList);
		 	 
	 }
	 
	
			
}
