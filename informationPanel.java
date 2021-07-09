import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class informationPanel implements Option{
    JPanel information;
    JScrollPane scrollPane;
    JScrollPane scrollCPU;
    JPanel CPU;
    JLabel Time;
    JLabel TimeQuantum;

    informationPanel(JPanel information){
        this.information = information;
    }
    public void setup(updateUI ui){
        JTextPane code = new JTextPane();
        JLabel Title = new JLabel("Code");
        Title.setOpaque(true);
        Title.setBackground(cellBlack);
        Title.setForeground(cellYellow);

        //Setup ScrollPane Options
        information.setPreferredSize(new Dimension(0,0));
        scrollPane = new JScrollPane(code,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setPreferredSize(new Dimension(0,0));
        scrollPane.setBackground(cellBlack);
        scrollPane.getVerticalScrollBar().setUI(new cJScrollPaneUI(cellYellow,cellBlack,cellYellow,"\u25BD","\u25B3"));
        scrollPane.getHorizontalScrollBar().setUI(new cJScrollPaneUI(cellYellow,cellBlack,cellYellow,"\u25B7","\u25C1"));
        scrollPane.setBorder(BorderFactory.createLineBorder(cellBlack));
        scrollPane.setColumnHeaderView(Title);
        scrollPane.getVerticalScrollBar().setUnitIncrement(20);

        //Set Default Code display in Information Panel
        code.setContentType("text/html");
        code.setBackground(cellGray);

        //Set empty CPU
        CPU = new JPanel(new FlowLayout(FlowLayout.LEFT));
        CPU.setBackground(cellBlack);
        CPU.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);

        scrollCPU = new JScrollPane(CPU,JScrollPane.VERTICAL_SCROLLBAR_NEVER,JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        scrollCPU.setPreferredSize(new Dimension(0,20));
        scrollCPU.setBackground(cellBlack);
        scrollCPU.getVerticalScrollBar().setUI(new cJScrollPaneUI(cellYellow,cellBlack,cellYellow,"\u25BD","\u25B3"));
        scrollCPU.getHorizontalScrollBar().setUI(new cJScrollPaneUI(cellYellow,cellBlack,cellYellow,"\u25B7","\u25C1"));
        scrollCPU.setBorder(BorderFactory.createLineBorder(cellBlack));
        scrollCPU.getVerticalScrollBar().setUnitIncrement(20);

        //SetCPU values
        ui.setInformation(this);
        String timeQ = String.format("<html><p style=\"text-align: center;\">Quantum:</p>\n" +
                "<p style=\"text-align: center;\">%d</p></html>",ui.getRoundRobin().getTimeQuantum());

        Time = new JLabel();
        Time.setHorizontalAlignment(JLabel.CENTER);
        Time.setForeground(cellWhite);
        Time.setBackground(cellGray);


        TimeQuantum = new JLabel();
        TimeQuantum.setText(timeQ);
        TimeQuantum.setHorizontalAlignment(JLabel.CENTER);
        TimeQuantum.setOpaque(true);
        TimeQuantum.setForeground(cellWhite);
        TimeQuantum.setBackground(cellGray);

        if(ui.getRoundRobin() != null) {

            for (int j = 0; j < ui.getRoundRobin().getSteps().size()-1; j++) {
                int i = ui.getRoundRobin().getSteps().get(j).getI();

                switch (ui.getRoundRobin().getSteps().get(j).getPart()) {
                    case 9:
                        ui.refactorCPU("", ui.getPage(), cellGreen, true);
                        break;
                    case 4:
                        ui.refactorCPU(String.valueOf(ui.getRoundRobin().getSteps().get(ui.getPage()).process[i]), ui.getPage(), cellRed, true);
                        break;
                    case 5:
                        ui.refactorCPU(String.valueOf(ui.getRoundRobin().getSteps().get(ui.getPage()).process[i]), ui.getPage(), cellGreen, true);
                        break;
                }
            }
        }

        //set Color for Information
        information.setBackground(cellBlack);


        GridBagConstraints informationConst = ui.constraints(GridBagConstraints.BOTH,1,0.85f);
        ui.constraints(informationConst,0,GridBagConstraints.RELATIVE,3,1);
        information.add(scrollPane,informationConst);
        ui.constraints(informationConst,0.90f,0.15f);
        ui.constraints(informationConst,GridBagConstraints.RELATIVE,1,1,1);
        information.add(scrollCPU,informationConst);
        ui.constraints(informationConst,GridBagConstraints.RELATIVE,1,1,1);
        ui.constraints(informationConst,0.05f,0.15f);
        information.add(Time,informationConst);
        information.add(TimeQuantum,informationConst);

    }
    public JPanel getPanel(){
        return information;
    }
    public JScrollPane getScrollPane(){
        return scrollPane;
    }

    public JLabel getTime() {
        return Time;
    }

    public JLabel getTimeQuantum() {
        return TimeQuantum;
    }

    public JScrollPane getScrollCPU() {
        return scrollCPU;
    }
    public JPanel getCPU() {
        return CPU;
    }
}
