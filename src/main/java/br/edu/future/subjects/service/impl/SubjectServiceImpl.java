package br.edu.future.subjects.service.impl;

import br.edu.future.subjects.domain.Subject;
import br.edu.future.subjects.domain.dto.SubjectRequest;
import br.edu.future.subjects.repository.SubjectRepository;
import br.edu.future.subjects.service.SubjectService;
import br.edu.future.subjects.util.RegisterSubjectMapper;
import br.edu.future.subjects.util.message.InfoMessages;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class SubjectServiceImpl implements SubjectService {

    private final RegisterSubjectMapper mapper;

    @Autowired
    private SubjectRepository repository;

    @Override
    public Object createSubject(SubjectRequest dto) {
        var checkId = repository.findByNumberSubject(dto.getIdSubject());
        if(checkId.isEmpty()){
            var prepareForDataBase = prepareSubject(dto);
            var registerSubjectDatabase = this.repository.save(prepareForDataBase);
            return this.mapper.toResponse(HttpStatus.CREATED, registerSubjectDatabase);
        } else {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body(InfoMessages.FOUND_NUMBER_REPOSITORY);
        }
    }

    private Subject prepareSubject(SubjectRequest request){
        return Subject.builder()
                .IdSubject(request.getIdSubject())
                .nameSubject(request.getName())
                .workload(request.getWorkload())
                .build();
    }

    public SubjectServiceImpl(RegisterSubjectMapper mapper) {
        this.mapper = mapper;
    }
}
