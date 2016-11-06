/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package renamingapp;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 *
 * @author p_unit
 */
public class Core {

    public static void main(String[] ar) {

        JFileChooser filechooser = new JFileChooser();

        String absPath = "";

        filechooser.showOpenDialog(null);

        filechooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
        filechooser.show(true);
        filechooser.setApproveButtonText("Open");
        filechooser.approveSelection();

        String path = filechooser.getCurrentDirectory().getAbsolutePath().toString();
        System.out.println("Path is  : -" + path + " \n\n\n");
        File f = new File(path);

        String fileList[] = f.list();

        File filter = null;

        String fileType = "";
        fileType = (JOptionPane.showInputDialog("Choose the File Extenstion"
                + " \n"));

        String renameTo = "";

        renameTo = (JOptionPane.showInputDialog("Enter the new Extention . "
                + ""));

        int indexatdot = 0;

        int no = 0;
        if (fileList.length != 0) {
            for (String Listing : fileList) {

                String fullName = f + "\\" + Listing.toString();

                filter = new File(fullName);

                if (fullName.contains("." + fileType)) {
                    if (!filter.isDirectory()) {

                        String fileOName = filter.getName();

                        indexatdot = fileOName.indexOf('.');
                        String filerename = fileOName.substring(0, indexatdot);
                        filerename = filerename + "." + renameTo;

                        File temp = new File(path + "\\" + filerename);
                        try {
                            temp.createNewFile();

                            System.out.printf("\n\nfile temp is created " + temp.getPath() + "\n");
                            boolean truee = filter.renameTo(new File("./" + filerename));

                            System.out.println(truee);

                            ///       temp.delete();
                        } catch (IOException ex) {
                            Logger.getLogger(Core.class.getName()).log(Level.SEVERE, null, ex);
                        }

//                        System.out.println(fileOName.substring(0, indexatdot));
                        no++;

                    }
                }

            }

            JOptionPane.showMessageDialog(null, "Total File are = " + no
                    + "  \nRenamed  " + no
                    + "\nRename from " + fileType
                    + " to " + renameTo);
        } else {

            JOptionPane.showMessageDialog(null, "No such file type found ."
                    + "\nPlease choose right file type");

        }

    }

}
