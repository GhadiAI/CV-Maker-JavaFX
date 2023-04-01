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
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author areejbaw
 */
public class CvTamplte0Controller implements Initializable {

    String path ="C:\\Users\\koka_\\Desktop\\UQU\\7th semester\\APproject\\Audio\\click-on-mouse.mp3";
    Media media = new Media(new File(path).toURI().toString());
    MediaPlayer mediaplayer = new MediaPlayer(media);
    @FXML
    private Label Name;
    @FXML
    private Label PhoneNumber;
    @FXML
    private Label Email;
    @FXML
    private Label Nationality;
    @FXML
    private Label MatrialStaute;
    @FXML
    private Label DOF;
    @FXML
    private Label Dgree;
    @FXML
    private Label NameOfUni;
    @FXML
    private Label graduateYaar;
    @FXML
    private Label Language1;
    @FXML
    private Label Level1;
    @FXML
    private Label Language2;
    @FXML
    private Label Level2;
    @FXML
    private Label JobTitle;
    @FXML
    private Label CompName;
    @FXML
    private Label StartDate;
    @FXML
    private Label EndDate;
    @FXML
    private Label Skills1;
    @FXML
    private Label Skills2;
    @FXML
    private Label Skills3;
    @FXML
    private Pane MPane;

    @FXML
    private Pane PanneCV;
    @FXML
    private Button BackBtn;
    @FXML
    private Pane Panne3;
    @FXML
    private Pane Panne2;
    @FXML
    private Button ExportBtn1;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Nationality.setText(gloabl.user.cv.getNationality());
        Name.setText(gloabl.user.cv.getFname());
        PhoneNumber.setText((String.valueOf("0"+gloabl.user.cv.getPhoneNum())));
        Email.setText(gloabl.user.cv.getEmail());
        MatrialStaute.setText(gloabl.user.cv.getMaritalStatus());
        DOF.setText(gloabl.user.cv.getDOF());
        Dgree.setText(gloabl.user.cv.education.getDgree());
        NameOfUni.setText(gloabl.user.cv.education.getUniName());
        graduateYaar.setText(gloabl.user.cv.education.getGradDate());

        List<languages> lan = gloabl.user.cv.getLanguages();
        Language1.setText(lan.get(0).getLanguage());
        Level1.setText(lan.get(0).getLevel());

        Language2.setText(lan.get(1).getLanguage());
        Level2.setText(lan.get(1).getLevel());
        JobTitle.setText(gloabl.user.cv.experience.getJopTitle());
        CompName.setText(gloabl.user.cv.experience.getCompName());
        StartDate.setText(gloabl.user.cv.experience.getStartDate());
        EndDate.setText(gloabl.user.cv.experience.getEndDate());
        

            Skills1.setText(gloabl.user.cv.Skill.get(0).getSkillName());

            Skills2.setText(gloabl.user.cv.Skill.get(1).getSkillName());

            Skills3.setText(gloabl.user.cv.Skill.get(2).getSkillName());
        

        Double pY=0.0;
        //System.out.println(pY);
        MPane.widthProperty().addListener( (obs,o,n)->{
             
            //FPane.setLayoutX((Double)n-150);
            //FPane.setLayoutY((Double)n/2);
            //Panne.setFillWidth(Panne.getWidth()+(Double)n);
            
            PanneCV.setLayoutX((Double)n/5.5);
            PanneCV.setLayoutY((Double)n/30);
            ExportBtn1.setLayoutX((Double)n-70);
            //BackBtn.setLayoutY(117+((Double)n-(Double)o));
        });

        /*MPane.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent e) {
                if (e.getCode() == KeyCode.F) {
                    try {
                        Parent root;
                        root = FXMLLoader.load(CvTamplte0Controller.this.getClass().getResource("Export.fxml"));

                        Scene scene = new Scene(root);
                        // gets stage info
                        Stage stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
                        stage.setScene(scene);
                        stage.show();
                        mediaplayer.play();// TODO
                    } catch (IOException ex) {
                        Logger.getLogger(CvTamplte0Controller.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        });*/
    }

    @FXML
    private void Back2_to_CvMenu(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Cv_Choose.fxml"));
        Scene scene = new Scene(root);

        // gets stage info
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
        mediaplayer.play();
    }

    @FXML
     private void ExportToFile(ActionEvent event) throws IOException{
 
                    Parent root = FXMLLoader.load(getClass().getResource("Export.fxml"));
        Scene scene = new Scene(root);
        Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
         mediaplayer.play();
        stage.show();
                  
                }
}
