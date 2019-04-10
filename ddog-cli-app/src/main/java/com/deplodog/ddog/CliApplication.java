package com.deplodog.ddog;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;
import lombok.Getter;
import lombok.Setter;

public class CliApplication {

    public static void main(String[] args) {
        Config config = new Config();
        JCommander jCommander = JCommander.newBuilder()
                .args(args)
                .addObject(config)
                .build();

        System.out.println(config.getEcho());
    }

    @Getter
    @Setter
    public static class Config {

        @Parameter(names = {"-e"}, description = "Echo.")
        private String echo;

    }
}
