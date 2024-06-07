package banco.Digital;

import banco.Digital.bd.DatabaseManager;

import java.util.Scanner;

public class Comando {
    int opcao;

     public  void menuEntrada() {

         Scanner scanner = new Scanner(System.in);

         System.out.println("----Bando Digital----");
         System.out.println("1) Entrar \n2) Cadastrar");
         opcao = scanner.nextInt();
         if (opcao == 1){ menulogin();
         }else {menuCadastro();}
        scanner.close();
    }
    public void  menuCadastro(){
        long cpf;
        String nome;
        String senha;
        String email;

        Scanner scanner = new Scanner(System.in);

        System.out.println("----Banco Digital----");
        System.out.println("Digite seu nome: \n");
        nome = scanner.nextLine();
        System.out.println("Digite seu CPF: \n");
        cpf = scanner.nextLong();
        System.out.println("Digite sua senha: \n");
        senha = scanner.nextLine();
        System.out.println("Digite seu e-mail: \n");
        email = scanner.nextLine();

        if(DatabaseManager.cpfExists(cpf)){
            System.out.println("CPF ja cadastrado.");
        }else {DatabaseManager.insert(1, nome, email, senha,cpf,0);}
        scanner.close();
    }
    public void menulogin(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("DIgite seu CPF: \n");
        long cpf = scanner.nextLong();
        if (DatabaseManager.cpfExists(cpf)) {
            System.out.println("Digite a senha: \n");
            String senha = scanner.nextLine();
            if(DatabaseManager.login(cpf, senha)){
                menuMovimentacao();
            }

        } else {
            System.out.println("CPF não cadastrado, tente de novo");
            scanner.close();
            menulogin();
        }
        scanner.close();
    }

    public void menuMovimentacao(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("----Banco Digital----\n");
        System.out.println(" 1) Saldo \n 2)Deposito \n 3)Saque \n DIgite o numero da opção desejada.");
        int op = scanner.nextInt();
        if (op == 1){

        }       }




    }
}
