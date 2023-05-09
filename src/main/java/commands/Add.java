package commands;

import cmd.AbstractCommand;
import cmd.ActionResult;
import cmd.CmdArgs;
import cmd.CmdType;
import collection.HumanSet;
import exceptions.ValidException;

import java.lang.reflect.InvocationTargetException;

public class Add extends AbstractCommand {
    private HumanSet humanSet;
    public Add(HumanSet humanSet){
        super("add", "добавить новый элемент в коллекцию", CmdType.COMPLEX_ARG);
        this.humanSet = humanSet;
    }
    @Override
    public ActionResult action(CmdArgs args) {
        try{
            humanSet.add(humanSet.getHumanDirector().buildHuman(args.getArgs()));
            return new ActionResult(true, "element added to collection");
        } catch (InvocationTargetException | IllegalAccessException | ValidException e){
            return new ActionResult(false, e.toString());
        }
    }
}
