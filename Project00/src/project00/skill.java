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
@Table(name="skill")
public class skill implements java.io.Serializable{
     @Id
     @Column(name="skillNo")
     private int skillNo;
     
     @Id
     @Column(name="CVID")
     private  int CVID;
     
     @Column(name="skillName")
     private String skillName;

    public skill() {
    }

    public int getSkillNo() {
        return skillNo;
    }

    public void setSkillNo(int skillNo) {
        this.skillNo = skillNo;
    }

    public int getCVID() {
        return CVID;
    }

    public void setCVID(int CVID) {
        this.CVID = CVID;
    }

    public String getSkillName() {
        return skillName;
    }

    public void setSkillName(String skillName) {
        this.skillName = skillName;
    }
      public static List<skill> getlist(int cvid){
      Session session = HibernateUtil.getSessionFactory().openSession();
        List<skill> sList = null;
        String queryStr = "from skill";
        Query query = session.createQuery(queryStr);
        sList = query.list();
        session.close();
        List<skill> lanList = new ArrayList<skill>();
        boolean flag = false;
        for (skill s : sList) {
            if (s.getCVID() == cvid) {
                lanList.add(s);
                flag = true;
            }

        }
        if(!flag){
            lanList.add(new skill());}
        return lanList;

    }}


