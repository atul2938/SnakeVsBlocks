package sample;

import javafx.animation.*;
import javafx.application.*;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.KeyCode;
import javafx.event.EventHandler;
import javafx.scene.layout.Pane;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.*;
import javafx.util.Duration;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.layout.Pane;

public class Main extends Application {

    double t=0;  //for increasing time

    ///////////////////////////////////////////////////////////////////////////////////////////
    @Override
    public void start(Stage primaryStage) throws Exception{

        Pane group = new Pane();                                                      //Changed root to group
        primaryStage.getIcons().add(new Image("file:Snake-icon.png"));;

        Image image = new Image("file:snake-vs-block.png");
        ImageView imageview=new ImageView(image);
        imageview.setFitHeight(820);
        imageview.setFitWidth(620);

        Text text = new Text();
        text.setText("Snake \n   vs \nBlock");
        text.setX(65);
        text.setY(250);
        text.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 75));
        text.setFill(Color.SEAGREEN);

        Button btn=new Button("Press ENTER");
        btn.setLayoutX(85);
        btn.setLayoutY(490);
        btn.setMinSize(200, 50);
        btn.setStyle("-fx-font: 25 arial; -fx-base: #008080;");

        // action event
        EventHandler<ActionEvent> event = new EventHandler<ActionEvent>() {

            public void handle(ActionEvent e)
            {
                Menu(primaryStage, imageview);

            }
        };

        // when button is pressed
        btn.setOnAction(event);
        
        
        // Blinking Effect in Button
        FadeTransition fadeTransition = new FadeTransition(Duration.seconds(4), btn);
        fadeTransition.setFromValue(1.0);
        fadeTransition.setToValue(0.6);
        fadeTransition.setCycleCount(Animation.INDEFINITE);
        fadeTransition.play();

        group.getChildren().addAll(imageview,text,btn);

        Scene scene = new Scene(group, 600,800);
        
        primaryStage.setTitle("SnakeVsBlock");
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();

    }
    
    //////////////////////////////////////////////////////////////////////////////////////////
    
    public class Blocks extends Rectangle {
        private int blockValue;                     		//number written on the block
        
        public Blocks(int x, int y, int w, int h, int blockValue, Color color) {

            super(w, h, color);
            super.setArcHeight(10);
            super.setArcHeight(20);
            this.blockValue = blockValue;
            setTranslateX(x);
            setTranslateY(y);



        }
        
        void moveLeft() {
            setTranslateX(getTranslateX() - 5);
        }
        
        void moveRight() {

            setTranslateX(getTranslateX() + 5);
        }
        
        void moveUp() {
            setTranslateY(getTranslateY() - 5);
        }
        void moveDown() {
            setTranslateY(getTranslateY() + 5);
        }

    }
    ///////////////////////////////////////////////////////////////////////////////////

    private void Menu(Stage primaryStage, ImageView imageview) {

        Pane subroot = new Pane();

        Text text = new Text();
        text.setText("Snake \n   vs \nBlock");
        text.setX(65);
        text.setY(250);
        text.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 75));
        text.setFill(Color.SEAGREEN);



        Button btn1=new Button("Play");
        btn1.setLayoutX(95);
        btn1.setLayoutY(450);
        btn1.setMinSize(160, 40);
        btn1.setStyle("-fx-font: 20 arial; -fx-base: #008080;");

        EventHandler<ActionEvent> event1 = new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e)
            {
                Play(primaryStage, imageview);

            }
        };
        
        // when button is pressed
        btn1.setOnAction(event1);



        Button btn2=new Button("LeaderBoard");
        btn2.setLayoutX(95);
        btn2.setLayoutY(510);
        btn2.setMinSize(160, 40);
        btn2.setStyle("-fx-font: 20 arial; -fx-base: #008080;");

        EventHandler<ActionEvent> event2 = new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e)
            {
                LeaderBoard(primaryStage, imageview);

            }
        };
        // when button is pressed
        btn2.setOnAction(event2);


        Button btn3=new Button("Themes");
        btn3.setLayoutX(95);
        btn3.setLayoutY(570);
        btn3.setMinSize(160, 40);
        btn3.setStyle("-fx-font: 20 arial; -fx-base: #008080;");

        EventHandler<ActionEvent> event3 = new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e)
            {
                Themes(primaryStage, imageview);

            }
        };
        
        // when button is pressed
        btn3.setOnAction(event3);

        Button btn4=new Button("How to Play");
        btn4.setLayoutX(95);
        btn4.setLayoutY(630);
        btn4.setMinSize(160, 40);
        btn4.setStyle("-fx-font: 20 arial; -fx-base: #008080;");


        EventHandler<ActionEvent> event4 = new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e)
            {
                Instructions(primaryStage, imageview);

            }
        };
        
        // when button is pressed
        btn4.setOnAction(event4);

        Button btn5=new Button("Exit");
        btn5.setLayoutX(95);
        btn5.setLayoutY(690);
        btn5.setMinSize(160, 40);
        btn5.setStyle("-fx-font: 20 arial; -fx-base: #008080;");

        EventHandler<ActionEvent> event5 = new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e)
            {

                Platform.exit();

            }

        };
        
        // when button is pressed
        btn5.setOnAction(event5);

        subroot.getChildren().addAll(imageview,text,btn1,btn2,btn3,btn4,btn5);
        
        Scene scene=new Scene(subroot,600,800);

        primaryStage.setScene(scene);

    }

