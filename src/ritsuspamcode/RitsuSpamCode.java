/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ritsuspamcode;

/**
 *
 * @author Plupiman
 */
import java.io.*;
import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;
import javax.swing.*;
import sun.nio.ch.IOUtil;
public class RitsuSpamCode {
	 
    public static void main(String[] args)throws IOException,
                           AWTException, InterruptedException {
        Robot rob = new Robot();
        File folder = new File(chooseFolder());
        int folderSize = folder.list().length;
        Integer folderSizeInteger = new Integer(folderSize);
        String folderSizeString = folderSizeInteger.toString();
        rob.delay(5000);
        for (int i = 1; i < folderSize ; i++){
            writeProgress(i, folderSizeString, rob);
            rob.keyPress(KeyEvent.VK_ENTER);
            rob.delay(30);
            rob.keyRelease(KeyEvent.VK_ENTER);
            rob.delay(200);
            if (i % 5 == 0){
                rob.delay(1500);
            }
        }
    }
    
    public static void writeProgress(int i, String folderSize, Robot rob){
        rob.setAutoDelay(50);
        Integer iInt = new Integer(i);
        String iString = iInt.toString();
        for (int j = 0 ; j < iString.length(); j++){
            System.out.println(iString.charAt(j));
            switch (iString.charAt(j)){
                case '0':  
                    System.out.println("hi");
                    rob.keyPress(KeyEvent.VK_0);
                    rob.keyRelease(KeyEvent.VK_0);
                    break;
                case '1':  
                    rob.keyPress(KeyEvent.VK_1);
                    rob.keyRelease(KeyEvent.VK_1);
                    break;        
                case '2':  
                    rob.keyPress(KeyEvent.VK_2);
                    rob.keyRelease(KeyEvent.VK_2);
                    break;
                case '3':  
                    rob.keyPress(KeyEvent.VK_3);
                    rob.keyRelease(KeyEvent.VK_3);
                    break;    
                case '4':  
                    rob.keyPress(KeyEvent.VK_4);
                    rob.keyRelease(KeyEvent.VK_4);
                    break;
                case '5':  
                    rob.keyPress(KeyEvent.VK_5);
                    rob.keyRelease(KeyEvent.VK_5);
                    break;        
                case '6':  
                    rob.keyPress(KeyEvent.VK_6);
                    rob.keyRelease(KeyEvent.VK_6);
                    break;
                case '7':  
                    rob.keyPress(KeyEvent.VK_7);
                    rob.keyRelease(KeyEvent.VK_7);
                    break;   
                case '8':  
                    rob.keyPress(KeyEvent.VK_8);
                    rob.keyRelease(KeyEvent.VK_8);
                    break;
                case '9':  
                    rob.keyPress(KeyEvent.VK_9);
                    rob.keyRelease(KeyEvent.VK_9);
                    break;        
 
            }
        }
        rob.keyPress(KeyEvent.VK_SLASH);
        rob.keyRelease(KeyEvent.VK_SLASH);
        for (int j = 0 ; j < folderSize.length(); j++){
            switch (folderSize.charAt(j)){
                case '0':  
                    System.out.println("hi");
                    rob.keyPress(KeyEvent.VK_0);
                    rob.keyRelease(KeyEvent.VK_0);
                    break;
                case '1':  
                    rob.keyPress(KeyEvent.VK_1);
                    rob.keyRelease(KeyEvent.VK_1);
                    break;        
                case '2':  
                    rob.keyPress(KeyEvent.VK_2);
                    rob.keyRelease(KeyEvent.VK_2);
                    break;
                case '3':  
                    rob.keyPress(KeyEvent.VK_3);
                    rob.keyRelease(KeyEvent.VK_3);
                    break;    
                case '4':  
                    rob.keyPress(KeyEvent.VK_4);
                    rob.keyRelease(KeyEvent.VK_4);
                    break;
                case '5':  
                    rob.keyPress(KeyEvent.VK_5);
                    rob.keyRelease(KeyEvent.VK_5);
                    break;        
                case '6':  
                    rob.keyPress(KeyEvent.VK_6);
                    rob.keyRelease(KeyEvent.VK_6);
                    break;
                case '7':  
                    rob.keyPress(KeyEvent.VK_7);
                    rob.keyRelease(KeyEvent.VK_7);
                    break;   
                case '8':  
                    rob.keyPress(KeyEvent.VK_8);
                    rob.keyRelease(KeyEvent.VK_8);
                    break;
                case '9':  
                    rob.keyPress(KeyEvent.VK_9);
                    rob.keyRelease(KeyEvent.VK_9);
                    break;        
 
            }
        }
    }
    
    public static String chooseFolder() throws FileNotFoundException, MalformedURLException{
        File test = new File(".");
           for(String fileNames : test.list()) System.out.println(fileNames);
        File chosenFolder = null; //reads old dump file location, preps for UI
        //URL txtURL = new URL("C:\\Users\\Edward Carlson\\Documents\\RitsuSpamCode\\build\\classes\\ritsuspamcode");
        //URL txtURL = RitsuSpamCode.class.getResource("ritsuspamcode/FileLoc.txt");
//InputStream in = this.getClass().getClassLoader().getResourceAsStream("FileLoc.txt");
        //OutputStream out = new FileOutputStream(txtFile);
        //IOUtils.copy(in, out);
        //File txtFile = new File (txtURL.getFile());
        //System.out.println(txtURL +"Hi");
        //File txtFile = new File (txtURL.getFile()); 
        File txtFile = new File
                ("build\\classes\\ritsuspamcode\\FileLoc.txt");
        //File txtFile = new File ("C:\\Users\\Edward Carlson\\Desktop\\test.txt");
        System.out.println(txtFile.exists());
        System.out.println(System.getProperty("user.dir") +"hi");
        Scanner fileRead = new Scanner(txtFile);
        if (fileRead.hasNextLine()){
            chosenFolder = new File(fileRead.nextLine());
            System.out.println(chosenFolder);
            if (!chosenFolder.exists()){
                chosenFolder = new File("C:");
            }
        }
        
        JButton chooser = new JButton();  //UI component section
        JFileChooser navi = new JFileChooser();
        navi.setCurrentDirectory(chosenFolder);
        navi.setDialogTitle("Choose Dump Folder");
        navi.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        if (navi.showOpenDialog(chooser) == JFileChooser.APPROVE_OPTION){
        }
        
        String selectedFile = navi.getSelectedFile().getAbsolutePath();//takes UI info and returns/saves
        try{
             FileWriter writer = new FileWriter(txtFile, false);
             writer.write(selectedFile);
             writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return(selectedFile);
        
    }
}
