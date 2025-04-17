package report_portal.fileUtils;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

    @FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
    public class ConfigReader {
        static final Properties appProperties = new Properties();
        static final Properties credentialsProperties = new Properties();
        static final Properties apiProperties = new Properties();

        static final String APP_PROPERTIES_PATH = "src/main/resources/app.properties";
        static final String CREDENTIALS_PROPERTIES_PATH = "src/main/resources/credentials.properties";
        static final String API_PROPERTIES_PATH = "src/main/resources/api.properties";

        static {
            try (FileInputStream appFis = new FileInputStream(APP_PROPERTIES_PATH);
                 FileInputStream credsFis = new FileInputStream(CREDENTIALS_PROPERTIES_PATH);
                 FileInputStream apiFis = new FileInputStream(API_PROPERTIES_PATH)) {

                appProperties.load(appFis);
                credentialsProperties.load(credsFis);
                apiProperties.load(apiFis);

            } catch (IOException e) {
                throw new RuntimeException("Failed to load properties files", e);
            }
        }

        public static String getAppProperty(String key) {
            return appProperties.getProperty(key);
        }

        public static String getCredential(String key) {
            return credentialsProperties.getProperty(key);
        }

        public static String getApiProperty(String key) {
            return apiProperties.getProperty(key);
        }
    }