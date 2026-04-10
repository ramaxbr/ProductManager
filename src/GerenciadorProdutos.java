import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class GerenciadorProdutos {
    ArrayList<Produto> listarProduto = new ArrayList<>();
    Scanner sc = new Scanner(System.in);

     void iniciarCadastro(){

        while (true) {
            try {
                System.out.println("Digite a quantidade de produtos que deseja incluir.");
                int qtdMenu = sc.nextInt();
                sc.nextLine();
                cadastrarProduto(qtdMenu);

            }catch (Exception error){
                System.out.println("Valor inválido!");
                sc.nextLine();
                continue;
            }
            break;
        }
    }


    void cadastrarProduto(int qtdOpcao){
        String nomeProduto;
        double precoProduto;
        int qtdProduto;
        for (int i = 0; i < qtdOpcao; i++) {
            //Recebe produto.
                System.out.printf("Digite o nome do %s° produto.", i + 1);
                nomeProduto = sc.nextLine();
                //Recebe preço.
            while (true){
            try {
                System.out.println("Digite o preço.");
                precoProduto = sc.nextDouble();
                sc.nextLine();
               if (precoProduto <= 0) {
                   System.out.println("O preço não pode ser zerado!");
                   continue;
               }
                break;
           }catch (InputMismatchException error){
               System.out.println("Valor invalido, utilize por exemplo: '1,0'");
                sc.nextLine();
           }
            }

            //Recebe quantidade.
            while (true) {
                try {
                        System.out.println("Digite a quantidade.");
                        qtdProduto = sc.nextInt();
                        sc.nextLine();
                        if (qtdProduto <= 0) {
                            System.out.println("A quantidade não pode ser zerada!");
                             continue;
                        }
                        break;
                    }catch (Exception error){
                         System.out.println("O valor é inválido.");
                         sc.nextLine();
                    }
            }
            listarProduto.add(new Produto(nomeProduto, precoProduto, qtdProduto));
            System.out.println("Produto cadastrado!");
        }
    }


void listarProduto(){
    for (Produto listar : listarProduto){
        System.out.println(listar);
    }
}

}
