package br.edu.future.subjects.util.mapper;

import br.edu.future.subjects.domain.Subjects;
import br.edu.future.subjects.domain.dto.SubjectResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class MapperConfig {

    private final ObjectMapper mapper;
    @SneakyThrows
    public SubjectResponse toResponseSubject(HttpStatus ok, Subjects subject) {
        var json = this.mapper.writeValueAsString(subject);
        return this.mapper.readValue(json, SubjectResponse.class);
    }
}
