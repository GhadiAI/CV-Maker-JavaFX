/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project00;
import java.util.List;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Table;
import org.hibernate.Query;
import org.hibernate.Session;
/**
 *
 * @author areejbaw
 */
@Entity
@Table(name="education")
public class education implements java.io.Serializable{
     
     @Column(name="dgree")
     private String dgree;
     
     @Id
     @Column(name="CVID")
     private int CVID;
     
     @Column(name="gradDate")
     private String gradDate;
     
     @Column(name="uniName")
     private String uniName;

    public education() {
    }    
    public education(int cvid) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<education> sList = null;
        String queryStr = "from education";
        Query query = session.createQuery(queryStr);
        sList = query.list();
        session.close();
        boolean flag=false;
        for (education s : sList) {
            if (s.getCVID()==cvid){
               dgree=s.getDgree();
               CVID=cvid;
               gradDate=s.getGradDate();
                uniName=s.getUniName();
                gloabl.user.cv.education=s;
                flag=true;
            }
        }
        if(!flag){
            dgree="";
            CVID=cvid;
            gradDate="";
            uniName="";
            
        }
    }

    public String getDgree() {
        return dgree;
    }

    public void setDgree(String dgree) {
        this.dgree = dgree;
    }

    public int getCVID() {
        return CVID;
    }

    public void setCVID(int CVID) {
        this.CVID = CVID;
    }

    public String getGradDate() {
        return gradDate;
    }

    public void setGradDate(String gradDate) {
        this.gradDate = gradDate;
    }

    public String getUniName() {
        return uniName;
    }

    public void setUniName(String uniName) {
        this.uniName = uniName;
    }
     
     
     
}
