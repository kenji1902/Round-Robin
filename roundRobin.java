import javax.swing.*;
import java.awt.*;

public class roundRobin implements Option {
    private String Title;
    private int Width;
    private int Height;
    private updateUI ui;
    roundRobin(String Title, int Width, int Height){
        this.Title = Title;
        this.Width = Width;
        this.Height = Height;
        ui = new updateUI();
    }
    public void setup(){

        //Initialize Main Container
        JPanel mainPanel = new JPanel(new GridBagLayout());
        JFrame mainFrame = new JFrame();

        //Initialize Main Frame
        mainFrame.setSize(Width,Height);
        mainFrame.setTitle(Title);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.add(mainPanel);
        mainFrame.setLocationRelativeTo(null);
        ui.setMainFrame(mainFrame);

        //SetupPanels
        informationPanel information = new informationPanel(new JPanel(new GridBagLayout()));
        tablePanel table = new tablePanel(new JPanel(new GridBagLayout()));
        inputPanel input = new inputPanel(new JPanel(new GridBagLayout()));

        //Insert Information to Main Panel Container
        information.setup(ui);
        GridBagConstraints mainConst = ui.constraints(GridBagConstraints.BOTH,informationWeightx,informationWeighty);
        mainPanel.add(information.getPanel(),mainConst);

        //Insert input to Main Panel Container
        input.setup(ui);
        ui.constraints(mainConst,inputWeightx,inputWeighty);
        mainPanel.add(input.getPanel(),mainConst);

        //Insert table to Main Panel Container
        table.setup(ui);
        ui.constraints(mainConst,0,1,2,1);
        ui.constraints(mainConst,tableWeightx,tableWeighty);
        mainPanel.add(table.getPanel(),mainConst);
        mainPanel.setBackground(cellBlack);
        //Create a window For MainFrame
        mainFrame.setVisible(true);
    }
}
