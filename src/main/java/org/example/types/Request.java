package org.example.types;

public class Request {

    private Level level;
    public Request(Level type) {
        this.level = type;
    }

    public boolean isAdmin() {
        return this.level == Level.ADMIN;
    }
}
