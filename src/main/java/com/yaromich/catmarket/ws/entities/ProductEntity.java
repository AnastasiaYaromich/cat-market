package com.yaromich.catmarket.ws.entities;

import lombok.Data;
import javax.persistence.*;


@Entity
@Table(name = "products")
@Data
public class ProductEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "price")
    private Integer price;

    @ManyToOne
    @JoinColumn(name = "categories_id")
    private CategoryEntity categories;
}
