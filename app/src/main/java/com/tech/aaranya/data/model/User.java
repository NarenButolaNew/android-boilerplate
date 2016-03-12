package com.tech.aaranya.data.model;

import android.support.annotation.NonNull;

import com.tech.aaranya.constants.StringConstant;

import java.io.Serializable;
import java.util.Map;

/**
 * Created by test on 3/8/16.
 */
public class User implements Serializable {
    private Address address;
    private String emailId;
    private String firstName;
    private String lastName;
    private String middleName;
    private String group;
    private String id;
    private Map<String, RegistrationDetail> registrationDetails;

    public User() {
    }

    @Override
    public String toString() {
        return "User{" +
                "address=" + address +
                ", emailId='" + emailId + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", middleName='" + middleName + '\'' +
                ", group='" + group + '\'' +
                ", id='" + id + '\'' +
                ", registrationDetails=" + registrationDetails +
                '}';
    }

    @NonNull
    public String nameDisplay() {
        StringBuilder nameBuilder = new StringBuilder(this.firstName);
        nameBuilder.append(StringConstant.SPACE);
        if (this.middleName != null && this.middleName.length() > 0) {
            nameBuilder.append(this.middleName);
            nameBuilder.append(StringConstant.SPACE);
        }
        nameBuilder.append(this.lastName);
        return nameBuilder.toString();
    }


    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Map<String, RegistrationDetail> getRegistrationDetails() {
        return registrationDetails;
    }

    public void setRegistrationDetails(Map<String, RegistrationDetail> registrationDetails) {
        this.registrationDetails = registrationDetails;
    }
}
