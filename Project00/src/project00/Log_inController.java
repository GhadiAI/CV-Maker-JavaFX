/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project00;

import java.io.File;
import java.io.IOException;
import java.net.URL;
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
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import static project00.CV.language;
import static project00.CV.Skill;

public class Log_inController implements Initializable {

    @FXML
    private Button Login;

    @FXML
    private Button JoinNow;

    @FXML
    private TextField tx_emailField;

    @FXML
    private PasswordField tx_PasswardField;

    String path ="\\Users\\koka_\\Desktop\\UQU\\7th semester\\APproject\\Audio\\click-on-mouse.mp3";
    Media media = new Media(new File(path).toURI().toString());
    MediaPlayer mediaplayer = new MediaPlayer(media);

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void login(ActionEvent event) throws IOException {

        ////////////////////////////////////////////////////////////////////////////
        gloabl ob = new gloabl();
        Session session = HibernateUtil.getSessionFactory().openSession();
        session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();

        List<UserP> sList2 = null;
        String queryStr = "from UserP";
        Query query = session.createQuery(queryStr);
        sList2 = query.list();
        session.getTransaction().commit();
        session.close();

        Alert a = new Alert(AlertType.NONE);
        boolean flag = false;
        for (UserP s : sList2) {

            if (tx_emailField.getText().equals(s.getEmail()) && tx_PasswardField.getText().equals(s.getPasswordUser())) {
                gloabl.user = s;
                CV cv = new CV(s.getIdUser());
                 gloabl.user.cv=cv;
                Session session1 = HibernateUtil.getSessionFactory().openSession();
                session1 = HibernateUtil.getSessionFactory().openSession();
                Transaction txw = session1.beginTransaction();

//                if (!(gloabl.user.cv.getFname() == null || gloabl.user.cv.getFname().equals(""))) {
//                    session1.save(gloabl.user.cv);
//                }
                session1.getTransaction().commit();
                session1.close();
                 System.out.println(CV.i+"ff  "+gloabl.user.getIdUser() + "  " + gloabl.user.cv.getCVID() + "  " + gloabl.user.cv.getIdUser());
                  gloabl.user.cv.education=new education(gloabl.user.cv.getCVID());
                gloabl.user.cv.experience=new experience(gloabl.user.cv.getCVID());
                 gloabl.user.cv.language= languages.getlist(gloabl.user.cv.getCVID());
                 gloabl.user.cv.Skill=skill.getlist(gloabl.user.cv.getCVID());
                 
                 Parent root = FXMLLoader.load(getClass().getResource("Project_Menu.fxml"));
                
                Scene scene = new Scene(root);
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                stage.setScene(scene);
                stage.show();
                mediaplayer.play();
                flag = true;

            } else if (tx_emailField.getText().isEmpty() || tx_PasswardField.getText().isEmpty()) {

                a.setAlertType(AlertType.ERROR);
                a.setContentText(" Plese make sure to fill both Email and Password Fields");
                a.show();
                flag = true;

            }

        }//end loop
        if (flag == false) {

            a.setAlertType(AlertType.ERROR);
            a.setContentText(" Wronggg infooo");
            a.show();

        }

    }//End Logn Action         

    /////////////////////////////////////////////////////////////////////////////     
    @FXML
    private void singinpPage(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Sign_in.fxml"));
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

}//End All  

//    for (String s : obItems){
//                
//             if(obItems.contains(tfSearch.getText()))  {
//                 msg.setText("The quantity of  "+tfSearch.getText()+" "+"is "+txQuantity.getText()+" "+ cboQType.getValue()+" "+"Expire at: "+obExDate.toString());
//                 
//             }else{
//                  msg.setText(" The item not found !!!");
//             }
//             
//           }

