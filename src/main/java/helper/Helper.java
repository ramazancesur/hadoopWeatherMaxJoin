package helper;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.LinkedList;
import java.util.List;

import org.apache.commons.io.IOUtils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import settings.EnumUtil;
import settings.EnumUtil.OKUMATIPI;

public class Helper {
    private static Helper instance;

    private Helper() {

    }

    public static Helper getInstance() {
        if (instance == null) {
            instance = new Helper();
        }
        return instance;
    }

    public List<String> getSystemUserNameList() {
        List<String> lstMacUser = new LinkedList<String>();

        File actual = new File("/Users/");
        for (File f : actual.listFiles()) {
            if (f.isDirectory()) {
                System.out.println(f.getName());
                lstMacUser.add(f.getName());
            }
        }
        return lstMacUser;
    }


    public String resourceFileOku(String filePath) {
        String result = "";

        ClassLoader classLoader = getClass().getClassLoader();
        try {
            result = IOUtils.toString(classLoader.getResourceAsStream(filePath));
        } catch (IOException e) {
            e.printStackTrace();
        }

        return result;
    }

    public <T> List<T> getData(String serviceUrl, Class<T> clazz, EnumUtil.OKUMATIPI okumaTipi) {
        String jsonStr = "";
        if (okumaTipi == OKUMATIPI.WEB) {
            jsonStr = readWebUrl(serviceUrl);
        } else {
            jsonStr = resourceFileOku(serviceUrl);
        }
        return listEntity(clazz, jsonStr);
    }

    public String readWebUrl(String url) {
        URL uri;
        InputStream is = null;
        BufferedReader br;
        String line;
        StringBuilder sb = new StringBuilder();
        try {
            uri = new URL(url);
            is = uri.openStream(); // throws an IOException
            br = new BufferedReader(new InputStreamReader(is));

            while ((line = br.readLine()) != null) {
                sb.append(line);
            }
        } catch (MalformedURLException mue) {
            mue.printStackTrace();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        } finally {
            try {
                if (is != null)
                    is.close();
            } catch (IOException ioe) {
                // nothing to see here
            }
        }
        return sb.toString();
    }

    private <T> List<T> listEntity(Class<T> clazz, String strJson) {
        List<T> lst = new LinkedList<T>();
        try {
            Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create();


            JsonParser parser = new JsonParser();
            JsonElement jsonElement = parser.parse(strJson);

            if (jsonElement instanceof JsonArray) {
                for (final JsonElement json : jsonElement.getAsJsonArray()) {
                    T entity = gson.fromJson(json, clazz);
                    lst.add(entity);
                }

            } else if (jsonElement instanceof JsonObject) {
                T entity = gson.fromJson(jsonElement, clazz);
                lst.add(entity);
            }
            return lst;

        } catch (Exception e) {
            e.printStackTrace();
            return new LinkedList<T>();
        }

    }

}