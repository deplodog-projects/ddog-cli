module ddog.cli.app {
    requires static lombok;
    requires static jsr305;

    requires ddog.cli.core;

    requires jcommander;
    opens com.deplodog.ddog.app to jcommander;
}
