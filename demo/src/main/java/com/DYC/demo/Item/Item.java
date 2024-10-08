package com.DYC.demo.Item;

import jakarta.persistence.*;
import lombok.ToString;

@Entity
@ToString
public class Item {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    public String product;

    @Column(columnDefinition = "TEXT")
    public String description;

    public Integer price;
    public Integer stock;
    public String category;
    /*
    public Date uploaded;
    public Date updated;
    public Date deleted;
    */
}
