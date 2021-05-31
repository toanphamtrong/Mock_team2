package itsol_project.itsolwebserver.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductTypeDto extends BaseDto{
    private String name;
    private String image;
    private Long priceSell;
    private Long sale;

    public ProductTypeDto() {
    }

}
