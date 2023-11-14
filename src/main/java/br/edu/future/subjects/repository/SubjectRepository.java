package br.edu.future.subjects.repository;

import br.edu.future.subjects.domain.Subject;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SubjectRepository extends MongoRepository<Subject, String>{

    @Query("{'IdSubject':?0}")
    List<Subject> findByNumberSubject(String IdSubject);

}
