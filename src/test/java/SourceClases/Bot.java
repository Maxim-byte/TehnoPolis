package SourceClases;

public final class Bot {
    public final String username;
    public final String password;

    public Bot(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public Bot() {
        this.username = "";
        this.password = "";
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}
