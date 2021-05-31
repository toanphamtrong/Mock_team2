package itsol_project.itsolwebserver.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;
@Getter
@Setter
public class UserDto extends BaseDto{
    private String fullname;
//    private String code;
    private Date birthday; // ngày sinh
    private String email;
    private String phoneNumber; // số điện thoại
    private String address; // địa chỉ
    private String username;
    private String password;
//    private Boolean isAdminAccount; // loại tài khoản: ADMIN: true || CLIENT: false
    private int status;
    public UserDto() {
    }

}