/////////////////////////////////////////////////////////////////////////////////////////


    protected void Play(Stage primaryStage, ImageView imageview) {

        AnimationTimer timer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                //update
            }
        };

        timer.start();

        Pane play=new Pane();

        Image image = new Image("file:blackBackground.png");
        ImageView blackBackground=new ImageView(image);
        blackBackground.setFitHeight(820);
        blackBackground.setFitWidth(620);

        Circle snake[]=new Circle[4];
        for(int i=0;i<4;i++){
            snake[i]=new Circle(300,620+i*20,10);
            snake[i].setFill(Color.WHITE);
        }
        

        Blocks block1 = new Blocks(10,100,100,100,10,Color.YELLOW);
        Blocks block2 = new Blocks(115,100,100,100,10,Color.YELLOW);
        Blocks block3 = new Blocks(325,100,100,100,10,Color.YELLOW);
        Blocks block4 = new Blocks(430,100,100,100,10,Color.YELLOW);

        Timeline timeline = new Timeline(new KeyFrame(
                Duration.millis(45),
                ae -> {
                    block1.moveDown();
                    block2.moveDown();
                    block3.moveDown();
                    block4.moveDown();
                }

         ));
        timeline.setCycleCount(100);
        timeline.play();


        Button btn6=new Button("Quit Game");
        btn6.setLayoutX(220);
        btn6.setLayoutY(730);
        btn6.setMinSize(160, 40);
        btn6.setStyle("-fx-font: 20 arial; -fx-base: #87CEFA;");

        EventHandler<ActionEvent> event6 = new EventHandler<ActionEvent>() {

            public void handle(ActionEvent e)
            {
                Menu(primaryStage, imageview);

            }
        };


        // when button is pressed
        btn6.setOnAction(event6);

        play.getChildren().setAll(blackBackground,btn6,block1,block2,block3,block4);
        play.getChildren().addAll(snake);

        Scene scene=new Scene(play,600,800);

        scene.setOnKeyPressed(e-> {

            switch(e.getCode()){

                case A :
                    for(int i=0;i<4;i++){
                        snake[i].setCenterX(snake[i].getCenterX()-10);
                    }
                    break;
                case D :
                    for(int i=0;i<4;i++) {
                        snake[i].setCenterX(snake[i].getCenterX() + 10);
                    }
                    break;

            }});


        primaryStage.setScene(scene);

    }



