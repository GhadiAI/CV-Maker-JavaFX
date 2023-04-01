/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project00;

import javafx.scene.paint.Color;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.SelectionMode;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

/**
 *
 * @author Ghadi
 */
public class GoalsController implements Initializable {

    //----------------------- OBSERVABLE LISTS--------------------------// 
    ObservableList<String> obGoalsName = FXCollections.observableArrayList();
    ObservableList<String> obDeadline = FXCollections.observableArrayList();
    ObservableList<String> obStartDate = FXCollections.observableArrayList();
    ObservableList<String> obCheckedG = FXCollections.observableArrayList();
    ObservableList<String> obPriority = FXCollections.observableArrayList();
    @FXML
    public ListView<String> ListDeadLine= new ListView(obDeadline);;

    @FXML
    public ListView<String> ListGoals= new ListView(obGoalsName);
    @FXML
    public ListView<String> ListStartDate = new ListView(obStartDate);;
    @FXML
    public ListView<String> checkedGoals= new ListView(obCheckedG);;
    @FXML
    private ListView<String> ListPriority = new ListView(obPriority);;

    @FXML
    private Button checked;

    @FXML
    private Button add;

    @FXML
    private DatePicker deadLine;

    @FXML
    private TextField nameGoal;

    @FXML
    private DatePicker startDate;

    //------------------Database---------------------//
    Label lblmsg = new Label();
    //  lblmsg.setTextFill(Color.DARKRED);
    @FXML
    private Text Goal_info;
    @FXML
    private ComboBox<String> priority;
    int gNum = 0;

    @FXML
    public void getAdd(ActionEvent event) {
//           Session session1 = HibernateUtil.getSessionFactory().openSession();
//           session1 = HibernateUtil.getSessionFactory().openSession();
//           Transaction tx = session1.beginTransaction();

        String name = nameGoal.getText();
        boolean available = obGoalsName.contains(name);

        if (!available) {

            if (!(nameGoal.getText().isEmpty() || deadLine.getValue() == null || startDate.getValue() == null)) {
                goal goalname = new goal();

                obGoalsName.add(nameGoal.getText());
                obDeadline.add(String.valueOf(deadLine.getValue()));
                obStartDate.add(String.valueOf(startDate.getValue()));
                obPriority.add(priority.getValue().toString());
                ListGoals.setItems(obGoalsName);
                ListDeadLine.setItems(obDeadline);
                ListStartDate.setItems(obStartDate);
                ListPriority.setItems(obPriority);

                goalname.setIdUser(gloabl.user.getIdUser());
                goalname.setGoalName(nameGoal.getText());
                goalname.setStartDateG(startDate.getValue().toString());
                goalname.setDeadline(deadLine.getValue().toString());
                goalname.setPriority(priority.getValue().toString());
//                  goal saveGoal=new goal();
                Session session = HibernateUtil.getSessionFactory().openSession();
                List<goal> gList = null;
                String queryStr = "from goal";
                Query query = session.createQuery(queryStr);
                gList = query.list();
                

                

                for (goal g : gList) {
                    System.out.println(g.getIdUser() + " " + goalname.getGoalName() + "  foor " + goalname.getIdUser() + " " + goalname.getGoalNo());
                    if (g.getIdUser() == goalname.getIdUser()) {
                        System.out.println(g.getIdUser() + " if  " + goalname.getIdUser() + " " + goalname.getGoalNo());
                        //goalname.setGoalNo(gNum);
                        gNum++;
                        

                    }
                }
                session.close();
                goalname.setGoalNo(gNum +1);
                goalname.setIsChecked(false);

//                  goalname=goalname.addGoal(  goalname);
                Session session1 = HibernateUtil.getSessionFactory().openSession();
                session1 = HibernateUtil.getSessionFactory().openSession();
                Transaction tx = session1.beginTransaction();

                session1.save(goalname);

                session1.getTransaction().commit();
                session1.close();
                List<goal> goalList = new ArrayList<goal>();
                goalList.add(goalname);

                gloabl.user.Goal = goalList;



//                  goalname.setgoalName(nameGoal.getText());
//                  goalname.obDeadline(ExDate.getValue().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
            } else {
                Alert a = new Alert(Alert.AlertType.NONE);
                a.setAlertType(Alert.AlertType.WARNING);
                a.setContentText("Please make sure to fill all the information !");
                a.show();
            }
        } else {

            Alert a = new Alert(Alert.AlertType.NONE);
            a.setAlertType(Alert.AlertType.WARNING);
            a.setContentText("You have goal with that name : " + name + " to edit click updat! ");
            a.show();
        }
      
       // boolean flag = false;
        //if (!(obGoalsName.isEmpty())) {
          //  flag = true;
        //}
        //if (flag ){
        String str = ListGoals.getSelectionModel().getSelectedItem();
        boolean flag = false;
        if (str != null) {
            flag = true;}
        CheckedIndexes();
            
            
            //}else{
            //System.out.println("Observable list is empty !!!");
        //}
    }

