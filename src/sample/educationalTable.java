package sample;

import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;

public class educationalTable {
    String idEducationalDataColumn, educationalLevelColumn, educationalCertificateNumberColumn,
            educationalCertificateAverageNumColumn, selectedSpecialityColumn, specialityCodeColumn, specialityNameColumn;
    
    public educationalTable(String idEducationalDataColumn, String educationalLevelColumn, String educationalCertificateNumberColumn, String educationalCertificateAverageNumColumn, String selectedSpecialityColumn, String specialityCodeColumn, String specialityNameColumn) {
        this.idEducationalDataColumn = idEducationalDataColumn;
        this.educationalLevelColumn = educationalLevelColumn;
        this.educationalCertificateNumberColumn = educationalCertificateNumberColumn;
        this.educationalCertificateAverageNumColumn = educationalCertificateAverageNumColumn;
        this.selectedSpecialityColumn = selectedSpecialityColumn;
        this.specialityCodeColumn = specialityCodeColumn;
        this.specialityNameColumn = specialityNameColumn;
    }

    public String getIdEducationalDataColumn() {
        return idEducationalDataColumn;
    }

    public void setIdEducationalDataColumn(String idEducationalDataColumn) {
        this.idEducationalDataColumn = idEducationalDataColumn;
    }

    public String getEducationalLevelColumn() {
        return educationalLevelColumn;
    }

    public void setEducationalLevelColumn(String educationalLevelColumn) {
        this.educationalLevelColumn = educationalLevelColumn;
    }

    public String getEducationalCertificateNumberColumn() {
        return educationalCertificateNumberColumn;
    }

    public void setEducationalCertificateNumberColumn(String educationalCertificateNumberColumn) {
        this.educationalCertificateNumberColumn = educationalCertificateNumberColumn;
    }

    public String getEducationalCertificateAverageNumColumn() {
        return educationalCertificateAverageNumColumn;
    }

    public void setEducationalCertificateAverageNumColumn(String educationalCertificateAverageNumColumn) {
        this.educationalCertificateAverageNumColumn = educationalCertificateAverageNumColumn;
    }

    public String getSelectedSpecialityColumn() {
        return selectedSpecialityColumn;
    }

    public void setSelectedSpecialityColumn(String selectedSpecialityColumn) {
        this.selectedSpecialityColumn = selectedSpecialityColumn;
    }

    public String getSpecialityCodeColumn() {
        return specialityCodeColumn;
    }

    public void setSpecialityCodeColumn(String specialityCodeColumn) {
        this.specialityCodeColumn = specialityCodeColumn;
    }

    public String getSpecialityNameColumn() {
        return specialityNameColumn;
    }

    public void setSpecialityNameColumn(String specialityNameColumn) {
        this.specialityNameColumn = specialityNameColumn;
    }

}