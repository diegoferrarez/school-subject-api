package br.edu.future.subjects.service;

import br.edu.future.subjects.domain.dto.SubjectRequest;
import br.edu.future.subjects.domain.dto.SubjectResponse;

public interface SubjectService {
    Object createSubject(SubjectRequest request);
}
