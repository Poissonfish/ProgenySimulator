import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.Random;

public class Simulator extends JFrame implements ActionListener, ChangeListener{
    static ImageLibs IMAGELIBS = new ImageLibs();;
    PaneConfig paneFather;
    PaneConfig paneMother;
    JPanel panePF, panePM;
    Human humanFather, humanMother;
    JButton buttonSimulate;
    PaneResult paneResult;
    JPanel pane;
    public Simulator() {
        paneFather = new PaneConfig("Father");
        paneMother = new PaneConfig("Mother");
        panePF = new JPanel(new MigLayout("", "[200!]", "[800!]"));
        panePM = new JPanel(new MigLayout("", "[200!]", "[800!]"));
        humanFather = new Human(EyeColor.Blue, HairColor.Blonde, Gender.Male, Glasses.Normal, 175);
        humanMother = new Human(EyeColor.Blue, HairColor.Blonde, Gender.Female, Glasses.Normal, 175);
        buttonSimulate = new JButton(("<html> -> </br> -> </br> -> </br> Simulate </br> -> </br> -> </br> -> </br></html>"));
        buttonSimulate.setFont(new Font("Serif", Font.BOLD, 48));
        paneResult = new PaneResult();
        pane = new JPanel(new MigLayout("", "[250!][250!][100!][1200!]", "[300!][800!]"));

        buttonSimulate.addActionListener(this);
        paneFather.comboEye.addActionListener(this);
        paneFather.comboHair.addActionListener(this);
        paneFather.comboNearSight.addActionListener(this);
        paneFather.sliderHeight.addChangeListener(this);
        paneMother.comboEye.addActionListener(this);
        paneMother.comboHair.addActionListener(this);
        paneMother.comboNearSight.addActionListener(this);
        paneMother.sliderHeight.addChangeListener(this);
        pane.add(paneFather, "grow, cell 0 0");
        pane.add(paneMother, "grow, cell 1 0");
        panePF.add(humanFather, "grow");
        panePF.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null),
                "Preview", TitledBorder.CENTER, TitledBorder.TOP, null, Color.RED));
        pane.add(panePF, "grow, cell 0 1, align c");
        panePM.add(humanMother, "grow");
        panePM.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null),
                "Preview", TitledBorder.CENTER, TitledBorder.TOP, null, Color.RED));
        pane.add(panePM, "grow, cell 1 1, align c");
        pane.add(buttonSimulate, "grow, cell 2 0 1 2");
        pane.add(paneResult, "grow, cell 3 0 1 2");
        this.setContentPane(pane);
        this.pack();
        this.setSize(1800, 1100);
        this.setTitle("Progeny Simulator");
        this.show();
    }

    void writeInput() {
        FileWriter fr = null;
        try {
            fr = new FileWriter(new File("/Users/jameschen/Dropbox/ZZLab/Project/Progeny_Simulator/src/main/resources/input.txt"));
        } catch (IOException e1) {
            e1.printStackTrace();
        }
        BufferedWriter br = new BufferedWriter(fr);
        PrintWriter pr = new PrintWriter(br);
        pr.write(paneFather.getHair() + "\n");
        pr.write(paneFather.getEye() + "\n");
        pr.write(paneFather.getSight() + "\n");
        pr.write(paneFather.getHeightCM() + "\n");
        pr.write(paneMother.getHair() + "\n");
        pr.write(paneMother.getEye() + "\n");
        pr.write(paneMother.getSight() + "\n");
        pr.write(paneMother.getHeightCM() + "\n");
        pr.flush();
        pr.close();
    }

    void callCPP() throws InterruptedException {
        Runtime runtime = Runtime.getRuntime();
        Process process = null;
        try {
            process = runtime.exec("/Users/jameschen/Dropbox/ZZLab/Project/Progeny_Simulator/src/main/resources/Hackathon.out /Users/jameschen/Dropbox/ZZLab/Project/Progeny_Simulator/src/main/resources/input.txt /Users/jameschen/Dropbox/ZZLab/Project/Progeny_Simulator/src/main/resources/output.txt");
            process.waitFor();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    void updateFather () {
        int tempInt;
        HairColor hair = null;
        EyeColor eye = null;
        Glasses glasses;
        int height;

        // Get information from output
        tempInt = paneFather.getHair();
        switch (tempInt) {
            case 1: hair = HairColor.Blonde; break;
            case 2: hair = HairColor.Brown; break;
            case 3: hair = HairColor.Black; break;
        }
        tempInt = paneFather.getEye();
        switch (tempInt) {
            case 1: eye = EyeColor.Blue; break;
            case 2: eye = EyeColor.Black; break;
            case 3: eye = EyeColor.Brown; break;
        }
        glasses = paneFather.getSight() == 1 ? Glasses.Normal : Glasses.NearSight;
        height = paneFather.getHeightCM();
        this.humanFather.update(eye, hair, Gender.Male, glasses, height);
    }

    void updateMother () {
        int tempInt;
        HairColor hair = null;
        EyeColor eye = null;
        Glasses glasses;
        int height;

        // Get information from output
        tempInt = paneMother.getHair();
        switch (tempInt) {
            case 1: hair = HairColor.Blonde; break;
            case 2: hair = HairColor.Brown; break;
            case 3: hair = HairColor.Black; break;
        }
        tempInt = paneMother.getEye();
        switch (tempInt) {
            case 1: eye = EyeColor.Blue; break;
            case 2: eye = EyeColor.Black; break;
            case 3: eye = EyeColor.Brown; break;
        }
        glasses = paneMother.getSight() == 1 ? Glasses.Normal : Glasses.NearSight;
        height = paneMother.getHeightCM();
        this.humanMother.update(eye, hair, Gender.Female, glasses, height);
    }

    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if (source == buttonSimulate) {
            writeInput();
            try {
              callCPP();
                this.paneResult.makeResult();
                repaint();
            } catch (FileNotFoundException e1) {
                e1.printStackTrace();
            } catch (IOException e1) {
                e1.printStackTrace();
            } catch (InterruptedException e1) {
                e1.printStackTrace();
            }
        } else if (source == paneFather.comboEye || source == paneFather.comboHair || source == paneFather.comboNearSight) {
            updateFather();
        } else if (source == paneMother.comboEye || source == paneMother.comboHair || source == paneMother.comboNearSight) {
            updateMother();
        }
    }

    public void stateChanged(ChangeEvent e) {
        Object source = e.getSource();
        if (source == paneFather.sliderHeight) {
            updateFather();
        } else if (source == paneMother.sliderHeight) {
            updateMother();
        }
    }
}
