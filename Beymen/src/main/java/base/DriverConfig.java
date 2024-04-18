package base;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import lombok.Data;
import org.apache.log4j.LogManager;

import java.io.File;
import java.io.IOException;
import java.util.logging.Logger;

@Data
public final class DriverConfig {

    private static DriverConfig instance;
    private boolean chromeHeadless;
    private boolean mobileHeadless;
    private boolean firefoxHeadless;

    private DriverConfig() {
    }

    public static DriverConfig getInstance() {
        if (instance == null) {
            try {
                ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
                instance = mapper.readValue(new File("src/main/resources/driverConfig.yaml"), DriverConfig.class);

            } catch (JsonMappingException e) {
                throw new RuntimeException(e);
            } catch (JsonParseException e) {
                throw new RuntimeException(e);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

            return instance;
        }

    }

