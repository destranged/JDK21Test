package org.example;

class DBAccess {
    String open() throws IllegalAccessException {
        System.out.println(Thread.currentThread().threadId()+ " get principal ");

        var principal = Server.PRINCIPAL.get();                           // (4)
        if (!principal.canOpen()) throw new IllegalAccessException();
        return "connected";
    }
}
