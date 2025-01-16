package org.chelonix;

import java.util.List;

import io.dagger.client.Client;
import io.dagger.client.Container;
import io.dagger.client.Dagger;
import io.dagger.module.annotation.ModuleFunction;
import io.dagger.module.annotation.ModuleObject;

/**
 * A simple test object
 */
@ModuleObject()
public class SampleModule {

    private Client client;

    public SampleModule() throws Exception {
        this.client = Dagger.connect();
    }

    /**
     * Returns a container that echoes whatever string argument is provided
     * 
     * @param stringArg the string to echoed
     */
    @ModuleFunction("echo")
    public Container containerEcho(String stringArg) {
        return client.container().from("alpine:latest").withExec(List.of("echo", stringArg));
    }

    /** 
     * Returns an empty list of strings 
     * 
     * @param size the size of string list
     */
    @ModuleFunction("foobar")
    public List<String> arrayOfString(int size) {
        return List.of();
    }
}
