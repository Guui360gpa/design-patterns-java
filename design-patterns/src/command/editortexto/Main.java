package command.editortexto;

public class Main {
    static void main(String[] args) {
        EditorDeTexto editorDeTexto = new EditorDeTexto();
        Command editor = new DigitarCommand(editorDeTexto);

        HistoricoComandos comandos = new HistoricoComandos();

        comandos.digitar(editor);
        comandos.apagar(editor);
    }
}
