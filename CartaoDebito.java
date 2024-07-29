import java.math.BigDecimal;

public class CartaoDebito extends Cartao {

    CartaoDebito(){
        super();
    }
    

    @Override
    public void debitar(double valor){
        conta.sacar(new BigDecimal(valor));
    }

    @Override
    public void imprimirFatura(){
        System.out.println("Cartão Debito: "+ numeroCartao);
        conta.imprimirExtrato();
    }

}
