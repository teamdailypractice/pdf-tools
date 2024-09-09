package info.dailypractice.pdfgenerator;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jdk8.Jdk8Module;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PageConfigurationProvider {

    public List<PageConfiguration> getPageConfiguration(String dataFilepath) throws IOException {
        List<PageConfiguration> pageConfigurations = new ArrayList<>();

        String data = Files.readAllLines(Path.of(dataFilepath), StandardCharsets.UTF_8)
                .stream().collect(Collectors.joining("\n"));
        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new Jdk8Module());
        try {
//            PageConfiguration[] configurations = mapper.readValue(data, PageConfiguration[].class);
//            List<Car> cars1 = objectMapper.readValue(jsonArray, new TypeReference<List<Car>>(){});
            List<PageConfiguration> pcs = mapper.readValue(data, new TypeReference<List<PageConfiguration>>() {
            });
            pageConfigurations.addAll(pcs);

        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        return pageConfigurations;
    }
}
