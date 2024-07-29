import java.math.BigDecimal;

public abstract class Cartao {

    private static int SEQUENCIAL = 1111;

    protected int numeroCartao;
    protected BigDecimal valor;
    protected InterfaceConta conta;

    Cartao(){
        this.numeroCartao = SEQUENCIAL++;
        this.valor = new BigDecimal(0);
    }


    public int getNumeroCartao() {
        return numeroCartao;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public BigDecimal setValor(BigDecimal valor) {
        return this.valor = valor;
    }

    public InterfaceConta getConta() {
        return conta;
    }


    public void setConta(InterfaceConta conta) {
        this.conta = conta;
    }
    
    public void debitar(double valor){
        
    }

    public void creditar(double valor, int parcelas){
        
    }

    public void imprimirFatura(){
        
    }

    public void pagarFatura(double valor, int numeroDePacelas){}

}
