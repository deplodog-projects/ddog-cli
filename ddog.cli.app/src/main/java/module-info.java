module ddog.cli.app {
    requires ddog.cli.core;
    requires jcommander;
    opens com.deplodog.ddog.app to jcommander;
}
