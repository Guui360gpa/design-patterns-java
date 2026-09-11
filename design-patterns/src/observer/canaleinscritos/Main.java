package observer.canaleinscritos;

public class Main {
    static void main(String[] args) {
        Canal canal = new Canal("Descomplica Java");

        Observer obs1 = new Inscrito("João");
        Observer obs2 = new Inscrito("Pedro");
        Observer obs3 = new Inscrito("Maria");

        canal.inscrever(obs1);
        canal.inscrever(obs2);
        canal.inscrever(obs3);

        canal.postarVideo("Design Patterns na prática");

        System.out.println("\n\n");

        canal.desinscrever(obs2);

        canal.postarVideo("Entendendo o padrão Observer");
    }
}
