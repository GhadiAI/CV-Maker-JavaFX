/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project00;

import java.io.File;
import java.io.FileWriter;
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
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author areejbaw
 */
public class ExportController implements Initializable {

    String path = "\\Users\\koka_\\Desktop\\UQU\\7th semester\\APproject\\Audio\\click-on-mouse.mp3";
    Media media = new Media(new File(path).toURI().toString());
    MediaPlayer mediaplayer = new MediaPlayer(media);
    
    @FXML
    private Label label1;
    @FXML
    private TextField Name;
    @FXML
    private Label label11;

    static String FileName;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void Export(ActionEvent event) throws IOException {
        String FileName=Name.getText()+".txt";
        
        
            try {
                FileWriter fw = new FileWriter(FileName);
               
                    String line=gloabl.user.getUsername()+"\n"+gloabl.user.cv.getFname()+" "+gloabl.user.cv.getMaritalStatus()+" "+gloabl.user.cv.getNationality()+" "+gloabl.user.cv.getDOF()+" "+ gloabl.user.cv.getPhoneNum()+
                           " \n"+ gloabl.user.cv.education.getDgree()+ " "+ gloabl.user.cv.education.getUniName()+" "+ gloabl.user.cv.education.getGradDate()+
                            "\n"+gloabl.user.cv.experience.getJopTitle()+" "+gloabl.user.cv.experience.getCompName()+" "+gloabl.user.cv.experience.getStartDate()+" "+gloabl.user.cv.experience.getEndDate()+
                             "\n"+gloabl.user.cv.language.get(0).getLanguage()+" "+gloabl.user.cv.language.get(0).getLevel()+gloabl.user.cv.language.get(1).getLanguage()+" "+gloabl.user.cv.language.get(1).getLevel()+
                            "\n"+gloabl.user.cv.Skill.get(0).getSkillName()+" "+gloabl.user.cv.Skill.get(1).getSkillName()+" "+gloabl.user.cv.Skill.get(0).getSkillName();
                    fw.write(line);
                
                fw.close();
            } catch (IOException ex) {
            }

        
        Parent root = FXMLLoader.load(getClass().getResource("Cv_Choose.fxml"));
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
        mediaplayer.play();
        
    }
    
}
