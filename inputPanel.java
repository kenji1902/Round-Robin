import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class inputPanel implements Option {
    private JPanel input;
    private TextPlaceHolder userInput;
    private TextPlaceHolder timeQuantum;
    private boolean acceptInput;

    inputPanel(JPanel input){
        this.input = input;
    }
    public void setup(updateUI ui){
        input.setBackground(cellBlack);
        input.setPreferredSize(new Dimension(0,0));
        JPanel scrollPanel = new JPanel(new GridBagLayout());
        timeQuantum = new TextPlaceHolder("[\t]|[a-zA-Z]|^ +| +$|( )+","Time Quantum",2);
        userInput = new TextPlaceHolder("[\t]|[a-zA-Z]|^ +| +$|( )+","Input separated by space and new line",2);
        userInput.setPlaceholder_color(new Color(145, 151, 161));

        GridBagConstraints scrollConst = ui.constraints(GridBagConstraints.BOTH,1,0.10f);
        ui.constraints(scrollConst,0,GridBagConstraints.RELATIVE,1,1);
        scrollPanel.add(timeQuantum,scrollConst);
        ui.constraints(scrollConst,1,0.90f);
        scrollPanel.add(userInput,scrollConst);
        JScrollPane jScrollPane = new JScrollPane(scrollPanel);
        jScrollPane.setBackground(cellBlack);
        jScrollPane.getVerticalScrollBar().setUI(new cJScrollPaneUI(cellYellow,cellBlack,cellYellow,"\u25BD","\u25B3"));
        jScrollPane.getHorizontalScrollBar().setUI(new cJScrollPaneUI(cellYellow,cellBlack,cellYellow,"\u25B7","\u25C1"));
        jScrollPane.setBorder(BorderFactory.createLineBorder(cellBlack));

        CButton Calculate = new CButton("Calculate", SwingConstants.CENTER);
        Calculate.setBorder(BorderFactory.createLineBorder(cellBlack));
        Image img = null;
        try {
            img = ImageIO.read(new File(System.getProperty("user.dir")+"\\resource\\random.png")).getScaledInstance(20, 20, Image.SCALE_AREA_AVERAGING);
        } catch (IOException e) {
            //e.printStackTrace();
        }
        Image finalImg = img;
        CButton Random = new CButton("",SwingConstants.CENTER){
            @Override
            protected void paintComponent(Graphics g2) {
                super.paintComponent(g2);
                Graphics2D g = (Graphics2D) g2;
                g.setPaint(cellYellow);
                try{
                    g2.drawImage(finalImg,(this.getWidth() - finalImg.getWidth(null))/2,(this.getHeight() - finalImg.getHeight(null))/2,this);
                }
                catch (Exception e) {
                    g.drawString("R", ((getWidth() - g.getFontMetrics().stringWidth("A")) / 2), ((g.getFontMetrics().getMaxAscent() + getHeight()) / 2) - 1);
                }
            }
        };
        Random.setBorder(BorderFactory.createLineBorder(cellBlack));
        GridBagConstraints c = ui.constraints(GridBagConstraints.BOTH,1,0.80f);
        ui.constraints(c,0,GridBagConstraints.RELATIVE,2,1);
        input.add(jScrollPane,c);

        ui.constraints(c,0.80f,0.20f);
        ui.constraints(c,0,1,1,1);
        input.add(Calculate,c);

        ui.constraints(c,1,1,1,1);
        ui.constraints(c,0.20f,0.20f);
        input.add(Random,c);

        timeQuantum.getDocument().addDocumentListener(new OnTextListener(timeQuantum, e -> {
            acceptInput = userInput.getText().length() > 0 && timeQuantum.getText().length() > 0;

        }));
        userInput.getDocument().addDocumentListener(new OnTextListener(userInput, e -> {
            acceptInput = userInput.getText().length() > 0 && timeQuantum.getText().length() > 0;
        }));
        Calculate.setActionCommand(String.valueOf(buttonId.calculate));
        Calculate.addActionListener(new onClickListener(ui));
        Random.setActionCommand(String.valueOf(buttonId.random));
        Random.addActionListener(new onClickListener(ui));
        ui.setInput(this);
    }

    public JPanel getPanel(){
        return input;
    }

    public boolean isAcceptInput() {
        return acceptInput;
    }
    public void setAcceptInput(boolean acceptInput) {
        this.acceptInput = acceptInput;
    }

    public TextPlaceHolder getUserInput() {
        return userInput;
    }

    public TextPlaceHolder getTimeQuantum() {
        return timeQuantum;
    }
}
