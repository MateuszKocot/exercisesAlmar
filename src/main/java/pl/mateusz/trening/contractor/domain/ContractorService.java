package pl.mateusz.trening.contractor.domain;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import pl.mateusz.trening.contractor.model.ContractorDto;

import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class ContractorService {

    private final ContractorRepository contractorRepository;

    public List<ContractorDto> findAll() {
        log.info("Pobieranie wszystkich kontrahentów.");
        return contractorRepository.findAll().stream()
                .map(this::mapToDto)
                .collect(Collectors.toList());
    }

    public Optional<ContractorDto> findOne(Long id) {
        log.info("Pobieranie kontrahenta o ID: {}", id);
        return contractorRepository.findById(id)
                .map(this::mapToDto); //
    }

    public ContractorDto create() {
        log.info("Tworzenie nowego kontrahenta z losowymi danymi.");

        Random random = new Random();
        String name = "Kontrahent " + random.nextInt(10000);
        String nip = String.format("%010d", random.nextLong() % 10000000000L);
        String address = "Ulica " + random.nextInt(100) + ", " + random.nextInt(50);
        String postalCode = String.format("%02d-%03d", random.nextInt(99), random.nextInt(999));
        String city = "Miasto " + random.nextInt(100);
        String country = "Polska";

        Contractor newContractor = Contractor.builder()
                .name(name)
                .nip(nip)
                .address(address)
                .postalCode(postalCode)
                .city(city)
                .country(country)
                .build();

        Contractor savedContractor = contractorRepository.save(newContractor);
        log.info("Utworzono kontrahenta: {}", savedContractor);
        return mapToDto(savedContractor);
    }

    public Optional<ContractorDto> update(Long id, ContractorDto contractorDto) {
        log.info("Próba aktualizacji kontrahenta o ID: {}", id);
        return contractorRepository.findById(id)
                .map(contractor -> {
                    contractor.setName(contractorDto.getName());
                    contractor.setNip(contractorDto.getNip());
                    contractor.setAddress(contractorDto.getAddress());
                    contractor.setPostalCode(contractorDto.getPostalCode());
                    contractor.setCity(contractorDto.getCity());
                    contractor.setCountry(contractorDto.getCountry());


                    Contractor updatedContractor = contractorRepository.save(contractor);
                    log.info("Zaktualizowano kontrahenta: {}", updatedContractor);
                    return mapToDto(updatedContractor);
                });
    }


    public boolean delete(Long id) {
        log.info("Próba usunięcia kontrahenta o ID: {}", id);
        if (contractorRepository.existsById(id)) {
            contractorRepository.deleteById(id);
            log.info("Usunięto kontrahenta o ID: {}", id);
            return true;
        }
        log.warn("Nie znaleziono kontrahenta o ID: {} do usunięcia.", id);
        return false;
    }

    private ContractorDto mapToDto(Contractor contractor) {
        return ContractorDto.builder()
                .name(contractor.getName())
                .nip(contractor.getNip())
                .address(contractor.getAddress())
                .postalCode(contractor.getPostalCode())
                .city(contractor.getCity())
                .country(contractor.getCountry())
                .build();
    }


}
