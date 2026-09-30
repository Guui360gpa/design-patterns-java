package command.controleremoto;

public class Lampada {
    private String comodo;

    public Lampada(String comodo) {
        this.comodo = comodo;
    }

    public void ligar(){
        System.out.println("Lâmpada da " + comodo + " ligada.");
    }

    public void desligar(){
        System.out.println("Lâmpada da " + comodo + " desligada.");
    }
}
