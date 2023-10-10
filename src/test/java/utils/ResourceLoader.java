package utils;

import java.net.URL;
import static org.hamcrest.MatcherAssert.assertThat;

public class ResourceLoader {
    private static ClassLoader getResourceLoader() {
        return Thread.currentThread().getContextClassLoader();
    }

    public static String getPathOfResource(String relativePath) {
        URL fileUrl = getResourceLoader().getResource(relativePath);
        assertThat("The resource cannot be found under the following path: " + relativePath, fileUrl != null);
        return fileUrl.getPath();
    }
}
