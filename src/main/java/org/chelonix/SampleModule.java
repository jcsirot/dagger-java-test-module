package org.chelonix;

import java.util.List;

import io.dagger.client.Client;
import io.dagger.client.Container;
import io.dagger.client.Dagger;
import io.dagger.module.annotation.ModuleFunction;
import io.dagger.module.annotation.ModuleObject;

@ModuleObject(description="A simple test object")
public class SampleModule {

    private Client client;

    public SampleModule() throws Exception {
        this.client = Dagger.connect();
    }

    @ModuleFunction(value="echo", description="Returns a container that echoes whatever string argument is provided")
    public Container containerEcho(String stringArg) {
        return client.container().from("alpine:latest").withExec(List.of("echo", stringArg));
    }

    @ModuleFunction(value="foobar")
    public List<String> arrayOfString() {
        return null;
    }
}
