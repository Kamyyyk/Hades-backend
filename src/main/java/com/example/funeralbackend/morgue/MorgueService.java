package com.example.funeralbackend.morgue;

import com.example.funeralbackend.morgue.errors.MorgueNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Component
@RequiredArgsConstructor
public class MorgueService {
    private final MorgueRepository morgueRepository;

    public List<Morgue> getAllDeceased() {
        return morgueRepository.findAll();
    }

    public Morgue createDeceased(Morgue morgue) {
        return morgueRepository.save(morgue);
    }

    public Morgue getDeceasedById(Long id) {
        return morgueRepository.findById(id)
                .orElseThrow(() -> new MorgueNotFoundException("Cannot find deceased by id: " + id));
    }

    public Morgue editDeceasedById(Long id, Morgue morgue) {
        Morgue existingDeceased = getDeceasedById(id);
        existingDeceased.setName(morgue.getName());
        existingDeceased.setSurname(morgue.getSurname());
        existingDeceased.setDateArrived(morgue.getDateArrived());
        existingDeceased.setSex(morgue.getSex());
        existingDeceased.setBirthDate(morgue.getBirthDate());
        existingDeceased.setDeathDate(morgue.getDeathDate());
        return morgueRepository.save(existingDeceased);
    }

    public void deleteDeceasedById(Long id) {
        morgueRepository.deleteById(id);
    }
}
