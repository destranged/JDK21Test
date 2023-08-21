package org.example.types;

public class Response {

    public String user;
    public int order;
    public Response(String user, int order) {
        this.user = user;
        this.order = order;
    }

    public String toString() {
        return this.user+ " : "+this.order;
    }
}
