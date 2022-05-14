package sample;

public class applicantDataTable {
    String idApplicantDataColumn, applicantDataFIO, applicantDataBirthdate, applicantDataBirthplace, applicantDataPassportData,
            applicantDataBirthCertData;

    public applicantDataTable(String idApplicantDataColumn, String applicantDataFIO, String applicantDataBirthdate, String applicantDataBirthplace, String applicantDataPassportData, String applicantDataBirthCertData) {
        this.idApplicantDataColumn = idApplicantDataColumn;
        this.applicantDataFIO = applicantDataFIO;
        this.applicantDataBirthdate = applicantDataBirthdate;
        this.applicantDataBirthplace = applicantDataBirthplace;
        this.applicantDataPassportData = applicantDataPassportData;
        this.applicantDataBirthCertData = applicantDataBirthCertData;
    }

    public String getIdApplicantDataColumn() {
        return idApplicantDataColumn;
    }

    public void setIdApplicantDataColumn(String idApplicantDataColumn) {
        this.idApplicantDataColumn = idApplicantDataColumn;
    }

    public String getApplicantDataFIO() {
        return applicantDataFIO;
    }

    public void setApplicantDataFIO(String applicantDataFIO) {
        this.applicantDataFIO = applicantDataFIO;
    }

    public String getApplicantDataBirthdate() {
        return applicantDataBirthdate;
    }

    public void setApplicantDataBirthdate(String applicantDataBirthdate) {
        this.applicantDataBirthdate = applicantDataBirthdate;
    }

    public String getApplicantDataBirthplace() {
        return applicantDataBirthplace;
    }

    public void setApplicantDataBirthplace(String applicantDataBirthplace) {
        this.applicantDataBirthplace = applicantDataBirthplace;
    }

    public String getApplicantDataPassportData() {
        return applicantDataPassportData;
    }

    public void setApplicantDataPassportData(String applicantDataPassportData) {
        this.applicantDataPassportData = applicantDataPassportData;
    }

    public String getApplicantDataBirthCertData() {
        return applicantDataBirthCertData;
    }

    public void setApplicantDataBirthCertData(String applicantDataBirthCertData) {
        this.applicantDataBirthCertData = applicantDataBirthCertData;
    }

}
