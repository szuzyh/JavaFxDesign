import com.jacob.activeX.ActiveXComponent;
import com.jacob.com.Dispatch;
import com.jacob.com.Variant;
import javafx.application.Application;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.embed.swing.SwingFXUtils;
import javafx.embed.swt.SWTFXUtils;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import javax.swing.*;
import java.awt.*;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

/**
 * Created by Leo on 2016/12/5.
 */
public class AppLauncher extends Application{
    private static ActiveXComponent com = new ActiveXComponent("CLSID:0F55CC69-97EF-42A9-B63D-D1831CB2B3B9");
    private static Dispatch disp = (Dispatch) com.getObject();
    private static String name;
    private static String sex;
    private static String nation;
    private static String birthday;
    private static String address;
    private static String ID;
    private static String department;
    private static String startDate;
    private static String endDate;
    private static String path;


    ObjectProperty<Image> imageProperty = new SimpleObjectProperty<Image>();
    InputStream in=new FileInputStream(new File(path));
    private Image image=new Image(in);

    private BorderPane root;
    private FlowPane buttonPanel;
    private ComboBox topChoiceCam;
    private ImageView leftCamVideo;
    private HBox rightMessageAllBox;
    private VBox TextMessageBox;
    private VBox imageVBox;
    private HBox nameHBox;
    private HBox sexHBox;
    private HBox nationHBox;
    private HBox birthdayHBox;
    private HBox addressHBox;
    private HBox IDHBox;
    private HBox departmentHBox;
    private HBox startDateHBox;
    private HBox endDateHBox;
    private TextField nameLeft;
    private static TextArea nameRight;
    private TextField sexLeft;
    private TextArea sexRight;
    private TextField nationLeft;
    private TextArea nationRight;
    private TextField birthdayLeft;
    private TextArea birthdayRight;
    private TextField addressLeft;
    private TextArea addressRight;
    private TextField IDLeft;
    private TextArea IDRight;
    private TextField departmentLeft;
    private TextArea departmentRight;
    private TextField startDateLeft;
    private TextArea startDateRight;
    private TextField endDateLeft;
    private TextArea endDateRight;

    private ImageView imageNull;
    private ImageView imagePerson;
    private Button btnCheck;
    private Button btnClear;
    private BorderPane webCamPane;

    public AppLauncher() throws FileNotFoundException {
    }

