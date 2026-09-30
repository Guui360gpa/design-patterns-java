package command.controleremoto;

public class DesligarLampadaCommand implements Command{
    private Lampada lampada;

    public DesligarLampadaCommand(Lampada lampada) {
        this.lampada = lampada;
    }


    @Override
    public void executar() {
        lampada.desligar();
    }

    @Override
    public void desfazer() {
        lampada.ligar();
    }
}
