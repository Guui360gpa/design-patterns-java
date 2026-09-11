package observer.estacaometeorologica;

import java.util.ArrayList;
import java.util.List;

public class EstacaoMeteorologica implements Subject{

    private double temperatura;
    private List<Observer> observers = new ArrayList<>();

    @Override
    public void inscrever(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void desinscrever(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notificarObserver() {
        for (Observer observer : observers){
            observer.atualizar(temperatura);
        }
    }

    public void setTemperatura(double novaTemperatura){
        System.out.println("\n!Nova leitura de temperatura!");
        this.temperatura = novaTemperatura;
        notificarObserver();
    }
}
