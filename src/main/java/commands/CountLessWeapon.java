package commands;

import cmd.AbstractCommand;
import cmd.ActionResult;
import cmd.CmdArgs;
import cmd.CmdType;
import collection.HumanSet;

import java.io.FileNotFoundException;

public class CountLessWeapon extends AbstractCommand {
    HumanSet humanSet;
    public CountLessWeapon(HumanSet humanSet){
        super("count_less_than_weapon_type", "вывести количество элементов, значение поля weaponType которых меньше заданного", CmdType.SIMPLE_ARG);
        this.humanSet = humanSet;
    }
    @Override
    public ActionResult action(CmdArgs args) throws FileNotFoundException {
        int res = humanSet.countLessWeapon(args.getArgs()[0]);
        return new ActionResult(true, Integer.toString(res) );
    }
}
