# Vitai Zsolt Vizsgaremek
#### A projekt az OpenCart webshop UI tesztautomatizációjáról készült
Az OpenCart egy elektronikai termékeket árusító webshop
### Manuális tesztek
Elérhető az alábbi link alatt: [Google Sheets](https://docs.google.com/spreadsheets/d/1vs4mAlTr9w_Gldx5eASO5Vr8b-eyZ3HOo7MQC3I5pqQ/edit?usp=sharing/)
### Információk a tesztautomatizációs folyamatról
Amiket használtam a projektben:
- JAVA
- Gradle
- IntelliJ Idea
- Selenium Webdriver

Böngészők listája amivel kompatibilis a projekt:
- Google Chrome
- Edge
- Firefox

Tesztelt területek:
- Regisztráció
- Bejelentkezés
- Privacy Policy használata
- Adat listázás
- Pagination
- Új adatbevitel - vélemény írása egy termékhez
- Repetitív adatbevitel - egyszerre több vélemény írása egy termékhez
- Adat módosítás - felhasználó telefonszámának megváltoztatása
- Adat mentése az oldalról egy fájlba
- Kijelentkezés

Automata tesztek futtatásának módja:
- (1) Leklónozni vagy letölteni a zippelt projektet
- (2) JAVA SE 15-ös verzió NAGYON FONTOS!
- (3) terminálból futtatni:
- benavigálni a projekt mappába | vzsolt-piton-masterwork |
- lefutattni a tesztcsomagot | ./gradlew clean test |
- megjeleníteni a tesztek report-ját | ./gradlew allureServe |
- HA MINDEZ NEM FUTNA LE AKKOR TÖLTSE LE A GRADLE ÉS ALLURE FÁJLOKAT ÉS ÁLLÍTSA BE A KÖRNYEZETI VÁLTOZÓKAT!

Fájlok:
Elérési útjuk: vzsolt-piton-masterwork\vitai_zsolt_masterwork\src\test\resources
- reviews.csv --> ez a fájl a repetatív adatbevitelhez szükséges, Yourname, Yourreview és Rating mezők taláhatóak benne. Szabadon mósodíthatóak a teszadatok, kérem az első sort ne módosítsa. Az első mező a vélemény írójának a neve, második a vélemény a harmadik pedig az érékelése számmal 1-től 5-ig
- test.properties --> megadható a fent említett böngészőkből egy | browser=chrome vagy browser=firefox vagy browser=edge |
- productDetails.csv --> a webshopból ide mentem le az adatokat