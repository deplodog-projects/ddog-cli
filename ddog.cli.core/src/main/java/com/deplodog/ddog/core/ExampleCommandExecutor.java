package com.deplodog.ddog.core;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;
import com.beust.jcommander.Parameters;
import lombok.Getter;

public class ExampleCommandExecutor {

    public static final String COMMAND_NAME = "echo";

    private final JCommander jCommander;
    private final Config config;
    private final boolean debugEnabled;

    public ExampleCommandExecutor(JCommander jCommander, Config config, boolean debugEnabled) {
        this.jCommander = jCommander;
        this.config = config;
        this.debugEnabled = debugEnabled;
    }

    public void execute() {
        if (config.isHelp()) {
            jCommander.usage(COMMAND_NAME);
        }
        JCommander.getConsole().println(config.getEcho());
    }

    @Getter
    @Parameters(
            commandNames = COMMAND_NAME,
            commandDescription = "Echo example command just for test."
    )
    public static class Config {

        @Parameter(description = "<ECHO TEXT>")
        private String echo;

        @Parameter(names = {"-h", "-help", "--help"}, help = true, description = "Show help description.")
        private boolean help;

    }
}
