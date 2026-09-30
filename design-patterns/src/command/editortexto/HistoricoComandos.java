package command.editortexto;

import java.util.Stack;

public class HistoricoComandos {
    private Stack<Command> historico = new Stack<>();

    public void digitar(Command command){
        command.executar();
        historico.push(command);
    }

    public void apagar(Command command){
        if (!historico.isEmpty()){
            Command ultimo = historico.pop();
            ultimo.desfazer();
            historico.remove(ultimo);
        }else {
            System.out.println("Nada para desfazer");
        }
    }
}
