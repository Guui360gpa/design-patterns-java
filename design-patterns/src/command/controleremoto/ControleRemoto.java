package command.controleremoto;

import java.util.Stack;

public class ControleRemoto {
    private Stack<Command> historico = new Stack<>();

    public void pressionarBotao(Command command){
        command.executar();
        historico.push(command);
    }

    public void desfazerUltimoComando() {
        if (!historico.isEmpty()) {
            Command ultimo = historico.pop();
            ultimo.desfazer();
        }else {
            System.out.println("Nada para desfazer.");
        }
    }
}
