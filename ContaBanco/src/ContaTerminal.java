import java.util.Scanner;
import java.util.Locale;

public class ContaTerminal {
    public static void main(String[] args){
        System.out.println("pra commit");
        long numeroConta;
        int menu1 = 0;
        String agencia;
        
        float saldo=0;
        int line = 1 , columns=4;
        String[][] bancoDados = new String[line][columns];//cria a matriz bancoDados
        
        /**Popula a matriz com os titulos */
        bancoDados[0][0]= "|Numero da conta|";bancoDados[0][1]="|Agencia|";bancoDados[0][2]="|Nome do cliente|";bancoDados[0][3]="|Saldo|";
       
        
        Scanner scanner = new Scanner(System.in).useLocale(Locale.getDefault());
        
        if (menu1 == 0) {
            System.out.println("\nDigite:\n(1) Para cadastro da sua conta\n(2)Para acesso a conta.");
            int menu2 = scanner.nextInt();
            scanner.nextLine();//consume a linha deixada anteriormente
            if (menu2==1) {  
                
                System.out.println("Digite seu nome completo: ");
                String nomeCliente = scanner.nextLine(); //pega o nome do cliente


                
                System.out.println("Digite o numero de 10 digitos da sua conta:");
                numeroConta = scanner.nextLong();//pega o valor numerico digitado
                scanner.nextLine();//pula a linha do enter

                String numeroString = Long.toString(numeroConta);//transforma em string o numero da conta
                int quantiaDigitos = numeroString.length();//verifica se foi digitado a quantia certa de caracteres
               
                //loop para encontrar a quantia certa de digitos
                if (quantiaDigitos!=10) {
                    System.out.println("Você digitou "+ quantiaDigitos +" digite o numero de 10 digitos da sua conta:");
                    numeroConta = scanner.nextLong();
                    scanner.nextLine();                
                };

                //verifica a agencia do cliente
                System.out.println("Digite o numero da sua agencia no formato xxx-x:");
                agencia = scanner.nextLine();

                //loop para caso não tenha quantia certa de digitos
                int contadorTraço = 0;
                if (agencia.length()!=4) {

                    for (int i = 0; i < agencia.length(); i++) {
                        if (agencia.charAt(i) == '-') {
                            contadorTraço++;
                        };
                    };
                
                    while (contadorTraço!=1) {
                    //verifica a agencia do cliente
                        System.out.println("Digite o numero da sua agencia no formato xxx-x:");
                        agencia = scanner.nextLine();

                        //loop para caso não tenha quantia certa de digitos
                        contadorTraço = 0;
                        for (int i = 0; i < agencia.length(); i++) {
                            if (agencia.charAt(i) == '-') {
                                contadorTraço++;
                            };
                        };   
                    };
                }else if (agencia.length()==4) {
                    
                    for (int i = 0; i < agencia.length(); i++) {
                        if (agencia.charAt(i) == '-') {
                            contadorTraço++;
                        };
                    };
                
                    while (contadorTraço!=1) {
                    //verifica a agencia do cliente
                        System.out.println("Digite o numero da sua agencia no formato xxx-x:");
                        agencia = scanner.nextLine();

                        //loop para caso não tenha quantia certa de digitos
                        contadorTraço = 0;
                        for (int i = 0; i < agencia.length(); i++) {
                            if (agencia.charAt(i) == '-') {
                                contadorTraço++;
                            };
                        };   
                    };
                
                 };


                //verificação da existencia da mesma conta com mesma agencia no sistema

                for (int i = 0; i < bancoDados.length; i++) {
                    
                    boolean encontradoNumero = false;
                    boolean encontradoAgencia = false;

                    if (bancoDados[i][0] == Long.toString(numeroConta)) {
                        encontradoNumero = true;
                        
                    }else if (encontradoNumero == true) {
                    
                    

                    if (bancoDados[i][1] == Long.toString(numeroConta)) {
                        encontradoAgencia = true;
                        break; // Se encontrado, não é necessário continuar procurando
                    }

                   }
                   if (encontradoNumero=true) {
                        boolean cadastrado = (encontradoNumero && encontradoAgencia);
                        if (cadastrado == false) {
                            
                            
                            int contadorPonto = 0;
                           
                            System.out.println("Digite seu saudo no formato xxxx.xx:\nR$ ");
                                saldo = scanner.nextFloat(); 
                            
                            while (contadorPonto !=1) {
                                //pega o valor do saldo
                                 
                                scanner.nextLine();
                                String saldoString = Float.toString(saldo);

                                for (int j = 0; j < saldoString.length(); j++) {
                                    if (saldoString.charAt(j) == ',') {
                                        contadorPonto++;
                                    };
                                };  
                            };
                            
                            int linha = bancoDados.length+1; 
                            String[][] bancoDados2 = new String[linha][columns]
                            bancoDados2[linha][0]= Long.toString(numeroConta); bancoDados[linha][1]=agencia; bancoDados[linha][2]=nomeCliente; bancoDados[linha][3] = Float.toString(saldo);


                                FileWriter arqMatrix = new FileWriter("Matriz1.txt");
                                 PrintWriter gravarArq = new PrintWriter(arqMatrix);

                                 for (int i = 0; i < n; i++){  
                                   gravarArq.println("[");   
                                   for (int j = 0; j < n; j++){
                                   gravarArq.println(bancoDados2[i][j]);
                                    }
                                    gravarArq.println("]"); 
                                 }gravarArq.println("\n"); 

    arqMatrix.close();
    System.out.println("Foi gerado um arquivo 'Matriz 1.txt' no mesmo local do projeto.\n");
}
                        }
                    
                   }                    
                }
                    
                
                
                


                };
            };

};

}
