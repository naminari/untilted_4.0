package example;

import builders.HumanDirector;
import cmd.CmdHandler;
import collection.HumanSet;
import collection.HumanValidator;
import commands.*;
import exceptions.CmdArgsAmountException;
import exceptions.ExecuteException;
import exceptions.ValidException;
import humans.HumanBeing;
import interacation.InputManager;
import io.XMLFileReader;
import io.XMLFileWriter;

import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.InvocationTargetException;
import java.util.LinkedHashSet;

public class Main {
    public static void main(String... args) throws CmdArgsAmountException, FileNotFoundException, ExecuteException, ValidException, InvocationTargetException, IllegalAccessException {
        String defaultPath = "C:\\Users\\naminari\\Downloads\\lab5\\tester.xml";
        File file = new File(defaultPath);
        XMLFileReader<HumanBeing> reader = new XMLFileReader<>(file, HumanBeing[].class);
        LinkedHashSet<HumanBeing> collection = new LinkedHashSet<>();
        HumanValidator humanValidator = new HumanValidator();
        XMLFileWriter<HumanBeing> writer = new XMLFileWriter<>();
        HumanDirector humanDirector = new HumanDirector(humanValidator);
        HumanSet humanSet = new HumanSet(collection,humanDirector,file,humanValidator,writer);
        CmdHandler cmdHandler = new CmdHandler(); {{
            new Clear(humanSet);
            new CountLessWeapon(humanSet);
            new Exit(humanSet);
            new FilterByImpactSpeed(humanSet);
            new FilterGreaterThanMood(humanSet);
            new Help(cmdHandler);
            new History(cmdHandler);
            new Info(humanSet);
            new RemoveById(humanSet);
            new RemoveLower(humanSet);
            new Save(humanSet);
            new Show(humanSet);
            new Update(humanSet);
            new Add(humanSet);
            new AddIfMin(humanSet);
        }};
        InputManager inputManager = new InputManager(cmdHandler);
        inputManager.run();
    }
}