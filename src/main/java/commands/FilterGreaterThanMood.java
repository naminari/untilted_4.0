package commands;

import cmd.AbstractCommand;
import cmd.ActionResult;
import cmd.CmdArgs;
import cmd.CmdType;
import collection.HumanSet;

import java.io.FileNotFoundException;

public class FilterGreaterThanMood extends AbstractCommand {
    private HumanSet humanSet;
    public FilterGreaterThanMood(HumanSet humanSet){
        super("filter_greater_than_mood", "вывести элементы, значение поля mood которых больше заданного", CmdType.SIMPLE_ARG);
        this.humanSet = humanSet;
    }
    @Override
    public ActionResult action(CmdArgs args) throws FileNotFoundException {
        String res = humanSet.filterGreaterThanMood(args.getArgs()[0]);
        return new ActionResult(true, res);
    }
}
