package commands;

import cmd.AbstractCommand;
import cmd.ActionResult;
import cmd.CmdArgs;
import cmd.CmdType;
import collection.HumanSet;

public class Info extends AbstractCommand {
    private final HumanSet humanSet;
    public Info(HumanSet humanSet){
        super("info", "вывести информацию о коллекции", CmdType.NO_ARGS);

        this.humanSet = humanSet;
    }
    @Override
    public ActionResult action(CmdArgs args) {
        return new ActionResult(true, "This collection's type is a " + humanSet.getCollection().getClass().getName() + ", it contains " + humanSet.getCollection().size() + " elements.");

    }
}
