package pl.mateusz.trening.contractor.model;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class ContractorDto {
    private String name;
    private String nip;
    private String address;
    private String postalCode;
    private String city;
    private String country;
}
