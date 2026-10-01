package command.controleremotomultiplosdispositivos;

public class TV {
    private int canalAtual = 0;
    private int canalAnterior = 0;
    private String comodo;

    public TV(String comodo) {
        this.comodo = comodo;
    }

    public void ligar(){
        System.out.println("TV da " + comodo + " ligada");
    }

    public void desligar() {
        System.out.println("TV da " + comodo + " desligada");
    }

    public void mudarCanal(){
        this.canalAnterior = this.canalAtual;
        this.canalAtual++;
        System.out.println("Mudando para o canal " + this.canalAtual);
    }

    public void voltarCanal(){
        this.canalAtual = this.canalAnterior;
        this.canalAnterior--;
        System.out.println("Voltando para o canal " + canalAtual);
    }


}
