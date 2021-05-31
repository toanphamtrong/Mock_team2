package itsol_project.itsolwebserver.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ColorDto extends BaseDto{
    private String code;
    private String name;

    public ColorDto() {
    }
}
