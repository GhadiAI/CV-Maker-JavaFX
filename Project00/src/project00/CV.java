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
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
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
@Table(name = "CV")
public class CV implements java.io.Serializable {
  static int i = -1;
    @Id
    @Column(name = "CVID")
    private int CVID;

//    @Id
    @Column(name = "idUser")
    private int idUser;

    @Column(name = "fname")
    public String fname;

    @Column(name = "email")
    private String email;
//

    @Column(name = "nationality")
    private String nationality;

    @Column(name = "phoneNum")
    private Integer phoneNum;

    @Column(name = "DOF")
    private String DOF;

    @Column(name = "maritalStatus")
    private String maritalStatus;

//    @JoinColumn(name = "idUser", referencedColumnName = "CV")
//    @OneToOne
//    public static CV cv=new CV(1);
//    
    @JoinColumn(name = "CVID", referencedColumnName = "education")
    @OneToOne
    public static education education;

    @OneToMany(targetEntity = languages.class, mappedBy = "CVID", fetch = FetchType.EAGER)
    @Fetch(value = FetchMode.SUBSELECT)
    public static List<languages> language;

    @JoinColumn(name = "CVID", referencedColumnName = "experience")
    @OneToOne
    public static experience experience;

    @OneToMany(targetEntity = skill.class, mappedBy = "CVID", fetch = FetchType.EAGER)
    @Fetch(value = FetchMode.SUBSELECT)
    public static List<skill> Skill;

    public CV() {
    }

    public CV(int userid) {
    Session session = HibernateUtil.getSessionFactory().openSession();
        List<CV> sList = null;
        String queryStr = "from CV";
        Query query = session.createQuery(queryStr);
        sList = query.list();
        session.close();
        for (CV s : sList) {
            if (i < s.CVID) {
                i = s.CVID;
            }
        }
        
        boolean flag = false;

        for (CV s : sList) {
            if (userid == s.getIdUser())
            {
              gloabl.user.cv = s;
              CVID=s.getCVID();
              idUser=userid;
              fname=s.getFname();
               email=s.getEmail();
               nationality=s.getNationality();
               phoneNum=s.getPhoneNum();
               DOF=s.getDOF();
               maritalStatus=s.getMaritalStatus(); 
               education = new education(s.getCVID());
               experience=new experience(s.getCVID());
               language= languages.getlist(gloabl.user.cv.getCVID());
               Skill=skill.getlist(gloabl.user.cv.getCVID());
             //  gloabl.user.cv.education=new education(s.getCVID());
               // gloabl.user.cv.experience=new experience(s.getCVID());
               
                    flag = true;
            }

        }
        
        if(!flag){
            CVID=i+1;   
              idUser=userid;
              fname="";
               email="";
               nationality="";
               phoneNum=0;
              DOF="";
               maritalStatus=""; 
//               education=new education();
//               experience=new experience();
//               language= languages.getlist(gloabl.user.cv.getCVID());
//               Skill=skill.getlist(gloabl.user.cv.getCVID());
        }
    }
    

    public int getCVID() {
        return CVID;
    }

    public void setCVID(int CVID) {
        this.CVID = CVID;
    }
    public void cvid(CV cv,int ii){
        
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public static List<languages> getLanguages() {
        return language;
    }

    public static void setLanguages(List<languages> languages) {
        CV.language = languages;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public Integer getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(Integer phoneNum) {
        this.phoneNum = phoneNum;
    }

    public String getDOF() {
        return DOF;
    }

    public void setDOF(String DOF) {
        this.DOF = DOF;
    }

    public String getMaritalStatus() {
        return maritalStatus;
    }

    public void setMaritalStatus(String maritalStatus) {
        this.maritalStatus = maritalStatus;
    }

    public  education getEducation() {
        return education;
    }

    public  void setEducation(education education) {
        CV.education = education;
    }

  
    public static experience getExperience() {
        return experience;
    }

    public static void setExperience(experience experience) {
        CV.experience = experience;
    }

    public static List<skill> getSkill() {
        return Skill;
    }

    public static void setSkill(List<skill> skill) {
        CV.Skill = skill;
    }
    

}
