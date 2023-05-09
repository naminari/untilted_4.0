package commands;

import cmd.AbstractCommand;
import cmd.ActionResult;
import cmd.CmdArgs;
import cmd.CmdType;
import collection.HumanSet;

import java.io.FileNotFoundException;

public class Save extends AbstractCommand {
    private HumanSet humanSet;
    public Save(HumanSet humanSet){
        super("save", "сохранить коллекцию в файл", CmdType.NO_ARGS);
        this.humanSet = humanSet;
    }
    @Override
    public ActionResult action(CmdArgs args) throws FileNotFoundException {
        humanSet.save(args.getArgs());
        return new ActionResult(true, "Collection been saved into file");
        }
    }
