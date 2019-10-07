package main.java.be.ipeters.ottoz.cpbelcar.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

@Service
public class CarSpecsService {
    private final static Logger log = LoggerFactory.getLogger(CarTypes.class);

    @Value(("${specs.dir}"))
    private String specsPath;

    public String getMissionInfo(String missionName) throws IOException {
        final StringBuilder fileContents = new StringBuilder(2000);
        final InputStream is = this.getClass().getResourceAsStream(specsPath + missionName);
        log.info("getCarInfo");
        try (BufferedReader br = new BufferedReader(new InputStreamReader(is));) {
            String line;
            while ((line = br.readLine()) != null) {
                fileContents.append(line).append("\n");
            }
        }
        return fileContents.toString();
    }
}
