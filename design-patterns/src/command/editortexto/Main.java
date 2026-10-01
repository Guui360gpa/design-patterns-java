package command.editortexto;

public class Main {
    public static void main(String[] args) {
        EditorDeTexto editor = new EditorDeTexto();
        HistoricoComandos historico = new HistoricoComandos();

        Command digitarOla = new DigitarCommand(editor, "Olá");
        Command digitarMundo = new DigitarCommand(editor, " mundo");
        Command digitarExclamacao = new DigitarCommand(editor, "!");

        historico.digitar(digitarOla);
        historico.digitar(digitarMundo);
        historico.digitar(digitarExclamacao);

        System.out.println("\n--- Desfazendo ultimo comando ---");
        historico.apagar();

        System.out.println("\n--- Desfazendo de novo ---");
        historico.apagar();

        System.out.println("\n--- Desfazendo de novo ---");
        historico.apagar();

        System.out.println("\n--- Tentando desfazer sem nada no historico ---");
        historico.apagar();
    }
}