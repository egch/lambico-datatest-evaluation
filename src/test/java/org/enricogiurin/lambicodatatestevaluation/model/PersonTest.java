package org.enricogiurin.lambicodatatestevaluation.model;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.lambico.datatest.json.DataAggregator;

import java.io.InputStream;
import java.util.Collection;

import static org.assertj.core.api.Assertions.assertThat;

public class PersonTest {


    @Test
    public void basicDeserialize() throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        InputStream jsonSource = PersonTest.class.getClassLoader()
                .getResourceAsStream("dataset.json");
        DataAggregator dataAggregator = mapper.readValue(jsonSource, DataAggregator.class);
        Collection<?> objects = dataAggregator.getObjects().get("org.enricogiurin.lambicodatatestevaluation.model.Person");
        Person enrico = (Person) objects.iterator().next();
        assertThat(enrico.getFirstName()).isEqualTo("Enrico");
        assertThat(enrico.getLastName()).isEqualTo("Giurin");
    }
}