package itsol_project.itsolwebserver.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SizeDto extends BaseDto{
    private String code;
    private String name;

    public SizeDto() {
    }
}
