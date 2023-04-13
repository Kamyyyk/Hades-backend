package com.example.funeralbackend.container;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/container")
public class ContainerController {
    private final ContainerService containerService;

    public ContainerController(ContainerService containerService) {
        this.containerService = containerService;
    }

    @GetMapping
    public List<Container> getAllContainers() {
        return containerService.getAllContainers();
    }

    @GetMapping("/{id}")
    public Container getContainerById(@PathVariable Long id) {
        return containerService.getContainer(id);
    }

    @PostMapping
    public Container createContainer(@RequestBody Container container) {
        return containerService.createContainer(container);
    }


    @PutMapping("/{id}")
    public Container updateContainerById(@PathVariable Long id, @RequestBody Container container) {
        return containerService.editContainer(id, container);
    }


    @DeleteMapping("/{id}")
    public void deleteContainerById(@PathVariable Long id) {
        containerService.deleteContainer(id);
    }
}
