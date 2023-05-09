package cmd;

import java.lang.reflect.Field;
import java.util.HashMap;

public class CmdArgs {
    private String[] args;
    public HashMap<Field, Object> deconstructedObject;
    public CmdArgs(String... args){
        this.args = args;
    }
    public CmdArgs(HashMap<Field, Object> deconstructedObject){
        this.deconstructedObject = deconstructedObject;
    }
    public String[] getArgs(){
        return args;
    }
    public void  setArgs(String[] args){
        this.args = args;
    }
    public void setDeconstructedObject(HashMap<Field, Object> deconstructedObject){
        this.deconstructedObject = deconstructedObject;
    }
}
