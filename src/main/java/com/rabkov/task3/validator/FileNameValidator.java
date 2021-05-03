package com.rabkov.task3.validator;

import com.rabkov.task3.exception.SphereException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;

public class FileNameValidator {
    static Logger logger = LogManager.getLogger();

    public boolean validateFile(String path) throws SphereException {
        if (path == null) {
            logger.info("The path equal to null");
            return false;
        }
        if (path.isBlank()) {
            logger.info("The name of the path is empty");
            return false;
        }
        File file = new File(path);
        if (!file.exists()) {
            return false;
        }
        return file.exists() && file.length() > 0;
    }
}
