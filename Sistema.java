import java.util.ArrayList;

public class Sistema {
    public static void executar() {
        int opcao;
        do {
            mostrarMenu();
            opcao = Console.lerInt();
            switch (opcao) {
                case 1:
                    adicionarAnimal();
                    break;
                case 2:
                    listarAnimais();
                    break;
                case 3:
                    removerAnimal();
                    break;
                case 4:
                    mostrarTodosAnimais();
                    break;
                case 0:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida! Por favor, tente novamente.");
            }
        } while (opcao != 0);
    }

    private static void mostrarMenu() {
        System.out.println("\nEscolha a opção para Gerenciamento de Animais:");
        System.out.println("1. Adicionar Animal");
        System.out.println("2. Listar Animais");
        System.out.println("3. Remover Animal");
        System.out.println("4. Mostrar Todos os Animais");
        System.out.println("0. Sair");
    }

    private static void adicionarAnimal() {
        System.out.println("Digite o nome do animal:");
        String nome = Console.lerString();
        System.out.println(" Escolha o tipo de Animal (1-Cachorro, 2-Gato, 3-Coelho): ");
        int especie = Console.lerInt();
        Animal novoAnimal = null;
        switch (especie) {
            case 1:
                novoAnimal = new Cachorro(nome);
                break;
            case 2:
                novoAnimal = new Gato(nome);
                break;
            case 3:
                novoAnimal = new Coelho(nome);
                break;
        }
        RepositorioAnimais.adicionarAnimal(novoAnimal);
        System.out.println("Animal adicionado com sucesso!");
    }


    private static void listarAnimais() {
        ArrayList<Animal> temp = RepositorioAnimais.getAnimais();
        if (temp.size() == 0) {
            System.out.println("Nenhum animal cadastrado.");
        } else {
            for (Animal animal : temp) {
                System.out.println(animal);
            }
        }
    }

    private static void removerAnimal() {
        System.out.println("Digite o nome do animal a ser removido:");
        String nome = Console.lerString();
        RepositorioAnimais.removerAnimal(nome);
        System.out.println("Animal removido com sucesso!");
    }

    private static void mostrarTodosAnimais() {
        System.out.println("Todos os animais cadastrados:");
        listarAnimais();
    }
}