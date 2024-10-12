package Model;

import DAL.GerenciadorBancoDados;
import com.sun.jdi.connect.spi.Connection;
import java.util.ArrayList;
import org.apache.derby.iapi.sql.PreparedStatement;
import org.apache.derby.iapi.sql.ResultSet;

public class CadastroUsuarioModel extends LoginModel {

    //Atributos
    private String username;
    private String email;
    private String perfil;
    private String id;

    //Contrutores
    public CadastroUsuarioModel() {
    }

    // Construtor utilizado para criar um novo registro no banco
    public CadastroUsuarioModel(String username, String email, String perfil, String login, String password) {
        super(login, password);
        this.username = username;
        this.email = email;
        this.perfil = perfil;
    }

    //Criar um construtor para listar os itens do banco de dados
    public CadastroUsuarioModel(String id, String username, String email, String login, String password, String perfil) {
        super(login, password);
        this.username = username;
        this.email = email;
        this.perfil = perfil;
        this.id = id;
    }

  
    
    

    //Getters e Setters
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPerfil() {
        return perfil;
    }

    public void setPerfil(String perfil) {
        this.perfil = perfil;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    //Método para enviar estes dados para o BDb
    public Boolean enviarDadosDbDAL(CadastroUsuarioModel novoUsuario) {

        Boolean sucesso = null;
        GerenciadorBancoDados novoUser = new GerenciadorBancoDados();
        sucesso = novoUser.salvarUsuarioBD(novoUsuario);
        return sucesso;
    }

    //Método para solicitar ao banco de dados TODAS informaões
    public ArrayList<CadastroUsuarioModel> listarDadosBanco() {
        GerenciadorBancoDados oper = new GerenciadorBancoDados();
        return oper.listagemUsuariosBD();
    }

    //Método para solicitar ao banco de dados TODAS informaões
    public ArrayList<CadastroUsuarioModel> filtrarDadosBanco(String nome) {
        GerenciadorBancoDados oper = new GerenciadorBancoDados();
        return oper.filtragemUsuariosBD(nome);
    }

    //Metodo que realizar o envio do ID para que o registro 
    //seja excluido do banco de dados
    public void excluirRegistroBDModel(String id_user) {
        GerenciadorBancoDados op = new GerenciadorBancoDados();
        op.deletarUsuarioBD(id_user);
    }
    
    public void atualizarRegistroBDModel(CadastroUsuarioModel usuarioAtualizado){
        GerenciadorBancoDados op = new GerenciadorBancoDados();
        op.alterarUsuarioBD(usuarioAtualizado);
    }
    
    public void AtualizarSenhaUsuarioModel(CadastroUsuarioModel senhaCadastroUsuarioModel){
    GerenciadorBancoDados oper = new GerenciadorBancoDados();
    oper.alterarSenhaUsuariosBD(senhaCadastroUsuarioModel);
    }
    
    public ArrayList<CadastroUsuarioModel> filtrarUsuarioAtualizarDadosBanco(String id_user){
        GerenciadorBancoDados oper = new GerenciadorBancoDados();
        return oper.filtrarUsuarioAtualizarDadosBanco(id_user);
    }
    } 
    
