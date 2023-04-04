package com.example.funeralbackend.morgue;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

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
    public Morgue getDeceased(@PathVariable Long id) {
        return morgueService.getDeceasedById(id);
    }

    @PostMapping
    public ResponseEntity<Morgue> createDeceased(@Validated @RequestBody Morgue morgue) {
        Morgue createdDeceased = morgueService.createDeceased(morgue);
        return ResponseEntity.created(URI.create("/api/morgue/" + morgue.getId())).body(createdDeceased);
    }

    @PutMapping("/{id}")
    public Morgue editDeceased(@PathVariable Long id, @RequestBody Morgue morgue) {
        return morgueService.editDeceasedById(id, morgue);
    }

    @DeleteMapping("/{id}")
    public void deleteDeceased(@PathVariable Long id) {
        morgueService.deleteDeceasedById(id);
    }

}
