package br.edu.future.subjects.service.impl;

import br.edu.future.subjects.domain.Subjects;
import br.edu.future.subjects.domain.dto.SubjectRequest;
import br.edu.future.subjects.domain.dto.SubjectResponse;
import br.edu.future.subjects.repository.SubjectRepository;
import br.edu.future.subjects.service.SubjectService;
import br.edu.future.subjects.util.mapper.MapperConfig;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
@Slf4j
public class SubjectServiceImpl implements SubjectService {

    private final MapperConfig mapper;

    private final ModelMapper modelMapper;

    @Autowired
    private SubjectRepository repository;

    @Override
    public List<SubjectResponse> findAll() {
        List<Subjects> subjectsList = repository.findAll();
        return Arrays.asList(modelMapper.map(subjectsList, SubjectResponse[].class));
    }

    @Override
    public SubjectResponse insertSubject(SubjectRequest dto) {
        var prepareSubject = saveSubject(dto);
        var saveSubjectDataBase = this.repository.save(prepareSubject);
        return this.mapper.toResponseSubject(HttpStatus.CREATED, saveSubjectDataBase);
    }

    private Subjects saveSubject(SubjectRequest register){
        return Subjects.builder()
                .idSubject(register.getIdSubject())
                .nameSubject(register.getNameSubject())
                .workload(register.getWorkload())
                .build();
    }


    public SubjectServiceImpl(MapperConfig mapper, org.modelmapper.ModelMapper modelMapper) {
        this.mapper = mapper;
        this.modelMapper = modelMapper;
    }
}
