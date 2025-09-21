package edu.ccrm.util;

import java.io.IOException;
import java.io.UncheckedIOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Stream;

public final class RecursiveUtils {


    private RecursiveUtils() {}


    public static long calculateDirectorySize(Path path) throws IOException {
        if (!Files.exists(path)) {
            return 0L;
        }

        try (Stream<Path> walk = Files.walk(path)) {
            return walk
                    .filter(Files::isRegularFile)
                    .mapToLong(p -> {
                        try {
                            return Files.size(p);
                        } catch (IOException e) {
                            // Re-throw IOException from within the lambda as an UncheckedIOException
                            throw new UncheckedIOException("Failed to get size of " + p, e);
                        }
                    })
                    .sum();
        } catch (UncheckedIOException e) {
            // Unwrap and re-throw the original IOException
            throw e.getCause();
        }
    }
}