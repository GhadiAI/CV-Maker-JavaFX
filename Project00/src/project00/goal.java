/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project00;

import java.io.Serializable;
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
@Table(name = "goal")
public class goal implements Serializable {

    @Id
    @Column(name = "idUser")
    private int idUser;

    @Id
    @Column(name = "goalNo")
    private int goalNo;

    @Column(name = "goalName")
    private String goalName;

    @Column(name = "startDateG")
    private String startDateG;

    @Column(name = "deadline")
    private String deadline;

    @Column(name = "priority")
    private String priority;

    @Column(name = "isChecked")
    private boolean isChecked;

    public goal() {

    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public int getGoalNo() {
        return goalNo;
    }

    public void setGoalNo(int goalNo) {
        this.goalNo = goalNo;
    }

    public String getGoalName() {
        return goalName;
    }

    public void setGoalName(String goalName) {
        this.goalName = goalName;
    }

    public String getStartDateG() {
        return startDateG;
    }

    public void setStartDateG(String startDateG) {
        this.startDateG = startDateG;
    }

    public String getDeadline() {
        return deadline;
    }

    public void setDeadline(String deadline) {
        this.deadline = deadline;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public boolean getIsChecked() {
        return isChecked;
    }

    public void setIsChecked(boolean isChecked) {
        this.isChecked = isChecked;
    }

    public   goal addGoal( goal goal) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<goal> gList = null;
        String queryStr = "from goal";
        Query query = session.createQuery(queryStr);
        gList = query.list();
        session.close();
        List<goal> glist = new ArrayList<goal>();
        int gNum = 0;
        boolean flag = false;
        for (goal g : glist) {
            if (g.getIdUser() == idUser ) {
           gNum++;
                flag = true;
            }
       }
       
           
              
                goal.setGoalNo(gNum + 1);
          
                boolean b = false;
                goal.setIsChecked(b);
                gloabl.user.Goal.add(goal);
            

//            }
        
        return goal;

    }

    public static List<goal> getlist(int idUser) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<goal> gList = null;
        String queryStr = "from goal";
        Query query = session.createQuery(queryStr);
        gList = query.list();
        session.close();
        List<goal> lanList = new ArrayList<goal>();
        int gNum = 0;
        boolean flag = false;
        for (goal g : gList) {
            if (g.getIdUser() == idUser) {
                lanList.add(g);
                flag = true;

            }

//            }
        }

        return lanList;

    }}
