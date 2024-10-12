import DAL.GerenciadorBancoDados;
import DAL.GerenciadorBancoDadosClientes;
import Model.LoginModel;
import java.util.ArrayList;

package Model;


public class CadastroClienteModel {
    public class CadastroUsuarioModel extends LoginModel {

    //Atributos
    private String nomeCliente;
    private String emailCliente;
    private String foneCliente;
    private String Endereco;
    private String cidade;
    private String numeroCasa;
    private String UF;
    

    //Contrutores
    public CadastroClienteModel() {
    }

    // Construtor utilizado para criar um novo registro no banco

        public CadastroUsuarioModel(String nomeCliente, String emailCliente, String foneCliente, String Endereco, String cidade, String numeroCasa, String UF) {
            this.nomeCliente = nomeCliente;
            this.emailCliente = emailCliente;
            this.foneCliente = foneCliente;
            this.Endereco = Endereco;
            this.cidade = cidade;
            this.numeroCasa = numeroCasa;
            this.UF = UF;
        }
    
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
    
}
