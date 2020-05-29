package SourceClases;

public final class Bot {
    private final String username;
    private final String password;

    public Bot(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}
