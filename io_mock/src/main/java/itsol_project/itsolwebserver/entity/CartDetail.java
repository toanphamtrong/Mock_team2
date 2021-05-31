package itsol_project.itsolwebserver.entity;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table
public class CartDetail extends BaseEntity{
    @ManyToOne
    private Product product;
    private Long numberPro;// Số lượng sản phẩm cần mua của 1 sanr phẩm
    private Long totalMoney; //tổng tiền của 1 sản phẩm VD : 2*400 = 800
}
