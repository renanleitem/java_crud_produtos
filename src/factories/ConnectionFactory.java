package factories;

import java.sql.Connection;
import java.sql.DriverManager;

/*
 * Classe responsável por gerar as conexões com o banco de dados
 * do PostGreSQL, aqui estamos aplicando o Design Pattern 'Factory Method'
 */
public class ConnectionFactory {

	// atributos
	private String driver = "org.postgresql.Driver";
	private String host = "jdbc:postgresql://localhost:5433/bd_java_projeto04";
	private String user = "postgres";
	private String password = "coti";

	// método para abrir e retornar uma conexão
	// com o banco de dados do PostGreSQL
	public Connection getConnection() throws Exception {
		// carregando o driver para conexão com o banco de dados
		Class.forName(driver);
		// abrindo e retornando uma conexão com o PostGreSQL
		return DriverManager.getConnection(host, user, password);
	}
}
