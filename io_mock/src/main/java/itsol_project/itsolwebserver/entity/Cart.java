package itsol_project.itsolwebserver.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Setter
@Getter
@Entity
public class Cart extends BaseEntity{
    @ManyToOne
    private User user;
    private Long totalMonneyCart; //tong gia tri all don hang
    private Long totalNumber; //tong so luong san pham

    @ManyToOne
    private Product product ;

    public Cart() {
    }
}
