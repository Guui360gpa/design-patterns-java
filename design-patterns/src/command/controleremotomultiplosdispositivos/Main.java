package command.controleremotomultiplosdispositivos;

public class Main {
    static void main(String[] args) {
        Lampada lampadaSala = new Lampada("sala");
        TV tvSala = new TV("sala");

        Command ligarLuz = new LigarLampadaCommand(lampadaSala);
        Command desligarLuz = new DesligarLampadaCommand(lampadaSala);
        Command ligarTV = new LigarTVCommand(tvSala);
        Command desligarTV = new DesligarTVCommand(tvSala);
        Command trocarCanal = new MudarCanalCommand(tvSala);

        ControleRemoto controleRemoto = new ControleRemoto();

        controleRemoto.pressionarBotao(ligarLuz);
        controleRemoto.pressionarBotao(ligarTV);

        controleRemoto.pressionarBotao(desligarTV);
        controleRemoto.pressionarBotao(desligarLuz);

        System.out.println("---Desfazendo último comando---");
        controleRemoto.desfazerUltimoComando(desligarLuz);

        System.out.println("---Desfazendo novamente---");
        controleRemoto.desfazerUltimoComando(desligarTV);
    }
}
