package itsol_project.itsolwebserver.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table
@Getter
@Setter
public class Brand extends BaseEntity{
    private String name;
    private String code;
    private String image;

    public Brand() {
    }
}
