package command.controleremotomultiplosdispositivos;

public class DesligarTVCommand implements Command{
    private TV tv;

    public DesligarTVCommand(TV tv) {
        this.tv = tv;
    }

    @Override
    public void executar() {
        tv.desligar();
    }

    @Override
    public void desfazer() {
        tv.ligar();
    }
}
