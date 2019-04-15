module ddog.cli.core {
    requires static lombok;
    requires static jsr305;

    requires jcommander;
    opens com.deplodog.ddog.core to jcommander;

    exports com.deplodog.ddog.core;
}
