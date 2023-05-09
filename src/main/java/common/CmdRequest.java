package common;

import cmd.CmdArgs;
import cmd.Command;

public class CmdRequest implements Request{
    private Command cmd;
    private CmdArgs cmdArgs;
    public CmdRequest(Command cmd, CmdArgs CmdArgs){
        this.cmd = cmd;
        this.cmdArgs = CmdArgs;
    }
    public void setCmdArgs(CmdArgs cmdArgs){
        this.cmdArgs = cmdArgs;
    }
    public Command getCmd(){
        return cmd;
    }
    public CmdArgs getCmdArgs(){
        return cmdArgs;
    }
}
