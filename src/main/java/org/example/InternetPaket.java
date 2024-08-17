package org.example;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class InternetPaket {
    private final StringProperty firstName;
    private final StringProperty lastName;
    private final StringProperty address;
    private final SimpleIntegerProperty speed;
    private final StringProperty bandwidth;
    private final StringProperty duration;

    public InternetPaket(String firstName, String lastName, String address, int speed, String bandwidth, String duration) {
        this.firstName = new SimpleStringProperty(firstName);
        this.lastName = new SimpleStringProperty(lastName);
        this.address = new SimpleStringProperty(address);
        this.speed = new SimpleIntegerProperty(speed);
        this.bandwidth = new SimpleStringProperty(bandwidth);
        this.duration = new SimpleStringProperty(duration);
    }
    public int getSpeed() { return speed.get(); }
    public void setSpeed(int speed) { this.speed.set(speed); }
    public IntegerProperty speedProperty() { return speed; }

    public String getBandwidth() { return bandwidth.get(); }
    public void setBandwidth(String bandwidth) { this.bandwidth.set(bandwidth); }
    public StringProperty bandwidthProperty() { return bandwidth; }

    public String getDuration() { return duration.get(); }
    public void setDuration(String duration) { this.duration.set(duration); }
    public StringProperty durationProperty() { return duration; }

    public String getFirstName() { return firstName.get(); }
    public void setFirstName(String firstName) { this.firstName.set(firstName); }
    public StringProperty firstNameProperty() { return firstName; }

    public String getLastName() { return lastName.get(); }
    public void setLastName(String lastName) { this.lastName.set(lastName); }
    public StringProperty lastNameProperty() { return lastName; }

    public String getAddress() { return address.get(); }
    public void setAddress(String address) { this.address.set(address); }
    public StringProperty addressProperty() { return address; }
}
