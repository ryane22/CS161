import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.io.*;
import java.util.*;

class MazeMaker extends JFrame
{
   JButton okbutton, savebutton;
   int rowcount;
   int colcount;
   char [][] maze;
   double density;
   JTextField rowbox, colbox, densebox, filebox;
   
   public MazeMaker()
   {
      super("Maze Generator");
      setDefaultCloseOperation(EXIT_ON_CLOSE);

      okbutton = new JButton("make");
      ButtonWatch bwatch = new ButtonWatch();
      okbutton.addActionListener(bwatch);
      JPanel okpanel = new JPanel();
      okpanel.add(okbutton);
      Box inpanel = new Box(BoxLayout.Y_AXIS);
      inpanel.setSize(new Dimension(400, 120));

      JPanel vpanel = new JPanel();
      vpanel.setPreferredSize(new Dimension(390,35));
      JLabel vlabel = new JLabel("How many rows?", SwingConstants.RIGHT);
      rowbox = new JTextField();
      rowbox.setPreferredSize(new Dimension(50,30));
      rowbox.setHorizontalAlignment(JTextField.CENTER);
      vpanel.add(vlabel);
      vpanel.add(rowbox);

      JPanel epanel = new JPanel();
      epanel.setPreferredSize(new Dimension(390,35));
      JLabel elabel = new JLabel("How many columns?", SwingConstants.RIGHT);
      colbox = new JTextField();
      colbox.setPreferredSize(new Dimension(50,30));
      colbox.setHorizontalAlignment(JTextField.CENTER);
      epanel.add(elabel);
      epanel.add(colbox);

      JPanel cpanel = new JPanel();
      cpanel.setPreferredSize(new Dimension(390,35));
      JLabel clabel = new JLabel("Probability of wall?", SwingConstants.RIGHT);
      densebox = new JTextField();
      densebox.setPreferredSize(new Dimension(50,30));
      densebox.setHorizontalAlignment(JTextField.CENTER);
      cpanel.add(clabel);
      cpanel.add(densebox);

      JPanel fpanel = new JPanel();
      fpanel.setPreferredSize(new Dimension(390,35));
      JLabel flabel = new JLabel("Filename?", SwingConstants.RIGHT);
      filebox = new JTextField("none");
      filebox.setPreferredSize(new Dimension(200,30));
      filebox.setHorizontalAlignment(JTextField.CENTER);
      savebutton = new JButton("save");
      savebutton.addActionListener(bwatch);
      
      fpanel.add(flabel);
      fpanel.add(filebox);
      fpanel.add(savebutton);

      inpanel.add(vpanel);
      inpanel.add(epanel);
      inpanel.add(cpanel);

      getContentPane().add(inpanel, BorderLayout.NORTH);
      getContentPane().add(okpanel, BorderLayout.CENTER);
      getContentPane().add(fpanel, BorderLayout.SOUTH);
   }

   private PrintStream makeStream()
   {
      String filename = filebox.getText();

      if (filename.equals("none"))
         return System.out;
      else try 
      {
         return new PrintStream(new File(filename));
      }
      catch (IOException e)
      {
         System.out.println("File "+filename+" cannot be opened for writing");
         return null;
      }
   }

   public void makeMaze()
   {
      char nextval;
      Random randgen = new Random();
      maze = new char [rowcount][colcount];

      for (int row=0; row<rowcount; row++)
         for (int col = 0; col<colcount; col++)
            if ((row == 0 && col == 0) || 
                  (row == rowcount-1 && col == colcount-1))
               maze[row][col] = ' ';
            else if (randgen.nextDouble() < density)
               maze[row][col] = 'X';
            else
               maze[row][col] = ' ';
   }
   
   private void writeMaze(PrintStream outstream)
   {
      if (outstream == null)
         return;
      outstream.println("" + rowcount + " " + colcount);
      for (int row=0; row<rowcount; row++)
      {
         for (int col = 0; col<colcount; col++)
            outstream.print("|" + maze[row][col]);
         outstream.println("|");
      }    
   }
   
   private class ButtonWatch implements ActionListener
   {
      public void actionPerformed(ActionEvent event)
      {
         Object source = event.getSource();
         if (source == okbutton)
         {
            rowcount = Integer.parseInt(rowbox.getText());
            colcount = Integer.parseInt(colbox.getText());
            density = Double.parseDouble(densebox.getText());
            makeMaze();
            writeMaze(System.out);
         }
         else if (source == savebutton)
            writeMaze(makeStream());
      }
   }

   public static void main(String[] args)
   {
      MazeMaker mazebox = new MazeMaker();
      mazebox.pack();
      mazebox.setVisible(true);
   }
}

