package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class DAO {
	/** modulo de conexão **/
	// parametros de conexão
	private String driver = "com.mysql.cj.jdbc.Driver";
	private String url = "jdbc:mysql://localhost:3306/dbagenda?useTimeZone=true&serverTimeZone=UTC";
	private String user = "root";
	private String password = "Jade@12345";

	// método de conexão

	private Connection conectar() {
		Connection con = null;
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, user, password);
			return con;
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}

	/** CRUD CREATE **/
	public void inserirContato(JavaBeans contato) {
		String create = "insert into contatos (nome,fone,email) values (?,?,?)";
		try {
			// abrir a conexão com o banco
			Connection con = conectar();
			// preparar a query para a execução no banco de dados
			PreparedStatement pst = con.prepareStatement(create);
			// substituit os parametros(?)pelos conteudos das variaveis javabeans
			pst.setString(1, contato.getNome());
			pst.setString(2, contato.getFone());
			pst.setString(3, contato.getEmail());
			// executar a query
			pst.executeUpdate();
			// encerrar a conexão com o banco
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	//CRUD READ
	public ArrayList<JavaBeans> listarContatos(){
		//criando um objeto para acessar a classe javabeans
		ArrayList<JavaBeans> contatos = new ArrayList<>();
		String read = "select * from contatos order by nome";
		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(read);
			ResultSet rs = pst.executeQuery();
			//o laco abaixo sera executado enquanto houver contatos
			while(rs.next()) {
				//variaveis de apoio que recebem os dados do banco
				String idcontato = rs.getString(1);
				String nome = rs.getString(2);
				String fone = rs.getString(3);
				String email = rs.getString(4);
				//populando o arraylist
				contatos.add(new JavaBeans(idcontato,nome,fone,email));
			}
			con.close();
			return contatos;
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}
	
	//CRUD UPDATE
	//selecionar o contato
	public void selecionarContato(JavaBeans contato) {
		String read2 = "select * from contatos where idcontato = ?";
		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(read2);
			pst.setString(1, contato.getIdcontato());
			ResultSet rs = pst.executeQuery();
			while(rs.next()) {
				//setar as variaveis javabeans
				contato.setIdcontato(rs.getString(1));
				contato.setNome(rs.getString(2));
				contato.setFone(rs.getString(3));
				contato.setEmail(rs.getString(4));
			}
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	//editar o contato
	public void alterarContato(JavaBeans contato) {
		String update = "update contatos set nome=?, fone=?,email=? where idcontato=?";
		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(update);
			pst.setString(1, contato.getNome());
			pst.setString(2, contato.getFone());
			pst.setString(3, contato.getEmail());
			pst.setString(4, contato.getIdcontato());
			pst.executeUpdate();
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	//crud delete
	public void deletarContato(JavaBeans contato) {
		String delete = "delete from contatos where idcontato=?";
		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(delete);
			pst.setString(1, contato.getIdcontato());
			pst.executeUpdate();
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
		
	}

}
