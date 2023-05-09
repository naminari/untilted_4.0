package commands;

import builders.BuildChecker;
import cmd.AbstractCommand;
import cmd.ActionResult;
import cmd.CmdArgs;
import cmd.CmdType;
import collection.HumanSet;
import exceptions.ValidException;
import humans.HumanBeing;

import java.lang.reflect.InvocationTargetException;
import java.util.UUID;

public class Update extends AbstractCommand {
    private HumanSet humanSet;

    public Update(HumanSet humanSet) {
        super("update", "обновить значение элемента коллекции, id которого равен заданному", CmdType.SIMPLE_ARG);
        this.humanSet = humanSet;
    }

    @Override
    public ActionResult action(CmdArgs args) throws ValidException, InvocationTargetException, IllegalAccessException {
        if (BuildChecker.checkId(args.getArgs()[0])) {
            for (HumanBeing humanBeing : humanSet.getCollection()) {
                if (humanBeing.getId().toString().equals(args.getArgs()[0])) {
                    HumanBeing human = humanSet.getHumanDirector().buildHuman();
                    human.setId(UUID.fromString(args.getArgs()[0]));
                    return new ActionResult(true, "element of collection been update");
                } else {
                    return new ActionResult(false, "no such element");
                }
            }
        }
        return new ActionResult(false, "Uncorrected UUID input");
    }
}