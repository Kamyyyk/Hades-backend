package com.example.funeralbackend.morgue;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MorgueRepository extends JpaRepository<Morgue, Long> {
}
