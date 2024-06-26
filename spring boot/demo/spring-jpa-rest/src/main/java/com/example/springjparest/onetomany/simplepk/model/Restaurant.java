package com.example.springjparest.onetomany.simplepk.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.LinkedHashSet;
import java.util.Set;

@Data
@ToString(exclude = "dishes")
@EqualsAndHashCode(exclude = "dishes")
@Entity
@Table(name = "restaurants")
public class Restaurant {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @OneToMany(mappedBy = "restaurant", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Dish> dishes = new LinkedHashSet<>();

    @Column(nullable = false)
    private String name;

    public void resetDishSet(Set<Dish> dishes) {
        this.dishes.clear();
        this.dishes.addAll(dishes);
    }

    public void clearDishs(){
        this.dishes.clear();
    }
}
