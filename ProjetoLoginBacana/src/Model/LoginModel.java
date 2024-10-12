
package Model;

import DAL.GerenciadorBancoDados;


public class LoginModel {
    
    //Atributos
    String login;
    private String password;
    
    //Metodos Contrutores
    public LoginModel() {
    }

    public LoginModel(String login, String password) {
        this.login = login;
        this.password = password;
    }

    //Getters e Setter
    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    //Métodos de acesso ao banco de dados
    //Recuperação de informações do banco de dados
    
    public Boolean buscarUserBancoDados(LoginModel user){
        
        Boolean resultado = null;
        String login = user.getLogin();
        String password = user.getPassword();
        GerenciadorBancoDados oper = new GerenciadorBancoDados();
        resultado = oper.verificarLoginSenha(login, password);
        return resultado;
    }
    
    
}
