package com.example.demo.models;


import javax.persistence.*;

@Entity
@Table(name = "client")
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Long id_user_id;
    private String first_name, second_name, patronymic, phone, address, driver_license, email, series, pass_number;
    private int experience;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId_user_id() {
        return id_user_id;
    }

    public void setId_user_id(Long id_user_id) {
        this.id_user_id = id_user_id;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
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

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public Client() {
    }

    public Client(Long id_user_id, String first_name, String second_name, String patronymic, String phone, String address, String driver_license, String email, String series, String pass_number, int experience) {
        this.id_user_id = id_user_id;
        this.first_name = first_name;
        this.second_name = second_name;
        this.patronymic = patronymic;
        this.phone = phone;
        this.address = address;
        this.driver_license = driver_license;
        this.email = email;
        this.series = series;
        this.pass_number = pass_number;
        this.experience = experience;
    }
}
