package model;

import java.sql.Connection;
import java.sql.DriverManager;

public class DAO {
	/**modulo de conexão**/
	//parametros de conexão
	private String driver = "com.mysql.cj.jdbc.Driver";
	private String url = "jdbc:mysql://localhost:3306/dbagenda?useTimeZone=true&serverTimeZone=UTC";
	private String user = "root";
	private String password = "Jade@12345";
	
	//método de conexão
	
	private Connection conectar() {
		Connection con = null;
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url,user,password);
			return con;
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}
	//teste de conexão
	public void testeConexao() {
		try {
			Connection con = conectar();
			System.out.println(con);
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
