import java.math.BigDecimal;

public interface InterfaceConta {
    
    void sacar(BigDecimal valor);
    void depositar(BigDecimal valor);
    void transferir(BigDecimal valor, InterfaceConta contaDestino);
    void imprimirExtrato();
    Cliente getCliente();
    
}
