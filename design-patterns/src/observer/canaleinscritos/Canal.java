package observer.canaleinscritos;

import java.util.ArrayList;
import java.util.List;

public class Canal implements Subject{

    private String nome;
    private List<Observer> inscritos = new ArrayList<>();

    public Canal(String nome){
        this.nome = nome;
    }

    @Override
    public void inscrever(Observer observer) {
        inscritos.add(observer);
    }

    @Override
    public void desinscrever(Observer observer) {
        inscritos.remove(observer);
    }

    @Override
    public void notificarInscritos(String tituloVideo) {
        for (Observer observer : inscritos){
            observer.atualizar(tituloVideo);
        }
    }

    public void postarVideo(String titulo){
        System.out.printf("\n[%s] postou um novo video: %s",nome,titulo);
        notificarInscritos(titulo);
    }
}
