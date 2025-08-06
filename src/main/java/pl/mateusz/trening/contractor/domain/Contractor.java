package pl.mateusz.trening.contractor.domain;

import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "KONTRAHENT")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EntityListeners(AuditingEntityListener.class)
public class Contractor {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "kontrahent_seq_generator")
    @SequenceGenerator(name = "kontrahent_seq_generator", sequenceName = "KONTRAHENT_SEQ", allocationSize = 1)

    @Column(name = "ID")
    private Long id;

    @Column(name = "NAZWA", nullable = false)
    private String name;

    @Column(name = "NIP", unique = true)
    private String nip;

    @Column(name = "ADRES")
    private String address;

    @Column(name = "KOD_POCZTOWY")
    private String postalCode;

    @Column(name = "MIASTO")
    private String city;

    @Column(name = "KRAJ")
    private String country;

    @CreatedDate
    @Column(name = "DATA_UTWORZENIA", nullable = false, updatable = false)
    private LocalDateTime creationDate;

    @LastModifiedDate
    @Column(name = "DATA_MODYFIKACJI", nullable = false)
    private LocalDateTime versionDate;


    @Override
    public String toString() {
        return "Contractor{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", nip='" + nip + '\'' +
                ", address='" + address + '\'' +
                ", postalCode='" + postalCode + '\'' +
                ", city='" + city + '\'' +
                ", country='" + country + '\'' +
                ", creationDate=" + creationDate +
                ", versionDate=" + versionDate +
                '}';
    }
}
