package com.example.demo.models;


import javax.persistence.*;

@Entity
@Table(name = "service")
public class Service {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Long id_auto_id;
    private Long id_road_accident_id;
    private String date_of_start, date_of_end, repair_description;

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

    public Long getId_road_accident_id() {
        return id_road_accident_id;
    }

    public void setId_road_accident_id(Long id_road_accident_id) {
        this.id_road_accident_id = id_road_accident_id;
    }

    public String getDate_of_start() {
        return date_of_start;
    }

    public void setDate_of_start(String date_of_start) {
        this.date_of_start = date_of_start;
    }

    public String getDate_of_end() {
        return date_of_end;
    }

    public void setDate_of_end(String date_of_end) {
        this.date_of_end = date_of_end;
    }

    public String getRepair_description() {
        return repair_description;
    }

    public void setRepair_description(String repair_description) {
        this.repair_description = repair_description;
    }

    public Service() {
    }

    public Service(Long id_auto_id, Long id_road_accident_id, String date_of_start, String date_of_end, String repair_description) {
        this.id_auto_id = id_auto_id;
        this.id_road_accident_id = id_road_accident_id;
        this.date_of_start = date_of_start;
        this.date_of_end = date_of_end;
        this.repair_description = repair_description;
    }

    public Service(Long id_auto_id, Long id_road_accident_id) {
        this.id_auto_id = id_auto_id;
        this.id_road_accident_id = id_road_accident_id;
    }
}
