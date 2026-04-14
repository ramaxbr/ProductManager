public class Produto {
    String nome;
    double preco;
    int quantidade;

    //Método construtor
     Produto (String nome, double preco, int quantidade){
        this.nome = nome;
        this.preco = preco;
        this.quantidade = quantidade;
    }

    @Override
    public String toString() {
         return "Produto: " + nome + " Preço: " + preco + " Quantidade: " + quantidade;
    }

public String getNome(){
         return nome;
    }

}