    @FXML
    public void getClear(ActionEvent event) {
         
        int seletedID = ListGoals.getSelectionModel().getSelectedIndex();
        String name= ListGoals.getSelectionModel().getSelectedItems().get(0);
        gNum=gNum+1;
        Session session = HibernateUtil.getSessionFactory().openSession();
            List<goal> gList = null;
            String queryStr = "from goal";
            Query query = session.createQuery(queryStr);
            gList = query.list();
            int PKuserID=0;
            int PCgoalNo=0;
            for (goal s: gList){
                if(s.getGoalName().equals(name)){
                    PKuserID=s.getIdUser();
                    PCgoalNo=s.getGoalNo();
                    s=null;
                    
                }
            }
            
            Session session2 = HibernateUtil.getSessionFactory().openSession();
            session2 = HibernateUtil.getSessionFactory().openSession();
            Transaction tx = session2.beginTransaction();
            
            //goal.setGoalNo(IndexOfItem);
            goal goal=new goal();
            goal.setGoalName(nameGoal.getText());
            goal.setDeadline(String.valueOf(deadLine.getValue()));
            goal.setStartDateG(String.valueOf(startDate.getValue()));
            goal.setPriority(priority.getValue().toString());
            goal.setGoalNo(PCgoalNo);
            goal.setIdUser(PKuserID);
            //goal.setGoalNo(gloabl.user.Goal.);

            session2.delete(goal);

            session2.getTransaction().commit();
            session2.close();
            
            //String queryStr2 = "delete FROM goal where goalNo="+PCgoalNo;
            
            //Query query2 = session.createQuery(queryStr2);

            session.close();
        ListGoals.getItems().remove(seletedID);
        ListDeadLine.getItems().remove(seletedID);
        ListStartDate.getItems().remove(seletedID);
        ListPriority.getItems().remove(seletedID);
        //DELETE FROM `movies` WHERE `movie_id` = 18;

    }

