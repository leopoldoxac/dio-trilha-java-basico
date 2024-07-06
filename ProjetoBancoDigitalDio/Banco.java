import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Banco {
    private Map<String, Conta> contas;
    private Scanner scanner;

    public Banco() {
        this.contas = new HashMap<>();
        this.scanner = new Scanner(System.in);
    }

    public void iniciar() {
        boolean executando = true;

        while (executando) {
            exibirMenu();
            int opcao = lerOpcao();

            switch (opcao) {
                case 1:
                    criarConta();
                    break;
                case 2:
                    realizarDeposito();
                    break;
                case 3:
                    realizarSaque();
                    break;
                case 4:
                    realizarTransferencia();
                    break;
                case 5:
                    consultarSaldo();
                    break;
                case 6:
                    executando = false;
                    System.out.println("Obrigado por usar nosso banco. Até logo!");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
        scanner.close();
    }

    private void exibirMenu() {
        System.out.println("\n=== MENU DO BANCO ===");
        System.out.println("1. Criar conta");
        System.out.println("2. Realizar depósito");
        System.out.println("3. Realizar saque");
        System.out.println("4. Realizar transferência");
        System.out.println("5. Consultar saldo");
        System.out.println("6. Sair");
        System.out.print("Escolha uma opção: ");
    }

    private int lerOpcao() {
        return scanner.nextInt();
    }

    private void criarConta() {
        scanner.nextLine(); // Consumir a nova linha
        System.out.print("Digite o número da conta: ");
        String numero = scanner.nextLine();
        System.out.print("Digite o nome do titular: ");
        String titular = scanner.nextLine();
        System.out.print("Tipo de conta (1 - Corrente, 2 - Poupança): ");
        int tipo = scanner.nextInt();
        scanner.nextLine(); // Consumir a nova linha

        Conta novaConta;
        if (tipo == 1) {
            System.out.print("Digite o limite da conta corrente: ");
            double limite = scanner.nextDouble();
            novaConta = new ContaCorrente(numero, titular, limite);
        } else {
            novaConta = new ContaPoupanca(numero, titular);
        }

        contas.put(numero, novaConta);
        System.out.println("Conta criada com sucesso!");
    }

    private void realizarDeposito() {
        scanner.nextLine(); // Consumir a nova linha
        System.out.print("Digite o número da conta: ");
        String numero = scanner.nextLine();
        Conta conta = contas.get(numero);
        if (conta != null) {
            System.out.print("Digite o valor do depósito: ");
            double valor = scanner.nextDouble();
            conta.depositar(valor);
            System.out.println("Depósito realizado com sucesso!");
        } else {
            System.out.println("Conta não encontrada.");
        }
    }

    private void realizarSaque() {
        scanner.nextLine(); // Consumir a nova linha
        System.out.print("Digite o número da conta: ");
        String numero = scanner.nextLine();
        Conta conta = contas.get(numero);
        if (conta != null) {
            System.out.print("Digite o valor do saque: ");
            double valor = scanner.nextDouble();
            if (conta.sacar(valor)) {
                System.out.println("Saque realizado com sucesso!");
            } else {
                System.out.println("Saldo insuficiente ou valor inválido.");
            }
        } else {
            System.out.println("Conta não encontrada.");
        }
    }

    private void realizarTransferencia() {
        scanner.nextLine(); // Consumir a nova linha
        System.out.print("Digite o número da conta de origem: ");
        String numeroOrigem = scanner.nextLine();
        System.out.print("Digite o número da conta de destino: ");
        String numeroDestino = scanner.nextLine();
        
        Conta contaOrigem = contas.get(numeroOrigem);
        Conta contaDestino = contas.get(numeroDestino);
        
        if (contaOrigem != null && contaDestino != null) {
            System.out.print("Digite o valor da transferência: ");
            double valor = scanner.nextDouble();
            if (contaOrigem.transferir(contaDestino, valor)) {
                System.out.println("Transferência realizada com sucesso!");
            } else {
                System.out.println("Saldo insuficiente ou valor inválido.");
            }
        } else {
            System.out.println("Uma ou ambas as contas não foram encontradas.");
        }
    }

    private void consultarSaldo() {
        scanner.nextLine(); // Consumir a nova linha
        System.out.print("Digite o número da conta: ");
        String numero = scanner.nextLine();
        Conta conta = contas.get(numero);
        if (conta != null) {
            System.out.println("Saldo atual: R$" + conta.getSaldo());
        } else {
            System.out.println("Conta não encontrada.");
        }
    }

    public static void main(String[] args) {
        Banco banco = new Banco();
        banco.iniciar();
    }
}