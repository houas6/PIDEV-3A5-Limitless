/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.util.Objects;

/**
 *
 * @author rassa
 */
public class product {
    
    private int id_product;
    private String name_product;
    private double price_product;

    public product() {
    }

    public product(int id_product, String name_product, double price_product) {
        this.id_product = id_product;
        this.name_product = name_product;
        this.price_product = price_product;
    }

    public int getId_product() {
        return id_product;
    }

    public void setId_product(int id_product) {
        this.id_product = id_product;
    }

    public String getName_product() {
        return name_product;
    }

    public void setName_product(String name_product) {
        this.name_product = name_product;
    }

    public double getPrice_product() {
        return price_product;
    }

    public void setPrice_product(double price_product) {
        this.price_product = price_product;
    }

    @Override
    public String toString() {
        return "product{" + "id_product=" + id_product + ", name_product=" + name_product + ", price_product=" + price_product + '}';
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + this.id_product;
        hash = 97 * hash + Objects.hashCode(this.name_product);
        hash = 97 * hash + (int) (Double.doubleToLongBits(this.price_product) ^ (Double.doubleToLongBits(this.price_product) >>> 32));
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final product other = (product) obj;
        if (this.id_product != other.id_product) {
            return false;
        }
        if (Double.doubleToLongBits(this.price_product) != Double.doubleToLongBits(other.price_product)) {
            return false;
        }
        if (!Objects.equals(this.name_product, other.name_product)) {
            return false;
        }
        return true;
    }
    
    
    
}
