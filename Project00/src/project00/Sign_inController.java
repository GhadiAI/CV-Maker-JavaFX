/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project00;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.stage.Window;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 * FXML Controller class
 *
 * @author areejbaw
 */
public class Sign_inController implements Initializable {

    
    @FXML
    private TextField tf_username;

    @FXML
    private PasswordField tf_password;

    @FXML
    private TextField tf_email;
    @FXML
    private Label invalidDetails;

  //protected
    String successMessage =String.format("-fx-text-fill:GREEN;");
    String errorMessage =  String.format("-fx-text-fill:#c75a5a;");
    String errorStyle   =  String.format("-fx-border-color: #983d3d; -fx-border-width: 2;");
    String successStyle =  String.format("-fx-border-color: #A9A9A9; -fx-border-width: 2;");


    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void loginPage(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Log_in.fxml"));
        Scene scene = new Scene(root);
        Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void SignIn(ActionEvent event) throws IOException {
         String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\."+"[a-zA-Z0-9_+&*-]+)*@" +
                 "(?:[a-zA-Z0-9-]+\\.)+[a-z" + "A-Z]{2,7}$";
        
        
        Session session = HibernateUtil.getSessionFactory().openSession(); 
        session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        Alert alt = new Alert(AlertType.NONE);
        
        if(tf_username.getText().isEmpty() || tf_password.getText().isEmpty() || tf_email.getText().isEmpty() )
        {
            invalidDetails.setText("All The Fields Are Required!");
            invalidDetails.setStyle(errorMessage);
            tf_username.setStyle(errorStyle);
            tf_password.setStyle(errorStyle);
            tf_email.setStyle(errorStyle);
            
        }else if(tf_password.getText().length() < 7)
        {
           invalidDetails.setText("The Password can't be less than 7 characters!");
           invalidDetails.setStyle(errorMessage);
           tf_password.setStyle(errorStyle);
            
           
        
        }else{
          
        boolean flag=false;;
        Session session3 = HibernateUtil.getSessionFactory().openSession();
        List<UserP> sList = null;
        String queryStr = "from UserP";
        Query query = session3.createQuery(queryStr);
       sList = query.list();
        session3.close();
        for (UserP s : sList) {
            if (tf_email.getText().equals(s.getEmail())||tf_email.getText()==s.getEmail()) {
               
           flag=true;
            
            }
        }
        if(flag){invalidDetails.setText("This email is used");
           invalidDetails.setStyle(errorMessage);
           tf_password.setStyle(errorStyle);}
      
             if(flag){invalidDetails.setText("This email is used");
           invalidDetails.setStyle(errorMessage);
           tf_password.setStyle(errorStyle);}
           
            if(tf_email.getText().matches(emailRegex)){
                if(!flag){
                invalidDetails.setText("Sign Up Succeeded!");
                invalidDetails.setStyle(successMessage);// fill it with green
                tf_username.setStyle(successStyle);
                tf_password.setStyle(successStyle);
                tf_email.setStyle(successStyle);
                UserP user=new UserP(3);
                user.setUsername(tf_username.getText());
                user.setEmail(tf_email.getText());
                user.setPasswordUser(tf_password.getText());
                gloabl.user= user;
                session.save(gloabl.user);
                session.getTransaction().commit();
                session.close();
                
                   gloabl.user = user;
                CV cv = new CV(user.getIdUser());
                gloabl.user.cv = cv;
                Session session1 = HibernateUtil.getSessionFactory().openSession();
                session1 = HibernateUtil.getSessionFactory().openSession();
                Transaction txw = session1.beginTransaction();
                //
                session1.getTransaction().commit();
                session1.close();
                System.out.println(CV.i + "ff  " + gloabl.user.getIdUser() + "  " + gloabl.user.cv.getCVID() + "  " + gloabl.user.cv.getIdUser());
                gloabl.user.cv.education = new education(gloabl.user.cv.getCVID());
                gloabl.user.cv.experience = new experience(gloabl.user.cv.getCVID());
                gloabl.user.cv.language = languages.getlist(gloabl.user.cv.getCVID());
                gloabl.user.cv.Skill = skill.getlist(gloabl.user.cv.getCVID());
                List<goal> gool=new ArrayList<goal>();
                gloabl.user.Goal=gool;
                 

                Parent root = FXMLLoader.load(getClass().getResource("Project_Menu.fxml"));
                
                Scene scene = new Scene(root);
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                stage.setScene(scene);
                stage.show();
                //mediaplayer.play();}
            }else{
            
            invalidDetails.setText("Wrong Email type !");
            invalidDetails.setStyle(errorMessage);
           }
           
        

        
    }
 }
    
    
    
    
    }}


// if(tf_password.getText().isEmpty())
//        {
//            alt.setAlertType(AlertType.ERROR);
//            alt.setContentText("Please Fill All Fields ");
//            // show the dialog
//            alt.show();
//        }



//if(tf_email.getText().matches(emailRegex)){
//            
//   
//           ob.user.setUsername(tf_username.getText());
//           ob.user.setEmail(tf_email.getText());
//           ob.user.setPasswordUser(tf_password.getText());
//           
//           
//           session.save(ob.user);
//           session.getTransaction().commit();
//           session.close();
//               
//               
//               
//               
//           }