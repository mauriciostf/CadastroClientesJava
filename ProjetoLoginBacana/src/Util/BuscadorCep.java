package Util ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.JSONArray;
import org.json.JSONObject;
import java.io.BufferedReader;
import java.io.IOException;

public class BuscadorCep {

    static String webService = "http://viacep.com.br/ws/";  //Endere�?§o viacep
    static String webremnant = "/json";                     //tipo de retorno
    static int codigoSucesso = 200;                         //C�?³digo Sucesso conex�?£o

    public static void encontraCep(String cep) {

        //Montagem da URL de chamada
        String urlChamada = webService + cep + webremnant;
        String dados = "";
        String jsonEmString = "";

        try {

            //Objeto para instanciar uma URL
            URL url = new URL(urlChamada);

            //Realiza a conex�?£o com o site
            HttpURLConnection conexao = (HttpURLConnection) url.openConnection();

            //Se a conex�?£o for bem sucedida, segue o processamento normalmente.
            //Caso contr�?¡rio, exibe a informa�?§�?£o do tipo de problema de conex�?£o. 0
            if (conexao.getResponseCode() != codigoSucesso) {
                throw new RuntimeException("Erro conex�?£o!" + conexao.getResponseMessage());
            }

            BufferedReader resposta = new BufferedReader(new InputStreamReader(conexao.getInputStream()));
            //Streaming: tecnologia de transmiss�?£o de dados pela internet
            //BufferReader: classe que realiza a armazenagem destes dados, em um ponteiro para posterior opera�?§�?£o
            //InputStreamReader: classe para realizar a leitura destes valores vindos do servidor (json, video)
            //getInputStream: retorna as informa�?§�?µes enviadas pelo servidor

            //Transformar o arquivo json em um arquivo de dados String
            while ((dados = resposta.readLine()) != null) {
                jsonEmString += dados;
            }

            System.out.println("String Json: " + jsonEmString);
                      
            //Transformar um json
            JSONObject obj = new JSONObject(jsonEmString);
            System.out.println(obj);
            
            String estado = obj.getString("estado").toString();
            System.out.println("Estado: "+ estado);
            
            String cidade = obj.getString("localidade").toString(); 
            System.out.println("Cidade: " + cidade);
            
            String rua = obj.getString("logradouro").toString(); 
            System.out.println("Rua: " + rua);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}