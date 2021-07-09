import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.util.LinkedList;
import java.util.TimerTask;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class onClickListener implements ActionListener {
    private updateUI ui;
    private int RandCounter;
    private int page;
    private int prevpage;


    onClickListener(updateUI ui){
        this.ui = ui;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        page = ui.getPage();
        prevpage = ui.getPrevpage();
        String sButtonId = String.valueOf(e.getActionCommand());
        roundRobinUtil roundRobin = ui.getRoundRobin();
        SwingWorker<Void,Void> geninBG = new SwingWorker<Void, Void>() {
            @Override
            protected Void doInBackground() throws Exception {
                JOptionPane.showMessageDialog(null,"Press the Rand Button again to Stop" ,"Generating Matrix",JOptionPane.INFORMATION_MESSAGE);
                RandCounter = ui.getRandomTaskCount();
                ui.setRandomTaskCount(++RandCounter);
                ui.getInput().setAcceptInput(false);
                ui.getInput().getPanel().setEnabled(false);
                genRandom();
                return null;
            }

            @Override
            protected void done() {
                super.done();
                ui.setRandomTaskCount(0);
                ui.getInput().setAcceptInput(true);
                ui.getInput().getPanel().setEnabled(true);
                ui.getTable().getPanel().removeAll();
                ui.getInformation().getPanel().removeAll();
                ui.getInformation().setup(ui);
                ui.getTable().setup(ui);
                ui.getMainFrame().repaint();
                ui.getMainFrame().revalidate();
            }

        };

        switch (sButtonId) {
            case "first":
                ui.stop();
                prevpage = 0;
                page = 0;

                ui.getTable().getPanel().removeAll();
                ui.getInformation().getPanel().removeAll();
                ui.setPage(page);
                ui.setPrevpage(prevpage);
                ui.getInformation().setup(ui);
                ui.getTable().setup(ui);
                ui.getMainFrame().repaint();
                ui.getMainFrame().revalidate();
                break;
            case "prev":
                ui.stop();
                if (page > 0) {
                    prevpage = page;
                    page--;
                    ui.setPage(page);
                    ui.setPrevpage(prevpage);
                    ui.colorChange(prevpage, false);
                    ui.colorChange(page, true);
                }
                break;
            case "next":
                ui.stop();
                if (page < roundRobin.getSteps().size() - 1) {
                    prevpage = page;
                    page++;
                    ui.setPage(page);
                    ui.setPrevpage(prevpage);
                    ui.colorChange(prevpage, false);
                    ui.colorChange(page, true);
                }
                break;
            case "equal":
                ui.stop();
                prevpage = page;
                page = roundRobin.getSteps().size() -1;

                ui.getTable().getPanel().removeAll();
                ui.getInformation().getPanel().removeAll();
                ui.setPage(page);
                ui.setPrevpage(prevpage);
                ui.getInformation().setup(ui);
                ui.getTable().setup(ui);
                ui.getMainFrame().repaint();
                ui.getMainFrame().revalidate();
                break;
            case "play":
                ui.play();
                break;
            case "stop":
                ui.stop();
                break;
            case "calculate":
                ui.stop();
                if(ui.getInput().isAcceptInput()){
                    try{
                        System.out.println("Calculate");
                        roundRobin = new roundRobinUtil(ui.getNums(ui.getInput().getUserInput().getText()),
                                                       Integer.parseInt(ui.getInput().getTimeQuantum().getText()));
                        roundRobin.roundRobin();
                        prevpage = 0;
                        page = 0;
                        ui.setRoundRobin(roundRobin);
                        ui.setPage(page);
                        ui.setPrevpage(prevpage);
                        ui.getTable().getPanel().removeAll();
                        ui.getInformation().getPanel().removeAll();
                        ui.getInformation().setup(ui);
                        ui.getTable().setup(ui);
                        ui.getMainFrame().repaint();
                        ui.getMainFrame().revalidate();

                    }catch (Exception err){
                        JOptionPane.showMessageDialog(null,"Please provide an Input\n"+err.getMessage() ,"Invalid Input",JOptionPane.WARNING_MESSAGE);
                    }
                }
                else {
                    if(ui.getRandomTaskCount() < 1)
                        JOptionPane.showMessageDialog(null, "Please provide an Input\n", "Invalid Input", JOptionPane.WARNING_MESSAGE);
                    else
                        JOptionPane.showMessageDialog(null,"Random Task in Progress\nCalculate Disabled","Random Task",JOptionPane.WARNING_MESSAGE);
                }
                break;
            case "random":
                ui.stop();

                if(ui.getRandomTaskCount() > 0) {
                    geninBG.cancel(true);
                    JOptionPane.showMessageDialog(null,"Random Generator Cancelled" ,"Random",JOptionPane.INFORMATION_MESSAGE);
                }
                else if(ui.getInput().getTimeQuantum().getText().isEmpty()){
                    geninBG.cancel(true);
                    JOptionPane.showMessageDialog(null,"Random Generator Cancelled\nProvide Time Quantum","Random",JOptionPane.INFORMATION_MESSAGE);
                }
                else
                    geninBG.execute();
                break;
        }
        System.out.println("part: " + roundRobin.getSteps().get(page).getPart());
        System.out.println("Prev Page >> " + prevpage);
        System.out.println("Page >> " + page);
    }
    void genRandom(){
        inputPanel input = ui.getInput();
        int page;
        int prevpage;
        roundRobinUtil roundRobin = null;
        LinkedList<Process> random;
        while(ui.getRandomTaskCount() > 0) {
            try {
                try {
                    random = ui.genRand(input.getUserInput().getText());
                }catch (Exception randErr){
                    ui.setRandomTaskCount(0);
                    JOptionPane.showMessageDialog(null,"Please provide an Input\n"+randErr.getMessage() ,"Invalid Input",JOptionPane.WARNING_MESSAGE);
                    break;
                }
                roundRobin = new roundRobinUtil(random, Integer.parseInt(input.getTimeQuantum().getText()));
                roundRobin.roundRobin();
                break;
            } catch (Exception err) {
                JOptionPane.showMessageDialog(null,"Please provide an Input\n"+"Time Quantum" ,"Invalid Input",JOptionPane.WARNING_MESSAGE);
            }
        }
        if(ui.getRandomTaskCount() > 0){
            prevpage = 0;
            page = 0;
            ui.setRoundRobin(roundRobin);
            ui.setPage(page);
            ui.setPrevpage(prevpage);
        }


    }
}

