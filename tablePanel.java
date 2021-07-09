import javax.swing.*;
import java.awt.*;

public class tablePanel implements Option {

    private JPanel table;
    private JPanel Buttons;
    private JPanel ScrollPanel;
    private JPanel rowIndex;
    private JPanel colIndex;
    private JLabel TAT;
    private JLabel WAT;
    JScrollPane jScrollPane;

    private Dimension cellSize = new Dimension(50,50);
    private Dimension rowSize = new Dimension(70,50);
    private Dimension colSize = new Dimension(50,20);

    tablePanel(JPanel table){
        this.table = table;
    }
    public void setup(updateUI ui){
        table.setBackground(cellBlack);
        int page = ui.getPage();
        int prevpage = ui.getPrevpage();
        //datahere
//        Process p1 = new Process("A",1,5);
//        Process p2 = new Process("B",2,3);
//        Process p3 = new Process("C",14,1);
//        Process p4 = new Process("D",3,2);
//        Process p5 = new Process("E",0,3);
//        LinkedList<Process> d = new LinkedList<Process>();
//        d.add(p1);
//        d.add(p2);
//        d.add(p3);
//        d.add(p4);
//        d.add(p5);
//
//        roundRobinUtil r = new roundRobinUtil(d,4);
//        r.roundRobin();
//        ui.setRoundRobin(r);
//
        roundRobinUtil roundRobin = ui.getRoundRobin();
        //       LinkedList<Process> queue = (LinkedList<Process>) roundRobin.getSteps().get(page).getQueue();

        int tableRowSize = ui.getRoundRobin().getProcesses().size();
        int tableColSize = 6;
        ui.setTableRowSize(tableRowSize);
        ui.setTableColSize(tableColSize);

        rowIndex = new JPanel(new GridBagLayout());
        colIndex = new JPanel(new GridBagLayout());

        ScrollPanel = new JPanel(new GridBagLayout());
        ScrollPanel.setName("scrollPanel");
        ScrollPanel.setBackground(cellGray);

        jScrollPane = new JScrollPane(ScrollPanel);
        jScrollPane.setName("scrollArea");
        jScrollPane.setRowHeaderView(rowIndex);
        jScrollPane.setColumnHeaderView(colIndex);
        jScrollPane.setBackground(cellBlack);
        jScrollPane.getVerticalScrollBar().setUI(new cJScrollPaneUI(cellYellow,cellBlack,cellYellow,"\u25BD","\u25B3"));
        jScrollPane.getHorizontalScrollBar().setUI(new cJScrollPaneUI(cellYellow,cellBlack,cellYellow,"\u25B7","\u25C1"));
        jScrollPane.setBorder(BorderFactory.createLineBorder(cellBlack));
        jScrollPane.getVerticalScrollBar().setUnitIncrement(20);

        jScrollPane.getColumnHeader().setBackground(cellBlack);
        jScrollPane.getRowHeader().setBackground(cellBlack);
        rowIndex.setBackground(cellBlack);
        colIndex.setBackground(cellBlack);
        rowIndex.setForeground(cellWhite);
        colIndex.setForeground(cellWhite);


        //Buttons
        Buttons = new JPanel(new GridBagLayout());
        Buttons.setBackground(cellBlack);
        CButton first = new CButton("<<",SwingConstants.CENTER);
        CButton prev = new CButton("<",SwingConstants.CENTER);
        CButton next = new CButton(">",SwingConstants.CENTER);
        CButton equal = new CButton(">>",SwingConstants.CENTER);
        CButton play = new CButton("\u25B6",SwingConstants.CENTER);
        CButton stop = new CButton("\u23F9",SwingConstants.CENTER);
        play.setFont(new Font("Arial Unicode MS",Font.PLAIN,10));
        stop.setFont(new Font("Arial Unicode MS",Font.PLAIN,10));

        //Button Option
        Dimension buttonSize = new Dimension(80,20);
        first.setMinimumSize(buttonSize);
        prev.setMinimumSize(buttonSize);
        next.setMinimumSize(buttonSize);
        equal.setMinimumSize(buttonSize);
        play.setMinimumSize(buttonSize);
        stop.setMinimumSize(buttonSize);

        //Setup Button
        first.setActionCommand(String.valueOf(buttonId.first));
        prev.setActionCommand(String.valueOf(buttonId.prev));
        next.setActionCommand(String.valueOf(buttonId.next));
        equal.setActionCommand(String.valueOf(buttonId.equal));
        play.setActionCommand(String.valueOf(buttonId.play));
        stop.setActionCommand(String.valueOf(buttonId.stop));

        first.addActionListener(new onClickListener(ui));
        prev.addActionListener(new onClickListener(ui));
        next.addActionListener(new onClickListener(ui));
        equal.addActionListener(new onClickListener(ui));
        play.addActionListener(new onClickListener(ui));
        stop.addActionListener(new onClickListener(ui));

        GridBagConstraints buttonConst = ui.constraints(GridBagConstraints.BOTH,1,1);
        JSeparator separator = new JSeparator(SwingConstants.HORIZONTAL);
        separator.setForeground(cellBlack);
        separator.setBackground(cellBlack);
        Buttons.add(first,buttonConst);
        Buttons.add(prev,buttonConst);
        Buttons.add(next,buttonConst);
        Buttons.add(equal,buttonConst);
        Buttons.add(play,buttonConst);
        Buttons.add(stop,buttonConst);

        JPanel colNums = new JPanel(new GridBagLayout());
        colNums.setBackground(cellBlack);

        //Setup Corner View
        JLabel Process = new JLabel("Process",JLabel.CENTER);
        Process.setForeground(cellWhite);
        Process.setPreferredSize(colSize);
        jScrollPane.setCorner(JScrollPane.UPPER_LEFT_CORNER,Process);
        //setup Row Header View
        GridBagConstraints rowConst = ui.constraints(GridBagConstraints.BOTH,1,1);
        ui.constraints(rowConst,0,GridBagConstraints.RELATIVE,1,1);

        GridBagConstraints ScrollConst = ui.constraints(GridBagConstraints.BOTH,1,1);

        int k = ui.getRoundRobin().getSteps().get(page).getI();
        for(int i = 0; i < tableRowSize; i++){
            JLabel rowLabel = new JLabel(String.valueOf(roundRobin.getSteps().get(page).process[i]), JLabel.CENTER);
            rowLabel.setPreferredSize(rowSize);
            rowLabel.setForeground(cellWhite);
            rowIndex.add(rowLabel, rowConst);

            JLabel Arrival        = new data(String.valueOf(roundRobin.getSteps().get(page).arrivalTime[i]),SwingConstants.CENTER);
            JLabel burstOut       = new data(String.valueOf(roundRobin.getSteps().get(page).burstTime[i]),SwingConstants.CENTER);
            JLabel Started        = new data(String.valueOf(roundRobin.getSteps().get(page).startTime[i]),SwingConstants.CENTER);
            JLabel Completion     = new data(String.valueOf(roundRobin.getSteps().get(page).completionTime[i]),SwingConstants.CENTER);
            JLabel TurnAroundTime = new data(String.valueOf(roundRobin.getSteps().get(page).turnAroundTime[i]),SwingConstants.CENTER);
            JLabel WaitingTime    = new data(String.valueOf(roundRobin.getSteps().get(page).waitingTime[i]),SwingConstants.CENTER);

            ui.constraints(ScrollConst,GridBagConstraints.RELATIVE,i,1,1);
            ui.constraints(ScrollConst,0.15f,1);
            ScrollPanel.add(Arrival,ScrollConst);
            ScrollPanel.add(burstOut,ScrollConst);
            ScrollPanel.add(Started,ScrollConst);
            ScrollPanel.add(Completion,ScrollConst);

            ui.constraints(ScrollConst,0.2f,1);
            ScrollPanel.add(TurnAroundTime,ScrollConst);
            ScrollPanel.add(WaitingTime,ScrollConst);
        }


        //setup Col Header View
        GridBagConstraints colConst = ui.constraints(GridBagConstraints.BOTH,0.15f,1);
        String[] Variables = {"Arrival","Burst Out","Started","Completion","Turnaround Time","Waiting Time"};
        for(int i = 0; i < tableColSize; i++){
            ui.constraints(colConst,GridBagConstraints.RELATIVE,0,1,1);
            if(i >= 4)
                ui.constraints(colConst,0.2f,1);

            JLabel colLabel = new JLabel(Variables[i],JLabel.CENTER);
            colLabel.setPreferredSize(colSize);
            colLabel.setForeground(cellWhite);
            colNums.add(colLabel,colConst);
        }

        ui.constraints(colConst,GridBagConstraints.RELATIVE,1,1,1);
        ui.constraints(colConst,scrollTableWeightx1,1);
        colIndex.add(colNums,colConst);

        JLabel separator1 = new JLabel("AVG:",JLabel.CENTER);
        separator1.setBackground(cellBlack);
        separator1.setOpaque(true);
        separator1.setPreferredSize(new Dimension(70,20));
        separator1.setForeground(cellWhite);
        JLabel corner = new JLabel();

        JPanel avgContainer = new JPanel(new GridBagLayout());
        JScrollPane avgScroll = new JScrollPane(avgContainer,JScrollPane.VERTICAL_SCROLLBAR_NEVER,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        avgScroll.setRowHeaderView(separator1);
        avgScroll.setBackground(cellBlack);
        avgScroll.setBorder(BorderFactory.createEmptyBorder());
        avgScroll.getVerticalScrollBar().setUI(new cJScrollPaneUI(cellYellow,cellBlack,cellYellow,"\u25BD","\u25B3"));
        avgScroll.getHorizontalScrollBar().setUI(new cJScrollPaneUI(cellYellow,cellBlack,cellYellow,"\u25B7","\u25C1"));
        jScrollPane.getHorizontalScrollBar().addAdjustmentListener(e -> {
            avgScroll.getHorizontalScrollBar().setValue(jScrollPane.getHorizontalScrollBar().getValue());

        });
        jScrollPane.getViewport().addChangeListener(e -> {
            if(jScrollPane.getVerticalScrollBar().isVisible()){
                corner.setVisible(true);
            }
            else corner.setVisible(false);
        });


        avgContainer.setBackground(cellGray);
        GridBagConstraints avgConst = ui.constraints(GridBagConstraints.BOTH,0.15f,1);
        for(int i = 0; i < tableColSize-2; i++) {
            JLabel avg = new JLabel(String.format("%s", "---"), JLabel.CENTER);
            avg.setPreferredSize(colSize);
            avg.setForeground(cellWhite);
            avg.setOpaque(true);
            avg.setBackground(cellGray);
            avg.setBorder(BorderFactory.createLineBorder(cellBlack));
            avgContainer.add(avg,avgConst);
        }
        ui.constraints(avgConst,0.2f,1);
        TAT = new JLabel(String.format("%.3f", ui.getRoundRobin().getSteps().get(page).avgTurnAroundTime[k]), JLabel.CENTER);
        WAT = new JLabel(String.format("%.3f", ui.getRoundRobin().getSteps().get(page).avgTurnAroundTime[k]), JLabel.CENTER);
        TAT.setPreferredSize(colSize);
        TAT.setForeground(cellWhite);
        TAT.setOpaque(true);
        TAT.setBorder(BorderFactory.createLineBorder(cellBlack));
        TAT.setBackground(cellGray);
        WAT.setPreferredSize(colSize);
        WAT.setOpaque(true);
        WAT.setBorder(BorderFactory.createLineBorder(cellBlack));
        WAT.setBackground(cellGray);
        WAT.setForeground(cellWhite);
        corner.setPreferredSize(new Dimension(20,20));
        avgContainer.add(TAT,avgConst);
        avgContainer.add(WAT,avgConst);
        ui.constraints(avgConst,0,1);
        avgContainer.add(corner,avgConst);

        JPanel tableContainer = new JPanel(new GridBagLayout());
        tableContainer.setPreferredSize(new Dimension(0,0));
        tableContainer.setName("tableContainer");

        GridBagConstraints tableConst = ui.constraints(GridBagConstraints.BOTH,1,0.05f);
        ui.constraints(tableConst,0,GridBagConstraints.RELATIVE,1,1);
        tableContainer.add(Buttons,tableConst);
        ui.constraints(tableConst,1,0.85f);
        tableContainer.add(jScrollPane,tableConst);
        ui.constraints(tableConst,1,0.10f);
        tableContainer.add(avgScroll,tableConst);

        GridBagConstraints mainConst = ui.constraints(GridBagConstraints.BOTH,1,1);
        table.add(tableContainer,mainConst);
        ui.setTable(this);
        ui.colorChange(prevpage,false);
        ui.colorChange(page,true);
    }
    public JPanel getPanel(){
        return table;
    }
    public JPanel getScrollPanel() {
        return ScrollPanel;
    }

    public JPanel getRowIndex() {
        return rowIndex;
    }

    public JPanel getColIndex() {
        return colIndex;
    }

    public JLabel getTAT() {
        return TAT;
    }

    public JLabel getWAT() {
        return WAT;
    }

    public JScrollPane getjScrollPane() {
        return jScrollPane;
    }

    class data extends JLabel{
        data(String text, int HorizontalAlignment){
            super(text,HorizontalAlignment);
            setForeground(cellWhite);
            setPreferredSize(cellSize);
            setBorder(BorderFactory.createLineBorder(cellBlack));
        }
    }
}
