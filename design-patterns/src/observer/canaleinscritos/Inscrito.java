package observer.canaleinscritos;

public class Inscrito implements Observer{

    private String nome;

    public Inscrito(String nome){
        this.nome = nome;
    }

    @Override
    public void atualizar(String tituloVideo) {
        System.out.printf("\n%s recebeu notificação: novo video %s",nome,tituloVideo);
    }
}
