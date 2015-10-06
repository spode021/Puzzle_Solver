package framework;

import graph.Vertex;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.Stack;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.LayoutStyle;
import javax.swing.Timer;
import javax.swing.border.TitledBorder;

/**
 * A class that creates GUI components for solving search problems.
 * @author Your Name Here
 */
public class GUI extends JComponent {
    
    public GUI(Problem problem, Canvas canvas) {
        this.problem = problem;
        this.canvas = canvas;
        resetState = problem.getCurrentState();
        
        setLayout(new FlowLayout());
        //setPreferredSize(new Dimension(750, 600));
        currentProblem = problem;
        
        currentCanvas = canvas;
        
        mainPanel = new JPanel();
        
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        
        createIntroPanel();
       
        createProblemPanel(); 
    
        createResetPanel();
       
        createSolvePanel();
        
        JScrollPane scrollablePane = new JScrollPane();
        
        scrollablePane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        
        scrollablePane.setPreferredSize(new Dimension(750,600));
        scrollablePane.setViewportView(mainPanel);
        add(scrollablePane);
        
   
       
        
        
    }
    
    //Methods
    
    public void createIntroPanel(){
        JPanel introPanel = new JPanel();
        JTextArea intro = new JTextArea(currentProblem.getIntroduction());
        intro.setFont(new Font("monospaced", Font.PLAIN, 14));
        intro.setEditable(false);
        introPanel.add(intro);
        //introPanel.setPreferredSize(new Dimension(700, 200));
        mainPanel.add(introPanel);
        mainPanel.add(Box.createVerticalStrut(20));
      //  mainPanel.setPreferredSize(new Dimension(650, 600));
        
    }
    public void createProblemPanel(){
        JPanel problemPanel = new JPanel();
        problemPanel.setLayout(new FlowLayout());
        problemPanel.setPreferredSize(new Dimension(700, 340));
        //Panel for state canvas
        JPanel statePanel = new JPanel();

        
        
        currentCanvas.setCurrentState(problem.getCurrentState());
        
        statePanel.add(currentCanvas);
        repaint();
        TitledBorder stateTitle = new TitledBorder("Current State");
        statePanel.setBorder(stateTitle);
       
        problemPanel.add(statePanel);
        
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridBagLayout());
        
        buttonPanel = createButtonPanel();
        
        TitledBorder buttonTitle = new TitledBorder("Possible Moves");
        buttonPanel.setBorder(buttonTitle);
        
