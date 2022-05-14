package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Controller {

    // переменные окна "Абитуриенты"
    @FXML
    private TableView<applicantTable> applicantTable;
    @FXML
    private TableColumn<applicantTable, String> idApplicantColumn;
    @FXML
    private TableColumn<applicantTable, String> FIOApplicantColumn;
    @FXML
    private TableColumn<applicantTable, String> applicantBirthdateColumn;
    @FXML
    private TableColumn<applicantTable, String> applicantHomeAddressColumn;
    @FXML
    private TableColumn<applicantTable, String> applicantPhoneNumColumn;
    @FXML
    private TextField applicantNumField;
    @FXML
    private TextField applicantFIOField;
    @FXML
    private TextField applicantBirthdateField;
    @FXML
    private TextField homeAddressField;
    @FXML
    private TextField phoneNumField;
    @FXML
    private Button addEditButtonApplicant;
    @FXML
    private Button removeApplicantButton;
    @FXML
    private Label applicantOutputField;
    int idApplicant = 0;
    ObservableList<applicantTable> applicantTableData = FXCollections.observableArrayList();

    // переменные окна "Личные данные абитуриента"
    @FXML
    private TableView<applicantDataTable> applicantDataTable;
    @FXML
    private TableColumn<applicantDataTable, String> idApplicantDataColumn;
    @FXML
    private TableColumn<applicantDataTable, String> applicantDataFIO;
    @FXML
    private TableColumn<applicantDataTable, String> applicantDataBirthdate;
    @FXML
    private TableColumn<applicantDataTable, String> applicantDataBirthplace;
    @FXML
    private TableColumn<applicantDataTable, String> applicantDataPassportData;
    @FXML
    private TableColumn<applicantDataTable, String> applicantDataBirthCertData;
    @FXML
    private TextField applicantDataNumField;
    @FXML
    private TextField applicantDataFIOField;
    @FXML
    private TextField applicantDataBithdateField;
    @FXML
    private TextField applicantDataBithplaceField;
    @FXML
    private TextField applicantDataPassportDataField;
    @FXML
    private TextField applicantDataBithCertDataField;
    @FXML
    private Button editButtonApplicantData;;
    @FXML
    private Label applicantDataOutputField;
    ObservableList<applicantDataTable> applicantDataTableData = FXCollections.observableArrayList();

    // переменные окна "Сведения об образовании"
    @FXML
    private TableView<educationalTable> educationalDataTable;
    @FXML
    private TableColumn<educationalTable, String> idEducationalDataColumn;
    @FXML
    private TableColumn<educationalTable, String> educationalLevelColumn;
    @FXML
    private TableColumn<educationalTable, String> educationalCertificateNumberColumn;
    @FXML
    private TableColumn<educationalTable, String> educationalCertificateAverageNumColumn;
    @FXML
    private TableColumn<educationalTable, String> selectedSpecialityColumn;
    @FXML
    private TableColumn<educationalTable, String> specialityCodeColumn;
    @FXML
    private TableColumn<educationalTable, String> specialityNameColumn;
    @FXML
    private TextField idEducationalDataField;
    @FXML
    private TextField educationalLevelField;
    @FXML
    private TextField educationalCertificateNumberField;
    @FXML
    private TextField educationalCertificateAverageNumField;
    @FXML
    private TextField selectedSpecialityField;
    @FXML
    private TextField specialityCodeField;
    @FXML
    private TextField specialityNameField;
    @FXML
    private Button editButtonEducationalData;
    @FXML
    private Label educationalDataOutputField;
    ObservableList<educationalTable> educationalTableData = FXCollections.observableArrayList();

    // переменные окна "Сведения о родителях"
    @FXML
    private TableView<parentsTable> familyDataTable;
    @FXML
    private TableColumn<parentsTable, String> idParentsDataColumn;
    @FXML
    private TableColumn<parentsTable, String> familyStatusColumn;
    @FXML
    private TableColumn<parentsTable, String> childQuantColumn;
    @FXML
    private TableColumn<parentsTable, String> FIOmumColumn;
    @FXML
    private TableColumn<parentsTable, String> homeAddressMumColumn;
    @FXML
    private TableColumn<parentsTable, String> phoneNumMumColumn;
    @FXML
    private TableColumn<parentsTable, String> workPlaceMumColumn;
    @FXML
    private TableColumn<parentsTable, String> FIOdadColumn;
    @FXML
    private TableColumn<parentsTable, String> houseAddressDadColumn;
    @FXML
    private TableColumn<parentsTable, String> phoneNumDadColumn;
    @FXML
    private TableColumn<parentsTable, String> dadWorkPlaceColumn;
    @FXML
    private TextField idParentsDataField;
    @FXML
    private TextField familyStatusField;
    @FXML
    private TextField childQuantField;
    @FXML
    private TextField FIOmumField;
    @FXML
    private TextField homeAddressMumField;
    @FXML
    private TextField phoneNumMumField;
    @FXML
    private TextField workPlaceMumField;
    @FXML
    private TextField FIOdadField;
    @FXML
    private TextField houseAddressDadField;
    @FXML
    private TextField phoneNumDadField;
    @FXML
    private TextField dadWorkPlaceField;
    @FXML
    private Button editButtonParentsData;
    @FXML
    private Label parentsDataOutputField;
    ObservableList<parentsTable> familyTableData = FXCollections.observableArrayList();

    public void initialize() throws SQLException {
        printApplicantTable();
        printApplicantDataTable();
        printEducationTable();
        printParentsTable();

        addEditButtonApplicant.setOnAction(event -> {
            applicantOutputField.setText("");
            if (applicantNumField.getText().equals("") & !applicantFIOField.getText().equals("")
                    & !applicantBirthdateField.getText().equals("") &
            !homeAddressField.getText().equals("") & !phoneNumField.getText().equals("")){
                try {
                    fillApplicantTable();
                } catch (SQLException throwable) {
                    throwable.printStackTrace();
                    applicantOutputField.setText("Неверные данные!");
                }
            }
            if (!applicantNumField.getText().equals("") & (!applicantFIOField.getText().equals("") |
                    !applicantBirthdateField.getText().equals("") |
                    !homeAddressField.getText().equals("") | !phoneNumField.getText().equals(""))){
                try {
                    changeApplicantString();
                } catch (SQLException throwable) {
                    applicantOutputField.setText("Неверные данные!");
                    applicantNumField.setText("");
                    applicantFIOField.setText("");
                    applicantBirthdateField.setText("");
                    homeAddressField.setText("");
                    phoneNumField.setText("");
                }
            }
            if(applicantNumField.getText() != null & applicantFIOField.getText() != null &
                    applicantBirthdateField.getText() != null & homeAddressField.getText() != null
                    & phoneNumField.getText() != null){
                applicantOutputField.setText("Неверные данные!");
            }
        });
        removeApplicantButton.setOnAction(event -> {
            applicantOutputField.setText("");
            if (!applicantNumField.getText().equals("") & (applicantNumField.getText()).matches("[-+]?\\d+")){
                try {
                    removeApplicantString();
                } catch (SQLException throwable) {
                    applicantOutputField.setText("Неверный номер строки!");
                }
            } else {
                applicantNumField.setText("");
                applicantOutputField.setText("Введите ID строки!");
            }
        });

        editButtonApplicantData.setOnAction(event -> {
            if (!applicantDataNumField.getText().equals("") & (!applicantDataFIOField.getText().equals("") |
                    !applicantDataBithdateField.getText().equals("") |
                    !applicantDataBithplaceField.getText().equals("") | !applicantDataPassportDataField.getText().equals("") |
                    !applicantDataBithCertDataField.getText().equals(""))){
                try {
                    changeApplicantDataString();
                } catch (SQLException throwable) {
                    throwable.printStackTrace();
                    applicantDataOutputField.setText("Неверные данные!");
                    applicantDataNumField.setText("");
                    applicantDataFIOField.setText("");
                    applicantDataBithdateField.setText("");
                    applicantDataBithplaceField.setText("");
                    applicantDataPassportDataField.setText("");
                    applicantDataBithCertDataField.setText("");;
                }
            } else {
                applicantDataOutputField.setText("Неверные данные!");
            }
        });

        editButtonEducationalData.setOnAction(event -> {
            if(!idEducationalDataField.getText().equals("") & (!educationalLevelField.getText().equals("") |
            !educationalCertificateNumberField.getText().equals("") |
            !educationalCertificateAverageNumField.getText().equals("") | !selectedSpecialityField.getText().equals("") |
            !specialityCodeField.getText().equals("") | !specialityNameField.getText().equals(""))){
                try {
                    changeEducationalString();
                } catch (SQLException throwable) {
                    educationalDataOutputField.setText("Неверные данные!");
                    idEducationalDataField.setText("");
                    educationalLevelField.setText("");
                    educationalCertificateNumberField.setText("");
                    educationalCertificateAverageNumField.setText("");
                    selectedSpecialityField.setText("");
                    specialityCodeField.setText("");
                    specialityNameField.setText("");
                }
            } else {
                educationalDataOutputField.setText("Неверные данные или поля пустые!");
            }
        });

        editButtonParentsData.setOnAction(event -> {
            if(!idParentsDataField.getText().equals("") & (!familyStatusField.getText().equals("") |
                    !childQuantField.getText().equals("") |
                    !FIOmumField.getText().equals("") |
                    !homeAddressMumField.getText().equals("") |
                    !phoneNumMumField.getText().equals("") |
                    !workPlaceMumField.getText().equals("") |
                    !FIOdadField.getText().equals("") |
                    !houseAddressDadField.getText().equals("") |
                    !phoneNumDadField.getText().equals("") |
                    !dadWorkPlaceField.getText().equals(""))){
                try {
                    changeParentsString();
                } catch (SQLException throwable) {
                    parentsDataOutputField.setText("Неверные данные!");
                    throwable.printStackTrace();
                }
            } else {
                parentsDataOutputField.setText("Неверные данные или поля пустые!");
            }
        });



    }

    public void printApplicantTable() throws SQLException { // Вывод данных из таблицы абитуриентов
        applicantTableData.clear();
        Connection connection = DBConnection.getConnection();
        ResultSet resultSet = connection.createStatement().executeQuery("SELECT * FROM applicants_information");
        while (resultSet.next()){
            idApplicant = Integer.parseInt(resultSet.getString("idapplicant"));
            applicantTableData.add(new applicantTable(resultSet.getString("idapplicant"),
                    resultSet.getString("name_lastname"), resultSet.getString("birthdate"),
                    resultSet.getString("home_address"), resultSet.getString("phone_num")));
        }
        idApplicantColumn.setCellValueFactory(new PropertyValueFactory<>("IdApplicantColumn"));
        FIOApplicantColumn.setCellValueFactory(new PropertyValueFactory<>("FIOApplicantColumn"));
        applicantBirthdateColumn.setCellValueFactory(new PropertyValueFactory<>("ApplicantBirthdateColumn"));
        applicantHomeAddressColumn.setCellValueFactory(new PropertyValueFactory<>("ApplicantHomeAddressColumn"));
        applicantPhoneNumColumn.setCellValueFactory(new PropertyValueFactory<>("ApplicantPhoneNumColumn"));
        applicantTable.setItems(applicantTableData);
    }

    public void printApplicantDataTable() throws SQLException { // Вывод данных из таблицы личные данные абитуриента
        applicantDataTableData.clear();
        Connection connection = DBConnection.getConnection();
        ResultSet resultSet = connection.createStatement().executeQuery("SELECT * FROM private_applicant_data");
        while (resultSet.next()){
            applicantDataTableData.add(new applicantDataTable(resultSet.getString(1),
                    resultSet.getString(2), resultSet.getString(3),
                    resultSet.getString(4), resultSet.getString(5), resultSet.getString(6)));
        }
        idApplicantDataColumn.setCellValueFactory(new PropertyValueFactory<>("IdApplicantDataColumn"));
        applicantDataFIO.setCellValueFactory(new PropertyValueFactory<>("ApplicantDataFIO"));
        applicantDataBirthdate.setCellValueFactory(new PropertyValueFactory<>("ApplicantDataBirthdate"));
        applicantDataBirthplace.setCellValueFactory(new PropertyValueFactory<>("ApplicantDataBirthplace"));
        applicantDataPassportData.setCellValueFactory(new PropertyValueFactory<>("ApplicantDataPassportData"));
        applicantDataBirthCertData.setCellValueFactory(new PropertyValueFactory<>("ApplicantDataBirthCertData"));
        applicantDataTable.setItems(applicantDataTableData);
    }

    public void printEducationTable() throws SQLException { // Вывод данных из таблицы "Данные об образовании"
        educationalTableData.clear();
        Connection connection = DBConnection.getConnection();
        ResultSet resultSet = connection.createStatement().executeQuery("SELECT * FROM education_information");
        while (resultSet.next()){
            educationalTableData.add(new educationalTable(resultSet.getString(1),
                    resultSet.getString(2), resultSet.getString(3),
                    resultSet.getString(4), resultSet.getString(5), resultSet.getString(6),
                    resultSet.getString(7)));
        }

        idEducationalDataColumn.setCellValueFactory(new PropertyValueFactory<>("IdEducationalDataColumn"));
        educationalLevelColumn.setCellValueFactory(new PropertyValueFactory<>("EducationalLevelColumn"));
        educationalCertificateNumberColumn.setCellValueFactory(new PropertyValueFactory<>("EducationalCertificateNumberColumn"));
        educationalCertificateAverageNumColumn.setCellValueFactory(new PropertyValueFactory<>("EducationalCertificateAverageNumColumn"));
        selectedSpecialityColumn.setCellValueFactory(new PropertyValueFactory<>("SelectedSpecialityColumn"));
        specialityCodeColumn.setCellValueFactory(new PropertyValueFactory<>("SpecialityCodeColumn"));
        specialityNameColumn.setCellValueFactory(new PropertyValueFactory<>("SpecialityNameColumn"));
        educationalDataTable.setItems(educationalTableData);
    }

    public void printParentsTable() throws SQLException { // Вывод данных из таблицы "Сведения о родителях"
        familyTableData.clear();
        Connection connection = DBConnection.getConnection();
        ResultSet resultSet = connection.createStatement().executeQuery("SELECT * FROM parents_data");
        while (resultSet.next()){
            familyTableData.add(new parentsTable(resultSet.getString(1),
                    resultSet.getString(2), resultSet.getString(3),
                    resultSet.getString(4), resultSet.getString(5), resultSet.getString(6),
                    resultSet.getString(7),  resultSet.getString(8), resultSet.getString(9),
                    resultSet.getString(10), resultSet.getString(11)));
        }
        idParentsDataColumn.setCellValueFactory(new PropertyValueFactory<>("IdParentsDataColumn"));
        familyStatusColumn.setCellValueFactory(new PropertyValueFactory<>("FamilyStatusColumn"));
        childQuantColumn.setCellValueFactory(new PropertyValueFactory<>("ChildQuantColumn"));
        FIOmumColumn.setCellValueFactory(new PropertyValueFactory<>("FIOmumColumn"));
        homeAddressMumColumn.setCellValueFactory(new PropertyValueFactory<>("HomeAddressMumColumn"));
        phoneNumMumColumn.setCellValueFactory(new PropertyValueFactory<>("PhoneNumMumColumn"));
        workPlaceMumColumn.setCellValueFactory(new PropertyValueFactory<>("WorkPlaceMumColumn"));
        FIOdadColumn.setCellValueFactory(new PropertyValueFactory<>("FIOdadColumn"));
        houseAddressDadColumn.setCellValueFactory(new PropertyValueFactory<>("HouseAddressDadColumn"));
        phoneNumDadColumn.setCellValueFactory(new PropertyValueFactory<>("PhoneNumDadColumn"));
        dadWorkPlaceColumn.setCellValueFactory(new PropertyValueFactory<>("DadWorkPlaceColumn"));
        familyDataTable.setItems(familyTableData);
    }

    public void removeApplicantString() throws SQLException{ // Удаление данных из таблицы "Абитуриенты"
        idApplicant--;
        String query = "DELETE FROM applicants_information WHERE idapplicant= ?";
        PreparedStatement statement = DBConnection.getConnection().prepareStatement(query);
        statement.setInt(1, Integer.parseInt(applicantNumField.getText()));
        statement.executeUpdate();

        query = "DELETE FROM private_applicant_data WHERE idapplicant= ?";
        PreparedStatement statementTwo = DBConnection.getConnection().prepareStatement(query);
        statementTwo.setInt(1, Integer.parseInt(applicantNumField.getText()));
        statementTwo.executeUpdate();

        query = "DELETE FROM parents_data WHERE idapplicant= ?";
        PreparedStatement statementThree = DBConnection.getConnection().prepareStatement(query);
        statementThree.setInt(1, Integer.parseInt(applicantNumField.getText()));
        statementThree.executeUpdate();

        query = "DELETE FROM education_information WHERE idapplicant= ?";
        PreparedStatement statementFour = DBConnection.getConnection().prepareStatement(query);
        statementFour.setInt(1, Integer.parseInt(applicantNumField.getText()));
        statementFour.executeUpdate();

        applicantNumField.setText("");
        printApplicantTable();
        printApplicantDataTable();
        printEducationTable();
        printParentsTable();
    }

    public void fillApplicantTable() throws SQLException{ // Добавление данных в таблицу "Абитуриенты"
        idApplicant++;
        String query = "INSERT applicants_information(idapplicant, name_lastname, birthdate, home_address, phone_num)" +
                " VALUES(?, ?, ?, ?, ?)";
        PreparedStatement statement = DBConnection.getConnection().prepareStatement(query);
        statement.setInt(1, idApplicant);
        statement.setString(2, applicantFIOField.getText());
        statement.setString(3, applicantBirthdateField.getText());
        statement.setString(4, homeAddressField.getText());
        statement.setString(5, phoneNumField.getText());
        statement.executeUpdate();

        query = "INSERT INTO private_applicant_data(idapplicant) VALUES(?)";
        PreparedStatement statementTwo = DBConnection.getConnection().prepareStatement(query);
        statementTwo.setInt(1, idApplicant);
        statementTwo.executeUpdate();

        query = "INSERT INTO parents_data(idapplicant) VALUES(?)";
        PreparedStatement statementThree = DBConnection.getConnection().prepareStatement(query);
        statementThree.setInt(1, idApplicant);
        statementThree.executeUpdate();

        query = "INSERT INTO education_information(idapplicant) VALUES(?)";
        PreparedStatement statementFour = DBConnection.getConnection().prepareStatement(query);
        statementFour.setInt(1, idApplicant);
        statementFour.executeUpdate();

        applicantNumField.setText("");
        applicantFIOField.setText("");
        applicantBirthdateField.setText("");
        homeAddressField.setText("");
        phoneNumField.setText("");
        printApplicantTable();
        printApplicantDataTable();
        printEducationTable();
        printParentsTable();
    }

    public void changeApplicantString() throws SQLException{ // Редактирование данных в таблице "Абитуриенты"
        applicantOutputField.setText("");

        String query = "UPDATE applicants_information SET name_lastname= ?, birthdate= ?, home_address= ?, phone_num= ?" +
                "WHERE idapplicant= ?";

        PreparedStatement statement = DBConnection.getConnection().prepareStatement(query);

        if(!applicantFIOField.getText().equals("")){
            statement.setString(1, applicantFIOField.getText());
        } else {
            ResultSet resultSet = DBConnection.getConnection().createStatement().executeQuery(
                    "SELECT * FROM applicants_information WHERE idapplicant= " + applicantNumField.getText());
            resultSet.next();
            statement.setString(1, resultSet.getString("name_lastname"));
        }

        if(!applicantBirthdateField.getText().equals("")){
            statement.setString(2, applicantBirthdateField.getText());
        } else {
            ResultSet resultSet = DBConnection.getConnection().createStatement().executeQuery(
                    "SELECT * FROM applicants_information WHERE idapplicant= " + applicantNumField.getText());
            resultSet.next();
            statement.setString(2, resultSet.getString("birthdate"));
        }

        if(!homeAddressField.getText().equals("")){
            statement.setString(3, homeAddressField.getText());
        } else {
            ResultSet resultSet = DBConnection.getConnection().createStatement().executeQuery(
                    "SELECT * FROM applicants_information WHERE idapplicant= " + applicantNumField.getText());
            resultSet.next();
            statement.setString(3, resultSet.getString("home_address"));
        }

        if(!phoneNumField.getText().equals("")){
            statement.setString(4, phoneNumField.getText());
        } else {
            ResultSet resultSet = DBConnection.getConnection().createStatement().executeQuery(
                    "SELECT * FROM applicants_information WHERE idapplicant= " + applicantNumField.getText());
            resultSet.next();
            statement.setString(4, resultSet.getString("phone_num"));
        }

        statement.setString(5, applicantNumField.getText());
        statement.executeUpdate();
        applicantNumField.setText("");
        applicantFIOField.setText("");
        applicantBirthdateField.setText("");
        homeAddressField.setText("");
        phoneNumField.setText("");
        printApplicantTable();
    }

    public void changeApplicantDataString() throws SQLException{ // Изменение данных в таблице "Личные данные абитуриентов"
        applicantDataOutputField.setText("");

        String queryTwo = "UPDATE private_applicant_data SET lastname_name=?, birthdate=?, bith_place=?, passport_data=?," +
                " birth_certificate_data=? WHERE idapplicant=?";

        PreparedStatement statement = DBConnection.getConnection().prepareStatement(queryTwo);

        if(!applicantDataFIOField.getText().equals("")){
            statement.setString(1, applicantDataFIOField.getText());
        } else {
            ResultSet resultSet = DBConnection.getConnection().createStatement().executeQuery(
                    "SELECT * FROM private_applicant_data WHERE idapplicant= " + applicantDataNumField.getText());
            resultSet.next();
            statement.setString(1, resultSet.getString("lastname_name"));
        }

        if(!applicantDataBithdateField.getText().equals("")){
            statement.setString(2, applicantDataBithdateField.getText());
        } else {
            ResultSet resultSet = DBConnection.getConnection().createStatement().executeQuery(
                    "SELECT * FROM private_applicant_data WHERE idapplicant= " +applicantDataNumField.getText());
            resultSet.next();
            statement.setString(2, resultSet.getString("birthdate"));
        }

        if(!applicantDataBithplaceField.getText().equals("")){
            statement.setString(3, applicantDataBithplaceField.getText());
        } else {
            ResultSet resultSet = DBConnection.getConnection().createStatement().executeQuery(
                    "SELECT * FROM private_applicant_data WHERE idapplicant= " + applicantDataNumField.getText());
            resultSet.next();
            statement.setString(3, resultSet.getString("bith_place"));
        }

        if(!applicantDataPassportDataField.getText().equals("")){
            statement.setString(4, applicantDataPassportDataField.getText());
        } else {
            ResultSet resultSet = DBConnection.getConnection().createStatement().executeQuery(
                    "SELECT * FROM private_applicant_data WHERE idapplicant= " + applicantDataNumField.getText());
            resultSet.next();
            statement.setString(4, resultSet.getString("passport_data"));
        }

        if(!applicantDataBithCertDataField.getText().equals("")){
            statement.setString(5, applicantDataBithCertDataField.getText());
        } else {
            ResultSet resultSet = DBConnection.getConnection().createStatement().executeQuery(
                    "SELECT * FROM private_applicant_data WHERE idapplicant= " + applicantDataNumField.getText());
            resultSet.next();
            statement.setString(5, resultSet.getString("birth_certificate_data"));
        }
        statement.setString(6, applicantDataNumField.getText());

        statement.executeUpdate();
        applicantDataNumField.setText("");
        applicantDataFIOField.setText("");
        applicantDataBithdateField.setText("");
        applicantDataBithplaceField.setText("");
        applicantDataPassportDataField.setText("");
        applicantDataBithCertDataField.setText("");
        printApplicantDataTable();
    }

    public void changeEducationalString() throws SQLException{ // Изменение данных в таблице "Сведения об образовании"
        educationalDataOutputField.setText("");

        String queryTwo = "UPDATE education_information SET last_education_level=?, education_certificate_number=?, " +
                "certificate_average_score=?, selected_specialization=?, specialization_code=?, " +
                "name_of_specialization=? WHERE idapplicant=?";

        PreparedStatement statement = DBConnection.getConnection().prepareStatement(queryTwo);

        if(!educationalLevelField.getText().equals("")){
            statement.setString(1, educationalLevelField.getText());
        } else {
            ResultSet resultSet = DBConnection.getConnection().createStatement().executeQuery(
                    "SELECT * FROM education_information WHERE idapplicant= " + idEducationalDataField.getText());
            resultSet.next();
            statement.setString(1, resultSet.getString("last_education_level"));
        }

        if(!educationalCertificateNumberField.getText().equals("")){
            statement.setString(2, educationalCertificateNumberField.getText());
        } else {
            ResultSet resultSet = DBConnection.getConnection().createStatement().executeQuery(
                    "SELECT * FROM education_information WHERE idapplicant= " + idEducationalDataField.getText());
            resultSet.next();
            statement.setString(2, resultSet.getString("education_certificate_number"));
        }

        if(!educationalCertificateAverageNumField.getText().equals("")){
            statement.setString(3, educationalCertificateAverageNumField.getText());
        } else {
            ResultSet resultSet = DBConnection.getConnection().createStatement().executeQuery(
                    "SELECT * FROM education_information WHERE idapplicant= " + idEducationalDataField.getText());
            resultSet.next();
            statement.setString(3, resultSet.getString("certificate_average_score"));
        }

        if(!selectedSpecialityField.getText().equals("")){
            statement.setString(4, selectedSpecialityField.getText());
        } else {
            ResultSet resultSet = DBConnection.getConnection().createStatement().executeQuery(
                    "SELECT * FROM education_information WHERE idapplicant= " + idEducationalDataField.getText());
            resultSet.next();
            statement.setString(4, resultSet.getString("selected_specialization"));
        }

        if(!specialityCodeField.getText().equals("")){
            statement.setString(5, specialityCodeField.getText());
        } else {
            ResultSet resultSet = DBConnection.getConnection().createStatement().executeQuery(
                    "SELECT * FROM education_information WHERE idapplicant= " + idEducationalDataField.getText());
            resultSet.next();
            statement.setString(5, resultSet.getString("specialization_code"));
        }

        if(!specialityNameField.getText().equals("")){
            statement.setString(6, specialityNameField.getText());
        } else {
            ResultSet resultSet = DBConnection.getConnection().createStatement().executeQuery(
                    "SELECT * FROM education_information WHERE idapplicant= " + idEducationalDataField.getText());
            resultSet.next();
            statement.setString(6, resultSet.getString("name_of_specialization"));
        }

        statement.setString(7, idEducationalDataField.getText());

        statement.executeUpdate();
        idEducationalDataField.setText("");
        educationalLevelField.setText("");
        educationalCertificateNumberField.setText("");
        educationalCertificateAverageNumField.setText("");
        selectedSpecialityField.setText("");
        specialityCodeField.setText("");
        specialityNameField.setText("");
        printEducationTable();
    }

    public void changeParentsString() throws SQLException{ // Изменение данных в таблице "Сведения о родителях"
        parentsDataOutputField.setText("");

        String queryTwo = "UPDATE parents_data SET family_status=?, family_child_quantity=?, name_lastname_mum=?, " +
                "mum_home_address=?, mum_phone=?, mum_work_place=?, name_lastname_dad=?, dad_house_address=?, " +
                "dad_phone=?, dad_work_place=? WHERE idapplicant=?";

        PreparedStatement statement = DBConnection.getConnection().prepareStatement(queryTwo);

        if(!familyStatusField.getText().equals("")){
            statement.setString(1, familyStatusField.getText());
        } else {
            ResultSet resultSet = DBConnection.getConnection().createStatement().executeQuery(
                    "SELECT * FROM parents_data WHERE idapplicant= " + idParentsDataField.getText());
            resultSet.next();
            statement.setString(1, resultSet.getString("family_status"));
        }

        if(!childQuantField.getText().equals("")){
            statement.setString(2, childQuantField.getText());
        } else {
            ResultSet resultSet = DBConnection.getConnection().createStatement().executeQuery(
                    "SELECT * FROM parents_data WHERE idapplicant= " + idParentsDataField.getText());
            resultSet.next();
            statement.setString(2, resultSet.getString("family_child_quantity"));
        }

        if(!FIOmumField.getText().equals("")){
            statement.setString(3, FIOmumField.getText());
        } else {
            ResultSet resultSet = DBConnection.getConnection().createStatement().executeQuery(
                    "SELECT * FROM parents_data WHERE idapplicant= " + idParentsDataField.getText());
            resultSet.next();
            statement.setString(3, resultSet.getString("name_lastname_mum"));
        }

        if(!homeAddressMumField.getText().equals("")){
            statement.setString(4, homeAddressMumField.getText());
        } else {
            ResultSet resultSet = DBConnection.getConnection().createStatement().executeQuery(
                    "SELECT * FROM parents_data WHERE idapplicant= " + idParentsDataField.getText());
            resultSet.next();
            statement.setString(4, resultSet.getString("mum_home_address"));
        }

        if(!phoneNumMumField.getText().equals("")){
            statement.setString(5, phoneNumMumField.getText());
        } else {
            ResultSet resultSet = DBConnection.getConnection().createStatement().executeQuery(
                    "SELECT * FROM parents_data WHERE idapplicant= " + idParentsDataField.getText());
            resultSet.next();
            statement.setString(5, resultSet.getString("mum_phone"));
        }

        if(!workPlaceMumField.getText().equals("")){
            statement.setString(6, workPlaceMumField.getText());
        } else {
            ResultSet resultSet = DBConnection.getConnection().createStatement().executeQuery(
                    "SELECT * FROM parents_data WHERE idapplicant= " + idParentsDataField.getText());
            resultSet.next();
            statement.setString(6, resultSet.getString("mum_work_place"));
        }

        if(!FIOdadField.getText().equals("")){
            statement.setString(7, FIOdadField.getText());
        } else {
            ResultSet resultSet = DBConnection.getConnection().createStatement().executeQuery(
                    "SELECT * FROM parents_data WHERE idapplicant= " + idParentsDataField.getText());
            resultSet.next();
            statement.setString(7, resultSet.getString("name_lastname_dad"));
        }

        if(!houseAddressDadField.getText().equals("")){
            statement.setString(8, houseAddressDadField.getText());
        } else {
            ResultSet resultSet = DBConnection.getConnection().createStatement().executeQuery(
                    "SELECT * FROM parents_data WHERE idapplicant= " + idParentsDataField.getText());
            resultSet.next();
            statement.setString(8, resultSet.getString("dad_house_address"));
        }

        if(!phoneNumDadField.getText().equals("")){
            statement.setString(9, phoneNumDadField.getText());
        } else {
            ResultSet resultSet = DBConnection.getConnection().createStatement().executeQuery(
                    "SELECT * FROM parents_data WHERE idapplicant= " + idParentsDataField.getText());
            resultSet.next();
            statement.setString(9, resultSet.getString("dad_phone"));
        }

        if(!dadWorkPlaceField.getText().equals("")){
            statement.setString(10, dadWorkPlaceField.getText());
        } else {
            ResultSet resultSet = DBConnection.getConnection().createStatement().executeQuery(
                    "SELECT * FROM parents_data WHERE idapplicant= " + idParentsDataField.getText());
            resultSet.next();
            statement.setString(10, resultSet.getString("dad_work_place"));
        }

        statement.setString(11, idParentsDataField.getText());

        statement.executeUpdate();
        idParentsDataField.setText("");
        familyStatusField.setText("");
        childQuantField.setText("");
        FIOmumField.setText("");
        homeAddressMumField.setText("");
        phoneNumMumField.setText("");
        workPlaceMumField.setText("");
        FIOdadField.setText("");
        houseAddressDadField.setText("");
        phoneNumDadField.setText("");
        dadWorkPlaceField.setText("");
        printParentsTable();
    }

}

