package command.controleremotomultiplosdispositivos;

public class LigarTVCommand implements Command{
    private TV tv;

    public LigarTVCommand(TV tv) {
        this.tv = tv;
    }

    @Override
    public void executar() {
        tv.ligar();
    }

    @Override
    public void desfazer() {
        tv.desligar();
    }
}
