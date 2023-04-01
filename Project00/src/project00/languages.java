/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project00;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author areejbaw
 */
@Entity
@Table(name = "languages")
public class languages implements java.io.Serializable {

    @Id
    @Column(name = "languageL")
    private String language;

    @Id
    @Column(name = "CVID")
    private int CVID;

    @Column(name = "levelL")
    private String level;

    public languages() {
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public int getCVID() {
        return CVID;
    }

    public void setCVID(int CVID) {
        this.CVID = CVID;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public static List<languages> getlist(int cvid) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<languages> sList = null;
        String queryStr = "from languages";
        Query query = session.createQuery(queryStr);
        sList = query.list();
        session.close();
        List<languages> lanList = new ArrayList<languages>();
        boolean flag = false;
        for (languages s : sList) {
            if (s.getCVID() == cvid) {
                lanList.add(s);
                flag=true;
            }

        }
//        if(!flag){
//            lanList.add(new languages());
//        }
        return lanList;

    }
}
