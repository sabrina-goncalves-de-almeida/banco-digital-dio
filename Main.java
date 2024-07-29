import java.math.BigDecimal;

public class Main {

    public static void main(String[] args) {
        Cliente anna = new Cliente("Anna", 26, "123.456.789-23");
        Cliente beto = new Cliente();
        beto.setNome("Beto");

        Cartao cDebito = new CartaoDebito();
        Cartao cCredito = new CartaoCredito();

        InterfaceConta corrente = new ContaCorrente(anna);
        Conta poupanca = new ContaPoupanca(beto);



        corrente.depositar(new BigDecimal(10000.0));

        corrente.transferir(new BigDecimal(2500), poupanca);

        poupanca.sacar(new BigDecimal(10));

        corrente.imprimirExtrato();
        System.out.println("");
        poupanca.imprimirExtrato();

        System.out.println("///////////////////////");

        cDebito.setConta(poupanca);
        cCredito.setConta(corrente);

        cCredito.creditar(100.0,3);

        cDebito.debitar(200.0);


        
        cDebito.imprimirFatura();

        System.out.println("");
        cCredito.imprimirFatura();


        cCredito.pagarFatura(66.66, 2);
        System.out.println("");
        cCredito.imprimirFatura();
    }
    
}
