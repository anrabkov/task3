package test.rabkov.task3.util;

import com.rabkov.task3.exception.SphereException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.net.URL;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;

public class Util {

    public String getFilePath(String filePath) {
        URL url = getClass().getClassLoader().getResource(filePath);
        String correctPath = URLDecoder.decode(url.getPath(), StandardCharsets.UTF_8).substring(1);
        File file = new File(correctPath);
        return correctPath;
    }
}
