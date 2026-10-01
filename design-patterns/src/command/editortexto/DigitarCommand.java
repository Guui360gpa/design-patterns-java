package command.editortexto;

public class DigitarCommand implements Command{

    private EditorDeTexto editorDeTexto;
    private String texto;

    public DigitarCommand(EditorDeTexto editorDeTexto,String texto) {
        this.editorDeTexto = editorDeTexto;
        this.texto = texto;
    }

    @Override
    public void executar() {
        editorDeTexto.digitar(texto);
    }

    @Override
    public void desfazer() {
        editorDeTexto.apagarTexto(texto);
    }
}
