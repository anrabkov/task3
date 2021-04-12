package com.rabkov.task3.parser;

import com.rabkov.task3.validator.RegexValidator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class DataParser {
    static  final String SPACE_REGEX = "\\s+";
   static Logger logger = LogManager.getLogger();
   private static RegexValidator regexValidator = new RegexValidator();

   public List<List<Double>> parseString(List<String> stringsFromFile){
       List<List<Double>> listDoubleList = new ArrayList<>();
       for (String string : stringsFromFile){
           if (regexValidator.validateRegex(string)){
               String[] stringArray = string.trim().split(SPACE_REGEX);
               List<Double> doubleList = new ArrayList<>();
               for (String s : stringArray){
                   doubleList.add(Double.parseDouble(s));
               }
               listDoubleList.add(doubleList);
           }
       }
       return listDoubleList;
   }
}
