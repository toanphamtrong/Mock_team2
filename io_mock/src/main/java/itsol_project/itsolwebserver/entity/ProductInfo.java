package itsol_project.itsolwebserver.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "productInfo")
@Getter
@Setter
public class ProductInfo extends BaseEntity {
    @ManyToOne
    private Product product;
    @ManyToOne
    private Color color; // màu sắc
    @ManyToOne
    private Size size; // kích cỡ
    private String image; // ảnh
    private Long numberProduct; // số sản phẩm

    public ProductInfo() {}


}
