package command.controleremoto;

public class Main {
    static void main(String[] args) {
        Lampada lampadaSala = new Lampada("sala");
        Command ligar = new LigarLampadaCommand(lampadaSala);
        Command desligar = new DesligarLampadaCommand(lampadaSala);

        ControleRemoto controleRemoto = new ControleRemoto();

        controleRemoto.pressionarBotao(ligar);
        controleRemoto.pressionarBotao(desligar);

        System.out.println("---Desfazendo último comando---");
        controleRemoto.desfazerUltimoComando();

        System.out.println("---Desfazendo novamente---");
        controleRemoto.desfazerUltimoComando();
    }
}
