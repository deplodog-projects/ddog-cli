package com.deplodog.ddog.app;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;
import com.deplodog.ddog.core.ExampleCommandExecutor;
import lombok.Getter;

import java.util.concurrent.atomic.AtomicBoolean;

public class CliApplication {

    private static final String VERSION = "0.0.1-SNAPSHOT";
    private static final String PROGRAM_NAME = "ddog";

    public static void main(String[] args) {
        AtomicBoolean debugEnabled = addExceptionHandler();

        Config config = new Config();
        ExampleCommandExecutor.Config exampleCommandConfig = new ExampleCommandExecutor.Config();

        JCommander jCommander = JCommander.newBuilder()
                .programName(PROGRAM_NAME)
                .args(args)
                .addObject(config)
                .addCommand(ExampleCommandExecutor.COMMAND_NAME, exampleCommandConfig)
                .build();

        debugEnabled.set(config.isDebug());

        if (config.isHelp()) {
            jCommander.usage();
        } else if (config.isVersion()) {
            JCommander.getConsole().println(VERSION);
        } else {
            String command = jCommander.getParsedCommand();
            if (command == null) {
                throw new IllegalArgumentException("Command expected. Use --help for details.");
            }
            switch (command) {
                case ExampleCommandExecutor.COMMAND_NAME:
                    new ExampleCommandExecutor(jCommander, exampleCommandConfig, debugEnabled.get())
                            .execute();
                    break;
                default:
                    throw new IllegalArgumentException("Wrong command. Use --help for details.");
            }
        }
    }

    private static AtomicBoolean addExceptionHandler() {
        AtomicBoolean debugEnabled = new AtomicBoolean();
        Thread.currentThread().setUncaughtExceptionHandler((t, e) -> {
            // print message and exit on any exception
            if (debugEnabled.get()) {
                e.printStackTrace();
            } else {
                System.err.println(e.getMessage());
            }
            System.exit(-1);
        });
        return debugEnabled;
    }

    @Getter
    private static class Config {

        @Parameter(names = {"-h", "-help", "--help"}, help = true, description = "Show help description.")
        private boolean help;

        @Parameter(names = {"-v", "-version", "--version"}, help = true, description = "Show application version.")
        private boolean version;

        @Parameter(names = {"-d", "-debug", "--debug"}, description = "Enable debug output.")
        private boolean debug = false;

    }

}
