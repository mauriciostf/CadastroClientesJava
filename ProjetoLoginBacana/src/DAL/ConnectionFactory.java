package DAL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class ConnectionFactory {

    public Connection getConnection() {

        Connection conn = null;
        String className = "org.apache.derby.jdbc.ClientDriver";
        String url = "jdbc:derby://localhost:1527/Assistencia_BD";
        String user = "root";
        String password = "123";

        try {
            Class.forName(className);
            conn = DriverManager.getConnection(url, user, password);
            System.out.println("Conexão realizada com suceso!");
        } catch (Exception e) {
            System.out.println("Erro ao realizar a conexão com banco de dados!");
        }
        return conn;
    }

}
