package commands;

import cmd.AbstractCommand;
import cmd.ActionResult;
import cmd.CmdArgs;
import cmd.CmdType;
import collection.HumanSet;
import exceptions.ValidException;

import java.lang.reflect.InvocationTargetException;

public class AddIfMin extends AbstractCommand {
    private HumanSet humanSet;
    public AddIfMin(HumanSet humanSet){
        super("add_if_min", "добавить новый элемент в коллекцию, если его значение меньше, чем у наименьшего элемента этой коллекции (сравнение по impact speed)", CmdType.COMPLEX_ARG);
        this.humanSet = humanSet;
    }
    @Override
    public ActionResult action(CmdArgs args) {
        try{
            humanSet.addIfMin(humanSet.getHumanDirector().buildHuman(args.getArgs()));
            return new ActionResult(true, "element added to collection");
        } catch (InvocationTargetException | IllegalAccessException | ValidException e){
            return new ActionResult(false, e.toString());
        }
    }
}

