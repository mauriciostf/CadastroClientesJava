package Controller;

import Model.LoginModel;
import View.TelaAplicacao;
import View.TelaLogin;
import javax.swing.JOptionPane;

public class LoginController {

    public void validaDadosController(String login, String password) {

        Boolean contem = null;
        LoginModel usuario = new LoginModel(login, password);
        contem = usuario.buscarUserBancoDados(usuario);

        if (contem) {

            TelaLogin tela = new TelaLogin();
            tela.setVisible(false);
            TelaAplicacao novaTela = new TelaAplicacao();
            novaTela.setVisible(true);
            

        } else {

            String mensagem = "Usuário e senha não encontrados!";
            JOptionPane.showMessageDialog(null, mensagem);
        }
    }

}
