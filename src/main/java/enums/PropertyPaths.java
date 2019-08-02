package enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum PropertyPaths {

    WEB_TEST("/src/test/properties/webtest.properties"),
    NATIVE_TEST("/src/test/properties/nativetest.properties");

    final String prop;

}
