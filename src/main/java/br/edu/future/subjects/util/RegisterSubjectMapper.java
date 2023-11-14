package br.edu.future.subjects.util;

import br.edu.future.subjects.domain.Subject;
import br.edu.future.subjects.domain.dto.SubjectResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class RegisterSubjectMapper {

    private final ObjectMapper mapper;

    @SneakyThrows
    public SubjectResponse toResponse(HttpStatus ok, Subject students) {
        var json = this.mapper.writeValueAsString(students);
        return this.mapper.readValue(json, SubjectResponse.class);
    }
}
