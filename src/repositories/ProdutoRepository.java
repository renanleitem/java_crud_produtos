package repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import entities.Produto;
import factories.ConnectionFactory;

//classe para realizar operações no banco de dados
//com a entidade produto
public class ProdutoRepository {

	// método para realizar o cadastro de um produto no banco de dados
	public void create(Produto produto) throws Exception {

		ConnectionFactory connectionFactory = new ConnectionFactory();
		Connection connection = connectionFactory.getConnection();

		// executar o comando SQL no banco de dados
		PreparedStatement statement = connection
				.prepareStatement("insert into produto(nome, descricao, preco, quantidade) values(?,?,?,?)");
		statement.setString(1, produto.getNome());
		statement.setString(2, produto.getDescricao());
		statement.setDouble(3, produto.getPreco());
		statement.setInt(4, produto.getQuantidade());
		statement.execute();

		// fechando a conexão com o banco de dados
		connection.close();
	}
	
	// método para realizar a atualização de um produto no banco de dados
	public void update(Produto produto) throws Exception {
		
		//abrindo conexão com o banco de dados
		ConnectionFactory connectionFactory = new ConnectionFactory();
		Connection connection = connectionFactory.getConnection();
		
		//escrever o comando SQL para atualizar um produto
		PreparedStatement statement = connection
				.prepareStatement("update produto set nome=?, descricao=?, preco=?, quantidade=? where id=?");
		statement.setString(1, produto.getNome());
		statement.setString(2, produto.getDescricao());
		statement.setDouble(3, produto.getPreco());
		statement.setInt(4, produto.getQuantidade());
		statement.setInt(5, produto.getId());
		statement.execute();
		
		//fechando a conexão
		connection.close();
	}
	
	// método para realizar a exclusão de um produto no banco de dados
	public void delete(Integer id) throws Exception {
		
		//abrindo conexão com o banco de dados
		ConnectionFactory connectionFactory = new ConnectionFactory();
		Connection connection = connectionFactory.getConnection();
		
		//escrever o comando SQL para excluir um produto
		PreparedStatement statement = connection
				.prepareStatement("delete from produto where id=?");
		statement.setInt(1, id);
		statement.execute();
		
		//fechando a conexão
		connection.close();
	}
	
	// método para consultar e retornar todos os produtos cadastrados no banco de dados
	public List<Produto> findAll() throws Exception {
		
		//abrindo conexão com o banco de dados
		ConnectionFactory connectionFactory = new ConnectionFactory();
		Connection connection = connectionFactory.getConnection();
		
		//escrever o comando SQL para consultar os produtos
		PreparedStatement statement = connection
				.prepareStatement("select * from produto order by id");
		//executando e capturando o retorno da consulta
		ResultSet resultSet = statement.executeQuery();
		
		//declarando uma lista de produtos
		List<Produto> lista = new ArrayList<Produto>();
		
		//percorrendo cada registro (linha) obtido na consulta
		while(resultSet.next()) {
			
			//capturar os dados do produto obtido do banco de dados
			Produto produto = new Produto();
			
			produto.setId(resultSet.getInt("id"));
			produto.setNome(resultSet.getString("nome"));
			produto.setDescricao(resultSet.getString("descricao"));
			produto.setPreco(resultSet.getDouble("preco"));
			produto.setQuantidade(resultSet.getInt("quantidade"));
			
			//adicionando o produto na lista
			lista.add(produto);
		}
		
		//fechando a conexão
		connection.close();
		
		//retornando a lista
		return lista;
	}
	
	// método para consultar 1 produto através do id
	public Produto findById(Integer id) throws Exception {
		
		//abrindo conexão com o banco de dados
		ConnectionFactory connectionFactory = new ConnectionFactory();
		Connection connection = connectionFactory.getConnection();
		
		//executando uma instrução SQL no banco de dados
		PreparedStatement statement = connection
				.prepareStatement("select * from produto where id=?");
		statement.setInt(1, id);
		ResultSet resultSet = statement.executeQuery();
		
		//criando um objeto Produto vazio
		Produto produto = null;
		
		//verificar se algum produto foi encontrado no banco de dados
		if(resultSet.next()) {
			
			//instanciando o objeto produto
			produto = new Produto();
			
			produto.setId(resultSet.getInt("id"));
			produto.setNome(resultSet.getString("nome"));
			produto.setDescricao(resultSet.getString("descricao"));
			produto.setPreco(resultSet.getDouble("preco"));
			produto.setQuantidade(resultSet.getInt("quantidade"));
		}
		
		//fechando a conexão
		connection.close();
		
		//retornando o produto
		return produto;
	}
	
}



















