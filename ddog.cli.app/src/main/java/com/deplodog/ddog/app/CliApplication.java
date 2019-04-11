package com.deplodog.ddog.app;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;
import com.deplodog.ddog.core.EchoService;

public class CliApplication {

    public static void main(String[] args) {
        Config config = new Config();
        JCommander jCommander = JCommander.newBuilder()
                .args(args)
                .addObject(config)
                .build();

        EchoService.echo(config.echo);
    }

    public static class Config {

        @Parameter(names = {"-e"}, description = "Echo.")
        private String echo;

    }
}
