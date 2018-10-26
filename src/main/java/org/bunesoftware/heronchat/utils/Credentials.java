package org.bunesoftware.heronchat.utils;

public class Credentials {

    public String ip;
    public String username;

    public Credentials() {
        this.ip = "Enter IP";
        this.username = "Enter username";
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String toString() {
        return "ip: \""+ ip +"\"\n" +
                "username: \""+ username +"\"";
    }
}
