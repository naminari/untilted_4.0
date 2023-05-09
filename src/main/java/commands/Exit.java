package commands;

import cmd.AbstractCommand;
import cmd.ActionResult;
import cmd.CmdArgs;
import cmd.CmdType;
import collection.HumanSet;

import java.io.FileNotFoundException;

public class Exit extends AbstractCommand {
    HumanSet humanSet;
    public Exit(HumanSet humanSet){
        super("exit", "завершить программу (без сохранения в файл)", CmdType.NO_ARGS);
        this.humanSet = humanSet;
    }
    @Override
    public ActionResult action(CmdArgs args) throws FileNotFoundException {
        humanSet.exit();
        return new ActionResult(true, "exit");
    }
}
