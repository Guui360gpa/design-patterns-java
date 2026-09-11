package observer.estacaometeorologica;

public interface Subject {

    void inscrever(Observer observer);
    void desinscrever(Observer observer);
    void notificarObserver();
}
