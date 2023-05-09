package interacation;

import cmd.*;
import common.Response;
import exceptions.CmdArgsAmountException;
import exceptions.ExecuteException;
import exceptions.ValidException;

import java.io.FileNotFoundException;
import java.lang.reflect.InvocationTargetException;
import java.util.*;

public class InputManager {
    private final CmdHandler cmdHandler;
    private final Scanner scanner = new Scanner(System.in);

    public InputManager(CmdHandler cmdHandler) {
        this.cmdHandler = cmdHandler;
    }

    private String[] getUserInput() {
        String[] input = null;
        while (Objects.isNull(input)) {
            System.out.print("Ведите команду: \n > ");
            String line = null;
            try {
                line = scanner.nextLine().trim();
            } catch (NoSuchElementException e) {
                System.exit(0);
            }
            if (!line.isEmpty()) {
                input = line.split(" ", 2);
            } else {
                System.out.println("Uncorrected input");
            }
        }
        return input;
    }

    public void run() throws CmdArgsAmountException, FileNotFoundException, ValidException, InvocationTargetException, IllegalAccessException, NullPointerException {
        while (true) {
            try {
                String[] args = getUserInput();
                Response result = cmdHandler.executeCmd(args);
                boolean isSuccess = result.getActionResult().isSuccess();
                if (isSuccess) {
                    String message = result.getActionResult().getMessage();
                    System.out.println(message);
                }
            } catch (ExecuteException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}