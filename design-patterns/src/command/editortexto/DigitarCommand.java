package command.editortexto;

public class DigitarCommand implements Command{

    private EditorDeTexto editorDeTexto;
    private String texto;

    public DigitarCommand(EditorDeTexto editorDeTexto) {
        this.editorDeTexto = editorDeTexto;
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
