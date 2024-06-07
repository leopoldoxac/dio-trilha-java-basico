import java.util.Scanner;
import java.util.Locale;

public class ContaTerminal {
    public static void main(String[] args) {

        long numeroConta;
        String agencia;

        float saldo = 0;

        Scanner scanner = new Scanner(System.in).useLocale(Locale.getDefault());

        System.out.println("Digite seu nome completo: ");
        String nomeCliente = scanner.nextLine(); // pega o nome do cliente

        System.out.println("Digite o numero de 10 digitos da sua conta:");
        numeroConta = scanner.nextLong();// pega o valor numerico digitado
        scanner.nextLine();// pula a linha do enter

        String numeroString = Long.toString(numeroConta);// transforma em string o numero da conta
        int quantiaDigitos = numeroString.length();// verifica se foi digitado a quantia certa de caracteres

        // loop para encontrar a quantia certa de digitos
        if (quantiaDigitos != 10) {
            System.out.println("Você digitou " + quantiaDigitos + " digite o numero de 10 digitos da sua conta:");
            numeroConta = scanner.nextLong();
            scanner.nextLine();
        }
        ;

        // pega a agencia do cliente
        System.out.println("Digite o numero da sua agencia no formato xxx-x:");
        agencia = scanner.nextLine();
        // loop para caso não tenha quantia certa de digitos
        int contadorTraço = 0;
        if (agencia.length() != 4) {

            for (int i = 0; i < agencia.length(); i++) {
                if (agencia.charAt(i) == '-') {
                    contadorTraço++;
                }
                ;
            }
            ;

            while (contadorTraço != 1) {
                // verifica a agencia do cliente
                System.out.println("Digite o numero da sua agencia no formato xxx-x:");
                agencia = scanner.nextLine();

                // loop para caso não tenha quantia certa de digitos
                contadorTraço = 0;
                for (int i = 0; i < agencia.length(); i++) {
                    if (agencia.charAt(i) == '-') {
                        contadorTraço++;
                    }
                    ;
                }
                ;
            }
        } else if (agencia.length() == 4) {

            for (int i = 0; i < agencia.length(); i++) {
                if (agencia.charAt(i) == '-') {
                    contadorTraço++;
                }
                ;
            }
            ;

            while (contadorTraço != 1) {
                // verifica a agencia do cliente
                System.out.println("Digite o numero da sua agencia no formato xxx-x:");
                agencia = scanner.nextLine();

                // loop para caso não tenha quantia certa de digitos
                contadorTraço = 0;
                for (int i = 0; i < agencia.length(); i++) {
                    if (agencia.charAt(i) == '-') {
                        contadorTraço++;
                    }
                    ;
                }
                ;
            }
            ;

        }
        ;

        int contadorPonto = 0;

        System.out.println("Digite seu saudo no formato xxxx.xx:\nR$ ");
        saldo = scanner.nextFloat();

        
        System.out.println("Olá " + nomeCliente + ", obrigado por criar uma conta em nosso banco, sua agência é "+ agencia + ", conta "+ numeroConta + "e seu saldo " + saldo + " já está disponível para saque.");
    }
}
