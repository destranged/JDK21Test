package org.example;

import org.example.types.Level;
import org.example.types.Request;
import org.example.types.Principal;
import org.example.types.Response;

import java.util.concurrent.ExecutionException;

class Server {
    final static ScopedValue<Principal> PRINCIPAL = ScopedValue.newInstance();

    static void serve(Request request, Response response) {
        Application application = new Application();
        var level     = (request.isAdmin() ? Level.ADMIN : Level.GUEST);
        var principal = new Principal(level);
        System.out.println(Thread.currentThread().threadId()+ " set principal");
        ScopedValue.where(PRINCIPAL, principal)
                .run(() -> {
                    try {
                        System.out.println(application.handle());
                    } catch (ExecutionException e) {
                        throw new RuntimeException(e);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                });
    }
}