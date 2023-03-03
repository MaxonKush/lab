package com.example.demo.models;

import javax.persistence.*;

@Entity
@Table(name = "confirm")
public class Confirm {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Long id_auto_id;
    private Long id_client_id;
    private String first_name, second_name, patronymic, phone, driver_license, email, series, pass_number, brand, model, number;
    private int experience;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId_auto_id() {
        return id_auto_id;
    }

    public void setId_auto_id(Long id_auto_id) {
        this.id_auto_id = id_auto_id;
    }

    public Long getId_client_id() {
        return id_client_id;
    }

    public void setId_client_id(Long id_client_id) {
        this.id_client_id = id_client_id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getSecond_name() {
        return second_name;
    }

    public void setSecond_name(String second_name) {
        this.second_name = second_name;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getDriver_license() {
        return driver_license;
    }

    public void setDriver_license(String driver_license) {
        this.driver_license = driver_license;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSeries() {
        return series;
    }

    public void setSeries(String series) {
        this.series = series;
    }

    public String getPass_number() {
        return pass_number;
    }

    public void setPass_number(String pass_number) {
        this.pass_number = pass_number;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public Confirm() {
    }

    public Confirm(Long id_auto_id, Long id_client_id, String first_name, String second_name,
                   String patronymic, String phone, String driver_license, String email, String series,
                   String pass_number, String brand, String model, String number, int experience) {
        this.id_auto_id = id_auto_id;
        this.id_client_id = id_client_id;
        this.first_name = first_name;
        this.second_name = second_name;
        this.patronymic = patronymic;
        this.phone = phone;
        this.driver_license = driver_license;
        this.email = email;
        this.series = series;
        this.pass_number = pass_number;
        this.brand = brand;
        this.model = model;
        this.number = number;
        this.experience = experience;
    }
}
