package sample;

import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;

public class parentsTable {

    String idParentsDataColumn, familyStatusColumn, childQuantColumn, FIOmumColumn, homeAddressMumColumn, phoneNumMumColumn,
            workPlaceMumColumn, FIOdadColumn, houseAddressDadColumn, phoneNumDadColumn, dadWorkPlaceColumn;

    public parentsTable(String idParentsDataColumn, String familyStatusColumn, String childQuantColumn, String FIOmumColumn,
                        String homeAddressMumColumn, String phoneNumMumColumn, String workPlaceMumColumn, String FIOdadColumn,
                        String houseAddressDadColumn, String phoneNumDadColumn, String dadWorkPlaceColumn) {
        this.idParentsDataColumn = idParentsDataColumn;
        this.familyStatusColumn = familyStatusColumn;
        this.childQuantColumn = childQuantColumn;
        this.FIOmumColumn = FIOmumColumn;
        this.homeAddressMumColumn = homeAddressMumColumn;
        this.phoneNumMumColumn = phoneNumMumColumn;
        this.workPlaceMumColumn = workPlaceMumColumn;
        this.FIOdadColumn = FIOdadColumn;
        this.houseAddressDadColumn = houseAddressDadColumn;
        this.phoneNumDadColumn = phoneNumDadColumn;
        this.dadWorkPlaceColumn = dadWorkPlaceColumn;
    }

    public String getIdParentsDataColumn() {
        return idParentsDataColumn;
    }

    public void setIdParentsDataColumn(String idParentsDataColumn) {
        this.idParentsDataColumn = idParentsDataColumn;
    }

    public String getFamilyStatusColumn() {
        return familyStatusColumn;
    }

    public void setFamilyStatusColumn(String familyStatusColumn) {
        this.familyStatusColumn = familyStatusColumn;
    }

    public String getChildQuantColumn() {
        return childQuantColumn;
    }

    public void setChildQuantColumn(String childQuantColumn) {
        this.childQuantColumn = childQuantColumn;
    }

    public String getFIOmumColumn() {
        return FIOmumColumn;
    }

    public void setFIOmumColumn(String FIOmumColumn) {
        this.FIOmumColumn = FIOmumColumn;
    }

    public String getHomeAddressMumColumn() {
        return homeAddressMumColumn;
    }

    public void setHomeAddressMumColumn(String homeAddressMumColumn) {
        this.homeAddressMumColumn = homeAddressMumColumn;
    }

    public String getPhoneNumMumColumn() {
        return phoneNumMumColumn;
    }

    public void setPhoneNumMumColumn(String phoneNumMumColumn) {
        this.phoneNumMumColumn = phoneNumMumColumn;
    }

    public String getWorkPlaceMumColumn() {
        return workPlaceMumColumn;
    }

    public void setWorkPlaceMumColumn(String workPlaceMumColumn) {
        this.workPlaceMumColumn = workPlaceMumColumn;
    }

    public String getFIOdadColumn() {
        return FIOdadColumn;
    }

    public void setFIOdadColumn(String FIOdadColumn) {
        this.FIOdadColumn = FIOdadColumn;
    }

    public String getHouseAddressDadColumn() {
        return houseAddressDadColumn;
    }

    public void setHouseAddressDadColumn(String houseAddressDadColumn) {
        this.houseAddressDadColumn = houseAddressDadColumn;
    }

    public String getPhoneNumDadColumn() {
        return phoneNumDadColumn;
    }

    public void setPhoneNumDadColumn(String phoneNumDadColumn) {
        this.phoneNumDadColumn = phoneNumDadColumn;
    }

    public String getDadWorkPlaceColumn() {
        return dadWorkPlaceColumn;
    }

    public void setDadWorkPlaceColumn(String dadWorkPlaceColumn) {
        this.dadWorkPlaceColumn = dadWorkPlaceColumn;
    }

}