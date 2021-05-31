package itsol_project.itsolwebserver.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ProductDto extends BaseDto{

    private String name;
    private String code;
    private Long priceSell; // giá bán
    private Double sale; // giảm giá
    private String image;
    private Long productTypeId; // loại sản phẩm
    private String productTypeName; // ở đây đặt tên giống vs tên ở bên ent + tên biến giá trị của đối tượng này: productType + Name, thì modelmapper nó phân truy cập sâu vào bên trong đối tượng lấy giá trị tướng ứng
    private Long brandId;
    private String brandName;
    private Long startPrice;
    private Long endPrice;
    private String status;
    private String description;
    private List<SizeDto> sizeList;
    private List<ColorDto> coloList;

    public ProductDto() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Long getPriceSell() {
        return priceSell;
    }

    public void setPriceSell(Long priceSell) {
        this.priceSell = priceSell;
    }

    public Double getSale() {
        return sale;
    }

    public void setSale(Double sale) {
        this.sale = sale;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMieuTa() {
        return description;
    }

    public void setMieuTa(String mieuTa) {
        this.description = mieuTa;
    }

}
