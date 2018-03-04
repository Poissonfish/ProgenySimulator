import javax.swing.*;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;

public class Human extends JPanel {

    Image imgEye, imgHair;
    JLabel lEye, lHair, lGlasses, lFeet, lHand, lFace, lSmile;

    Point lineST, lineED;

    public Human(EyeColor eyecolor, HairColor haircolor, Gender gender, Glasses glasses, int height) {
        switch (eyecolor) {
            case Blue: imgEye = Simulator.IMAGELIBS.eyeBlue;
                break;
            case Brown: imgEye = Simulator.IMAGELIBS.eyeBrown;
                break;
            case Black: imgEye = Simulator.IMAGELIBS.eyeBlack;
                break;
        }
        if (gender == Gender.Male) {
            switch (haircolor) {
                case Black: imgHair = Simulator.IMAGELIBS.hairBlackBoy;
                    break;
                case Brown: imgHair = Simulator.IMAGELIBS.hairBrownBoy;
                    break;
                case Blonde: imgHair = Simulator.IMAGELIBS.hairBlondBoy;
                    break;
            }
        } else {
            switch (haircolor) {
                case Black: imgHair = Simulator.IMAGELIBS.hairBlackGirl;
                    break;
                case Brown: imgHair = Simulator.IMAGELIBS.hairBrownGirl;
                    break;
                case Blonde: imgHair = Simulator.IMAGELIBS.hairBlondGirl;
                    break;
            }
        }
        lEye = new JLabel(new ImageIcon(imgEye));
        lHair = new JLabel(new ImageIcon(imgHair));
        lHand = new JLabel(new ImageIcon(Simulator.IMAGELIBS.hands));
        lFeet = new JLabel(new ImageIcon(Simulator.IMAGELIBS.feet));
        lFace = new JLabel(new ImageIcon(Simulator.IMAGELIBS.face));
        lGlasses = new JLabel(new ImageIcon(Simulator.IMAGELIBS.glasses));
        lineST = new Point(0, 0);
        lineED = new Point(0, 0);
        lSmile = new JLabel(new ImageIcon(Simulator.IMAGELIBS.smile));
        this.setLayout(null);
        this.setOpaque(false);
        assembleHead(glasses);
        assembleBody(height);
        repaint();
    }

    void update(EyeColor eyecolor, HairColor haircolor, Gender gender, Glasses glasses, int height) {
        this.removeAll();
        switch (eyecolor) {
            case Blue: imgEye = Simulator.IMAGELIBS.eyeBlue;
                break;
            case Brown: imgEye = Simulator.IMAGELIBS.eyeBrown;
                break;
            case Black: imgEye = Simulator.IMAGELIBS.eyeBlack;
                break;
        }
        if (gender == Gender.Male) {
            switch (haircolor) {
                case Black: imgHair = Simulator.IMAGELIBS.hairBlackBoy;
                    break;
                case Brown: imgHair = Simulator.IMAGELIBS.hairBrownBoy;
                    break;
                case Blonde: imgHair = Simulator.IMAGELIBS.hairBlondBoy;
                    break;
            }
        } else {
            switch (haircolor) {
                case Black: imgHair = Simulator.IMAGELIBS.hairBlackGirl;
                    break;
                case Brown: imgHair = Simulator.IMAGELIBS.hairBrownGirl;
                    break;
                case Blonde: imgHair = Simulator.IMAGELIBS.hairBlondGirl;
                    break;
            }
        }
        lEye = new JLabel(new ImageIcon(imgEye));
        lHair = new JLabel(new ImageIcon(imgHair));
        lHand = new JLabel(new ImageIcon(Simulator.IMAGELIBS.hands));
        lFeet = new JLabel(new ImageIcon(Simulator.IMAGELIBS.feet));
        lFace = new JLabel(new ImageIcon(Simulator.IMAGELIBS.face));
        lGlasses = new JLabel(new ImageIcon(Simulator.IMAGELIBS.glasses));
        lineST = new Point(0, 0);
        lineED = new Point(0, 0);
        lSmile = new JLabel(new ImageIcon(Simulator.IMAGELIBS.smile));
        this.setLayout(null);
        this.setOpaque(false);
        assembleHead(glasses);
        assembleBody(height);
        repaint();
    }

    void assembleHead(Glasses glasses) {
        this.add(lEye);
        if (glasses == Glasses.NearSight) {
            this.add(lGlasses);
            lGlasses.setBounds(0, 40, lGlasses.getIcon().getIconWidth(), lGlasses.getIcon().getIconHeight());
        }
        this.add(lHair);
        this.add(lSmile);
        this.add(lFace);
        lFace.setBounds(20, 0,lFace.getIcon().getIconWidth(), lFace.getIcon().getIconHeight());
        lEye.setBounds(45, 55, lEye.getIcon().getIconWidth(), lEye.getIcon().getIconHeight());
        lHair.setBounds(20, 0, lHair.getIcon().getIconWidth(), lHair.getIcon().getIconHeight());
        lSmile.setBounds(75, 110, lSmile.getIcon().getIconWidth(), lSmile.getIcon().getIconHeight());
    }

    void assembleBody(int height) {
        int leftBound = 30;
        int upBound = 150;
        int length = height - 50;
        this.add(lHand);
        this.add(lFeet);
        lHand.setBounds(leftBound, upBound, lHand.getIcon().getIconWidth(), lHand.getIcon().getIconHeight());
        this.lineST.setLocation(94, upBound);
        this.lineED.setLocation(94, upBound + length);
        lFeet.setBounds(leftBound + 24, upBound + length, lFeet.getIcon().getIconWidth(), lFeet.getIcon().getIconHeight());
    }

    @Override
    protected void paintComponent(Graphics g){
        Stroke solid = new BasicStroke(3,
                BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND,
                0, new float[] {10, 0}, 0);
        super.paintComponent(g);
        g.setColor(Color.BLACK);
        drawLine(g, this.lineST, this.lineED, solid);
    }

    void drawLine(Graphics g, Point pt1, Point pt2, Stroke s){
        //creates a copy of the Graphics instance
        Graphics2D g2d = (Graphics2D) g.create();
        //set the stroke of the copy, not the original
        g2d.setStroke(s);
        g2d.drawLine((int)pt1.getX(), (int)pt1.getY(), (int)pt2.getX(), (int)pt2.getY());
        //gets rid of the copy
        g2d.dispose();
    }
}
