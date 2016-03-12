package com.tech.aaranya.data.model;

import java.util.Date;
import java.util.List;

/**
 * Created by test on 3/7/16.
 */
public class Company {
    List<Employee> users;
    private String id;
    private String name;
    private Address address;
    private boolean isActive;
    private Date registrationDate;
    private Date updateDate;
    private Date deActivatedDate;
    private String updateBy;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setIsActive(boolean isActive) {
        this.isActive = isActive;
    }

    public Date getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(Date registrationDate) {
        this.registrationDate = registrationDate;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public Date getDeActivatedDate() {
        return deActivatedDate;
    }

    public void setDeActivatedDate(Date deActivatedDate) {
        this.deActivatedDate = deActivatedDate;
    }

    public String getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy;
    }

    public List<Employee> getUsers() {
        return users;
    }

    public void setUsers(List<Employee> users) {
        this.users = users;
    }
}
