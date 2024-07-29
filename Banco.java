import java.util.List;

public class Banco {
    private String nome;
    private List<InterfaceConta> contas;
    private List<Cartao> cartoes;


    

    public List<Cartao> getCartoes() {
        return cartoes;
    }

    public List<InterfaceConta> getContas() {
        return contas;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void abrirConta(InterfaceConta conta){
        contas.add(conta);
    }

    public void imprimirClientes(){
        for (InterfaceConta conta : contas) {
            System.out.println(String.format("Cliente: %s",conta.getCliente().getNome()));
        }
    }
}