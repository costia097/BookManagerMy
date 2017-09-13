package net.model;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.Size;

public class UserLoginDTO {

    @NotEmpty
    @Size(min = 4,max = 25,message = "Login title must be from 6 to 20 characters!Nigga!!!")
    private String userLogin;

    @NotEmpty
    @Size(min = 4,max = 30,message = "Password title must be from 6 to 20 characters!Bitch")
    private String userPassword;

    @NotEmpty
    @Email
    private String userEmail;

    private String userStatus;

    private Integer userCode;

    public String getUserLogin() {
        return userLogin;
    }

    public void setUserLogin(String userLogin) {
        this.userLogin = userLogin;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserStatus() {
        return userStatus;
    }

    public void setUserStatus(String userStatus) {
        this.userStatus = userStatus;
    }

    public Integer getUserCode() {
        return userCode;
    }

    public void setUserCode(int userCode) {
        this.userCode = userCode;
    }
}
