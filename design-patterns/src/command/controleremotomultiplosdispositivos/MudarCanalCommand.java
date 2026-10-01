package command.controleremotomultiplosdispositivos;

public class MudarCanalCommand implements Command{
    private TV tv;
    private int canal;

    public MudarCanalCommand(TV tv) {
        this.tv = tv;
    }

    @Override
    public void executar() {
        tv.mudarCanal();
    }

    @Override
    public void desfazer() {
        tv.voltarCanal();
    }
}
