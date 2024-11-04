package proyecto_edd;

import java.util.concurrent.atomic.AtomicLong;

public class CustomUUIDGenerator {
    private static final AtomicLong counter = new AtomicLong();

    public static String generateUUID() {
        return Long.toHexString(counter.incrementAndGet());
    }
}