package com.rabkov.task3.reader;

import com.rabkov.task3.exception.SphereException;
import com.rabkov.task3.util.Util;
import com.rabkov.task3.validator.FileNameValidator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.InvalidPathException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class DataReader {
    static Logger logger = LogManager.getLogger();
    private FileNameValidator fileNameValidator;

    public List<String> readFromFile(String filePath) throws SphereException {
        if (filePath == null) {
            logger.info("FilePath equal to null");
            throw new SphereException("FilePath equal to null");
        }
        fileNameValidator = new FileNameValidator();
        Util util = new Util();
        String correctFilePath = util.getFilePath(filePath);
        try {
            if (!fileNameValidator.validateFile(correctFilePath)) {
                logger.info("Reading from the file impossible: " + correctFilePath);
                throw new SphereException("Reading from the file impossible: " + correctFilePath);
            }

            Path path = Paths.get(correctFilePath);

            Stream<String> stringStream = Files.lines(path);
            List<String> list = stringStream.collect(Collectors.toList());
            return list;
        } catch (InvalidPathException | IOException e) {
            throw new SphereException("Unable to open file: " + filePath, e);
        }
    }
}



