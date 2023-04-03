package com.example.funeralbackend.morgue;

import com.example.funeralbackend.morgue.errors.MorgueErrorResponse;
import com.example.funeralbackend.morgue.errors.MorgueNotFoundException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/api/morgue")
public class MorgueController {
    private final MorgueService morgueService;

    public MorgueController(MorgueService morgueService) {
        this.morgueService = morgueService;
    }
    @GetMapping
    public List<Morgue> getAllDeceased() {
        return morgueService.getAllDeceased();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Morgue> getDeceased(@PathVariable Long id) {
        try {
            Morgue deceased = morgueService.getDeceasedById(id);
            return ResponseEntity.ok(deceased);
        } catch (EntityNotFoundException ex) {
            throw new MorgueNotFoundException("Deceased id not found:" + id);
        }
    }

    @PostMapping
    public ResponseEntity<Morgue> createDeceased(@Validated @RequestBody Morgue morgue) {
        morgueService.createDeceased(morgue);
        return ResponseEntity.created(URI.create("/api/morgue/" + morgue.getId())).body(morgue);
    }

    @PutMapping("/{id}")
    public Morgue editDeceased(@PathVariable Long id, @RequestBody Morgue morgue) {
        return morgueService.editDeceasedById(id, morgue);
    }

    @DeleteMapping("/{id}")
    public void deleteDeceased(@PathVariable Long id) {
        morgueService.deleteDeceasedById(id);
    }

    @ExceptionHandler
    public ResponseEntity<MorgueErrorResponse> handleException(MorgueNotFoundException exc) {
        MorgueErrorResponse error = new MorgueErrorResponse();
        error.setMessage(exc.getMessage());
        error.setTimeStamp(System.currentTimeMillis());
        error.setStatus(HttpStatus.NOT_FOUND.value());
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

}
