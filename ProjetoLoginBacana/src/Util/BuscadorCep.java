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

    static String webService = "http://viacep.com.br/ws/";  //EndereÃ?Â§o viacep
    static String webremnant = "/json";                     //tipo de retorno
    static int codigoSucesso = 200;                         //CÃ?Â³digo Sucesso conexÃ?Â£o

    public static void encontraCep(String cep) {

        //Montagem da URL de chamada
        String urlChamada = webService + cep + webremnant;
        String dados = "";
        String jsonEmString = "";

        try {

            //Objeto para instanciar uma URL
            URL url = new URL(urlChamada);

            //Realiza a conexÃ?Â£o com o site
            HttpURLConnection conexao = (HttpURLConnection) url.openConnection();

            //Se a conexÃ?Â£o for bem sucedida, segue o processamento normalmente.
            //Caso contrÃ?Â¡rio, exibe a informaÃ?Â§Ã?Â£o do tipo de problema de conexÃ?Â£o. 0
            if (conexao.getResponseCode() != codigoSucesso) {
                throw new RuntimeException("Erro conexÃ?Â£o!" + conexao.getResponseMessage());
            }

            BufferedReader resposta = new BufferedReader(new InputStreamReader(conexao.getInputStream()));
            //Streaming: tecnologia de transmissÃ?Â£o de dados pela internet
            //BufferReader: classe que realiza a armazenagem destes dados, em um ponteiro para posterior operaÃ?Â§Ã?Â£o
            //InputStreamReader: classe para realizar a leitura destes valores vindos do servidor (json, video)
            //getInputStream: retorna as informaÃ?Â§Ã?Âµes enviadas pelo servidor

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