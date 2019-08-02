package setup;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import static enums.PropertyPaths.NATIVE_TEST;
import static enums.PropertyPaths.WEB_TEST;

class TestProperties {

    private Properties currentProps = new Properties();

    private Properties getCurrentProps(String testType) throws IOException {

        String propertyPaths;
        switch(testType){
            case "native":
                propertyPaths = NATIVE_TEST.getProp();
                break;
            case "web":
                propertyPaths = WEB_TEST.getProp();
                break;
            default:
                throw new IOException("Unknown input type");
        }

        FileInputStream in = new FileInputStream(System.getProperty("user.dir") + propertyPaths);
        currentProps.load(in);
        in.close();
        return currentProps;
    }

    String getProp(String testType, String propKey) throws IOException {
        if(!currentProps.containsKey(propKey)) {
            currentProps = getCurrentProps(testType);
        }
        // "default" from used to handle the absence of parameter
        return currentProps.getProperty(propKey, null);
    }
}
