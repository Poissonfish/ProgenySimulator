import javax.swing.*;
import java.io.*;
import java.util.Random;

public class PaneResult extends JPanel {
    Human stickmenoid[] = new Human[100];
    int rdmx, rdmy;

    public PaneResult() {
        this.setLayout(null);
//        this.setOpaque(false);
    }

    void makeResult() throws IOException {
        this.removeAll();
        this.setLayout(null);
        BufferedReader reader = new BufferedReader(new FileReader(new File("/Users/jameschen/Dropbox/ZZLab/Project/Progeny_Simulator/src/main/resources/output.txt")));
        int xbUp = 800, xbLow = 0, ybUp = 550, ybLow = 0;
        int index1 = 0, index2 = 0;

        String tempRead;
        int tempInt;

        HairColor hair = null;
        EyeColor eye = null;
        Glasses glasses;
        int height;
        for (int i = 0; i < 20; i ++) {
            index1 = i * 2;
            index2 = i * 2 + 1;

            // Get information from output
            tempRead = reader.readLine();
            tempInt = Integer.parseInt(tempRead);
            switch (tempInt) {
                case 1: hair = HairColor.Blonde; break;
                case 2: hair = HairColor.Brown; break;
                case 3: hair = HairColor.Black; break;
            }
            tempRead = reader.readLine();
            tempInt = Integer.parseInt(tempRead);
            switch (tempInt) {
                case 1: eye = EyeColor.Blue; break;
                case 2: eye = EyeColor.Black; break;
                case 3: eye = EyeColor.Brown; break;
            }
            tempRead = reader.readLine();
            tempInt = Integer.parseInt(tempRead);
            glasses = tempInt == 1 ? Glasses.Normal : Glasses.NearSight;
            tempRead = reader.readLine();
            height = Integer.parseInt(tempRead);

            // Ini human
            rdmx = new Random().nextInt(xbUp - xbLow) + xbLow;
            rdmy = new Random().nextInt(ybUp - ybLow) + ybLow;
            stickmenoid[index1] = new Human(eye, hair, Gender.Male, glasses, height);
            this.add(stickmenoid[index1]);
            stickmenoid[index1].setBounds(rdmx, rdmy, 500, 300);

            rdmx = new Random().nextInt(xbUp - xbLow) + xbLow;
            rdmy = new Random().nextInt(ybUp - ybLow) + ybLow;
            stickmenoid[index2] = new Human(eye, hair, Gender.Female, glasses, height);
            this.add(stickmenoid[index2]);
            stickmenoid[index2].setBounds(rdmx, rdmy, 500, 300);
        }
    }
}
