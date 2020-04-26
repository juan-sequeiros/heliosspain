package es.heliosspain.against.covid19.util;

import java.io.*;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class MockUtil {


    private static Logger logger = LogManager.getLogger(MockUtil.class.getName());
    
    public static String readJsonFile(String url){

        JSONParser jsonParser = new JSONParser();
        JSONArray jsonArray = null;
        try (FileReader reader = new FileReader(url))
        {

            Object obj = jsonParser.parse(reader);
            jsonArray = (JSONArray) obj;
            logger.info("JSONArray: " + jsonArray);


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return jsonArray.toJSONString();
    }
}
