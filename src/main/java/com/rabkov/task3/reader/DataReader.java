package com.rabkov.task3.reader;

import com.rabkov.task3.exception.SphereException;
import com.rabkov.task3.validator.FileNameValidator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.InvalidPathException;
import java.nio.file.Path;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class DataReader {
    static Logger logger = LogManager.getLogger();
    private static FileNameValidator validator;


    public List<String> readFromFile(String filePath) throws SphereException {
        try {
            if (!validator.validateFile(filePath)){
                logger.info("Reading from the file impossible");
                throw new SphereException("Reading from the file impossible");
            }
            Path path = Path.of(filePath);
            Stream<String> stringStream = Files.lines(path);
            return stringStream.collect(Collectors.toList());

        } catch (InvalidPathException | IOException e) {
            throw new SphereException("Unable to open file: " + filePath, e);
        }
    }
}
