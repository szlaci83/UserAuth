package me.laszloszoboszlai.Entity;

import javax.persistence.*;
import java.util.List;

/**
 * Created by laci on 03/07/2017.
 */
@Entity
public class Role {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name = "roleName")
    private String roleName;

    @ManyToMany(mappedBy = "roles")
    List<User> users;


    public Role(){
    }

    public Role(int id, String roleName){
        this.id = id;
        this.roleName = roleName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    @Override
    public String toString() {
        return "Role{" +
                "id=" + id +
                ", roleName='" + roleName + '\'' +
                '}';
    }
}