    @FXML
    public void getChecked(ActionEvent event) {
        String str = ListGoals.getSelectionModel().getSelectedItem();
//        String str1 = ListDeadLine.getSelectionModel().getSelectedItem();
//        String str2 = ListStartDate.getSelectionModel().getSelectedItem();
        int seletedID = ListGoals.getSelectionModel().getSelectedIndex();
        boolean flag = false;
        if (str != null) {
            flag = true;
            //ListGoals.getSelectionModel().clearSelection();
            Session session = HibernateUtil.getSessionFactory().openSession();
            List<goal> gList = null;
            String queryStr = "from goal";
            Query query = session.createQuery(queryStr);
            gList = query.list();
            session.close();

            for (goal g : gList) {
                if (str.equals(g.getGoalName())) {
                    Session session1 = HibernateUtil.getSessionFactory().openSession();
                    session1 = HibernateUtil.getSessionFactory().openSession();
                    Transaction tx = session1.beginTransaction();
                    g.setIsChecked(true);

                    session1.update(g);
                    session1.getTransaction().commit();
                    session1.close();

                }

            }

        }
        if (flag) {
           
        
            checkedGoals.setItems(obCheckedG);
            obCheckedG.add(str);
            obGoalsName.remove(str);

            ListDeadLine.getItems().remove(seletedID);
            ListStartDate.getItems().remove(seletedID);
            ListPriority.getItems().remove(seletedID);}
    
            
       // }if(flag){
        
               
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        CheckedIndexes();
        priority.setValue("Medium");
        priority.getItems().addAll("Important", "Medium", "Not Important");

//        msg.setTextFill(Color.DARKRED);
//        //msg.setMaxHeight(263);
//        msg.setTranslateX(263);
//         msg.setTranslateY(157);
//        msg.setMaxWidth(700);
//        msg.setMinHeight(100);
//        //msg.setMinWidth(700);
//        msg.setFont(new Font(20.0));
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<goal> gList = null;
        String queryStr = "from goal";
        Query query = session.createQuery(queryStr);
        gList = query.list();
        session.close();

        for (goal g : gList) {
            if (g.getIdUser() == gloabl.user.getIdUser()) {
                if (!g.getIsChecked()) {
                    obGoalsName.add(g.getGoalName());
                    obDeadline.add(g.getDeadline());
                    obStartDate.add(g.getStartDateG());
                    obPriority.add(g.getPriority());

                } else {
                    obCheckedG.add(g.getGoalName());
                }
            }
        }

        ListDeadLine.setItems(obDeadline);
        ListGoals.setItems(obGoalsName);
        ListStartDate.setItems(obStartDate);
        checkedGoals.setItems(obCheckedG);
        ListPriority.setItems(obPriority);

        Text ss = new Text("");
//        Goalinfo.textProperty().bind(checkedGoals.getSelectionModel().getSelectedItems());
        checkedGoals.getSelectionModel().selectedItemProperty().addListener(new InvalidationListener() {
            @Override
            public void invalidated(Observable ov) {

                Session session = HibernateUtil.getSessionFactory().openSession();
                List<goal> gList = null;
                String queryStr = "from goal";
                Query query = session.createQuery(queryStr);
                gList = query.list();

                String sss = "";
                for (goal g : gList) {
                    if (checkedGoals.getSelectionModel().getSelectedItems().get(0).equals(g.getGoalName())) {
                        Session session1 = HibernateUtil.getSessionFactory().openSession();
                        session1 = HibernateUtil.getSessionFactory().openSession();
                        Transaction tx = session1.beginTransaction();
                        sss = "Goal Name " + g.getGoalName() + " ,start date: " + g.getStartDateG() + " ,deadline: " + g.getDeadline() + " ,Priority: " + g.getPriority();
                        session1.getTransaction().commit();
                        session1.close();

                    }

                }

                session.close();
                Goal_info.setText(sss);
                System.out.println(sss);
                
                

                // TODO
            }
        });
    }

