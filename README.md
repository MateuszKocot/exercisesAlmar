# exercisesAlmar

This is a recruitment exercise for the almar company


I. Wymagania instalacyjne
1. Zainstalować JAVA 11 (https://adoptopenjdk.net/)
• Sprawdzić czy komenda w cmd (java --version) drukuje informacje o wersji do
konsoli

3. Zainstalować Maven 3 (https://maven.apache.org/)
• Sprawdzić czy komenda w cmd (mvn --version) drukuje informacje o wersji do
konsoli
4. Zainstalować Git (https://git-scm.com/)
• Sprawdzić czy komenda w cmd (git --version) drukuje informacje o wersji do
konsoli
• Utworzyć repozytorium lokalne dla projektu
• Utworzyć repozytorium zdalne (np. na GitHub)
• Połączyć repozytorium lokalne ze zdalnym
• Uzupełnić plik .gitignore
5. Zainstalować IntelliJ IDEA (https://www.jetbrains.com/idea/)
• Zainstalować plugin do lomboka
• Wersja community też może być
6. Zainstalować PostgreSQL (https://www.postgresql.org/)
• Utworzyć użytkownika bazy danych
• Założyć bazę danych
• Podłączyć się do bazy danych (np. przez PgAdmin i sprawdzić czy działa)
7. Zainicjować projekt (https://start.spring.io/)
• Zależności: Lombok, Spring Data JPA, PostgreSQL Driver, Spring Data JDBC,
Rest Repositories, Spring Configuration Processor
• Maven Project, Java (11), Jar, Spring Boot 2.5.1
• Uruchomić projekt (zamiast application.properties użyć application.yml),
połączyć się z bazą danych, gotowy projekt zacommitować i spushować na zdalne
repozytorium
II. Zadanie
1. Przygotować pakiet contractor
2. W pakiecie contractor dodać podpakiety domain, model
3. W pakiecie contractor stworzyć klasę ContractorController
4. W pakiecie contractor.domain stworzyć klasy Contractor,
ContractorService oraz interfejs ContractorRepository
5. Klasa Contractor ma być reprezentacją tabeli w bazie danych KONTRAHENT
6. Klasa Contractor ma zawierać takie pola jak (w nawiasach nazwa pola w tabeli w
bazie danych):
• id (ID)
• name (NAZWA)
• nip (NIP)
• address (ADRES)
• postalCode (KOD_POCZTOWY)
• city (MIASTO)
• country (KRAJ)
• creationDate (DATA_UTWORZENIA)
• versionDate (DATA_MODYFIKACJI)
7. Pole id w klasie Contractor ma być nadawane przez sekwencję w bazie danych
8. W interfejsie ContractorRepository rozszerzyć klasę JpaRepository<T, ID>
9. W klasie ContractorService dodać metody (wykorzystać w/w interfejs do tego):
• findAll – zwraca wszystkich kontrahentów z bazy danych
• findOne – zwraca jednego kontrahenta (po id) – metoda ma zwrócić obiekt
opakowany w Optional<K> (uwaga: Optionala nie da się zwrócić przez
koncówkę restową, należy na to jakoś zareagować)
• create – dodaje kontrahenta (losowe dane)
• update – aktualizuje kontrahenta (według uznania)
• delete – usuwa kontrahenta (po id)
10. Dodać klasę ContractorDto w pakiecie contractor.model i używać jej do
zwracania danych z metod findAll / findOne
11. Klasa ContractorDto ma zawierać te same pola co klasa (encja) Contractor za
wyjątkiem id, creationDate, versionDate
12. Do każdej metody z ContractorService stworzyć odpowiadający endpoint
restowy w klasie ContractorController.
13. Główne mapowanie endpointa dla ContractorController to /contractor
14. Mapowania konkretnych endpointów mają być takie same jak nazwy
odpowiadających metod z ContractorService (np. findAll -> /findAll)
15. Ukończony projekt zacommitować i spushować na repozytorium zdalne
Dodatkowe punkty za:
1. Używanie funkcjonalności Lombok (@Getter, @RequiredArgsConstructor,
@NoArgsConstructor, @AllArgsConstructor, @Builder itd.)
2. Używanie API dat z Javy 8+ oraz Streamów
3. Stworzenie schematu przy pomocy Hibernate
4. Obsługa potencjalnych błędów (np. przy metodzie findOne)
5. Dodanie logów do aplikacji
6. Wszystkie inne fajne rzeczy dodane wedle własnego uznania
