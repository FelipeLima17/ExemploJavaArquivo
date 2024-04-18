package models;

import java.util.ArrayList;
import java.util.Scanner;

public class Main extends Produto{
    public Main(int id, String nome, double preco, int quantidade) {
		super(id, nome, preco, quantidade);
		// TODO Auto-generated constructor stub
	}

	private static ArrayList<Produto> produtos = new ArrayList<>();
    private static int proximoId = 1;
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean sair = false;
        while (!sair) {
            System.out.println("\nEscolha uma opção:");
            System.out.println("1. Adicionar Produto");
            System.out.println("2. Listar Produtos");
            System.out.println("3. Atualizar Produto");
            System.out.println("4. Deletar Produto");
            System.out.println("5. Sair");

            int opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    adicionarProduto();
                    break;
                case 2:
                    listarProdutos();
                    break;
                case 3:
                    atualizarProduto();
                    break;
                case 4:
                    deletarProduto();
                    break;
                case 5:
                    sair = true;
                    break;
                default:
                    System.out.println("Opção inválida. Por favor, escolha novamente.");
            }
        }
    }

    private static void adicionarProduto() {
        System.out.println("Digite o nome do produto:");
        String nome = scanner.next();
        System.out.println("Digite o preço do produto:");
        double preco = scanner.nextDouble();
        System.out.println("Digite a quantidade do produto:");
        int quantidade = scanner.nextInt();

        Produto produto = new Produto(proximoId++, nome, preco, quantidade);
        produtos.add(produto);

        System.out.println("Produto adicionado com sucesso.");
    }

    private static void listarProdutos() {
        if (produtos.isEmpty()) {
            System.out.println("Nenhum produto cadastrado ainda.");
            return;
        }

        System.out.println("Lista de Produtos:");
        for (Produto produto : produtos) {
            System.out.println(produto);
        }
    }

    private static void atualizarProduto() {
        System.out.println("Digite o ID do produto que deseja atualizar:");
        int id = scanner.nextInt();

        for (Produto produto : produtos) {
            if (produto.getId() == id) {
                System.out.println("Digite o novo preço do produto:");
                double novoPreco = scanner.nextDouble();
                produto.setPreco(novoPreco);

                System.out.println("Digite a nova quantidade do produto:");
                int novaQuantidade = scanner.nextInt();
                produto.setQuantidade(novaQuantidade);

                System.out.println("Produto atualizado com sucesso.");
                return;
            }
        }

        System.out.println("Produto não encontrado.");
    }

    private static void deletarProduto() {
        System.out.println("Digite o ID do produto que deseja deletar:");
        int id = scanner.nextInt();

        for (Produto produto : produtos) {
            if (produto.getId() == id) {
                produtos.remove(produto);
                System.out.println("Produto deletado com sucesso.");
                return;
            }
        }

        System.out.println("Produto não encontrado.");
    }
}