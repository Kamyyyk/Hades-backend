package com.example.funeralbackend.deceasedDocumentation;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/deceased-documentation")
public class DeceasedDocumentationController {

    private final DeceasedDocumentationService deceasedDocumentationService;

    public DeceasedDocumentationController(DeceasedDocumentationService deceasedDocumentationService) {
        this.deceasedDocumentationService = deceasedDocumentationService;
    }

    @GetMapping
    public List<DeceasedDocumentation> getAllDeceasedDocumentation() {
        return  deceasedDocumentationService.getAllDocumentation();
    }

    @PostMapping
    public DeceasedDocumentation createDeceasedDocumentation(@RequestBody DeceasedDocumentation deceasedDocumentation) {
        return deceasedDocumentationService.createDeceasedDocumentation(deceasedDocumentation);
    }

    @PutMapping("/{id}")
    public DeceasedDocumentation editDeceasedDocumentationById(@PathVariable Long id, @RequestBody DeceasedDocumentation deceasedDocumentation) {
        return deceasedDocumentationService.editDeceasedDocumentation(id, deceasedDocumentation);
    }

    @GetMapping("/{id}")
    public DeceasedDocumentation getDeceasedDocumentationById(@PathVariable Long id) {
        return deceasedDocumentationService.getDeceasedDocumentation(id);
    }

    @DeleteMapping("/{id}")
    public void deleteDeceasedDocumentationById(@PathVariable Long id) {
        deceasedDocumentationService.deleteDeceasedDocumentation(id);
    }
}
