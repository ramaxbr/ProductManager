import java.util.Scanner;

public class Main {
    static void main() {
        GerenciadorProdutos g = new GerenciadorProdutos();
        Scanner sc = new Scanner(System.in);

        boolean rodar = true;

        System.out.println("Bem vindo ao sistema de estoque do mercado.");

        while (rodar) {
            System.out.println("========Gerenciador de Produtos========");
            System.out.println("Selecione uma das opções abaixo:");
            System.out.println("1- Cadastrar.");
            System.out.println("2- Listar.");
            System.out.println("3- Atualizar.");
            System.out.println("4- Deletar.");
            System.out.println("0- Finalizar programa.");
             int opcaoMenu = sc.nextInt();
             sc.nextLine();

            switch (opcaoMenu) {
                case 1:
                    g.iniciarCadastro();
                    break;
                case 2:
                    g.listarProduto();
                    break;
                case 3:
                    g.atualizarProduto();
                    break;
                case 4:
                    break;
                case 0:
                    rodar = false;
                    break;
                default:
                    System.out.println("Opção incorreta, tente novamente!");
            }
        }

    }
}
