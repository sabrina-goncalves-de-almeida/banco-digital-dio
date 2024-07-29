import java.math.BigDecimal;

public abstract class Conta implements  InterfaceConta {

    private static final int AGENCIA_PADRAO = 1;    
    private static int SEQUENCIAL = 1;

    protected int agencia;
    protected int numero;
    protected BigDecimal saldo;
    protected Cliente cliente;
    
    public Conta(Cliente cliente){
        this.agencia = Conta.AGENCIA_PADRAO;
        this.numero = SEQUENCIAL++;
        this.cliente = cliente;
        this.saldo = new BigDecimal(0);
    }

    public int getAgencia() {
        return this.agencia;
    }
    public int getNumero() {
        return this.numero;
    }
    public BigDecimal getSaldo() {
        return this.saldo;
    }
    @Override
    public void sacar(BigDecimal valor) {
        this.saldo=this.saldo.subtract(valor);
    }
    @Override
    public void depositar(BigDecimal valor) {
        this.saldo=this.saldo.add(valor);
    }
    @Override
    public void transferir(BigDecimal valor, InterfaceConta contaDestino) {
        this.sacar(valor);
        contaDestino.depositar(valor);
    }

    protected void imprimirInfosComuns(){
        System.out.println(String.format("Titular: %s", this.cliente.getNome()));
        System.out.println(String.format("Agência: %d", this.agencia));
        System.out.println(String.format("Numero da conta: %d", this.numero));
        System.out.println(String.format("Saldo: %.2f", this.saldo));
    }

    @Override
    public void imprimirExtrato() {

    }

    
    @Override
    public Cliente getCliente(){
        return this.cliente;
    }
    
}
