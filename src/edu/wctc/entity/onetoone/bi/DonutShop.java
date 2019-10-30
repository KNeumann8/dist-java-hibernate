package edu.wctc.entity.onetoone.bi;

import javax.persistence.*;

/**
 * This class demonstrates a one-to-one table relationship. A DonutShop object has one DonutShopDetail. Each DonutShopDetail belongs to one DonutShop.
 */

@Entity
@Table(name = "donut_shop")
public class DonutShop {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "shop_id")
    private int id;

    @Column(name = "nm")
    private String name;

    @Column(name = "img_directory")
    private String imageDirectory;

    // Set up relationship between a DonutShop and a DonutShopDetail
    // CascadeType.ALL means that when DonutShop updates, saves, refreshes, etc. its DonutShopDetail should also update, save, refresh, etc.
    // The detail_id column in the DonutShop table is a foreign key from the DonutShopDetail table
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "detail_id")
    private DonutShopDetail detail;

    public DonutShop() {
        // no-arg constructor
    }

    public DonutShop(String name, String imageDirectory) {
        this.name = name;
        this.imageDirectory = imageDirectory;
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

    public String getImageDirectory() {
        return imageDirectory;
    }

    public void setImageDirectory(String imageDirectory) {
        this.imageDirectory = imageDirectory;
    }

    public DonutShopDetail getDetail() {
        return detail;
    }

    public void setDetail(DonutShopDetail detail) {
        this.detail = detail;
    }

    @Override
    public String toString() {
        return "DonutShop{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", imageDirectory='" + imageDirectory + '\'' +
                ", detail=" + detail +
                '}';
    }
}
