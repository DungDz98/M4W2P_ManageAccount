package model;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.sql.Date;

@Entity
@Table(name = "account")
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idtk;
    @NotEmpty(message = "Khong duoc de trong")
    private String username;
    @Size(min = 6, message = "Mat khau phai co it nhat 6 ky tu")
    @Pattern(regexp = "^\\w+$", message = "Sai dinh dang, chi bao gom chu hoac so")
    private String password;
    @NotNull(message = "Vui long chon ngay")
    private Date createDate;


    public Account() {
    }

    public Account(String username, String password, Date createDate) {
        this.username = username;
        this.password = password;
        this.createDate = createDate;
    }

    public int getIdtk() {
        return idtk;
    }

    public void setIdtk(int idtk) {
        this.idtk = idtk;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
}
