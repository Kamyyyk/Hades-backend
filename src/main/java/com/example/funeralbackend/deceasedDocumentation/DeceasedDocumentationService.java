package com.example.funeralbackend.deceasedDocumentation;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Component
public class DeceasedDocumentationService {
    private final DeceasedDocumentationRepository deceasedDocumentationRepository;

    public DeceasedDocumentationService(DeceasedDocumentationRepository documentationRepository) {
        this.deceasedDocumentationRepository = documentationRepository;
    }

    public List<DeceasedDocumentation> getAllDocumentation() {
        return deceasedDocumentationRepository.findAll();
    }

    public DeceasedDocumentation getDeceasedDocumentation(Long id) {
        return deceasedDocumentationRepository.findById(id).orElseThrow();
    }

    public DeceasedDocumentation createDeceasedDocumentation(DeceasedDocumentation deceasedDocumentation) {
        return deceasedDocumentationRepository.save(deceasedDocumentation);
    }

    public DeceasedDocumentation editDeceasedDocumentation(Long id, DeceasedDocumentation deceasedDocumentation) {
        DeceasedDocumentation existedDeceasedDocumentation = getDeceasedDocumentation(id);
        existedDeceasedDocumentation.setName(deceasedDocumentation.getName());
        existedDeceasedDocumentation.setMorgue(deceasedDocumentation.getMorgue());
        return deceasedDocumentationRepository.save(existedDeceasedDocumentation);
    }

    public void deleteDeceasedDocumentation(Long id) {
        DeceasedDocumentation existedDeceasedDocumentation = getDeceasedDocumentation(id);
        deceasedDocumentationRepository.delete(existedDeceasedDocumentation);
    }
}
