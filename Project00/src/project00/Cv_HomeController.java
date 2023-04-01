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
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 * FXML Controller class
 *
 * @author Ghadi
 */
public class Cv_HomeController implements Initializable {
 
        Session session = HibernateUtil.getSessionFactory().openSession();
        String queryStr = "from CV";
        Query query = session.createQuery(queryStr);
        List<CV>  sList = query.list();

        
    String path ="\\Users\\koka_\\Desktop\\UQU\\7th semester\\APproject\\Audio\\click-on-mouse.mp3";
    Media media = new Media(new File(path).toURI().toString());
    MediaPlayer mediaplayer = new MediaPlayer(media);

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void Creat_Cv(ActionEvent event) throws IOException {
        //Parent root = FXMLLoader.load(getClass().getResource("Cv_info1.fxml"));
        Alert a = new Alert(Alert.AlertType.WARNING);
       
        boolean flag = false;

        for (CV s : sList) {
            if (s.getIdUser() == gloabl.user.cv.getIdUser());
            {
                // System.out.println(gloabl.user.getIdUser() + "  " + gloabl.user.cv.getCVID() + "  " + gloabl.user.cv.getIdUser()+gloabl.user.cv.getFname());

                if (!(gloabl.user.cv.getFname() == null||gloabl.user.cv.getFname().equals(""))) {
                    a.setAlertType(Alert.AlertType.WARNING);
                
                a.setContentText(" You have CV already !\nif you want to update your cv click on edit your CV ");
                a.show();
                flag = true;}

            }
        }

        if (!flag) {
            Parent root = FXMLLoader.load(getClass().getResource("Cv_info1.fxml"));
            Scene scene = new Scene(root);
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.show();
            mediaplayer.play();
        }

    }

    @FXML

    private void Edit_Cv(ActionEvent event) throws IOException {
       
        
        
        
             Alert a = new Alert(Alert.AlertType.WARNING);
       
        boolean flag = false;

        for (CV s : sList) {
            if (s.getIdUser() == gloabl.user.cv.getIdUser());
            { if ((gloabl.user.cv.getFname() == null||gloabl.user.cv.getFname().equals(""))) {
                    a.setAlertType(Alert.AlertType.ERROR);
                
                a.setContentText(" You don't have CV to Edit ...\nPlease click on Create CV ");
                a.show();
                flag = true;}

            }
        }
                if (!flag) {
                            session.close();

   Parent root = FXMLLoader.load(getClass().getResource("Cv_info1Up.fxml"));
        Scene scene = new Scene(root);

        // gets stage info
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
        mediaplayer.play();
    }
        }
    
      

    @FXML

    private void Show_Cv(ActionEvent event) throws IOException {
              
        
        
        
             Alert a = new Alert(Alert.AlertType.ERROR);
       
        boolean flag = false;

        for (CV s : sList) {
            if (s.getIdUser() == gloabl.user.cv.getIdUser());
            { if ((gloabl.user.cv.getFname() == null||gloabl.user.cv.getFname().equals(""))) {
                    a.setAlertType(Alert.AlertType.ERROR);
                
                a.setContentText(" You don't have CV to show ...\nPlease click on Create CV ");
                a.show();
                flag = true;}

            }
        }
                if (!flag) {
                            session.close();

        Parent root = FXMLLoader.load(getClass().getResource("Cv_Choose.fxml"));
        Scene scene = new Scene(root);

        // gets stage info
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
        mediaplayer.play();
        }
    }

    @FXML
    private void Back_Menu(ActionEvent event) throws IOException {
              session.close();
              
        Parent root = FXMLLoader.load(getClass().getResource("Project_Menu.fxml"));
        Scene scene = new Scene(root);

        // gets stage info
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
        mediaplayer.play();

    }

}