    @FXML
    private void Back_CourseMenu(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Project_Menu.fxml"));
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void getUpdate(ActionEvent event) {

        String name = ListGoals.getSelectionModel().getSelectedItems().get(0);
        boolean available = obGoalsName.contains(name);

        if (available) {
            System.out.println();
            int IndexOfItem = ListGoals.getSelectionModel().getSelectedIndex();;
            obGoalsName.set(IndexOfItem, nameGoal.getText());
            obDeadline.set(IndexOfItem, String.valueOf(deadLine.getValue()));
            obStartDate.set(IndexOfItem, String.valueOf(startDate.getValue()));
            obPriority.set(IndexOfItem, priority.getValue().toString());
            Session session = HibernateUtil.getSessionFactory().openSession();
            List<goal> gList = null;
            goal goal = new goal();

            String queryStr = "from goal";
            Query query = session.createQuery(queryStr);
            gList = query.list();
            int PKuserID=0;
            int PCgoalNo=0;
            for (goal s: gList){
                if(s.getGoalName().equals(name)){
                    PKuserID=s.getIdUser();
                    PCgoalNo=s.getGoalNo();
                    goal=s;
                    
                }
            }

            session.close();
            lblmsg.setText("Item " + name + " was updated");

            
            Session session2 = HibernateUtil.getSessionFactory().openSession();
            session2 = HibernateUtil.getSessionFactory().openSession();
            Transaction tx = session2.beginTransaction();
            
            //goal.setGoalNo(IndexOfItem);
            goal.setGoalName(nameGoal.getText());
            goal.setDeadline(String.valueOf(deadLine.getValue()));
            goal.setStartDateG(String.valueOf(startDate.getValue()));
            goal.setPriority(priority.getValue().toString());
            //goal.setGoalNo(PCgoalNo);
            //goal.setIdUser(PKuserID);
            //goal.setGoalNo(gloabl.user.Goal.);

            session2.update(goal);

            session2.getTransaction().commit();
            session2.close();
        } else {
            Alert a = new Alert(Alert.AlertType.NONE);
            a.setAlertType(Alert.AlertType.WARNING);
            a.setContentText("You don't have goal with that name : " + name + " to add click add! ");
            a.show();
        }

    }
    private void CheckedIndexes(){
          ListGoals.getSelectionModel().selectedItemProperty().addListener(e -> {

                    ListGoals.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
                    int index = ListGoals.getSelectionModel().getSelectedIndex();

                    ListPriority.getSelectionModel().select(index);
                    ListStartDate.getSelectionModel().select(index);
                    ListDeadLine.getSelectionModel().select(index);

                    if((obGoalsName.isEmpty())){
                        nameGoal.setText("");

                    //startDate.setValue(LocalDate.parse(""));
                    //deadLine.setValue(LocalDate.parse(""));
                    //priority.setValue("");
                    }else{
                    
                    nameGoal.setText(obGoalsName.get(index));

                    startDate.setValue(LocalDate.parse(obStartDate.get(index)));
                    deadLine.setValue(LocalDate.parse(obDeadline.get(index)));
                    priority.setValue(obPriority.get(index));}
                });

                ListStartDate.getSelectionModel().selectedItemProperty().addListener(e -> {
                    ListStartDate.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
                    int index = ListStartDate.getSelectionModel().getSelectedIndex();

                    ListGoals.getSelectionModel().select(index);

                    if((obGoalsName.isEmpty())){
                        nameGoal.setText("");}
                    else{
                    nameGoal.setText(obGoalsName.get(index));

                    startDate.setValue(LocalDate.parse(obStartDate.get(index)));

                    deadLine.setValue(LocalDate.parse(obDeadline.get(index)));
                    priority.setValue(obPriority.get(index));}
                });

                ListDeadLine.getSelectionModel().selectedItemProperty().addListener(e -> {
                    ListDeadLine.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
                    int index = ListDeadLine.getSelectionModel().getSelectedIndex();

                    ListGoals.getSelectionModel().select(index);

                    if((obGoalsName.isEmpty())){
                        nameGoal.setText("");}
                    else{
                    nameGoal.setText(obGoalsName.get(index));

                    startDate.setValue(LocalDate.parse(obStartDate.get(index)));
                    deadLine.setValue(LocalDate.parse(obDeadline.get(index)));
                    priority.setValue(obPriority.get(index));}
                });

                ListPriority.getSelectionModel().selectedItemProperty().addListener(e -> {
                    ListPriority.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
                    int index = ListPriority.getSelectionModel().getSelectedIndex();

                    ListGoals.getSelectionModel().select(index);
                    ListStartDate.getSelectionModel().select(index);
                    ListDeadLine.getSelectionModel().select(index);

                    if((obGoalsName.isEmpty())){
                        nameGoal.setText("");}
                    else{
                    nameGoal.setText(obGoalsName.get(index));

                    priority.setValue(obPriority.get(index));
                    startDate.setValue(LocalDate.parse(obStartDate.get(index)));
                    deadLine.setValue(LocalDate.parse(obDeadline.get(index)));}
                });
    }
}
