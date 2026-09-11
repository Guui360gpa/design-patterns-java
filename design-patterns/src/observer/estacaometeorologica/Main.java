package observer.estacaometeorologica;

public class Main {

    static void main(String[] args) {
        EstacaoMeteorologica estacao = new EstacaoMeteorologica();



        Observer alertas = new AlertaTemperatura();
        Observer display = new PainelDisplay();

        estacao.inscrever(alertas);
        estacao.inscrever(display);

        estacao.setTemperatura(45);

        estacao.desinscrever(alertas);

        System.out.println("\n\n");

        estacao.setTemperatura(23);


    }
}
