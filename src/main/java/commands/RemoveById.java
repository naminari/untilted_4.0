package commands;

import cmd.AbstractCommand;
import cmd.ActionResult;
import cmd.CmdArgs;
import cmd.CmdType;
import collection.HumanSet;

public class RemoveById extends AbstractCommand {
    HumanSet humanSet;
    public RemoveById(HumanSet humanSet){
        super("remove_by_id", "удалить элемент из коллекции по его id", CmdType.SIMPLE_ARG);
        this.humanSet = humanSet;
    }
    @Override
    public ActionResult action(CmdArgs args) {
        humanSet.removeById(args.getArgs()[0]);
        return new ActionResult(true, "Successfully deleted element with id " + args.getArgs());
    }
}
