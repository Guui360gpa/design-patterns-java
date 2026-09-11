package observer.estacaometeorologica;

public class PainelDisplay implements Observer{
    @Override
    public void atualizar(double temperatura) {
        System.out.printf("\nTEMPERATURA ATUAL (ºC): %.2f",temperatura);
    }
}
