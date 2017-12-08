package banking.UI;

import java.io.IOException;
import java.io.RandomAccessFile;

import bankingDAO.FixedLengthStringIO;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.collections.*;
import javafx.application.*;
import javax.swing.*;
import javafx.*;
public class MainWindow extends Application{
final static int FIRSTNAME_SIZE=32;
final static int LASTNAME_SIZE=32;
final static int RECORD_SIZE =
(FIRSTNAME_SIZE+LASTNAME_SIZE);

// Access customers.dat using RandomAccessFile
private RandomAccessFile raf;

// Text fields

ObservableList<String> strList = FXCollections.observableArrayList("红色","黄色","绿色");  
private ListView<String> lvCustomerlist = new ListView<String>();  

private TextField jtfFirstName=new TextField();
private TextField jtfLastName=new TextField();
public void setLvCustomerlist(ListView lvCustomerlist) {
	this.lvCustomerlist = lvCustomerlist;
}
//butttons
private Button jbtAdd=new Button("ADD");
private Button jbtDel=new Button("DEL");
private Button jbtSearch=new Button("SEARCH");
private Button jbtSort=new Button("SORT");

@Override // Override the start method in the Application class
	public void start(Stage primaryStage) {
	 // Open or create a random access file
    try {
      raf = new RandomAccessFile("customers.dat", "rw");
    }
    catch(IOException ex) {
      System.out.print("Error: " + ex);
      System.exit(0);
    }
    
    // Pane p1 for holding labels and so on;
	 GridPane p1=new GridPane();
	 ObservableList<String> strList = FXCollections.observableArrayList("Bryant,Owen","Simms,Jane","Soley,Maria","Soley,Tim");  

	 lvCustomerlist.setItems(strList);
	 lvCustomerlist.setPrefSize(200, 100);
	 p1.add(new Label("Cusomers List:"), 0, 0);
	 p1.add(lvCustomerlist, 0, 1);
	 p1.setVgap(20);
	 
	   // Add buttons to a pane
	    //FlowPane布局概述FlowPane是一个容器。它在一行上排列连续的子组件,并且如果当前行填满了以后,则自动将子组件向下推到下一行。

	    FlowPane jpButton = new FlowPane();
	    jpButton.getChildren().add(jbtAdd);
	    jpButton.getChildren().add(jbtDel);
	    jpButton.getChildren().add(jbtSearch);
	    jpButton.getChildren().add(jbtSort);
	    jpButton.setHgap(30);
	    jpButton.setPadding(new Insets(10,10,10,50));
	    /**配置布局**/
	    //以下代码演示使用GridPane布局的简单表单应用程序。它有以下布局。
/*
+------------------------+
| [label ] [   field   ] |
| [label ] [   field   ] |
|             [ button ] |
*/
	    GridPane p2=new GridPane();
	    p2.add(new Label("FirstName:"), 0, 0);
	    p2.add(new Label("LastName:"), 0, 1);
	    p2.add(jtfFirstName, 1, 0);
	    p2.add(jtfLastName, 1, 1);
	    
	    GridPane p3=new GridPane();
	    p3.add(p2,0,0);
	    p3.add(jpButton,0,1);
	    
	    BorderPane pAll=new BorderPane();
	    pAll.setLeft(p1);
	    pAll.setCenter(p3);
	    
	    //create and register the handler with lambda expression
	    jbtAdd.setOnAction(e -> addCustomer());//这里添加执行增加客户的方法
	    
	    jbtDel.setOnAction(e -> {
	          try {
	            if (raf.length() > 0)addCustomer();//这里添加执行删除操作的方法;
	          }
	          catch (IOException ex) {
	            ex.printStackTrace();
	          }
	      });
	    
	    jbtSearch.setOnAction(e -> {
	          try {
		            if (raf.length() > 0)addCustomer();//这里添加执行search操作的方法;
		          }
		          catch (IOException ex) {
		            ex.printStackTrace();
		          }
		      });
	    jbtSort.setOnAction(e -> {
	          try {
		            if (raf.length() > 0)addCustomer();//这里添加执行sort操作的方法;
		          }
		          catch (IOException ex) {
		            ex.printStackTrace();
		          }
		      });
	    
	 // place it in the scene
	    Scene scene=new Scene(pAll);
	    primaryStage.setTitle("banking"); // Set the stage title
	    primaryStage.setScene(scene); // Place the scene in the stage
	    primaryStage.show(); // Display the stage
}

/** Write a record at the end of the file */
public void addCustomer() {
	 try {
		    raf.seek(raf.length());
		    FixedLengthStringIO.writeFixedLengthString(
		      jtfFirstName.getText(), FIRSTNAME_SIZE, raf);
		    FixedLengthStringIO.writeFixedLengthString(
		      jtfLastName.getText(), LASTNAME_SIZE, raf);

		  }
		  catch (IOException ex) {
		    ex.printStackTrace();
		  }
		}

/** Read a record at the specified position */
public void readCustomer(long position) throws IOException {
  raf.seek(position);
  String firstName = FixedLengthStringIO.readFixedLengthString(
		  FIRSTNAME_SIZE, raf);
  String lastName = FixedLengthStringIO.readFixedLengthString(
		  LASTNAME_SIZE, raf);
  
  //关于怎么在列表上显示
  
 /**暂未完成**/
}
  /**
	 * The main method is only needed for the IDE with limited
	 * JavaFX support. Not needed for running from the command line.
	 */

public static  void main(String[] args) { 
	  launch(args);
	
	}
}