        problemPanel.add(buttonPanel);
        mainPanel.add(problemPanel);
    }

    public JPanel createButtonPanel(){
    buttons = new JPanel();
    buttons.setLayout(new GridBagLayout());
    GridBagConstraints c = new GridBagConstraints();
    
    c.insets = new Insets(5,0,0,0);
    c.gridx = 0;
    c.gridy = 0;
    c.gridheight = 1;
    for(final Move move : currentProblem.getMoves()){
        JButton button = new JButton(move.getMoveName());
        button.setPreferredSize(new Dimension(175, 25));
        button.addActionListener(new ActionListener() {
         
            @Override
            public void actionPerformed(ActionEvent e){
            State newState = move.doMove(currentProblem.getCurrentState());
            if(newState != null){
                currentProblem.setCurrentState(newState);
                currentCanvas.setCurrentState(newState);
                currentCanvas.render();
                
                System.out.print(currentProblem.getCurrentState().toString());
                moveNumber++;
                if(currentProblem.success())
                    JOptionPane.showMessageDialog(mainPanel, "Congratulations.  You solved the problem using " +
                    moveNumber + " moves.", "Message", JOptionPane.INFORMATION_MESSAGE);
            
                     }
            else
                JOptionPane.showMessageDialog(mainPanel, "Illegalmove.", "Error", JOptionPane.INFORMATION_MESSAGE);
            }
            
                
            
        });
        buttons.add(button, c);
        c.gridy++;
    }
    return buttons;
    }
    public void createResetPanel(){
        JButton res = new JButton("RESET");
        res.setPreferredSize(new Dimension(75, 25));
        res.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
               reset();
            }
        });
        
        JPanel resetPanel = new JPanel();
        resetPanel.add(res);
        
        mainPanel.add(resetPanel);
    }
    
    public void reset(){
        moveNumber = 0;
        currentProblem.setCurrentState(resetState);
        currentCanvas.setCurrentState(resetState);
        currentCanvas.render();
        maxSizeStatInfo.setText("");
        solLengthStatInfo.setText("");
        numDEQUEStatInfo.setText("");
        
        nextMoveButton.setEnabled(false);
        allMovesButton.setEnabled(false);
        solveButton.setEnabled(true);
        clicked = false;
        
          for(Component c: buttons.getComponents()){
                    c.setEnabled(true);
                }
    }
    
    public void createSolvePanel(){
        
        solvePanel = new JPanel();
      
        solvePanel.setLayout(new BoxLayout(solvePanel, BoxLayout.X_AXIS));
      
        radioPanel = new JPanel();
      
        radioPanel.setLayout(new BoxLayout(radioPanel, BoxLayout.Y_AXIS));
      
        searchOptionsPanel = new JPanel();
      
        searchOptionsPanel.setLayout(new BoxLayout(searchOptionsPanel, BoxLayout.Y_AXIS));
        ButtonGroup group = new ButtonGroup();
      
        depthSearch = new JRadioButton("Depth-Search");
        breadthSearch = new JRadioButton("Breadth-Search");
        group.add(depthSearch);
        group.add(breadthSearch);
      
        depthSearch.setSelected(true);
      
        radioPanel.add(depthSearch);
        radioPanel.add(breadthSearch);
      
        radioBorder = new TitledBorder(" Search Options");
        radioPanel.setBorder(radioBorder);
      
        solveButton = new JButton("SOLVE");
        solveButton.setPreferredSize(new Dimension(120, 120));
      
     
      
        searchOptionsPanel.add(radioPanel);
      
        searchOptionsPanel.add(solveButton);
        solvePanel.add(searchOptionsPanel);
      
      
        statsPanel = new JPanel();
        statsPanel.setLayout(new BoxLayout(statsPanel, BoxLayout.Y_AXIS));
      
        //statsPanel.setPreferredSize(new Dimension(300, 300));
        statsInfoPanel = new JPanel();
        statsInfoPanel.setLayout(new BoxLayout(statsInfoPanel, BoxLayout.Y_AXIS));
      
      
        solLengthPanel = new JPanel();
      
        solLengthPanel.setLayout(new BoxLayout(solLengthPanel, BoxLayout.X_AXIS));
      
        numDEQUEPanel = new JPanel();
      
        numDEQUEPanel.setLayout(new BoxLayout(numDEQUEPanel, BoxLayout.X_AXIS));
      
        maxSizePanel = new JPanel();
      
        maxSizePanel.setLayout(new BoxLayout(maxSizePanel, BoxLayout.X_AXIS));
        solLengthStat = new JLabel("Solution Length:   ");
      
        maxSizeStat = new JLabel("Max DEQUE SIZE:    ");
        numDEQUEStat = new JLabel("Num of DEQUE Ops:  ");
      
        solLengthStatInfo = new JLabel("");
        numDEQUEStatInfo = new JLabel("");
        maxSizeStatInfo = new JLabel("");
      
        solLengthPanel.add(solLengthStat);
        solLengthPanel.add(solLengthStatInfo);
      
        statsInfoPanel.add(solLengthPanel);
      
        numDEQUEPanel.add(numDEQUEStat);
        numDEQUEPanel.add(numDEQUEStatInfo);
      
        statsInfoPanel.add(numDEQUEPanel);
      
        maxSizePanel.add(maxSizeStat);
        maxSizePanel.add(maxSizeStatInfo);
      
        statsInfoPanel.add(maxSizePanel);
        JLabel blankLabel = new JLabel("                                                        ");
        statsInfoPanel.add(blankLabel);
        TitledBorder statsBorder = new TitledBorder("Solution Statistics");
      
        statsInfoPanel.setBorder(statsBorder);
      
        statsPanel.add(statsInfoPanel);
      
        nextMoveButton = new JButton("SHOW NEXT MOVE");
      
        allMovesButton = new JButton("SHOW ALL MOVES");
      
        nextMoveButton.setEnabled(false);
        allMovesButton.setEnabled(false);
      
        statsPanel.add(nextMoveButton);
        statsPanel.add(allMovesButton);
      
        solveButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent evt){
                reset();
                if(depthSearch.isSelected())
                    problem.depthFirstSearch((Vertex) currentProblem.getCurrentState());
                else
                    problem.breadthFirstSearch((Vertex) currentProblem.getCurrentState());
              /*
                State newState = currentProblem.getCurrentState();
                currentCanvas.setCurrentState(newState);
                currentCanvas.render();
              */
                maxSizeStatInfo.setText(currentProblem.getMaxQueueSize()+"");
                numDEQUEStatInfo.setText(currentProblem.getQueueOps()+"");
                solLengthStatInfo.setText(currentProblem.getMinimalMoves()+"");
              
                solStack = currentProblem.getStack();
              
                solStack.pop(); //pop off starting state since already displayed.
                nextMoveButton.setEnabled(true);
                allMovesButton.setEnabled(true);
                solveButton.setEnabled(false);
                
                
                for(Component c: buttons.getComponents()){
                    c.setEnabled(false);
                }
            }
        });
       
        nextMoveButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                if(solStack.isEmpty() == false){
                    
                    State newState = (State) solStack.pop();
                    
                    
                    currentCanvas.setCurrentState(newState);
                    currentCanvas.render();
                    
                }
            }
        });
         
        timer = new Timer(1000, new ActionListener() {
           
            @Override
            public void actionPerformed(ActionEvent evt){
                if(!currentProblem.getStack().isEmpty())
                    newState = (State) (solStack.pop());
                
                if(newState != null) {
                    moveNumber++;
                    problem.setCurrentState(newState);
                    canvas.setCurrentState(newState);
                    canvas.render();
                    repaint();
                    
                    if(problem.success()) {
                        ((Timer)evt.getSource()).stop();
                        clicked = true;
                        
                    }
                }
                
            }
        });
        
        allMovesButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                if(!clicked)
                    timer.start();
            }
        });
                 
        solvePanel.add(statsPanel);
        mainPanel.add(solvePanel);
      
  
    }
                          

                 


    //variables for solvePanel
    
    private JPanel solvePanel;
    private JPanel searchOptionsPanel;
    private JPanel radioPanel;
    private TitledBorder radioBorder;
    private JButton allMovesButton;
    private JRadioButton breadthSearch;
    private JRadioButton depthSearch;
   
    private JLabel maxSizeStat;
    private JLabel maxSizeStatInfo;
    private JButton nextMoveButton;
    private JLabel numDEQUEStat;
    private JLabel numDEQUEStatInfo;
   
    private JLabel solLengthStat;
    private JLabel solLengthStatInfo;
    private JButton solveButton;
    private Stack solStack;
    private Timer timer;
    private Boolean clicked = false;
    
    private JPanel statsInfoPanel;
    private JPanel statsPanel;
    private JPanel solLengthPanel;
    private JPanel numDEQUEPanel;
    private JPanel maxSizePanel;
    
        
        
 
    
//Common variables
    private State newState;
    private Problem problem;
    private Canvas canvas;
    private int moveNumber = 0;
    private Problem currentProblem;
    private State resetState;
    private Canvas currentCanvas;
    JPanel mainPanel;
    JPanel buttons;

}