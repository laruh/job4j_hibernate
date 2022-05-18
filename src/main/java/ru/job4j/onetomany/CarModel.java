package ru.job4j.onetomany;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "model_car")
public class CarModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    public static CarModel of(String name) {
        CarModel model = new CarModel();
        model.name = name;
        return model;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        CarModel carModel = (CarModel) o;
        return id == carModel.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
