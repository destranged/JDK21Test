package org.example;

import org.example.types.Level;
import org.example.types.Request;
import org.example.types.Response;

import java.awt.*;

public class Main {

    public static void main(String[] args) {
        Request request = new Request(Level.ADMIN);
        Response response = new Response("hello", 100);
        Server.serve(request, response);
    }

}