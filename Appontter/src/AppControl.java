import java.util.HashMap;

public class AppControl {
    private HashMap<String, Handler> handlerMap = new HashMap();

    public void handleIt(String command, HashMap<String, Object> data){
        Handler theCommandHandler = handlerMap.get(command);
        if (theCommandHandler != null){
            theCommandHandler.handleIt(data);
        }
    }

    public void mapCommand(String aCommand, Handler apHandler){
        handlerMap.put(aCommand,apHandler);
    }
}
