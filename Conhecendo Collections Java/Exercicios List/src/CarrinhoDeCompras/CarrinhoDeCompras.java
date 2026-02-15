package CarrinhoDeCompras;

import java.util.ArrayList;
import java.util.List;

public class CarrinhoDeCompras {

    List<Item> listaCompras = new ArrayList<>();

    public void adicionarItem(String nome, double preco, int quantidade){
        if(quantidade <= 0){
            System.out.println("Nenhum item adicionado");
            return;
        } else if (preco <= 0) {
            System.out.println("Valor invalido!");
            return;
        }

        var item = findBy(nome, preco);

        if(item != null){
            var newValue = item.getQuantidade() + quantidade;
            item.setQuantidade(newValue);
            return;
        }
        listaCompras.add(new Item(nome, preco, quantidade));
    }

    public void removerItem(String nome){
        var listTemp = new ArrayList<Item>();

        if(!listaCompras.isEmpty()){
            for(Item s : listaCompras){
                if(s.getNome().equalsIgnoreCase(nome)){
                    listTemp.add(s);
                }
            }
        } else {
            System.out.println("Lista vazia");
            return;
        }

        listaCompras.removeAll(listTemp);
        System.out.println("Item removido com sucesso!");
    }

    public Item findBy(String nome, double preco){
        for(Item i : listaCompras){
            if(i.getNome().equalsIgnoreCase(nome) && i.getPreco() == preco){
                return i;
            }
        }
        return null;
    }

    public void removerQuantidadeItem(Item item, int quantidade){
        if(!(item == null)){
        var newValue = item.getQuantidade() - quantidade;
            if(!(quantidade > item.getQuantidade())){
                if(newValue == 0){
                    removerItem(item.getNome());
                    return;
                }
            }
            item.setQuantidade(newValue);
        }
    }

    public void calcularValorTotal(){
        double result = 0;
        if(!listaCompras.isEmpty()){
            for(Item i : listaCompras){
                result += i.getPreco() * i.getQuantidade();
            }
        }
        System.out.printf("Valor total da compra: %.2f\n", result);
    }

    public void listarCarrinho(){
        System.out.println("========= CARIINHO =========");
        if(!listaCompras.isEmpty()){
            for(Item i : listaCompras)
                System.out.println(i);
        }
        calcularValorTotal();
        System.out.println("============================");
    }



}
