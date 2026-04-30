package com.example.demo;

import com.example.demo.model.*;
import javafx.beans.property.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;
import javafx.util.StringConverter;

public class HelloController {

    @FXML private TableView<Teacher> teacherTable;
    @FXML private TableColumn<Teacher, String> colName;
    @FXML private TableColumn<Teacher, String> colSurname;
    @FXML private TableColumn<Teacher, TeacherCondition> colCondition;
    @FXML private TableColumn<Teacher, Integer> colBirthYear;
    @FXML private TableColumn<Teacher, Double> colSalary;

    @FXML private TextField nameField;
    @FXML private TextField surnameField;
    @FXML private TextField birthYearField;
    @FXML private TextField salaryField;
    @FXML private ComboBox<TeacherCondition> conditionCombo;
    @FXML private TextField surnameFieldSearch;
    @FXML private TextField partialSearchField;
    @FXML private ComboBox<Teacher> changeConditionTeacherCombo;
    @FXML private ComboBox<TeacherCondition> changeConditionCombo;
    @FXML private TextField addSalaryField;
    @FXML private ComboBox<TeacherCondition> countConditionCombo;
    @FXML private Label conditionCountLabel;
    @FXML private TableView<ClassTeacher> groupTable;
    @FXML private TableColumn<ClassTeacher, String> colGroupName;
    @FXML private TableColumn<ClassTeacher, Integer> colGroupCount;
    @FXML private TableColumn<ClassTeacher, Integer> colGroupMax;
    @FXML private TableColumn<ClassTeacher, String> colGroupPercent;

    @FXML private ComboBox<Teacher> teacherCombo;
    @FXML private ComboBox<ClassTeacher> groupCombo;

    @FXML private ListView<String> teacherListInSelectedGroup;

    @FXML private TextField groupNameField;
    @FXML private TextField groupLimitField;

    @FXML private ComboBox<ClassTeacher> deleteGroupCombo;




    private final ObservableList<Teacher> teachers = FXCollections.observableArrayList();

    private boolean surnameAscending = true;
    private boolean salaryDescending = true;

    private final ObservableList<ClassTeacher> groupData = FXCollections.observableArrayList();
    private ClassContainer container = new ClassContainer();




    @FXML
    public void initialize() {
        // Powiązanie kolumn z właściwościami Teacher
        colName.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getName()));
        colSurname.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getSurname()));
        colCondition.setCellValueFactory(cellData -> new SimpleObjectProperty<>(cellData.getValue().getCondition()));
        colBirthYear.setCellValueFactory(cellData -> new SimpleIntegerProperty(cellData.getValue().getBirthYear()).asObject());
        colSalary.setCellValueFactory(cellData -> new SimpleDoubleProperty(cellData.getValue().getSalary()).asObject());

        // Automatyczne rozciąganie kolumn
        teacherTable.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

        teacherTable.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);

        teacherTable.setItems(teachers);

        // Wypełnienie ComboBox-a
        conditionCombo.getItems().setAll(TeacherCondition.values());

        changeConditionTeacherCombo.setItems(teachers);
        changeConditionCombo.getItems().setAll(TeacherCondition.values());
        changeConditionTeacherCombo.setConverter(new StringConverter<>() {
            @Override
            public String toString(Teacher teacher) {
                return teacher == null ? "" : teacher.getName() + " " + teacher.getSurname();
            }

            @Override
            public Teacher fromString(String string) {
                return null;
            }
        });



        // Zliczanie stanow
        countConditionCombo.getItems().setAll(TeacherCondition.values());


        teacherTable.getSelectionModel().selectedItemProperty().addListener((obs, oldVal, newVal) -> {
            if (newVal != null) {
                conditionCombo.setValue(newVal.getCondition());
            }
        });


        // 4 nauczycieli na start
        teachers.addAll(
                new Teacher("Jan", "Kowalski", TeacherCondition.OBECNY, 1985, 6000),
                new Teacher("Anna", "Nowak", TeacherCondition.DELEGACJA, 1990, 7500),
                new Teacher("Piotr", "Wiśniewski", TeacherCondition.CHORY, 1980, 6800),
                new Teacher("Katarzyna", "Nowak", TeacherCondition.NIEOBECNY, 1995, 7200),
                new Teacher("Marek", "Lewandowski", TeacherCondition.OBECNY, 1988, 8000),
                new Teacher("Zofia", "Kowalczyk", TeacherCondition.DELEGACJA, 1992, 9000),
                new Teacher("Tomasz", "Wójcik", TeacherCondition.CHORY, 1983, 8500),
                new Teacher("Ewa", "Dąbrowska", TeacherCondition.NIEOBECNY, 1991, 9500),
                new Teacher("Jakub", "Zieliński", TeacherCondition.OBECNY, 1987, 7000),
                new Teacher("Natalia", "Szymańska", TeacherCondition.DELEGACJA, 1994, 7800),
                new Teacher("Michał", "Kowal", TeacherCondition.CHORY, 1986, 8200),
                new Teacher("Agnieszka", "Witkowska", TeacherCondition.NIEOBECNY, 1993, 7600),
                new Teacher("Krzysztof", "Mazur", TeacherCondition.OBECNY, 1984, 6400)
        );

        // Tworzenie przykładowych grup
        container.addClass("1A", 5);
        container.addClass("2B", 6);
        container.addClass("3C", 7);

        // Załaduj grupy do observableList
        groupData.addAll(container.getAll().values());
        groupTable.setItems(groupData);

