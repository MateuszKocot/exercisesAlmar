package pl.mateusz.trening.contractor;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.mateusz.trening.contractor.domain.ContractorService;
import pl.mateusz.trening.contractor.model.ContractorDto;

import java.util.List;

@RestController
@RequestMapping("/contractor")
@RequiredArgsConstructor
@Slf4j
public class ContractorController {

    private final ContractorService contractorService;

    @GetMapping("/findAll")
    public ResponseEntity<List<ContractorDto>> findAll() {
        log.info("Otrzymano żądanie GET /contractor/findAll");
        List<ContractorDto> contractors = contractorService.findAll();
        return ResponseEntity.ok(contractors);
    }


    @GetMapping("/findOne/{id}")
    public ResponseEntity<ContractorDto> findOne(@PathVariable Long id) {
        log.info("Otrzymano żądanie GET /contractor/findOne/{}", id);
        return contractorService.findOne(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> {
                    log.warn("Kontrahent o ID {} nie został znaleziony.", id);
                    return ResponseEntity.notFound().build();
                });
    }


    @PostMapping("/create")
    public ResponseEntity<ContractorDto> create() {
        log.info("Otrzymano żądanie POST /contractor/create");
        ContractorDto createdContractor = contractorService.create();
        return new ResponseEntity<>(createdContractor, HttpStatus.CREATED);
    }


    @PutMapping("/update/{id}")
    public ResponseEntity<ContractorDto> update(@PathVariable Long id, @RequestBody ContractorDto contractorDto) {
        log.info("Otrzymano żądanie PUT /contractor/update/{} z danymi: {}", id, contractorDto);
        return contractorService.update(id, contractorDto)
                .map(ResponseEntity::ok)
                .orElseGet(() -> {
                    log.warn("Kontrahent o ID {} nie został znaleziony do aktualizacji.", id);
                    return ResponseEntity.notFound().build();
                });
    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        log.info("Otrzymano żądanie DELETE /contractor/delete/{}", id);
        if (contractorService.delete(id)) {
            return ResponseEntity.noContent().build();
        } else {
            log.warn("Kontrahent o ID {} nie został znaleziony do usunięcia.", id);
            return ResponseEntity.notFound().build();
        }
    }
}
