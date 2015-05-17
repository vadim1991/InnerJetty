package com.dassader.command;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by swift-seeker-89717 on 24.04.2015.
 */
public class CommandContainer {

    private Map<String, Command> commandMap;

    private static final String RUN_COMMAND = "run";
    private static final String DELETE_COMMAND = "delete";
    private static final String DOWNLOAD_COMMAND = "download";
    private static final String CLOSE_COMMAND = "close";
    private static final String SHOW_PROCESS_COMMAND = "process";
    private static final String KILL_PROCESS_COMMAND = "kill";

    public CommandContainer() {
        commandMap = new HashMap<String, Command>();
        init();
    }

    private void init() {
        commandMap.put(RUN_COMMAND, new RunFileCommand());
        commandMap.put(DELETE_COMMAND, new DeleteFileCommand());
        commandMap.put(DOWNLOAD_COMMAND, new DownloadCommand());
        commandMap.put(CLOSE_COMMAND, new CloseProcessCommand());
        commandMap.put(SHOW_PROCESS_COMMAND, new ShowProcessCommand());
        commandMap.put(KILL_PROCESS_COMMAND, new KillProcess());
    }

    public Command getCommand(String commandName) {
        Command command = commandMap.get(commandName);
        if (command == null) {
            command = new RunFileCommand();
        }
        return command;
    }

}
