package commands;

import cmd.AbstractCommand;
import cmd.ActionResult;
import cmd.CmdArgs;
import cmd.CmdType;
import collection.HumanSet;

import java.io.FileNotFoundException;

public class FilterByImpactSpeed extends AbstractCommand {
    HumanSet humanSet;
    public FilterByImpactSpeed(HumanSet humanSet){
        super("filter_by_impact_speed", " вывести элементы, значение поля impactSpeed которых равно заданному", CmdType.SIMPLE_ARG);
        this.humanSet = humanSet;
    }
    @Override
    public ActionResult action(CmdArgs args) throws FileNotFoundException {
        String res = humanSet.filterByImpactSpeed(args.getArgs()[0]);
        return new ActionResult(true, res);
    }
}
