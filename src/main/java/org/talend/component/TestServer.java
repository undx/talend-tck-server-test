package org.talend.component;

import lombok.extern.slf4j.Slf4j;
import org.talend.sdk.component.tools.WebServer;

import java.util.ArrayList;
import java.util.Collection;

@Slf4j
public class TestServer {

    private final static Collection<String> serverArguments = new ArrayList<String>();

    public static void main(String[] args) {

        int port = Integer.valueOf(System.getProperty("server.port", "8080"));
        String gavs = System.getProperty("server.gavs", "");
        boolean open = Boolean.valueOf(System.getProperty("server.openbrowser", "true"));

        System.setProperty("talend.component.server.maven.repository", System.getProperty("repository", System.getProperty("user.home") + ".m2/repository"));

        final WebServer webServer = new WebServer(serverArguments, port, log, gavs);
        if (open) {
            webServer.openBrowserWhenReady();
        }
        webServer.run();

    }

}
