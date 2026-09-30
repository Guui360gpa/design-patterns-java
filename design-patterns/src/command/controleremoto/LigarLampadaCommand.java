package command.controleremoto;

public class LigarLampadaCommand implements Command{
    private Lampada lampada;

    public LigarLampadaCommand(Lampada lampada) {
        this.lampada = lampada;
    }

    @Override
    public void executar() {
        lampada.ligar();
    }

    @Override
    public void desfazer() {
        lampada.desligar();
    }
}
