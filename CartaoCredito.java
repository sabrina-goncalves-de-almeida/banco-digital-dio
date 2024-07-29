import java.math.BigDecimal;

public class CartaoCredito extends Cartao{

    private BigDecimal valorParcelado;
    private BigDecimal valorTotal;
    private int parcelas;

    CartaoCredito(){
        super();
        this.parcelas = 0;
        this.valorTotal = new BigDecimal(0);
        this.valorParcelado = new BigDecimal(0);
    }


    public int getParcelas() {
        return this.parcelas;
    }

    public BigDecimal getValorTotal() {
        return this.valorTotal;
    }

    public BigDecimal getValorParcelado() {
        return this.valorParcelado;
    }


    @Override
    public void creditar(double valor, int parcelas){
        BigDecimal valorBig = new BigDecimal(valor);
        this.parcelas += parcelas;
        this.juroSimples();
        this.somarValor(valorBig);
        this.parcelar(valor, parcelas);
    }

    private void juroSimples(){
        if(this.parcelas <=3){
            this.valorTotal = this.valorTotal.add(this.valorTotal.multiply(new BigDecimal(0.1)));
        }else if(this.parcelas <=6){
            this.valorTotal = this.valorTotal.add(this.valorTotal.multiply(new BigDecimal(0.3)));
        }else if(this.parcelas >6){
            this.valorTotal = this.valorTotal.add(this.valorTotal.multiply(new BigDecimal(0.6)));
        }

    }

    private void somarValor(BigDecimal valor){
        this.valorTotal=this.valorTotal.add(valor);
    }

    private void parcelar(double valor, int parcelas){
        this.valorParcelado = new BigDecimal(valor/parcelas);
    }

    public void pagarFatura(BigDecimal valor){
        this.parcelas -=1;
        this.valorTotal = this.valorTotal.subtract(valor);
        conta.sacar(valor);
    }

    @Override
    public void pagarFatura(double valor, int numeroDePacelas){
        BigDecimal valorBig = new BigDecimal(valor);
        this.parcelas -= numeroDePacelas;
        this.valorTotal = this.valorTotal.subtract(valorBig);
        conta.sacar(valorBig);
    }

    @Override
    public void imprimirFatura(){
        System.out.println("Cartão Credito: "+ numeroCartao);
        System.out.println(String.format("Valor máximo: %.2f", valor.floatValue()));
        System.out.println(String.format("Divida do cartão: %.2f", this.valorTotal.floatValue()));
        System.out.println("Quantidades de parcelas restante: "+ this.parcelas);
        System.out.println(String.format("Valor da parcela: %.2f", this.valorParcelado.floatValue()));
        conta.imprimirExtrato();
    }
    
}
