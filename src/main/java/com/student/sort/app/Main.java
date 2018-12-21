package com.student.sort.app;

import java.awt.EventQueue;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.filechooser.FileSystemView;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import com.student.sort.algorithm.AlgorithmBuilder;
import com.student.sort.algorithm.SortAlgorithm;
import com.student.sort.domain.Student;
import com.student.sort.enums.Algorithm;
import com.student.sort.enums.SortDirection;
import com.student.sort.reader.TextFileReader;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.LinkedList;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;

public class Main {

  private final JFrame frame = new JFrame();

  private final List<Student> students = new LinkedList<Student>();
  
  private final TextFileReader textFileReader = new TextFileReader();

  private final AlgorithmBuilder algorithmBuilder = new AlgorithmBuilder();
  
  private final String[] tableColumns = {"Student title", "score"};
  
  private DefaultTableModel tableModel = new DefaultTableModel(tableColumns, 0);
  
  //private final JTable table = new JTable(tableModel);
  private JTable table = new JTable(tableModel);

  /**
   * Launch the application.
   */
  public static void main(String[] args) {
      EventQueue.invokeLater(new Runnable() {
          public void run() {
              try {
                  Main main = new Main();
                  main.frame.setVisible(true);
              } catch (Exception e) {
                  e.printStackTrace();
              }
          }
      });
  }

  /**
   * Create the application.
   */
  public Main() {
      initialize();
  }

  /**
   * Initialize the contents of the frame.
   */
  @SuppressWarnings(value = {"rawtypes", "unchecked"})
  private void initialize() {

      frame.setBounds(100, 100, 631, 506);
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.getContentPane().setLayout(null);

      JLabel lblRecords = new JLabel("Records");
      lblRecords.setBounds(232, 15, 65, 14);
      frame.getContentPane().add(lblRecords);
      
      JLabel lblRecordsResult = new JLabel("");
      lblRecordsResult.setBounds(344, 15, 39, 14);
      frame.getContentPane().add(lblRecordsResult);
      
      JLabel lblSortingTime = new JLabel("Sorting time");
      lblSortingTime.setBounds(232, 55, 91, 14);
      frame.getContentPane().add(lblSortingTime);
      
      JLabel lblSortingTimeResult = new JLabel("");
      lblSortingTimeResult.setBounds(337, 55, 46, 14);

      frame.getContentPane().add(lblSortingTimeResult);

      JComboBox<Algorithm> sortAlgorithmSelector = new JComboBox(Algorithm.values());
      sortAlgorithmSelector.setBounds(486, 52, 119, 20);
      frame.getContentPane().add(sortAlgorithmSelector);
      
      JComboBox<SortDirection> sortDirectionSelector = new JComboBox(SortDirection.values());
      sortDirectionSelector.setBounds(485, 12, 120, 20);
      frame.getContentPane().add(sortDirectionSelector);
      
      JLabel lblDirection = new JLabel("Direction");
      lblDirection.setBounds(393, 15, 66, 14);
      frame.getContentPane().add(lblDirection);
      
      JLabel lblAlgorithm = new JLabel("Algorithm");
      lblAlgorithm.setBounds(393, 55, 66, 14);
      frame.getContentPane().add(lblAlgorithm);

      table = new JTable();
      table.setBounds(10, 141, 479, 315);
      frame.getContentPane().add(table);
      
      JButton btnSelectFile = new JButton("Select file");
      btnSelectFile.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
          JFileChooser jfc = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
          jfc.setDialogTitle("Select student input file");
          jfc.setFileSelectionMode(JFileChooser.FILES_ONLY);
          int returnValue = jfc.showOpenDialog(null);
          
          if (returnValue == JFileChooser.APPROVE_OPTION) {
            File selectedFile = jfc.getSelectedFile();
            students.clear();
            students.addAll(textFileReader.readFromFile(selectedFile));
            
            tableModel.setRowCount(0);
            for (Student student : students) {
              tableModel.addRow(new Object[] {student.getTitle(), student.getScore()});
            }
            tableModel.fireTableDataChanged();
            table.setModel(tableModel);
            
            lblRecordsResult.setText(Integer.toString(students.size()));
          }
        }
      });
      btnSelectFile.setBounds(10, 11, 168, 23);
      frame.getContentPane().add(btnSelectFile);
      
      JButton btnSort = new JButton("Sort");
      btnSort.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
          SortDirection direction = (SortDirection) sortAlgorithmSelector.getSelectedItem();
          Algorithm algorithm = (Algorithm) sortAlgorithmSelector.getSelectedItem();
          SortAlgorithm sortAlgorithm = algorithmBuilder.buildAlgorithm(algorithm);
          long startTime = System.currentTimeMillis();
          sortAlgorithm.sort(students, direction);
          long stopTime = System.currentTimeMillis();
          long elapsedTime = stopTime - startTime;
          lblSortingTimeResult.setText(Long.toString(elapsedTime)+ " ms");
        }
      });
      btnSort.setBounds(10, 52, 168, 22);
      frame.getContentPane().add(btnSort);

  }
}