    public void start(Stage primaryStage) throws Exception {

        primaryStage.setTitle("身份证信息上传器");
        root=new BorderPane();
        //选择器
        topChoiceCam=new ComboBox();
        topChoiceCam.setPromptText("选择摄像机");
        root.setTop(topChoiceCam);
        //视频传输
        webCamPane=new BorderPane();
        webCamPane = new BorderPane();
        webCamPane.setStyle("-fx-background-color: #ccc;");
        leftCamVideo = new ImageView();
        webCamPane.setCenter(leftCamVideo);
        root.setLeft(webCamPane);
        //身份证信息
        rightMessageAllBox=new HBox();
        rightMessageAllBox.setPrefHeight(377);
        rightMessageAllBox.setPrefWidth(353);
        rightMessageAllBox.setAlignment(Pos.CENTER);
        //文字信息
        TextMessageBox=new VBox();
        TextMessageBox.setPrefWidth(223);
        TextMessageBox.setPrefHeight(377);
        TextMessageBox.setAlignment(Pos.TOP_LEFT);
        //姓名栏
        nameHBox=new HBox();
        nameHBox.setAlignment(Pos.TOP_LEFT);
        nameHBox.setPrefWidth(223);
        nameHBox.setPrefHeight(32);
        nameLeft=new TextField();
        nameLeft.setAlignment(Pos.CENTER_RIGHT);
        nameLeft.setPrefHeight(23);
        nameLeft.setPrefWidth(77);
        nameLeft.setText("姓名：");
        nameLeft.setFont(Font.font(12));
        nameHBox.getChildren().add(nameLeft);
        nameRight=new TextArea();
        nameRight.setMinWidth(Region.USE_PREF_SIZE);
        nameRight.setMinHeight(Region.USE_PREF_SIZE);
        nameRight.setPrefWidth(146);
        nameRight.setPrefHeight(23);
        nameRight.setMaxWidth(Region.USE_PREF_SIZE);
        nameRight.setMaxHeight(Region.USE_PREF_SIZE);
        nameRight.setEditable(false);
        nameRight.setText(name);

        nameHBox.getChildren().add(nameRight);
        TextMessageBox.getChildren().add(nameHBox);
//性别栏
        sexHBox=new HBox();
        sexHBox.setAlignment(Pos.TOP_LEFT);
        sexHBox.setPrefWidth(223);
        sexHBox.setPrefHeight(32);
        sexLeft=new TextField();
        sexLeft.setAlignment(Pos.CENTER_RIGHT);
        sexLeft.setPrefHeight(23);
        sexLeft.setPrefWidth(77);
        sexLeft.setText("性别：");
        sexLeft.setFont(Font.font(12));
        sexHBox.getChildren().add(sexLeft);
        sexRight=new TextArea();
        sexRight.setMinWidth(Region.USE_PREF_SIZE);
        sexRight.setMinHeight(Region.USE_PREF_SIZE);
        sexRight.setPrefWidth(146);
        sexRight.setPrefHeight(23);
        sexRight.setMaxWidth(Region.USE_PREF_SIZE);
        sexRight.setMaxHeight(Region.USE_PREF_SIZE);
        sexRight.setEditable(false);
        sexRight.setText(sex);
        sexHBox.getChildren().add(sexRight);
        TextMessageBox.getChildren().add(sexHBox);
        //民族栏
        nationHBox=new HBox();
        nationHBox.setAlignment(Pos.TOP_LEFT);
        nationHBox.setPrefWidth(223);
        nationHBox.setPrefHeight(32);
        nationLeft=new TextField();
        nationLeft.setAlignment(Pos.CENTER_RIGHT);
        nationLeft.setPrefHeight(23);
        nationLeft.setPrefWidth(77);
        nationLeft.setText("民族：");
        nationLeft.setFont(Font.font(12));
        nationHBox.getChildren().add(nationLeft);
        nationRight=new TextArea();
        nationRight.setMinWidth(Region.USE_PREF_SIZE);
        nationRight.setMinHeight(Region.USE_PREF_SIZE);
        nationRight.setPrefWidth(146);
        nationRight.setPrefHeight(23);
        nationRight.setMaxWidth(Region.USE_PREF_SIZE);
        nationRight.setMaxHeight(Region.USE_PREF_SIZE);
        nationRight.setEditable(false);
        nationRight.setText(nation);
        nationHBox.getChildren().add(nationRight);
        TextMessageBox.getChildren().add(nationHBox);
        //住址栏，需注意文字太多换行的问题
        addressHBox=new HBox();
        addressHBox.setAlignment(Pos.TOP_LEFT);
        addressHBox.setPrefWidth(223);
        addressHBox.setPrefHeight(64);
        addressLeft=new TextField();
        addressLeft.setAlignment(Pos.CENTER_RIGHT);
        addressLeft.setPrefHeight(23);
        addressLeft.setPrefWidth(77);
        addressLeft.setText("住址：");
        addressLeft.setFont(Font.font(12));
        addressHBox.getChildren().add(addressLeft);
        addressRight=new TextArea();
        addressRight.setPrefWidth(146);
        addressRight.setPrefHeight(64);
        addressRight.setEditable(false);
        addressRight.setWrapText(true);
        addressRight.setText(address);
        addressHBox.getChildren().add(addressRight);
        TextMessageBox.getChildren().add(addressHBox);
        //身份证号栏
        IDHBox=new HBox();
        IDHBox.setAlignment(Pos.TOP_LEFT);
        IDHBox.setPrefWidth(223);
        IDHBox.setPrefHeight(32);
        IDLeft=new TextField();
        IDLeft.setAlignment(Pos.CENTER_RIGHT);
        IDLeft.setPrefHeight(23);
        IDLeft.setPrefWidth(77);
        IDLeft.setText("身份证号：");
        IDLeft.setFont(Font.font(12));
        IDHBox.getChildren().add(IDLeft);
        IDRight=new TextArea();
        IDRight.setMinWidth(Region.USE_PREF_SIZE);
        IDRight.setMinHeight(Region.USE_PREF_SIZE);
        IDRight.setPrefWidth(146);
        IDRight.setPrefHeight(23);
        IDRight.setMaxWidth(Region.USE_PREF_SIZE);
        IDRight.setMaxHeight(Region.USE_PREF_SIZE);
        IDRight.setEditable(false);
        IDRight.setText(ID);
        IDHBox.getChildren().add(IDRight);
        TextMessageBox.getChildren().add(IDHBox);
        //签发机关栏
        departmentHBox=new HBox();
        departmentHBox.setAlignment(Pos.TOP_LEFT);
        departmentHBox.setPrefWidth(223);
        departmentHBox.setPrefHeight(32);
        departmentLeft=new TextField();
        departmentLeft.setAlignment(Pos.CENTER_RIGHT);
        departmentLeft.setPrefHeight(23);
        departmentLeft.setPrefWidth(77);
        departmentLeft.setText("签发机关：");
        departmentLeft.setFont(Font.font(12));
        departmentHBox.getChildren().add(departmentLeft);
        departmentRight=new TextArea();
        departmentRight.setMinWidth(Region.USE_PREF_SIZE);
        departmentRight.setMinHeight(Region.USE_PREF_SIZE);
        departmentRight.setPrefWidth(146);
        departmentRight.setPrefHeight(23);
        departmentRight.setMaxWidth(Region.USE_PREF_SIZE);
        departmentRight.setMaxHeight(Region.USE_PREF_SIZE);
        departmentRight.setEditable(false);
        departmentRight.setText(department);
        departmentHBox.getChildren().add(departmentRight);
        TextMessageBox.getChildren().add(departmentHBox);
        //发证日期栏
        startDateHBox=new HBox();
        startDateHBox.setAlignment(Pos.TOP_LEFT);
        startDateHBox.setPrefWidth(223);
        startDateHBox.setPrefHeight(32);
        startDateLeft=new TextField();
        startDateLeft.setAlignment(Pos.CENTER_RIGHT);
        startDateLeft.setPrefHeight(23);
        startDateLeft.setPrefWidth(77);
        startDateLeft.setText("发证日期：");
        startDateLeft.setFont(Font.font(12));
        startDateHBox.getChildren().add(startDateLeft);
        startDateRight=new TextArea();
        startDateRight.setMinWidth(Region.USE_PREF_SIZE);
        startDateRight.setMinHeight(Region.USE_PREF_SIZE);
        startDateRight.setPrefWidth(146);
        startDateRight.setPrefHeight(23);
        startDateRight.setMaxWidth(Region.USE_PREF_SIZE);
        startDateRight.setMaxHeight(Region.USE_PREF_SIZE);
        startDateRight.setEditable(false);
        startDateRight.setText(startDate);
        startDateHBox.getChildren().add(startDateRight);
        TextMessageBox.getChildren().add(startDateHBox);
        //有效期栏
        endDateHBox=new HBox();
        endDateHBox.setAlignment(Pos.TOP_LEFT);
        endDateHBox.setPrefWidth(223);
        endDateHBox.setPrefHeight(32);
        endDateLeft=new TextField();
        endDateLeft.setAlignment(Pos.CENTER_RIGHT);
        endDateLeft.setPrefHeight(23);
        endDateLeft.setPrefWidth(77);
        endDateLeft.setText("有效期：");
        endDateLeft.setFont(Font.font(12));
        endDateHBox.getChildren().add(endDateLeft);
        endDateRight=new TextArea();
        endDateRight.setMinWidth(Region.USE_PREF_SIZE);
        endDateRight.setMinHeight(Region.USE_PREF_SIZE);
        endDateRight.setPrefWidth(146);
        endDateRight.setPrefHeight(23);
        endDateRight.setMaxWidth(Region.USE_PREF_SIZE);
        endDateRight.setMaxHeight(Region.USE_PREF_SIZE);
        endDateRight.setEditable(false);
        endDateRight.setText(endDate);
        endDateHBox.getChildren().add(endDateRight);
        TextMessageBox.getChildren().add(endDateHBox);
        //添加左信息栏
        rightMessageAllBox.getChildren().add(TextMessageBox);
//添加右照片栏
        imageVBox=new VBox();
        //!
        imageVBox.setAlignment(Pos.TOP_LEFT);
        imageVBox.setPrefWidth(124);
        imageVBox.setPrefHeight(305);

        //空图，为了空出空间
        imageNull=new ImageView();
        imageNull.setVisible(false);
        imageNull.setFitWidth(121);
        imageNull.setFitHeight(30);
        imageVBox.getChildren().add(imageNull);

        //照片
        imagePerson=new ImageView();
        imagePerson.setFitHeight(150);
        imagePerson.setFitWidth(122);
        imagePerson.setImage(image);

        imageVBox.getChildren().add(imagePerson);
        btnControls();
        rightMessageAllBox.getChildren().add(imageVBox);
        //添加身份证所有信息
        root.setRight(rightMessageAllBox);
        buttonPanel = new FlowPane();
        buttonPanel.setOrientation(Orientation.HORIZONTAL);
        buttonPanel.setAlignment(Pos.CENTER);
        buttonPanel.setHgap(20);
        buttonPanel.setVgap(10);
        buttonPanel.setPrefHeight(40);
        buttonPanel.setDisable(true);
        root.setBottom(buttonPanel);
        primaryStage.setScene(new Scene(root));
        primaryStage.setHeight(600);
        primaryStage.setWidth(1000);
        primaryStage.centerOnScreen();
        primaryStage.show();
    }

    private void btnControls() {
        btnCheck=new Button();
        btnCheck.setText("查询");
        btnCheck.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                Thread t=new Thread(new Runnable() {
                    public void run() {

                    }
                });
            }
        });
        imageVBox.getChildren().add(btnCheck);
    }

    public static void main(String args[]){
        initJacob();
        launch(args);
    }
    private static void initJacob() {

        int ret = Dispatch.call(disp, "getCardInfo", new Variant("E:\\GET\\person.bmp")).getInt();
        if (ret != 0) {
            System.out.println("打开设备失败");
        } else {
            System.out.println("打开设备成功");
        }
        name = Dispatch.call(disp, "Name").getString().trim();
        sex = Dispatch.call(disp, "Sex").getString().trim();
        nation = Dispatch.call(disp, "Nation").getString().trim();
        birthday = Dispatch.call(disp, "Birthday").getString().trim();
        address = Dispatch.call(disp, "Address").getString().trim();
        ID = Dispatch.call(disp, "ID").getString().trim();
        department = Dispatch.call(disp, "Department").getString().trim();
        startDate = Dispatch.call(disp, "StartDate").getString().trim();
        endDate = Dispatch.call(disp, "EndDate").getString().trim();
        path="E:\\GET\\person.bmp";
    }
}
