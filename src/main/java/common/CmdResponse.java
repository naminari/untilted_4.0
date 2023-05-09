package common;

import cmd.ActionResult;

public class CmdResponse implements Response {
    private final ActionResult actionResult;

    public CmdResponse(ActionResult actionResult) {
        this.actionResult = actionResult;
    }

    public ActionResult getActionResult() {
        return actionResult;
    }
}
