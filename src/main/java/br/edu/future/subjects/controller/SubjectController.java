package br.edu.future.subjects.controller;

import br.edu.future.subjects.domain.dto.SubjectRequest;
import br.edu.future.subjects.domain.dto.SubjectResponse;
import br.edu.future.subjects.service.SubjectService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("v1/subject/")
public class SubjectController {

    @Autowired
    private SubjectService service;

    @PostMapping("insertNewSubject")
    public Object registerSubject(SubjectRequest request){
        return service.createSubject(request);
    }

}
