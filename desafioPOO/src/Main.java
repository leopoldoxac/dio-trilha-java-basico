import java.time.LocalDate;
import java.util.*;

// Classes Conteudo, Curso, Mentoria, Dev e Bootcamp permanecem as mesmas

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static Bootcamp bootcamp;
    private static List<Dev> devs = new ArrayList<>();

    public static void main(String[] args) {
        inicializarBootcamp();
        
        while (true) {
            exibirMenu();
            int opcao = scanner.nextInt();
            scanner.nextLine(); // Consumir a nova linha

            switch (opcao) {
                case 1:
                    criarDev();
                    break;
                case 2:
                    inscreverDevNoBootcamp();
                    break;
                case 3:
                    progredirDev();
                    break;
                case 4:
                    exibirConteudosInscritosDosDev();
                    break;
                case 5:
                    exibirConteudosConcluidosDosDev();
                    break;
                case 6:
                    calcularXPTotalDosDev();
                    break;
                case 0:
                    System.out.println("Saindo do programa. Até logo!");
                    return;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }

    private static void inicializarBootcamp() {
        Curso curso1 = new Curso();
        curso1.setTitulo("Curso Java");
        curso1.setDescricao("Descrição do curso Java");
        curso1.setCargaHoraria(8);

        Curso curso2 = new Curso();
        curso2.setTitulo("Curso JS");
        curso2.setDescricao("Descrição do curso JS");
        curso2.setCargaHoraria(4);

        Mentoria mentoria = new Mentoria();
        mentoria.setTitulo("Mentoria de Java");
        mentoria.setDescricao("Descrição da mentoria Java");
        mentoria.setData(LocalDate.now());

        bootcamp = new Bootcamp();
        bootcamp.setNome("Bootcamp Java Developer");
        bootcamp.setDescricao("Descrição Bootcamp Java Developer");
        bootcamp.getConteudos().add(curso1);
        bootcamp.getConteudos().add(curso2);
        bootcamp.getConteudos().add(mentoria);
    }

    private static void exibirMenu() {
        System.out.println("\n===== Menu =====");
        System.out.println("1. Criar novo Dev");
        System.out.println("2. Inscrever Dev no Bootcamp");
        System.out.println("3. Progredir Dev");
        System.out.println("4. Exibir conteúdos inscritos dos Devs");
        System.out.println("5. Exibir conteúdos concluídos dos Devs");
        System.out.println("6. Calcular XP total dos Devs");
        System.out.println("0. Sair");
        System.out.print("Escolha uma opção: ");
    }

    private static void criarDev() {
        System.out.print("Digite o nome do Dev: ");
        String nome = scanner.nextLine();
        Dev dev = new Dev();
        dev.setNome(nome);
        devs.add(dev);
        System.out.println("Dev " + nome + " criado com sucesso!");
    }

    private static void inscreverDevNoBootcamp() {
        if (devs.isEmpty()) {
            System.out.println("Não há Devs cadastrados. Crie um Dev primeiro.");
            return;
        }

        System.out.println("Selecione o Dev para inscrever no Bootcamp:");
        for (int i = 0; i < devs.size(); i++) {
            System.out.println((i + 1) + ". " + devs.get(i).getNome());
        }

        int escolha = scanner.nextInt();
        scanner.nextLine(); // Consumir a nova linha

        if (escolha > 0 && escolha <= devs.size()) {
            Dev devEscolhido = devs.get(escolha - 1);
            devEscolhido.inscreverBootcamp(bootcamp);
            System.out.println(devEscolhido.getNome() + " inscrito no Bootcamp com sucesso!");
        } else {
            System.out.println("Escolha inválida.");
        }
    }

    private static void progredirDev() {
        if (devs.isEmpty()) {
            System.out.println("Não há Devs cadastrados.");
            return;
        }

        System.out.println("Selecione o Dev para progredir:");
        for (int i = 0; i < devs.size(); i++) {
            System.out.println((i + 1) + ". " + devs.get(i).getNome());
        }

        int escolha = scanner.nextInt();
        scanner.nextLine(); // Consumir a nova linha

        if (escolha > 0 && escolha <= devs.size()) {
            Dev devEscolhido = devs.get(escolha - 1);
            devEscolhido.progredir();
            System.out.println(devEscolhido.getNome() + " progrediu!");
        } else {
            System.out.println("Escolha inválida.");
        }
    }

    private static void exibirConteudosInscritosDosDev() {
        for (Dev dev : devs) {
            System.out.println("Conteúdos Inscritos de " + dev.getNome() + ":");
            for (Conteudo conteudo : dev.getConteudosInscritos()) {
                System.out.println("- " + conteudo.getTitulo());
            }
            System.out.println();
        }
    }

    private static void exibirConteudosConcluidosDosDev() {
        for (Dev dev : devs) {
            System.out.println("Conteúdos Concluídos de " + dev.getNome() + ":");
            for (Conteudo conteudo : dev.getConteudosConcluidos()) {
                System.out.println("- " + conteudo.getTitulo());
            }
            System.out.println();
        }
    }

    private static void calcularXPTotalDosDev() {
        for (Dev dev : devs) {
            System.out.println(dev.getNome() + " - XP Total: " + dev.calcularTotalXp());
        }
    }
}