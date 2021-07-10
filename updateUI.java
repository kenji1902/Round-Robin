import javax.swing.*;
import java.awt.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.TimerTask;
import java.util.Timer;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class updateUI implements Option {
    private informationPanel information;
    private tablePanel table;
    private inputPanel input;
    private JFrame mainFrame;


    private int page;
    private int prevpage;
    private int tableColSize;
    private int tableRowSize;
    private int randomTaskCount;
    private roundRobinUtil roundRobin;

    //Gridbag constraints Utitlity
    updateUI(){
        Process p1 = new Process("A",1,5);
        Process p2 = new Process("B",2,3);
        Process p3 = new Process("C",14,1);
        Process p4 = new Process("D",3,2);
        Process p5 = new Process("E",0,3);
        LinkedList<Process> d = new LinkedList<Process>();
        d.add(p1);
        d.add(p2);
        d.add(p3);
        d.add(p4);
        d.add(p5);
        roundRobin = new roundRobinUtil(d,4);
        roundRobin.roundRobin();
        randomTaskCount = 0;
        page = 0;
        prevpage = 0;
    }

    public GridBagConstraints constraints(int fill, float weightx, float weighty){
        GridBagConstraints consts = new GridBagConstraints();
        consts.fill = fill;
        consts.weightx = weightx;
        consts.weighty = weighty;
        return consts;
    }

    public void constraints(GridBagConstraints consts, float weightx, float weighty){
        consts.weightx = weightx;
        consts.weighty = weighty;
    }

    public void constraints(GridBagConstraints consts, int gridx, int gridy, int gridwidth, int gridheight){
        consts.gridx = gridx;
        consts.gridy = gridy;
        consts.gridwidth = gridwidth;
        consts.gridheight = gridheight;
    };

    //Refactor Cells
    public void colorChange(int page,boolean opaque){
        JScrollPane pane = information.getScrollPane();
        JTextPane code = (JTextPane) pane.getViewport().getView();
        JLabel Time = information.getTime();
        JLabel TimeQuantum = information.getTimeQuantum();
        JLabel TAT = table.getTAT();
        JLabel WAT = table.getWAT();

        Codes html = new Codes();

        TimeQuantum.setOpaque(opaque);
        TimeQuantum.setBackground(cellGray);

        Time.setOpaque(opaque);
        Time.setBackground(cellGray);
        String timeVal = String.format("<html><p style=\"text-align: center;\"><span style=\"color: #ffffff;\">Time:</span></p>\n" +
                "<p style=\"text-align: center;\">%d</p></html>",roundRobin.getSteps().get(page).getTime());
        int i = roundRobin.getSteps().get(page).getI();
        int part = roundRobin.getSteps().get(page).getPart();

        switch (part){
            case 0:
                code.setText(html.code0);
                Time.setText(timeVal);
                for(int j = 0; j < tableRowSize; j++)
                    refactorCellRow(j, this.page, cellBlack, opaque);
                break;
            case 1:
                TimerTask task = new TimerTask() {
                    int j = 0;
                    @Override
                    public void run() {
                        if(j < tableRowSize) {
                            refactorCell(tableColSize * j, page, "arrival", cellYellow, opaque);
                            refactorCell(tableColSize * j + 1, page, "burstTime", cellRed, opaque);
                            //refactorCellRow(j, page, cellOrange, opaque);
                            j++;
                        }
                    }
                };
                ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(tableRowSize);
                for (int j = 0; j  < tableRowSize; j++) {
                    scheduler.schedule(task,j*50, TimeUnit.MILLISECONDS);
                }
                scheduler.shutdown();
                break;
            case 2:
                code.setText(html.code2);
                refactorCell(tableColSize * i + 2, page, "startedTime", cellRed, opaque);
                refactorCell(tableColSize * i,page,"arrival",cellYellow,opaque);
                Time.setText(timeVal);
                refactorCellRow(i,page,cellGray,opaque);
                break;
            case 3:
                code.setText(html.code3);
                refactorCell(tableColSize * i + 2, page, "startedTime", cellRed, opaque);
                TimeQuantum.setBackground(cellOrange);
                Time.setText(timeVal);
                Time.setBackground(cellBlue);
                refactorCellRow(i,page,cellGray,opaque);

                break;
            case 4:
                code.setText(html.code4);
                TimeQuantum.setBackground(cellOrange);
                refactorCell(tableColSize * i + 1,page,"burstTime",cellYellow,opaque);
                refactorCellRow(i,page,cellGray,opaque);
                refactorCPU(String.valueOf(roundRobin.getSteps().get(page).process[i]),page,cellRed,opaque);

                break;

            case 5:
                code.setText(html.code5);
                Time.setText(timeVal);
                Time.setBackground(cellBlue);
                refactorCell(tableColSize * i + 1,page,"burstTime",cellYellow,opaque);
                refactorCellRow(i,page,cellGray,opaque);
                refactorCPU(String.valueOf(roundRobin.getSteps().get(page).process[i]),page,cellGreen,opaque);

                break;
            case 6:
                code.setText(html.code6);
                Time.setText(timeVal);
                Time.setBackground(cellBlue);
                refactorCell(tableColSize * i + 3,page,"completionTime",cellYellow,opaque);
                refactorCellRow(i,page,cellGray,opaque);
                break;
            case 7:
                code.setText(html.code7);
                refactorCell(tableColSize * i,page,"arrival",cellRed,opaque);
                refactorCell(tableColSize * i + 3,page,"completionTime",cellOrange,opaque);
                refactorCell(tableColSize * i + 4,page,"turnAroundTime",cellYellow,opaque);
                refactorCellRow(i,page,cellGray,opaque);

                break;
            case 8:
                code.setText(html.code8);
                refactorCell(tableColSize * i + 1,page,"burstTime",cellRed,opaque);
                refactorCell(tableColSize * i + 4,page,"turnAroundTime",cellOrange,opaque);
                refactorCell(tableColSize * i + 5,page,"waitingTime",cellYellow,opaque);
                refactorCellRow(i,page,cellGray,opaque);
                TAT.setText(String.format("%.3f",roundRobin.getSteps().get(page).avgTurnAroundTime[i]));
                WAT.setText(String.format("%.3f",roundRobin.getSteps().get(page).avgWaitingTime[i]));

                break;
            case 9:
                code.setText(html.code9);
                refactorCPU("",page,cellGreen,opaque);
                break;
            case 10:
                task = new TimerTask() {
                    int j = 0;

                    @Override
                    public void run() {
                        int i = roundRobin.getSteps().get(j).getI();
                        if(j < tableRowSize && getPage() > getPrevpage() && opaque) {
                            refactorCell(tableColSize * j + 4, page, "turnAroundTime", cellYellow, opaque);
                            refactorCell(tableColSize * j + 5, page, "waitingTime", cellRed, opaque);
                            refactorCell(tableColSize * j + 1, page, "burstTime", cellGray, opaque);
                            refactorCellRow(j, page, cellOrange, opaque);
                        }
                        else {
                            refactorCell(tableColSize * j + 4, page, "turnAroundTime", cellYellow, false);
                            refactorCell(tableColSize * j + 5, page, "waitingTime", cellRed, false);
                            refactorCell(tableColSize * j + 1, page, "burstTime", cellGray, false);
                            refactorCellRow(j, page, cellOrange, false);
                        }
                        j++;
                    }
                };
                scheduler = Executors.newScheduledThreadPool(tableRowSize);
                for (int j = 0; j  < roundRobin.getSteps().size(); j++) {
                    scheduler.schedule(task,j*50, TimeUnit.MILLISECONDS);
                }
                scheduler.shutdown();
                Time.setText(timeVal);

                break;
            case 11:
                code.setText(html.code11);
                TimeQuantum.setBackground(cellOrange);
                Time.setText(timeVal);
                Time.setBackground(cellBlue);
                refactorCellRow(i,page,cellGray,opaque);
                break;

            case 12:
                code.setText(html.code12);
                refactorCell(tableColSize * i + 1,page,"burstTime",cellRed,opaque);
                refactorCellRow(i,page,cellGray,opaque);
                break;
            case 13:
                code.setText(html.code13);
                refactorCell(tableColSize * i,page,"arrival",cellYellow,opaque);
                refactorCell(tableColSize * i + 1,page,"burstTime",cellRed,opaque);
                Time.setText(timeVal);
                Time.setBackground(cellBlue);
                refactorCellRow(i,page,cellGray,opaque);

                break;

        }

    }
    public void refactorCellRow(int index, int page, Color color, boolean opaque ){

        int row = (int) index / tableColSize;
        int col = index % tableColSize;

        JPanel Table = this.table.getRowIndex();
        JLabel cell = (JLabel) Table.getComponent(index);
        cell.setOpaque(true);
        cell.setText(String.valueOf(roundRobin.getSteps().get(page).process[index]));

        if(opaque) {
            Rectangle rec = cell.getBounds();
            table.getjScrollPane().getVerticalScrollBar().setValue(rec.y);
            if(color == cellYellow)
                cell.setForeground(cellGray);
            cell.setBackground(color);
        }
        else {
            if(page !=0 && this.page < prevpage)
                cell.setText(String.valueOf(roundRobin.getSteps().get(page).process[index]));
            cell.setBackground(cellBlack);
            cell.setForeground(cellWhite);
        }

    }
    public void refactorCell(int index,int page, String data, Color color, boolean opaque ){

        int row = (int) index / tableColSize;
        int col = index % tableColSize;

        JPanel Table = this.table.getScrollPanel();
        JLabel cell = (JLabel) Table.getComponent(index);
        cell.setOpaque(opaque);
        switch (data) {
            case  "arrival":
                cell.setText(String.valueOf(roundRobin.getSteps().get(page).arrivalTime[row]));
                if (opaque) {
                    if (color == cellYellow)
                        cell.setForeground(cellGray);
                    cell.setBackground(color);
                } else {
                    if (page != 0 && this.page < prevpage)
                        cell.setText(String.valueOf(roundRobin.getSteps().get(page-1).arrivalTime[row]));
                    cell.setBackground(cellGray);
                    cell.setForeground(cellWhite);
                }
                break;
            case  "burstTime":
                cell.setText(String.valueOf(roundRobin.getSteps().get(page).burstTime[row]));
                if (opaque) {
                    if (color == cellYellow)
                        cell.setForeground(cellGray);
                    cell.setBackground(color);
                } else {
                    if (page != 0 && this.page < prevpage)
                        cell.setText(String.valueOf(roundRobin.getSteps().get(page-1).burstTime[row]));
                    cell.setBackground(cellGray);
                    cell.setForeground(cellWhite);
                }
                break;
            case  "startedTime":
                cell.setText(String.valueOf(roundRobin.getSteps().get(page).startTime[row]));
                if (opaque) {
                    if (color == cellYellow)
                        cell.setForeground(cellGray);
                    cell.setBackground(color);
                } else {
                    if (page != 0 && this.page < prevpage)
                        cell.setText(String.valueOf(roundRobin.getSteps().get(page-1).startTime[row]));
                    cell.setBackground(cellGray);
                    cell.setForeground(cellWhite);
                }
                break;
            case  "completionTime":
                cell.setText(String.valueOf(roundRobin.getSteps().get(page).completionTime[row]));
                if (opaque) {
                    if (color == cellYellow)
                        cell.setForeground(cellGray);
                    cell.setBackground(color);
                } else {
                    if (page != 0 && this.page < prevpage)
                        cell.setText(String.valueOf(roundRobin.getSteps().get(page-1).completionTime[row]));
                    cell.setBackground(cellGray);
                    cell.setForeground(cellWhite);
                }
                break;
            case  "turnAroundTime":
                cell.setText(String.valueOf(roundRobin.getSteps().get(page).turnAroundTime[row]));
                if (opaque) {
                    if (color == cellYellow)
                        cell.setForeground(cellGray);
                    cell.setBackground(color);
                } else {
                    if (page != 0 && this.page < prevpage)
                        cell.setText(String.valueOf(roundRobin.getSteps().get(page-1).turnAroundTime[row]));
                    cell.setBackground(cellGray);
                    cell.setForeground(cellWhite);
                }
                break;
            case  "waitingTime":
                cell.setText(String.valueOf(roundRobin.getSteps().get(page).waitingTime[row]));
                if (opaque) {
                    if (color == cellYellow)
                        cell.setForeground(cellGray);
                    cell.setBackground(color);
                } else {
                    if (page != 0 && this.page < prevpage)
                        cell.setText(String.valueOf(roundRobin.getSteps().get(page-1).waitingTime[row]));
                    cell.setBackground(cellGray);
                    cell.setForeground(cellWhite);
                }
                break;


        }

    }

    public void refactorCPU(String text, int page, Color color, boolean opaque){
        JScrollPane scrollCPU = information.getScrollCPU();
        scrollCPU.getHorizontalScrollBar().setValue(scrollCPU.getHorizontalScrollBar().getMaximum());
        JPanel CPU = information.getCPU();
        JLabel Process = new JLabel();
        Process.setOpaque(true);
        Process.setPreferredSize(new Dimension(50,20));
        //Process.setMinimumSize(new Dimension(10,10));
        Process.setHorizontalAlignment(SwingConstants.CENTER);

        if(opaque && this.page > this.prevpage) {
            Process.setBackground(color);
            Process.setText(text);
            CPU.add(Process);
            CPU.repaint();
            CPU.revalidate();
        }
        else if(page == this.prevpage && this.page < this.prevpage){
            CPU.remove(CPU.getComponentCount()-1);
            CPU.repaint();
            CPU.revalidate();
        }
    }

    /**
     **Play and Stop function with Delay,
     **This functions will skip the next and prev button, to preview the steps without clicking
     * */
    private Timer scheduler;
    public void play(){
        stop();
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                if(page < roundRobin.getSteps().size()-1) {
                    prevpage = page;
                    page++;
                    colorChange(prevpage, false);
                    colorChange(page, true);
                }
            }
        };
        scheduler = new Timer();
        scheduler.schedule(task,0,100);
    }
    public void stop(){
        if(scheduler != null)
            scheduler.cancel();
    }

    /**
    **Function decode the input
     */
    public LinkedList<Process> getNums(String array) throws Exception{
        String[] Line = array.split("\n");
        String[][] matrix = Arrays.stream(Line).map(str -> str.split(" ")).toArray(String[][]::new);
        int rowSize = matrix.length;
        int colSize = matrix[0].length;
        for(String[] str : matrix)
            if(colSize != str.length)
                throw new Exception("Process, Arrival Time, and BurstOut TIme must be same size");
        if(rowSize < 2)
            throw new Exception("(Format):\nArrival Time\nBurst Out");



        LinkedList<Process>  container = new LinkedList<Process>();
        for (int i = 0; i < colSize; i++)
           container.add(new Process(String.valueOf((char) ((i % 26) + 'A'))+i,Integer.parseInt(matrix[0][i]),Integer.parseInt(matrix[1][i])));
        return container;

    }

    /**
     * Function to generate Random Numbers
     */
    public LinkedList<Process> genRand(String array) throws Exception{
        String[] line = array.split(" ");
        Pattern pattern = Pattern.compile("\n");
        Matcher matcher = pattern.matcher(array);
        if(matcher.find()){
            throw new Exception("Input Format (Random):\nProcessors Min Max\nMin = Minimum Value of Random\nMax = Maximum Value of Random");
        }
        if(line.length != 3)
            throw new Exception("Input Format (Random):\nProcessors Min Max\nMin = Minimum Value of Random\nMax = Maximum Value of Random");

        int Row = Integer.parseInt(line[0]);
        float min = Integer.parseInt(line[1]);
        float max = Integer.parseInt(line[2]);

        if(Row < 1)
            throw new Exception("Row must be greater than 0");

        if(min < 0)
            throw new Exception("min must be greater than and equal to 0");

        if(min >= max)
            throw new Exception("min must be less than max");

        LinkedList<Process> random = new LinkedList<>();
        for(int i = 0; i < Row; i++){
            int Val1 = (int) Math.floor(Math.random() * (max - min + 1) + min);
            int Val2 = (int) Math.floor(Math.random() * (max - min + 1) + min);
            random.add(new Process(String.valueOf((char) ((i % 26) + 'A'))+i,Val1,Val2));
        }

        return random;

    }

    public informationPanel getInformation() {
        return information;
    }

    public void setInformation(informationPanel information) {
        this.information = information;
    }

    public tablePanel getTable() {
        return table;
    }

    public void setTable(tablePanel table) {
        this.table = table;
    }

    public inputPanel getInput() {
        return input;
    }

    public void setInput(inputPanel input) {
        this.input = input;
    }

    public int getTableColSize() {
        return tableColSize;
    }

    public void setTableColSize(int tableColSize) {
        this.tableColSize = tableColSize;
    }

    public int getTableRowSize() {
        return tableRowSize;
    }

    public void setTableRowSize(int tableRowSize) {
        this.tableRowSize = tableRowSize;
    }

    public roundRobinUtil getRoundRobin() {
        return roundRobin;
    }

    public void setRoundRobin(roundRobinUtil roundRobin) {
        this.roundRobin = roundRobin;
    }
    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getPrevpage() {
        return prevpage;
    }

    public void setPrevpage(int prevpage) {
        this.prevpage = prevpage;
    }

    public JFrame getMainFrame() {
        return mainFrame;
    }

    public void setMainFrame(JFrame mainFrame) {
        this.mainFrame = mainFrame;
    }

    public int getRandomTaskCount() {
        return randomTaskCount;
    }

    public void setRandomTaskCount(int randomTaskCount) {
        this.randomTaskCount = randomTaskCount;
    }
}
