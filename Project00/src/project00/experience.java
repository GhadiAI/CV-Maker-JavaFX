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
@Table(name = "experience")
public class experience implements java.io.Serializable {

    
    @Column(name = "jopTitle")
    private String jopTitle;

    @Id
    @Column(name = "CVID")
    private int CVID;

    @Column(name = "compName")
    private String compName;

    @Column(name = "startDate")
    private String startDate;

    @Column(name = "endDate")
    private String endDate;

    public experience() {
    }

    public experience(int cvid) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<experience> sList = null;
        String queryStr = "from experience";
        Query query = session.createQuery(queryStr);
        sList = query.list();
        session.close();
        boolean flag = false;
        for (experience s : sList) {
            if (s.getCVID() == cvid) {
                jopTitle = s.getJopTitle();
                compName = s.getCompName();
                startDate = s.getStartDate();
                endDate = s.getEndDate();
                CVID = cvid;
                gloabl.user.cv.experience = s;
                flag = true;
            }
        }
        if (!flag) {
            jopTitle = "";
            compName = "";
            startDate = "";
            endDate = "";
            CVID = cvid;
        }
    }

    public String getJopTitle() {
        return jopTitle;
    }

    public void setJopTitle(String jopTitle) {
        this.jopTitle = jopTitle;
    }

    public int getCVID() {
        return CVID;
    }

    public void setCVID(int CVID) {
        this.CVID = CVID;
    }

    public String getCompName() {
        return compName;
    }

    public void setCompName(String compName) {
        this.compName = compName;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

}
