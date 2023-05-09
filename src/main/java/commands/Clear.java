package commands;

import cmd.AbstractCommand;
import cmd.ActionResult;
import cmd.CmdArgs;
import cmd.CmdType;
import collection.HumanSet;

public class Clear extends AbstractCommand {
    private HumanSet humanSet;

    public Clear(HumanSet humanSet){
        super("clear", "очистить коллекцию", CmdType.NO_ARGS);
        this.humanSet = humanSet;
    }

    @Override
    public ActionResult action(CmdArgs args) {
        humanSet.clear();
        return new ActionResult(true, "Successfully cleared collection");
    }
}
