package net.model;


import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity
@Table(name = "user")
public class User {
    @NotEmpty
    @Size(min = 4,max = 20,message = "Login title must be from 6 to 20 characters!")
    private String loggin;
    @NotEmpty
    @Size(min = 4,max = 20,message = "Login title must be from 6 to 20 characters!")
    private String password;
    private long sessionId;
    @NotEmpty
    @Email
    private String email;

    @Id
    @Column(name = "login")
    public String getLoggin() {
        return loggin;
    }


    public void setLoggin(String loggin) {
        this.loggin = loggin;
    }

    @Basic
    @Column(name = "password")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Basic
    @Column(name = "session_id")
    public long getSessionId() {
        return sessionId;
    }

    public void setSessionId(long sessionId) {
        this.sessionId = sessionId;
    }

    @Basic
    @Column(name = "email")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (sessionId != user.sessionId) return false;
        if (loggin != null ? !loggin.equals(user.loggin) : user.loggin != null) return false;
        if (password != null ? !password.equals(user.password) : user.password != null) return false;
        return email != null ? email.equals(user.email) : user.email == null;
    }

    @Override
    public int hashCode() {
        int result = loggin != null ? loggin.hashCode() : 0;
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (int) (sessionId ^ (sessionId >>> 32));
        result = 31 * result + (email != null ? email.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "User{" +
                "loggin='" + loggin + '\'' +
                ", password='" + password + '\'' +
                ", sessionId=" + sessionId +
                ", email='" + email + '\'' +
                '}';
    }
}
