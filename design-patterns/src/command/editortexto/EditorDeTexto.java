package command.editortexto;

public class EditorDeTexto {
    private String texto = "";
    private String digitadoPorUltimo;

    public void digitar(String texto){
        this.texto += texto;
        System.out.println(this.texto);
    }

    public void apagarTexto(String textoParaRemover) {
        if (this.texto.endsWith(textoParaRemover)){
            int inicio = this.texto.length() - textoParaRemover.length();
            this.texto = this.texto.substring(0,inicio);
        }
        System.out.println(this.texto);
    }

    public String getTexto(){
        return texto;
    }
}
