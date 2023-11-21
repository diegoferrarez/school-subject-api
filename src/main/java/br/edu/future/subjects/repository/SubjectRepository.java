package br.edu.future.subjects.repository;

import br.edu.future.subjects.domain.Subjects;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubjectRepository extends MongoRepository<Subjects, String> {
}
