package test.rabkov.task3.util;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.net.URL;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;

public class Util {
    static Logger logger = LogManager.getLogger();

    public String getFilePath(String filePath){
        URL url = getClass().getClassLoader().getResource(filePath);
        String correctPath = URLDecoder.decode(url.getPath(), StandardCharsets.UTF_8);
        return correctPath;
    }
}
