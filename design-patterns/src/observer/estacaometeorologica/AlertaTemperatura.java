package observer.estacaometeorologica;

public class AlertaTemperatura implements Observer{
    @Override
    public void atualizar(double temperatura) {
        if (temperatura > 35.00){
            System.out.println("\n!ALERTA SEVERO! Tempos quentes e secos vindo por aí, se hidratem!");
        } else if (temperatura < 10) {
            System.out.println("\n!ALERTA SEVERO! Tempos frios vindo por aí, saiam de casa com blusa!");
        }
    }
}
