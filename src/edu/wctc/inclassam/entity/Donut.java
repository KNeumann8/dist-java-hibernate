package edu.wctc.inclassam.entity;

import edu.wctc.DateUtils;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="donut")
public class Donut {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="donut_id")
    private int id;
    @Column(name="shop_id")
    private int shopId;
    @Column(name="nm")
    private String name;
    @Column(name="calories")
    private int calories;
    @Column(name="img_filename")
    private String imageFilename;
    @Column(name="date_added")
    private Date dateAdded;

    public Donut() {
        // no-arg constructor
    }

    public Donut(int shopId, String name, int calories, String imageFilename, Date dateAdded) {
        this.shopId = shopId;
        this.name = name;
        this.calories = calories;
        this.imageFilename = imageFilename;
        this.dateAdded = dateAdded;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getShopId() {
        return shopId;
    }

    public void setShopId(int shopId) {
        this.shopId = shopId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCalories() {
        return calories;
    }

    public void setCalories(int calories) {
        this.calories = calories;
    }

    public String getImageFilename() {
        return imageFilename;
    }

    public void setImageFilename(String imageFilename) {
        this.imageFilename = imageFilename;
    }

    public Date getDateAdded() {
        return dateAdded;
    }

    public void setDateAdded(Date dateAdded) {
        this.dateAdded = dateAdded;
    }

    @Override
    public String toString() {
        return "Donut{" +
                "id=" + id +
                ", shopId=" + shopId +
                ", name='" + name + '\'' +
                ", calories=" + calories +
                ", imageFilename='" + imageFilename + '\'' +
                ", dateAdded=" + DateUtils.formatDate(dateAdded) +
                '}';
    }
}