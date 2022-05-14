package sample;

public class applicantTable {
    String idApplicantColumn, FIOApplicantColumn, applicantBirthdateColumn, applicantHomeAddressColumn, applicantPhoneNumColumn;

    public applicantTable(String idApplicantColumn, String FIOApplicantColumn, String applicantBirthdateColumn, String applicantHomeAddressColumn, String applicantPhoneNumColumn) {
        this.idApplicantColumn = idApplicantColumn;
        this.FIOApplicantColumn = FIOApplicantColumn;
        this.applicantBirthdateColumn = applicantBirthdateColumn;
        this.applicantHomeAddressColumn = applicantHomeAddressColumn;
        this.applicantPhoneNumColumn = applicantPhoneNumColumn;
    }

    public String getIdApplicantColumn() {
        return idApplicantColumn;
    }

    public void setIdApplicantColumn(String idApplicantColumn) {
        this.idApplicantColumn = idApplicantColumn;
    }

    public String getFIOApplicantColumn() {
        return FIOApplicantColumn;
    }

    public void setFIOApplicantColumn(String FIOApplicantColumn) {
        this.FIOApplicantColumn = FIOApplicantColumn;
    }

    public String getApplicantBirthdateColumn() {
        return applicantBirthdateColumn;
    }

    public void setApplicantBirthdateColumn(String applicantBirthdateColumn) {
        this.applicantBirthdateColumn = applicantBirthdateColumn;
    }

    public String getApplicantHomeAddressColumn() {
        return applicantHomeAddressColumn;
    }

    public void setApplicantHomeAddressColumn(String applicantHomeAddressColumn) {
        this.applicantHomeAddressColumn = applicantHomeAddressColumn;
    }

    public String getApplicantPhoneNumColumn() {
        return applicantPhoneNumColumn;
    }

    public void setApplicantPhoneNumColumn(String applicantPhoneNumColumn) {
        this.applicantPhoneNumColumn = applicantPhoneNumColumn;
    }
}
