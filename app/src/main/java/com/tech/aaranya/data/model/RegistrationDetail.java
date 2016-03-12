package com.tech.aaranya.data.model;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by test on 3/8/16.
 */
public class RegistrationDetail implements Serializable {
    private String deviceId;
    private boolean active;
    private boolean temporary;
    private Date activationDate;
    private Date temporaryLoginDate;

    public RegistrationDetail() {
    }

    @Override
    public String toString() {
        return "RegistrationDetail{" +
                "deviceId='" + deviceId + '\'' +
                ", active=" + active +
                ", temporary=" + temporary +
                ", activationDate=" + activationDate +
                ", temporaryLoginDate='" + temporaryLoginDate + '\'' +
                '}';
    }

    public Date getTemporaryLoginDate() {
        return temporaryLoginDate;
    }

    public void setTemporaryLoginDate(Date temporaryLoginDate) {
        this.temporaryLoginDate = temporaryLoginDate;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public boolean isTemporary() {
        return temporary;
    }

    public void setTemporary(boolean temporary) {
        this.temporary = temporary;
    }

    public Date getActivationDate() {
        return activationDate;
    }

    public void setActivationDate(Date activationDate) {
        this.activationDate = activationDate;
    }
}