//////////////////////////////////////////////////////////////////////////////////////

    protected void Instructions(Stage primaryStage, ImageView imageview) {
        Pane instructions=new Pane();
        Text text=new Text();
        text.setText("				How To Play \n"
                + "Your have to control snake, collect food, and destroy\n"
                + "blocks to get points. The  speed of snake will increse\n"
                + "gradually.\n \n"
                + "Each food has some points which will be counted \n"
                + "towards snake length. Each Block has some value and \n"
                + "could be destroyed completely only if you have snake \n"
                + "of length more than its value. If you continue hitting \n"
                + "the block after that, you lose. \n \n"
                + "				Controls : \n "
                + "		Press -A- to turn left. \n "
                + "		Press -D- to turn right. \n \n "
                + "				Tokens : \n "
                + "There are 4 token which could help you in scoring and \n "
                + "tackling blocks. These are listed below: \n"
                + "1.Ball : Increases snake's length by its value.  \n"
                + "2.Destroy Blocks  : Destroy all blocks on screen and and \n 				 increse score by its value. \n"
                + "3.Magnet : Attract coins towards the snake. \n"
                + "4.Shield : Protects snake against any block for 5 seconds. \n");

        text.setX(70);
        text.setY(70);
        text.setFont(Font.font("Helvetica", FontWeight.BOLD, FontPosture.REGULAR,18));	   //changed Font to Helvetica
        text.setFill(Color.BROWN);


        Button btn6=new Button("Back to Menu");
        btn6.setLayoutX(220);
        btn6.setLayoutY(650);
        btn6.setMinSize(160, 40);
        btn6.setStyle("-fx-font: 20 arial; -fx-base: #87CEFA;");

        EventHandler<ActionEvent> event6 = new EventHandler<ActionEvent>() {

            public void handle(ActionEvent e)
            {
                Menu(primaryStage, imageview);

            }
        };

        // when button is pressed
        btn6.setOnAction(event6);


        Rectangle r = new Rectangle();
        r.setX(50);
        r.setY(50);
        r.setWidth(500);
        r.setHeight(700);
        r.setFill(Color.BEIGE);
        r.setOpacity(0.95);

        instructions.getChildren().setAll(imageview,r,text,btn6);

        Scene scene=new Scene(instructions,600,800);

        primaryStage.setScene(scene);


    }

    ////////////////////////////////////////////////////////////////////////////////////////

    protected void LeaderBoard(Stage primaryStage, ImageView imageview) {
        Pane leaderboard=new Pane();

        Image image = new Image("file:blackBackground.png");
        ImageView blackBackground=new ImageView(image);
        blackBackground.setFitHeight(820);
        blackBackground.setFitWidth(620);
        
        Image temp = new Image("file:coming-soon.jpg");								// added coming-soon image
        ImageView comingSoon=new ImageView(temp);
        comingSoon.setFitHeight(820);
        comingSoon.setFitWidth(620);

        Button btn6=new Button("Back to Menu");
        btn6.setLayoutX(220);
        btn6.setLayoutY(730);
        btn6.setMinSize(160, 40);
        btn6.setStyle("-fx-font: 20 arial; -fx-base: #87CEFA;");

        EventHandler<ActionEvent> event6 = new EventHandler<ActionEvent>() {

            public void handle(ActionEvent e)
            {
                Menu(primaryStage, imageview);

            }
        };
        
        // when button is pressed
        btn6.setOnAction(event6);

        leaderboard.getChildren().setAll(blackBackground,comingSoon,btn6);

        Scene scene=new Scene(leaderboard,600,800);


        primaryStage.setScene(scene);


    }

    /////////////////////////////////////////////////////////////////////////////////////////////

    protected void Themes(Stage primaryStage, ImageView imageview) {
        Pane themes=new Pane();

        Image image = new Image("file:blackBackground.png");
        ImageView blackBackground=new ImageView(image);
        blackBackground.setFitHeight(820);
        blackBackground.setFitWidth(620);
        
        Image temp = new Image("file:coming-soon.jpg");									// added coming-soon image
        ImageView comingSoon=new ImageView(temp);
        comingSoon.setFitHeight(820);
        comingSoon.setFitWidth(620);

        Button btn6=new Button("Back to Menu");
        btn6.setLayoutX(220);
        btn6.setLayoutY(730);
        btn6.setMinSize(160, 40);
        btn6.setStyle("-fx-font: 20 arial; -fx-base: #87CEFA;");

        EventHandler<ActionEvent> event6 = new EventHandler<ActionEvent>() {

            public void handle(ActionEvent e)
            {
                Menu(primaryStage, imageview);

            }
        };
        // when button is pressed
        btn6.setOnAction(event6);

        themes.getChildren().setAll(blackBackground,comingSoon,btn6);

        Scene scene=new Scene(themes,600,800);

        primaryStage.setScene(scene);


    }

    public static void main(String[] args) {

        launch(args);
    }
}