package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertyHandler {

    protected static Properties prop = new Properties();

    public static final String platform ;

    public static final String browser ;

    static {
        try {
            PropertyHandler.loadPropertyFile();
            platform = getProperty("platform");
            browser = getProperty("browser");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void loadPropertyFile() throws IOException {
        InputStream input = new FileInputStream(String.join(File.separator,System.getProperty("user.dir") ,"src","main","resources","configuration.properties"));
        prop.load(input);
    }

    public static String getProperty(String key){
        return prop.getProperty(key);
    }

//    public static String getPlatform(){
//        return getProperty("platform");
//    }
//
//    public static String getBrowser(){
//        return getProperty("browser");
//    }

}
