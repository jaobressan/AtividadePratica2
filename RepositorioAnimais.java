import java.util.ArrayList;

class RepositorioAnimais {
    static ArrayList<Animal> animais = new ArrayList<>();

    public static void adicionarAnimal(Animal animal) {
        animais.add(animal);
    }

    public static ArrayList<Animal> getAnimais() {
        return new ArrayList<>(animais);
    }

    public static void removerAnimal(String nome) {
        animais.removeIf(animal -> animal.getNome().equals(nome));
    }

    public static void limparLista() {
        animais.clear();
    }
}