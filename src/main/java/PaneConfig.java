import net.miginfocom.swing.MigLayout;
import javax.swing.*;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;

public class PaneConfig extends JPanel {
    // Components
    JLabel labelEye, labelHair, labelNearSight, labelHeight;
    JComboBox comboEye, comboHair, comboNearSight;
    JSlider sliderHeight;

    public PaneConfig(String title) {
        super(new MigLayout("", "[grow][grow]", "[grow][grow][grow][grow]"));
        iniCombo();
        iniSlider();
        this.add(labelEye, "cell 0 0, align r");
        this.add(comboEye, "cell 1 0, align l");
        this.add(labelHair, "cell 0 1, align r");
        this.add(comboHair, "cell 1 1, align l");
        this.add(labelNearSight, "cell 0 2, align r");
        this.add(comboNearSight, "cell 1 2, align l");
        this.add(labelHeight, "cell 0 3, align r");
        this.add(sliderHeight, "cell 1 3, align l, grow");
        this.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null),
						title, TitledBorder.CENTER, TitledBorder.TOP, null, Color.RED));
    }

    void iniCombo() {
        labelEye = new JLabel("Eye color");
        labelHair = new JLabel("Hair color");
        labelNearSight = new JLabel("Nearsighted?");
        comboEye = new JComboBox(new String[]{"Blue", "Black", "Brown"});
        comboHair = new JComboBox(new String[]{"Blonde", "Brown", "Black"});
        comboNearSight = new JComboBox(new String[]{"No", "Yes "});
        labelHeight = new JLabel("Height");
    }

    void iniSlider() {
        sliderHeight = new JSlider(JSlider.HORIZONTAL, 130, 250, 175);
        sliderHeight.setMinorTickSpacing(5);
        sliderHeight.setMajorTickSpacing(30);
        sliderHeight.setPaintTicks(true);
        sliderHeight.setPaintLabels(true);
        sliderHeight.setLabelTable(sliderHeight.createStandardLabels(30));
    }

    int getEye() {
        return this.comboEye.getSelectedIndex() + 1;
    }

    int getHair() {
        return this.comboHair.getSelectedIndex() + 1;
    }

    int getSight() {
        return this.comboNearSight.getSelectedIndex() + 1;
    }

    int getHeightCM() {
        return this.sliderHeight.getValue();
    }


}
