package com.deplodog.ddog.core;

import com.deplodog.ddog.core.impl.EchoServiceImpl;

public class EchoService {

    public static void echo(String e) {
        EchoServiceImpl.echo(e);
    }
}
