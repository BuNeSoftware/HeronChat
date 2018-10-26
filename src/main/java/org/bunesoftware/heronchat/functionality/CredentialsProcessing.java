package org.bunesoftware.heronchat.functionality;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import org.bunesoftware.heronchat.utils.Credentials;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class CredentialsProcessing {

    private final File configFile;
    private final Credentials credentials;

    public CredentialsProcessing() {
        configFile = new File("config.yaml");
        credentials = loadCredentials();
    }

    public Credentials getCredentials() {
        return this.credentials;
    }

    public void writeCredentials(String ip, String username) {
        if (!areCredentialsSame(ip, username)) {
            setNewCredentials(ip, username);
            try (FileWriter fr = new FileWriter(configFile)) {
                fr.write(credentials.toString());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void setNewCredentials(String ip, String username) {
        this.credentials.setIp(ip);
        this.credentials.setUsername(username);
    }

    private Credentials loadCredentials() {
        if (configFile.exists()) {
            ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
            try {
                return mapper.readValue(configFile, Credentials.class);
            } catch (IOException e) {
                throw new IllegalStateException("Cannot load last credentials", e);
            }
        }
        return new Credentials();
    }

    private boolean areCredentialsSame(String ip, String username) {
        String savedIp = credentials.getIp();
        String savedUsername = credentials.getUsername();
        return savedIp.matches(ip) && savedUsername.matches(username);
    }
}