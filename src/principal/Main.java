package principal;

import java.util.Scanner;

import controllers.ProdutoController;

public class Main {

	public static void main(String[] args) {

		try {
			
			Scanner scanner = new Scanner(System.in);
			
			System.out.println("\nCONTROLE DE PRODUTOS:\n");
			System.out.println("(1) CADASTRAR PRODUTO");
			System.out.println("(2) ATUALIZAR PRODUTO");
			System.out.println("(3) EXCLUIR PRODUTO");
			System.out.println("(4) CONSULTAR PRODUTOS");
			
			System.out.print("\nESCOLHA A OPÇÃO DESEJADA: ");
			Integer opcao = Integer.parseInt(scanner.nextLine());
			
			ProdutoController produtoController = new ProdutoController();
			
			switch(opcao) {
			case 1:
				produtoController.cadastrarProduto();
				break;
				
			case 2:
				produtoController.atualizarProduto();
				break;
				
			case 3:
				produtoController.excluirProduto();
				break;
				
			case 4:
				produtoController.consultarProdutos();
				break;
				
			default: //nenhum dos anteriores
				System.out.println("\nOPÇÃO INVÁLIDA!");
				break;
			}
			
			
			scanner.close();
		}
		catch(Exception e) {
			//imprimindo mensagem de erro
			System.out.println("\nOcorreu um erro: " + e.getMessage());
		}
	}

}
