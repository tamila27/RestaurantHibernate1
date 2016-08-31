package com.goit.gojavaonline.model;


import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * Created by tamila on 8/24/16.
 */
@Entity
@Table(name = "STORAGE")
public class StorageIngredient {
    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    @Column(name = "ID")
    private int id;

    @OneToOne
    @JoinColumn(name = "INGREDIENT_ID")
    private Ingredient ingredient;

    @Column(name = "QUANTITY")
    private float quantity;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Ingredient getIngredient() {
        return ingredient;
    }

    public void setIngredient(Ingredient ingredient) {
        this.ingredient = ingredient;
    }

    public float getQuantity() {
        return quantity;
    }

    public void setQuantity(float quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "StorageIngredient{" +
                "id=" + id +
                ", ingredient=" + ingredient +
                ", quantity=" + quantity +
                '}';
    }
}