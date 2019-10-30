package edu.wctc.inclassam.entity;

import javax.persistence.*;

@Entity
@Table(name="donut_shop")
public class DonutShop {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="shop_id")
    private int id;
    @Column(name="nm")
    private String name;
    @Column(name="img_directory")
    private String imageDirectory;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="detail_id")
    private DonutShopDetail detail;

    public DonutShop() {

    }

    public DonutShop(String name, String imageDirectory) {
        this.name = name;
        this.imageDirectory = imageDirectory;
    }

    public DonutShopDetail getDetail() {
        return detail;
    }

    public void setDetail(DonutShopDetail detail) {
        this.detail = detail;
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
