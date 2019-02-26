/* Classe para conexão com banco de dados Oracle
 * Data criação: 20/02/2019 - 16:43hs
 * Data alteração: 24/02/2019
 * Autor: Zulu
 */
/*
 * CONEXÃO JAVA COM ORACLE
 */
package application;

import java.sql.*;

public class TestOracle {

    public static void main(String[] args) {
        String sql;

        /*
         *	O driver JDBC do Oracle está disponível no seguinte endereço:
         *	http://www.oracle.com/technetwork/database/features/jdbc/index-091264.html
         */
        // Configuração dos parâmetros de conexão
        String server = "192.168.25.10";
        String port = "1521";
        String database = "xe";

        // Configuração dos parâmetros de autenticação
        String user = "dev";
        String passwd = "senha";

        try {
            String url = "jdbc:oracle:thin:@" + server + ":" + port + ":" + database;

            // Abre-se a conexão com o Banco de Dados
            Connection con;
            con = DriverManager.getConnection(url, user, passwd);

            // Cria-se Statement com base na conexão con
            Statement stmt = con.createStatement();
            
            /*
            // Exemplo: cria-se uma tabela no Banco de Dados de Teste
            sql = "CREATE TABLE `filmes` ("
                    + "`id` INT UNSIGNED NOT NULL AUTO_INCREMENT,"
                    + "`titulo` VARCHAR(80) NOT NULL,"
                    + "`ano` INT UNSIGNED,"
                    + "`diretor` VARCHAR(80),"
                    + "PRIMARY KEY (`id`))"
                    + "CHARACTER SET utf8";
            stmt.executeUpdate(sql);

            // Exemplo: inserindo dados na tabela de filmes
            sql = "INSERT INTO `filmes` (`titulo`, `ano`, `diretor`)"
                    + "VALUES ('The Matrix', 1999, 'Andy Wachowski & Larry Wachowski')";
            stmt.executeUpdate(sql);

            sql = "INSERT INTO `filmes` (`titulo`, `ano`, `diretor`)"
                    + "VALUES ('The Matrix Reloaded', 2003, 'Andy Wachowski & Larry Wachowski')";
            stmt.executeUpdate(sql);

            sql = "INSERT INTO `filmes` (`titulo`, `ano`, `diretor`)"
                    + "VALUES ('The Matrix Revolutions', 2003, 'Andy Wachowski & Larry Wachowski')";
            stmt.executeUpdate(sql);

                Exemplo: excluindo a tabela filmes do Banco de Dados de Teste
                    sql = "DROP TABLE `filmes`";
                    stmt.executeUpdate(sql);            
            
            */
            
            // Exemplo: navegando e exibindo os dados dos filmes
            sql = "SELECT NOME, SOBRENOME, TELEFONE, ENDERECO, IDADE FROM DEV.TB_TESTE ORDER BY NOME"; // WHERE PARTNAME = 'CREATE_MEASUREFOLDER'";

            // Executa-se a consulta dos campos titulo,ano da tabela de filmes
            ResultSet result = stmt.executeQuery(sql);

            String nome, sobrenome, endereco;

            while (result.next()) {
                nome = result.getString("NOME");
                sobrenome = result.getString("SOBRENOME");
                endereco = result.getString("ENDERECO");
    
                System.out.println("NOME: " + nome + " " + sobrenome + " - " + endereco);
            }
            con.close();
//        } catch (Exception e) {
//            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println(e.getErrorCode() + " - " + e.getMessage());

        }
    }
}
