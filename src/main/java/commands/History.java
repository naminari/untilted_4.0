package commands;

import cmd.*;

import java.util.LinkedList;

public class History extends AbstractCommand {
    private final CmdHandler cmdHandler;
    public History(CmdHandler cmdHandler){
        super("history", "вывести последние 8 команд", CmdType.NO_ARGS);
        this.cmdHandler = cmdHandler;
    }
    public ActionResult action(CmdArgs args){
        LinkedList<Command> cmds = cmdHandler.getCmdHistory();
        StringBuilder str = new StringBuilder();
        for (Command cmd : cmds){
            if (cmd != null){
                str.append(cmd.getName()).append("\n");
            }
        }
        return new ActionResult(true, str.toString());
    }
}
