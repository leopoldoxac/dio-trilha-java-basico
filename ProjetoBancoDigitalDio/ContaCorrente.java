// Herança: ContaCorrente herda de Conta
public class ContaCorrente extends Conta {
    private double limite;

    public ContaCorrente(String numero, String titular, double limite) {
        super(numero, titular);
        this.limite = limite;
    }   

    // Polimorfismo: implementação específica do método depositar
    @Override
    public void depositar(double valor) {
        if (valor > 0) {
            saldo += valor;
        }
    }

    // Polimorfismo: implementação específica do método sacar
    @Override
    public boolean sacar(double valor) {
        if (valor > 0 && valor <= saldo + limite) {
            saldo -= valor;
            return true;
        }
        return false;
    }
}