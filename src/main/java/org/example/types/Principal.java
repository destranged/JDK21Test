package org.example.types;

public class Principal {

    private Level level;
    public Principal(Level level) {
        this.level=level;
    }

    public boolean canOpen() {
        return this.level == Level.ADMIN;
    }
}
