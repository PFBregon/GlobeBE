package dev.patriciafb.spring.academy;

import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/academies")
public class AcademyController {
    private final AcademyService service;

    public AcademyController(AcademyService service) {
        this.service = service;
    }

    @GetMapping
    public List<Academy> getAll() {
        return service.findAll();
    }

    @PostMapping
    public Academy create(@RequestBody Academy academy) {
        return service.save(academy);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.deleteById(id);
    }
}
