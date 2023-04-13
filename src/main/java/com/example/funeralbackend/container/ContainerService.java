package com.example.funeralbackend.container;

import com.example.funeralbackend.errors.NotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Component
public class ContainerService {
    private final ContainerRepository containerRepository;

    public ContainerService(ContainerRepository containerRepository) {
        this.containerRepository = containerRepository;
    }

    public List<Container> getAllContainers() {
        return containerRepository.findAll();
    }

    public Container getContainer(Long id) {
        return containerRepository.findById(id).orElseThrow(() -> new NotFoundException("Cannot found container with id: " + id));
    }

    public Container createContainer(Container container) {
        return containerRepository.save(container);
    }

    public Container editContainer(Long id, Container container) {
        Container existedContainer = getContainer(id);
        existedContainer.setContainerName(container.getContainerName());
        existedContainer.setContainerType(container.getContainerType());
        return containerRepository.save(existedContainer);
    }

    public void deleteContainer(Long id) {
        Container existedContainer = getContainer(id);
        containerRepository.delete(existedContainer);
    }
}
