package itsol_project.itsolwebserver.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "productType")
@Getter
@Setter
public class ProductType extends BaseEntity {
    @Column(nullable = false)
    private String name;
    private String code;
    @ManyToOne
    private ProductType productTypeParent;

    public ProductType(){}
}
