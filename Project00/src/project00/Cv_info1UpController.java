/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project00;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 * FXML Controller class
 *
 * @author koka_
 */
public class Cv_info1UpController implements Initializable {

    String path = "\\Users\\koka_\\Desktop\\UQU\\7th semester\\APproject\\Audio\\click-on-mouse.mp3";
    Media media = new Media(new File(path).toURI().toString());
    MediaPlayer mediaplayer = new MediaPlayer(media);
    @FXML
    private Label label1;
    @FXML
    private TextField Name;
    @FXML
    private TextField Nationality;
    @FXML
    private TextField MatrialStaute;
    @FXML
    private TextField PhoneNumber;
    @FXML
    private TextField Email;
    @FXML
    private DatePicker DOF;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Email.setPromptText(gloabl.user.cv.getEmail());
        Name.setPromptText(gloabl.user.cv.getFname());
        Nationality.setPromptText(gloabl.user.cv.getNationality());
        PhoneNumber.setPromptText(String.valueOf(gloabl.user.cv.getPhoneNum()));
        DOF.setPromptText(gloabl.user.cv.getDOF());
        MatrialStaute.setPromptText(gloabl.user.cv.getMaritalStatus());

    }

    /*@FXML
    private void Back_Cv(ActionEvent event) {
    }*/
    @FXML
    private void Next_info1(ActionEvent event) throws IOException {
        Session session1 = HibernateUtil.getSessionFactory().openSession();
        session1 = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session1.beginTransaction();
         if (!(Email.getText().equals(""))) {
            gloabl.user.cv.setEmail(Email.getText());
        }

        if (!(Name.getText().equals(""))) {
            gloabl.user.cv.setFname(Name.getText());
        }
        if (!(Nationality.getText().equals(""))) {
            gloabl.user.cv.setNationality(Nationality.getText());
        }

        if (!(DOF.getValue() == null)) {
            gloabl.user.cv.setDOF(DOF.getValue().toString());
        }
        if (!(PhoneNumber.getText().equals(""))) {
            gloabl.user.cv.setPhoneNum(Integer.parseInt(PhoneNumber.getText()));
        }
        if (!(MatrialStaute.getText().equals(""))) {
            gloabl.user.cv.setMaritalStatus(MatrialStaute.getText());
        }
        //obj.user.cv.setIdUser(obj.user.getIdUser());
        System.out.println(gloabl.user.getIdUser() + "  " + gloabl.user.cv.getCVID() + "  " + gloabl.user.cv.getIdUser());
        //obj.user.cv=cv;
        session1.update(gloabl.user);
        session1.update(gloabl.user.cv);

        session1.getTransaction().commit();
        session1.close();

        Parent root = FXMLLoader.load(getClass().getResource("Cv_info2Up.fxml"));
        Scene scene = new Scene(root);

        // gets stage info
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
        mediaplayer.play();
    }

}
