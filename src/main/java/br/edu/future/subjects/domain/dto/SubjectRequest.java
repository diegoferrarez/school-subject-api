package br.edu.future.subjects.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SubjectRequest {
    private String idSubject;
    private String nameSubject;
    private int workload;
}



