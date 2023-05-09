package commands;

import cmd.AbstractCommand;
import cmd.ActionResult;
import cmd.CmdArgs;
import cmd.CmdType;
import collection.HumanSet;
import exceptions.ValidException;

import java.io.FileNotFoundException;
import java.lang.reflect.InvocationTargetException;

public class RemoveLower extends AbstractCommand {
    HumanSet humanSet;

    public RemoveLower(HumanSet humanSet) {
        super("remove_lower", "удалить из коллекции все элементы, меньшие, чем заданный", CmdType.COMPLEX_ARG);
        this.humanSet = humanSet;
    }

    @Override
    public ActionResult action(CmdArgs args) throws FileNotFoundException {
        try {
            humanSet.removeLower(humanSet.getHumanDirector().buildHuman(args.getArgs()));
            return new ActionResult(true, "Successfully removed all lower objects");
        } catch (InvocationTargetException | IllegalAccessException | ValidException e) {
            return new ActionResult(false, e.toString());
        }
    }
}