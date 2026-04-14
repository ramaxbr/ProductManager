import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class GerenciadorProdutos{
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

     Produto buscarProduto(){
         System.out.println("Digite o nome do produto que deseja selecionar.");
         String buscarNome = sc.nextLine();
        for(Produto buscar : listarProduto) {
            if (buscar.getNome().toLowerCase().contains(buscarNome.toLowerCase())) {
                System.out.println("Produto encontrado.");
                return buscar;
            }
        }
        System.out.println("Nome não encontrado.");
        return null;
    }

    void atualizarProduto() {
     Scanner sc = new Scanner(System.in);
     int opcaoUsuario = 0;
     boolean rodar = true;
     while (rodar) {
         System.out.println("========Sistema para atualização========");
         System.out.println("O que deseja mudar?:");
         System.out.println("1- Nome.");
         System.out.println("2- Preço.");
         System.out.println("3- Quantidade.");
         opcaoUsuario = sc.nextInt();
         sc.nextLine();

         switch (opcaoUsuario) {
             case 1:
                 atualizarNome();
                 rodar = false;
                 break;
             case 2:
                 atualizarPreco();
                 rodar = false;
                 break;
             case 3:
                 atualizarQuantidade();
                 rodar = false;
                 break;
         }
     }
 }

    void atualizarNome(){
         Produto nomeAntigo = buscarProduto();
        if (nomeAntigo != null) {
            System.out.println("Digite o novo nome: ");
            String novoNome = sc.nextLine();
            nomeAntigo.nome = novoNome;
            System.out.println("Nome atualizado com sucesso!");
        }
     }

        void atualizarPreco(){
            Produto nomeAntigo = buscarProduto();
            double novoPreco;
            if(nomeAntigo  != null) {
                while (true) {
                    try {
                        System.out.println("Digite o preço.");
                        novoPreco = sc.nextDouble();
                        sc.nextLine();
                        if (novoPreco <= 0) {
                            System.out.println("O preço não pode ser zerado!");
                            continue;
                        }
                        break;
                    } catch (InputMismatchException error) {
                        System.out.println("Valor invalido, utilize por exemplo: '1,0'");
                        sc.nextLine();
                    }
                }
                nomeAntigo.preco = novoPreco;
                System.out.println("Preço atualizado com sucesso!");
            }
        }

        void atualizarQuantidade(){
         Produto nomeAntigo = buscarProduto();
         int novaQtd;
         if(nomeAntigo != null){
             while (true) {
                 try {
                     System.out.println("Digite a quantidade.");
                     novaQtd = sc.nextInt();
                     sc.nextLine();
                     if (novaQtd <= 0) {
                         System.out.println("A quantidade não pode ser zerada!");
                         continue;
                     }
                     break;
                 }catch (Exception error){
                     System.out.println("O valor é inválido.");
                     sc.nextLine();
                 }
             }
             nomeAntigo.quantidade = novaQtd;
             System.out.println("Quantidade atualizada com sucesso!");
         }
     }

    void deletarProduto(){
        listarProduto();
         Produto nomeProduto = buscarProduto();

         if(nomeProduto != null){
            listarProduto.remove(nomeProduto);
            System.out.println("Produto deletado com sucesso!");
         }
     }
}




