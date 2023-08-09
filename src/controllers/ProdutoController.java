package controllers;

import java.util.List;
import java.util.Scanner;

import entities.Produto;
import repositories.ProdutoRepository;

//camada de controle do projeto
//para realizar as interações 
//com o usuário do sistema
public class ProdutoController {

	// método para executar o cadastro de um produto no sistema
	public void cadastrarProduto() {

		try {
			
			System.out.println("\nCADASTRO DE PRODUTO:\n");
			
			Produto produto = new Produto();
			Scanner scanner = new Scanner(System.in);
			
			System.out.print("NOME DO PRODUTO....: ");
			produto.setNome(scanner.nextLine());
			
			System.out.print("DESCRIÇÃO..........: ");
			produto.setDescricao(scanner.nextLine());
			
			System.out.print("PREÇO..............: ");
			produto.setPreco(Double.parseDouble(scanner.nextLine()));
			
			System.out.print("QUANTIDADE.........: ");
			produto.setQuantidade(Integer.parseInt(scanner.nextLine()));
			
			//Realizar o cadastro do produto no banco de dados
			ProdutoRepository produtoRepository = new ProdutoRepository();
			produtoRepository.create(produto);
			
			System.out.println("\nPRODUTO CADASTRADO COM SUCESSO.");
			
			scanner.close();
		}
		catch(Exception e) {
			System.out.println("\nFALHA AO CADASTRAR PRODUTO: " + e.getMessage());
		}		
	}

	// método para executar a edição de um produto no sistema
	public void atualizarProduto() {

		try {
			
			System.out.println("\nATUALIZAÇÃO DE PRODUTO:\n");			
			Scanner scanner = new Scanner(System.in);
			
			System.out.print("ID DO PRODUTO......: ");
			Integer id = Integer.parseInt(scanner.nextLine());
			
			//pesquisar o produto no banco de dados através do ID
			ProdutoRepository produtoRepository = new ProdutoRepository();
			Produto produto = produtoRepository.findById(id);
			
			//verificar se o produto foi encontrado
			if(produto != null) {
				
				System.out.print("NOME DO PRODUTO....: ");
				produto.setNome(scanner.nextLine());
				
				System.out.print("DESCRIÇÃO..........: ");
				produto.setDescricao(scanner.nextLine());
				
				System.out.print("PREÇO..............: ");
				produto.setPreco(Double.parseDouble(scanner.nextLine()));
				
				System.out.print("QUANTIDADE.........: ");
				produto.setQuantidade(Integer.parseInt(scanner.nextLine()));
				
				//atualizando o produto
				produtoRepository.update(produto);
				
				System.out.println("\nPRODUTO ATUALIZADO COM SUCESSO.");
			}
			else {
				System.out.println("\nPRODUTO NÃO ENCONTRADO.");
			}
			
			scanner.close();
		}
		catch(Exception e) {
			System.out.println("\nFALHA AO ATUALIZAR PRODUTO: " + e.getMessage());
		}		
	}

	// método para executar a exclusão de um produto no sistema
	public void excluirProduto() {

		try {
			
			System.out.println("\nEXCLUSÃO DE PRODUTO:\n");			
			Scanner scanner = new Scanner(System.in);
			
			System.out.print("ID DO PRODUTO......: ");
			Integer id = Integer.parseInt(scanner.nextLine());
			
			//pesquisar o produto no banco de dados através do ID
			ProdutoRepository produtoRepository = new ProdutoRepository();
			Produto produto = produtoRepository.findById(id);
			
			//verificando se o produto foi encontrado
			if(produto != null) {
				
				//excluindo o produto
				produtoRepository.delete(produto.getId());
				
				System.out.println("\nPRODUTO EXCLUÍDO COM SUCESSO.");
			}
			else {
				System.out.println("\nPRODUTO NÃO ENCONTRADO.");
			}
			
			scanner.close();
		}
		catch(Exception e) {
			System.out.println("\nFALHA AO EXCLUIR PRODUTO: " + e.getMessage());
		}		
	}

	// método para executar a consulta dos produtos no sistema
	public void consultarProdutos() {

		try {
			
			System.out.println("\nCONSULTA DE PRODUTOS:\n");
			
			//consultar todos os produtos contidos no banco de dados
			ProdutoRepository produtoRepository = new ProdutoRepository();
			List<Produto> lista = produtoRepository.findAll();
			
			//varrer e imprimir a lista (foreach)
			for(Produto produto : lista) {
				
				System.out.println("ID.........: " + produto.getId());
				System.out.println("NOME.......: " + produto.getNome());
				System.out.println("DESCRIÇÃO..: " + produto.getDescricao());
				System.out.println("PREÇO......: " + produto.getPreco());
				System.out.println("QUANTIDADE.: " + produto.getQuantidade());
				System.out.println("...");
			}
		}
		catch(Exception e){
			System.out.println("\nFALHA AO CONSULTAR PRODUTOS: " + e.getMessage());
		}
	}
}











