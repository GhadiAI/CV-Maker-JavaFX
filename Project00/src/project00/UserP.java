/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project00;

import java.util.List;
import java.util.Set;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

/**
 *
 * @author areejbaw
 */
@Entity
@Table(name = "UserP")
public class UserP implements java.io.Serializable {

    @Id
    @Column(name = "idUser")
    private int idUser;

    @Column(name = "email")
    private String email;

    @Column(name = "passwordUser")
    private String passwordUser;

    @Column(name = "username")
    private String username;
    

//    
    @JoinColumn(name = "idUser", referencedColumnName = "CV")
    @OneToOne
    public static CV cv;
    
        
    @JoinColumn(name = "goal", referencedColumnName = "idUser")
    @OneToMany
    @Fetch(value = FetchMode.SUBSELECT)
    public static List<goal> Goal;

    public UserP(int t) {

        Session session = HibernateUtil.getSessionFactory().openSession();
        List<UserP> sList = null;
        String queryStr = "from UserP";
        Query query = session.createQuery(queryStr);
       sList = query.list();
       System.out.println(sList);
        session.close();
        int i = -1;
        for (UserP s : sList) {
            if (i < s.idUser) {
                i = s.idUser;
            }
        }
       idUser = i+1;
       
    }

    public UserP() {
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPasswordUser() {
        return passwordUser;
    }

    public void setPasswordUser(String passwordUser) {
        this.passwordUser = passwordUser;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public List<goal> getGoal() {
        return Goal;
    }

    public void setGoal(List<goal> goal) {
        this.Goal = goal;
    }

//    public CV getCv() {
//        return cv;
//    }
//
//    public void setCv(CV cv) {
//        this.cv = cv;
//    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

}
