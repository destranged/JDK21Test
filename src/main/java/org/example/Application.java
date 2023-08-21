package org.example;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.StructuredTaskScope;
import java.util.function.Supplier;
import org.example.types.Response;

class Application {
     Response handle() throws ExecutionException, InterruptedException {
         System.out.println(Thread.currentThread().threadId()+" handle");
        try (var scope = new StructuredTaskScope.ShutdownOnFailure()) {
            Supplier<String> user  = scope.fork(() -> findUser());       // (1)
            Supplier <Integer> order = scope.fork(() -> fetchOrder());    // (2)
            scope.join().throwIfFailed();  // Wait for both forks
            return new Response(user.get(), order.get());
        }
    }

    String findUser() throws IllegalAccessException {
         System.out.println(Thread.currentThread().threadId()+ " findUser");
         DBAccess dbAccess = new DBAccess();
         return dbAccess.open();
    }

    Integer fetchOrder() {
        System.out.println(Thread.currentThread().threadId()+ " fetchOrder");
        return 100;
    }
}