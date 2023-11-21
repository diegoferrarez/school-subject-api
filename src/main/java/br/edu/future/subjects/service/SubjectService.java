package br.edu.future.subjects.service;

import br.edu.future.subjects.domain.dto.SubjectRequest;
import br.edu.future.subjects.domain.dto.SubjectResponse;

import java.util.List;

public interface SubjectService {

    SubjectResponse insertSubject(SubjectRequest request);

    List<SubjectResponse> findAll();
}
