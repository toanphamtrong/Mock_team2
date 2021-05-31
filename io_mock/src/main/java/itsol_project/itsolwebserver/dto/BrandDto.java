package itsol_project.itsolwebserver.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BrandDto extends BaseDto{
    private String name;
    private String code;
    private String image;

    public BrandDto() {
    }
}
