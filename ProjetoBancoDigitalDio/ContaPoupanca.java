// Herança: ContaPoupanca herda de Conta
public class ContaPoupanca extends Conta {
    public ContaPoupanca(String numero, String titular) {
        super(numero, titular);
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
        if (valor > 0 && valor <= saldo) {
            saldo -= valor;
            return true;
        }
        return false;
    }
}

