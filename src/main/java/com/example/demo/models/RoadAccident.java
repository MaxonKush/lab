package com.example.demo.models;

import javax.persistence.*;

@Entity
@Table(name = "road_accident")
public class RoadAccident {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Long id_auto_id;
    private String date_road_accident, defect;

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

    public String getDate_road_accident() {
        return date_road_accident;
    }

    public void setDate_road_accident(String date_road_accident) {
        this.date_road_accident = date_road_accident;
    }

    public String getDefect() {
        return defect;
    }

    public void setDefect(String defect) {
        this.defect = defect;
    }

    public RoadAccident() {
    }

    public RoadAccident(Long id_auto_id, String date_road_accident, String defect) {
        this.id_auto_id = id_auto_id;
        this.date_road_accident = date_road_accident;
        this.defect = defect;
    }
}
