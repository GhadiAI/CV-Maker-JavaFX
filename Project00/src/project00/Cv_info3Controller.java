/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project00;

import java.io.File;
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
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 * FXML Controller class
 *
 * @author Ghadi
 */
public class Cv_info3Controller implements Initializable {

    String path = "\\Users\\koka_\\Desktop\\UQU\\7th semester\\APproject\\Audio\\click-on-mouse.mp3";
    Media media = new Media(new File(path).toURI().toString());
    MediaPlayer mediaplayer = new MediaPlayer(media);

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private TextField Language1;

    @FXML
    private TextField Level1;

    @FXML
    private TextField Language2;

    @FXML
    private TextField Level2;

    @FXML
    private TextField skill1;

    @FXML
    private TextField skill2;

    @FXML
    private TextField skill3;

    /*@FXML
    private void Back_info2(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Cv_info2.fxml"));
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();

    }*/
    @FXML
    private void Next_CvTamplet(ActionEvent event) throws IOException {

        Session session1 = HibernateUtil.getSessionFactory().openSession();
        session1 = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session1.beginTransaction();

        List<languages> lang = new ArrayList<languages>();

        languages lan1 = new languages();
        lan1.setCVID(gloabl.user.cv.getCVID());
        lan1.setLanguage(Language1.getText());
        lan1.setLevel(Level1.getText());
        lang.add(lan1);
        //lan.setCVID(obj.user.cv.getCVID());
        languages lan2 = new languages();
        lan2.setCVID(gloabl.user.cv.getCVID());
        lan2.setLanguage(Language2.getText());
        lan2.setLevel(Level2.getText());
        lang.add(lan2);

        gloabl.user.cv.language = lang;

        session1.save(lan1);
        session1.save(lan2);

        
        List<skill> sk = new ArrayList<skill>(3);
        skill skill11 = new skill();
        skill11.setSkillNo(1);
        skill11.setCVID(gloabl.user.cv.getCVID());
        if (!(skill1.getText().isEmpty())) {

            skill11.setSkillName(skill1.getText());
        } else {
            skill11.setSkillName("");
        }
        sk.add(0, skill11);
        session1.save(skill11);
        
        skill skill12 = new skill();
        skill12.setSkillNo(2);
        skill12.setCVID(gloabl.user.cv.getCVID());
        if (!(skill2.getText().isEmpty())) {

            skill12.setSkillName(skill2.getText());
        } else {
            skill12.setSkillName("");
        }
        sk.add(1, skill12);
        session1.save(skill12);
        
        skill skill13 = new skill();
        skill13.setSkillNo(3);
        skill13.setCVID(gloabl.user.cv.getCVID());
        if (!(skill3.getText().isEmpty())) {

            skill13.setSkillName(skill3.getText());
        } else {
            skill13.setSkillName("");
        }
        sk.add(2, skill13);
        session1.save(skill13);
        
       

        gloabl.user.cv.setSkill(sk);

        //session1.save(gloabl.user.cv.Skill);

//        session1.save(sk);
        session1.getTransaction().commit();
        session1.close();
        Parent root = FXMLLoader.load(getClass().getResource("Cv_Choose.fxml"));
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
        mediaplayer.play();

    }
}

//        gloabl obj=new gloabl();
//         Session session1 = HibernateUtil.getSessionFactory().openSession();
//        session1 = HibernateUtil.getSessionFactory().openSession();
//        Transaction tx = session1.beginTransaction();
//        obj.user.cv.setCVID(51);
//        language lan1=new language();
//        language lan2=new language();
//       lan1.setCVID(obj.user.cv.getCVID());
//       lan1.setLanguage(Language1.getText());
//       lan1.setLevel(Level1.getText());
//       
//       //lan2.setCVID(obj.user.cv.getCVID());
//       //lan2.setLanguage(Language2.getText());
//       //lan2.setLevel(Level2.getText());
//       
//       //List<languages> lan=new ArrayList<languages>();
//       //lan.add(lan1);
//       //lan.add(lan2);
//       //obj.user.cv.setLanguag(lan);
//        
//        
//        Skill Skill=new Skill();
//        Skill.setSkillName(Skills.getText());
//        Skill.setSkillNo(1);
//        Skill.setCVID(obj.user.cv.getCVID());
//        
//        List<skill> sk=new ArrayList<skill>();
//       sk.add(Skill);
//        obj.user.cv.setSkill(sk);
//        
//       
//        session1.save(lan1);
//        //session1.save(lan2);
//        session1.save(Skill);
//        
//
//        session1.getTransaction().commit();
//        session1.close();
