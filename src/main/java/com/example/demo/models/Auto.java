package com.example.demo.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Auto {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String brand, model, body_type, color, transmission, fuel, photo, number;
    private Double engine, consumption_per_100, price_per_day;
    private int places, reserve, power, capacity, state;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getBody_type() {
        return body_type;
    }

    public void setBody_type(String body_type) {
        this.body_type = body_type;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getTransmission() {
        return transmission;
    }

    public void setTransmission(String transmission) {
        this.transmission = transmission;
    }

    public String getFuel() {
        return fuel;
    }

    public void setFuel(String fuel) {
        this.fuel = fuel;
    }

    public Double getPrice_per_day() {
        return price_per_day;
    }

    public void setPrice_per_day(Double price_per_day) {
        this.price_per_day = price_per_day;
    }

    public Double getEngine() {
        return engine;
    }

    public void setEngine(Double engine) {
        this.engine = engine;
    }

    public Double getConsumption_per_100() {
        return consumption_per_100;
    }

    public void setConsumption_per_100(Double consumption_per_100) {
        this.consumption_per_100 = consumption_per_100;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public int getPlaces() {
        return places;
    }

    public void setPlaces(int places) {
        this.places = places;
    }

    public int getReserve() {
        return reserve;
    }

    public void setReserve(int reserve) {
        this.reserve = reserve;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public Auto() {
    }

    public Auto(String brand, String model, String body_type, String color, String transmission,
                String fuel, String photo, String number, Double engine, Double consumption_per_100,
                Double price_per_day, int places, int reserve, int power, int capacity, int state) {
        this.brand = brand;
        this.model = model;
        this.body_type = body_type;
        this.color = color;
        this.transmission = transmission;
        this.fuel = fuel;
        this.photo = photo;
        this.number = number;
        this.engine = engine;
        this.consumption_per_100 = consumption_per_100;
        this.price_per_day = price_per_day;
        this.places = places;
        this.reserve = reserve;
        this.power = power;
        this.capacity = capacity;
        this.state = state;
    }

    /*brand = models.CharField('Марка', max_length=50, choices=BRAND)
    model = models.CharField('Модель', max_length=50)
    body_type = models.CharField('Тип кузова', max_length=50, choices=BODY_TYPE)
    number = models.CharField('Номер', max_length=5, unique=True)
    date_of_issue = models.DateField('Дата выпуска')
    color = models.CharField('Цвет', max_length=50, choices=COLOR)
    engine = models.FloatField('Объём двигателя (л.)', max_length=50, validators=[validate_even])
    transmission = models.CharField('Тип КП', max_length=50, choices=TRANSMISSION)
    consumption_per_100 = models.FloatField('Расход (на 100 км.)', max_length=50, validators=[validate_even])
    price_per_day = models.DecimalField('Цена в день (Br)', max_digits=18, decimal_places=2, validators=[validate_even])
    state = models.BooleanField('Доступна', default=True)
    reserve = models.CharField('Запас хода (км.)', max_length=5)
    places = models.CharField('Места', max_length=2, choices=PLACES)
    capacity = models.CharField('Багажник (л.)', max_length=5)
    fuel = models.CharField('Топливо', max_length=50, choices=FUEL_TYPE)
    power = models.CharField('Мощность (л.с.)', max_length=4)*/

}
