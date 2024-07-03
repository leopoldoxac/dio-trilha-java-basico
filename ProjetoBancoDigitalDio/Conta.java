// Abstração: Classe abstrata Conta representa uma conta bancária genérica
public abstract class Conta {
    // Encapsulamento: atributos privados
    private String numero;
    private String titular;
    protected double saldo;

    // Construtor
    public Conta(String numero, String titular) {
        this.numero = numero;
        this.titular = titular;
        this.saldo = 0.0;
    }

    // Encapsulamento: métodos públicos para acessar e modificar atributos privados
    public String getNumero() {
        return numero;
    }

    public String getTitular() {
        return titular;
    }

    public double getSaldo() {
        return saldo;
    }

    // Abstração: métodos abstratos que serão implementados pelas classes filhas
    public abstract void depositar(double valor);
    public abstract boolean sacar(double valor);

    // Método para transferência entre contas
    public boolean transferir(Conta destino, double valor) {
        if (this.sacar(valor)) {
            destino.depositar(valor);
            return true;
        }
        return false;
    }
}

