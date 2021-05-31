package itsol_project.itsolwebserver.dto;

import itsol_project.itsolwebserver.entity.BaseEntity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RoleDto extends BaseDto {
    private Long user_id;
    private Long role_id;

    public RoleDto() {
    }
}