// Powiązanie kolumn z właściwościami
        colGroupName.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getGroupName()));
        colGroupCount.setCellValueFactory(cellData -> new SimpleIntegerProperty(cellData.getValue().getTeachers()).asObject());
        colGroupMax.setCellValueFactory(cellData -> new SimpleIntegerProperty(cellData.getValue().getMaxNumberOfTeacher()).asObject());

// Dodaj nauczycieli do grup (jeśli lista nauczycieli istnieje)
        if (teachers.size() >= 5) {
            container.addTeacherToClass("1A", teachers.get(0));
            container.addTeacherToClass("1A", teachers.get(1));
            container.addTeacherToClass("1A", teachers.get(2));
            container.addTeacherToClass("1A", teachers.get(3));
            container.addTeacherToClass("2B", teachers.get(4));
            container.addTeacherToClass("2B", teachers.get(5));
            container.addTeacherToClass("3C", teachers.get(7));
            container.addTeacherToClass("3C", teachers.get(8));
            container.addTeacherToClass("3C", teachers.get(9));
            container.addTeacherToClass("3C", teachers.get(10));


        }

        teacherCombo.setItems(teachers);
        teacherCombo.setConverter(new StringConverter<>() {
            @Override
            public String toString(Teacher teacher) {
                return teacher == null ? "" : teacher.getName() + " " + teacher.getSurname();
            }

            @Override
            public Teacher fromString(String string) {
                return null; // niepotrzebne tutaj
            }
        });

        groupCombo.setItems(groupData);
        deleteGroupCombo.setItems(groupData);
        deleteGroupCombo.setConverter(new StringConverter<>() {
            @Override
            public String toString(ClassTeacher group) {
                return group == null ? "" : group.getGroupName();
            }

            @Override
            public ClassTeacher fromString(String string) {
                return null;
            }
        });

        groupCombo.setConverter(new StringConverter<>() {
            @Override
            public String toString(ClassTeacher group) {
                return group == null ? "" : group.getGroupName();
            }

            @Override
            public ClassTeacher fromString(String string) {
                return null;
            }
        });

        colGroupPercent.setCellValueFactory(cellData -> {
            ClassTeacher group = cellData.getValue();
            int current = group.getTeachers();
            int max = group.getMaxNumberOfTeacher();
            String percent = max == 0 ? "0%" : String.format("%.0f%%", (double) current / max * 100);
            return new SimpleStringProperty(percent);
        });

        groupTable.getSelectionModel().selectedItemProperty().addListener((obs, oldVal, newVal) -> {
            teacherListInSelectedGroup.getItems().clear();

            if (newVal != null) {
                for (Teacher teacher : newVal.getTeacherList()) {
                    teacherListInSelectedGroup.getItems().add(teacher.getName() + " " + teacher.getSurname());
                }
            }
        });


    }

    @FXML
    private void handleAddTeacher() {
        try {
            String name = nameField.getText();
            String surname = surnameField.getText();
            int birthYear = Integer.parseInt(birthYearField.getText());
            double salary = Double.parseDouble(salaryField.getText());
            TeacherCondition condition = conditionCombo.getValue();

            if (name.isEmpty() || surname.isEmpty() || condition == null) {
                showAlert("Błąd", "Wypełnij wszystkie pola.");
                return;
            }

            Teacher teacher = new Teacher(name, surname, condition, birthYear, salary);
            teachers.add(teacher);

            nameField.clear();
            surnameField.clear();
            birthYearField.clear();
            salaryField.clear();
            conditionCombo.getSelectionModel().clearSelection();

        } catch (NumberFormatException e) {
            showAlert("Błąd danych", "Wprowadź poprawne liczby w polach 'rok' i 'pensja'.");
        }
    }

    @FXML
    private void handleDeleteTeacher() {
        Teacher selected = teacherTable.getSelectionModel().getSelectedItem();
        if (selected != null) {
            teachers.remove(selected);
        } else {
            showAlert("Brak wyboru", "Zaznacz nauczyciela do usunięcia.");
        }
    }

    private void showAlert(String title, String content) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(content);
        alert.showAndWait();
    }


    @FXML
    public void handleSortBySurname(ActionEvent actionEvent) {
        if (surnameAscending) {
            FXCollections.sort(teachers, (t1, t2) -> t1.getSurname().compareToIgnoreCase(t2.getSurname()));
        } else {
            FXCollections.sort(teachers, (t1, t2) -> t2.getSurname().compareToIgnoreCase(t1.getSurname()));
        }
        surnameAscending = !surnameAscending; // zmień stan na przeciwny
        teacherTable.refresh();
    }

    @FXML
    public void handleSortBySalary(ActionEvent actionEvent) {
        if (salaryDescending) {
            FXCollections.sort(teachers, (t1, t2) -> Double.compare(t2.getSalary(), t1.getSalary())); // ↓
        } else {
            FXCollections.sort(teachers, (t1, t2) -> Double.compare(t1.getSalary(), t2.getSalary())); // ↑
        }
        salaryDescending = !salaryDescending;
        teacherTable.refresh();
    }

    @FXML
    public void handleSearchBySurname(ActionEvent actionEvent) {
        String surname = surnameFieldSearch.getText().trim().toLowerCase();

        if (surname.isEmpty()) {
            showAlert("Błąd", "Wprowadź nazwisko do wyszukania.");
            return;
        }

        boolean anySelected = false;

        // sprawdź, czy już są zaznaczeni jacyś nauczyciele z tym nazwiskiem
        for (Teacher t : teacherTable.getSelectionModel().getSelectedItems()) {
            if (t.getSurname().toLowerCase().equals(surname)) {
                anySelected = true;
                break;
            }
        }

        // tryb przełącznika
        teacherTable.getSelectionModel().clearSelection();

        if (!anySelected) {
            boolean found = false;
            for (int i = 0; i < teacherTable.getItems().size(); i++) {
                Teacher t = teacherTable.getItems().get(i);
                if (t.getSurname().toLowerCase().equals(surname)) {
                    teacherTable.getSelectionModel().select(i);
                    found = true;
                }
            }
            if (!found) {
                showAlert("Nie znaleziono", "Nie znaleziono nauczyciela o nazwisku: " + surname);
            }
        }
    }


    @FXML
    private void handleSearchPartial() {
        String query = partialSearchField.getText().trim().toLowerCase();

        if (query.isEmpty()) {
            showAlert("Puste pole", "Wprowadź fragment imienia lub nazwiska.");
            return;
        }

        boolean anySelected = false;
        // sprawdź, czy już są zaznaczeni jacyś nauczyciele z tym nazwiskiem
        for (Teacher t : teacherTable.getSelectionModel().getSelectedItems()) {
            if (t.getName().toLowerCase().contains(query) || t.getSurname().toLowerCase().contains(query)) {
                anySelected = true;
                break;
            }
        }
        // tryb przełącznika
        teacherTable.getSelectionModel().clearSelection();

        if (!anySelected) {
            boolean found = false;
            for (int i = 0; i < teacherTable.getItems().size(); i++) {
                Teacher t = teacherTable.getItems().get(i);
                if (t.getName().toLowerCase().contains(query) || t.getSurname().toLowerCase().contains(query)) {
                    teacherTable.getSelectionModel().select(i);
                    found = true;
                }
            }
            if (!found) {
                showAlert("Nie znaleziono", "Nie znaleziono nauczyciela zawierającego: " + query);
            }
        }

    }



    public TextField getPartialSearchField() {
        return partialSearchField;
    }

    public void setPartialSearchField(TextField partialSearchField) {
        this.partialSearchField = partialSearchField;
    }

    @FXML
    private void handleChangeCondition() {
        Teacher selected = changeConditionTeacherCombo.getValue();
        TeacherCondition newCondition = changeConditionCombo.getValue();

        if (selected == null) {
            showAlert("Brak wyboru", "Wybierz nauczyciela, którego stan chcesz zmienić.");
            return;
        }

        if (newCondition == null) {
            showAlert("Brak stanu", "Wybierz nowy stan z listy.");
            return;
        }

        if (selected.getCondition() == newCondition) {
            showAlert("Ten sam stan", "Nowy stan musi różnić się od obecnego.");
            return;
        }

        selected.setCondition(newCondition);
        teacherTable.refresh();
        changeConditionTeacherCombo.getSelectionModel().clearSelection();
        changeConditionCombo.getSelectionModel().clearSelection();
    }




    public void handleAddSalary(ActionEvent actionEvent) {
        Teacher selected = teacherTable.getSelectionModel().getSelectedItem();

        if (selected == null) {
            showAlert("Brak wyboru", "Zaznacz nauczyciela, któremu chcesz dodać kwotę.");
            return;
        }

        String input = addSalaryField.getText().trim();
        if (input.isEmpty()) {
            showAlert("Brak kwoty", "Wpisz kwotę do dodania.");
            return;
        }

        try {
            double amount = Double.parseDouble(input);
            if (amount <= 0) {
                showAlert("Nieprawidłowa kwota", "Kwota musi być większa od zera.");
                return;
            }

            double newSalary = selected.getSalary() + amount;
            selected.setSalary(newSalary);
            teacherTable.refresh(); // odśwież tabelę

            addSalaryField.clear();
        } catch (NumberFormatException e) {
            showAlert("Błąd danych", "Wprowadź poprawną liczbę (np. 500.00).");
        }
    }

    @FXML
    public void handleCountCondition(ActionEvent actionEvent) {
        TeacherCondition selectedCondition = countConditionCombo.getValue();

        if (selectedCondition == null) {
            conditionCountLabel.setText("Wybierz stan, aby policzyć.");
            return;
        }

        long count = teachers.stream()
                .filter(t -> t.getCondition() == selectedCondition)
                .count();

        conditionCountLabel.setText("Liczba osób w stanie \"" + selectedCondition + "\": " + count);
    }


    public ClassContainer getContainer() {
        return container;
    }

    public void setContainer(ClassContainer container) {
        this.container = container;
    }

    @FXML
    private void handleAssignTeacherToGroup() {
        Teacher selectedTeacher = teacherCombo.getValue();
        ClassTeacher selectedGroup = groupCombo.getValue();

        if (selectedTeacher == null || selectedGroup == null) {
            showAlert("Błąd", "Wybierz nauczyciela i grupę.");
            return;
        }

        if (selectedGroup.getTeacherList().contains(selectedTeacher)) {
            showAlert("Info", "Nauczyciel już jest w tej grupie.");
            return;
        }

        // ✅ Sprawdzenie dostępności miejsca
        if (selectedGroup.getTeachers() >= selectedGroup.getMaxNumberOfTeacher()) {
            showAlert("Błąd", "Nie można dodać — grupa jest pełna.");
            return;
        }

        selectedGroup.addTeacher(selectedTeacher); // dodaj nauczyciela
        groupTable.refresh(); // odśwież licznik grupy
    }

    @FXML
    private void handleCreateGroup() {
        String groupName = groupNameField.getText().trim();
        String limitText = groupLimitField.getText().trim();

        if (groupName.isEmpty() || limitText.isEmpty()) {
            showAlert("Błąd", "Podaj nazwę grupy i limit.");
            return;
        }

        int limit;
        try {
            limit = Integer.parseInt(limitText);
            if (limit <= 0) {
                showAlert("Błąd", "Limit musi być większy od zera.");
                return;
            }
        } catch (NumberFormatException e) {
            showAlert("Błąd", "Limit musi być liczbą całkowitą.");
            return;
        }

        if (container.getAll().containsKey(groupName)) {
            showAlert("Błąd", "Grupa o takiej nazwie już istnieje.");
            return;
        }

        container.addClass(groupName, limit);
        groupData.clear();
        groupData.addAll(container.getAll().values());
        groupCombo.setItems(groupData);

        groupNameField.clear();
        groupLimitField.clear();
    }

    @FXML
    private void handleDeleteGroup() {
        ClassTeacher selectedGroup = deleteGroupCombo.getValue();

        if (selectedGroup == null) {
            showAlert("Błąd", "Wybierz grupę do usunięcia.");
            return;
        }

        container.getAll().remove(selectedGroup.getGroupName()); // usuń z mapy
        groupData.remove(selectedGroup); // usuń z observable listy

        groupTable.refresh();
        groupCombo.setItems(groupData);
        deleteGroupCombo.setItems(groupData);

        deleteGroupCombo.getSelectionModel().clearSelection();
    }






}
