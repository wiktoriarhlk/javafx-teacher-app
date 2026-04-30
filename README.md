# 🖥 JavaFX — Teacher Management App

Desktopowa aplikacja graficzna stworzona w JavaFX do zarządzania nauczycielami i grupami. Projekt zaliczeniowy będący poprzednikiem aplikacji Spring Boot — dane przechowywane są w pamięci (bez bazy danych).

---

##  Użyte technologie i ich rola

| Technologia | Rola w projekcie |
|-------------|-----------------|
| **Java 17** | Główny język programowania |
| **JavaFX** | Framework do budowania graficznego interfejsu użytkownika (GUI) |
| **FXML** | Język XML do definiowania layoutu okien aplikacji |
| **Maven** | Zarządzanie zależnościami i budowanie projektu |

>  To projekt "przed bazą danych" — wszystkie dane istnieją tylko podczas działania aplikacji i znikają po jej zamknięciu. Kolejnym krokiem było dodanie Hibernate i MySQL (projekt `springboot`).

---

##  Funkcje

**Zarządzanie nauczycielami:**
- Dodawanie nauczyciela (imię, nazwisko, rok urodzenia, pensja, stan zatrudnienia)
- Usuwanie nauczyciela
- Wyszukiwanie po nazwisku (pełne i częściowe)
- Zmiana stanu zatrudnienia nauczyciela
- Podwyższenie pensji
- Sortowanie po nazwisku i pensji
- Zliczanie nauczycieli według stanu zatrudnienia

**Zarządzanie grupami:**
- Tworzenie grupy z limitem nauczycieli
- Usuwanie grupy
- Przypisywanie nauczyciela do grupy
- Podgląd nauczycieli w grupie
- Automatyczny procent zapełnienia grupy

---

##  Uruchomienie

**W IntelliJ IDEA:**
1. Otwórz folder `javafx_baza/` jako projekt
2. Poczekaj na synchronizację Maven
3. Znajdź `HelloApplication.java` → kliknij ▶️

**Lub w terminalu:**
```bash
./mvnw javafx:run
```

---

##  Struktura projektu

```
src/main/java/com/example/demo/
├── HelloApplication.java      ← punkt startowy aplikacji
├── HelloController.java       ← logika całego GUI (obsługa przycisków, tabel)
└── model/
    ├── Teacher.java           ← klasa nauczyciela
    ├── ClassTeacher.java      ← klasa grupy z listą nauczycieli
    ├── ClassContainer.java    ← kontener przechowujący wszystkie grupy
    └── TeacherCondition.java  ← enum stanów zatrudnienia
```

---

##  Ewolucja projektu

Ten projekt jest częścią serii:

| Etap | Projekt | Opis |
|------|---------|------|
| 1 | **javafx_baza** (ten projekt) | GUI w JavaFX, dane w pamięci |
| 2 | **hibernate** | Nauka połączenia z MySQL przez Hibernate |
| 3 | **springboot** | REST API w Spring Boot z bazą MySQL |

---
