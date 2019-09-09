package parameters;

import org.apache.commons.lang3.RandomStringUtils;

public class Configurations {


    public static String
        URL_Dev = "https://dev.zenio.co",
        URL_Dev_API = "https://dev.zenio.co/api",
        URL_Dev_Login = "https://dev.zenio.co/login";

    public static String randomString() {
        return (RandomStringUtils.randomAlphabetic(12));
    }

    public static String email = randomString() + "@gmail.com";
    public static String BodyEmail = ("{\"emails\":" + "[\"" + email + "\"]}");
}
