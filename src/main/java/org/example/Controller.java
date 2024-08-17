package org.example;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

public class Controller {
    @FXML
    private TextField firstNameField;
    @FXML
    private TextField lastNameField;
    @FXML
    private TextField addressField;
    @FXML
    private TableView<InternetPaket> tableView;
    @FXML
    private TableColumn<InternetPaket, String> firstNameColumn;
    @FXML
    private TableColumn<InternetPaket, String> lastNameColumn;
    @FXML
    private TableColumn<InternetPaket, String> addressColumn;
    @FXML
    private TableColumn<InternetPaket, Integer> speedColumn;
    @FXML
    private TableColumn<InternetPaket, String> bandwidthColumn;
    @FXML
    private TableColumn<InternetPaket, String> durationColumn;

    @FXML
    private ToggleButton speed2, speed5, speed10, speed20, speed50, speed100;
    @FXML
    private ToggleButton bandwidth1, bandwidth5, bandwidth10, bandwidth100, bandwidthFlat;
    @FXML
    private ToggleButton duration1Year, duration2Years;

    private ToggleGroup speedGroup = new ToggleGroup();
    private ToggleGroup bandwidthGroup = new ToggleGroup();
    private ToggleGroup durationGroup = new ToggleGroup();
    private ObservableList<InternetPaket> data;

    @FXML
    private void initialize() {
        firstNameColumn.setCellValueFactory(new PropertyValueFactory<>("firstName"));
        lastNameColumn.setCellValueFactory(new PropertyValueFactory<>("lastName"));
        addressColumn.setCellValueFactory(new PropertyValueFactory<>("address"));
        speedColumn.setCellValueFactory(new PropertyValueFactory<>("speed"));
        bandwidthColumn.setCellValueFactory(new PropertyValueFactory<>("bandwidth"));
        durationColumn.setCellValueFactory(new PropertyValueFactory<>("duration"));


        speed2.setToggleGroup(speedGroup);
        speed5.setToggleGroup(speedGroup);
        speed10.setToggleGroup(speedGroup);
        speed20.setToggleGroup(speedGroup);
        speed50.setToggleGroup(speedGroup);
        speed100.setToggleGroup(speedGroup);

        bandwidth1.setToggleGroup(bandwidthGroup);
        bandwidth5.setToggleGroup(bandwidthGroup);
        bandwidth10.setToggleGroup(bandwidthGroup);
        bandwidth100.setToggleGroup(bandwidthGroup);
        bandwidthFlat.setToggleGroup(bandwidthGroup);

        duration1Year.setToggleGroup(durationGroup);
        duration2Years.setToggleGroup(durationGroup);

    }
    @FXML
    private void handleSavePackage() {
        String firstName = firstNameField.getText();
        String lastName = lastNameField.getText();
        String address = addressField.getText();

        ToggleButton selectedSpeed = (ToggleButton) speedGroup.getSelectedToggle();
        int speed = Integer.parseInt(selectedSpeed.getText());

        ToggleButton selectedBandwidth = (ToggleButton) bandwidthGroup.getSelectedToggle();
        String bandwidth = selectedBandwidth.getText();

        ToggleButton selectedDuration = (ToggleButton) durationGroup.getSelectedToggle();
        String duration = selectedDuration.getText();

        InternetPaket internetPaket = new InternetPaket(firstName, lastName, address, speed, bandwidth, duration);
        tableView.getItems().add(internetPaket);

        handleClearForm();
    }

    @FXML
    private void handleClearForm() {
        firstNameField.clear();
        lastNameField.clear();
        addressField.clear();
        speedGroup.getSelectedToggle().setSelected(false);
        bandwidthGroup.getSelectedToggle().setSelected(false);
        durationGroup.getSelectedToggle().setSelected(false);
    }

    @FXML
    private void handleDeleteTableRow() {
        int selectedIndex = tableView.getSelectionModel().getSelectedIndex();
        if (selectedIndex >= 0) {
            tableView.getItems().remove(selectedIndex);
        }
    }
}

