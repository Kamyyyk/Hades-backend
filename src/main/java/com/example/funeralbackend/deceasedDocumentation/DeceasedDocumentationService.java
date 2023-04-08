package com.example.funeralbackend.deceasedDocumentation;

import com.example.funeralbackend.morgue.errors.MorgueNotFoundException;

import java.util.List;

public class DeceasedDocumentationService {
    private final DeceasedDocumentationRepository documentationRepository;

    public DeceasedDocumentationService(DeceasedDocumentationRepository documentationRepository) {
        this.documentationRepository = documentationRepository;
    }

    public List<DeceasedDocumentation> getAllDocumentation() {
        return documentationRepository.findAll();
    }

    public DeceasedDocumentation getDeceasedDocumentation(Long id) {
        return documentationRepository.findById(id).orElseThrow();
    }


    public void deleteDeceasedDocumentation(Long id) {
        DeceasedDocumentation existedDeceasedDocumentation = getDeceasedDocumentation(id);
        documentationRepository.delete(existedDeceasedDocumentation);
    }
}
