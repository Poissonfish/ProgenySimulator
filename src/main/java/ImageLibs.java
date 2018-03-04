import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class ImageLibs {
    Image hairBrownGirl, hairBlackGirl, hairBlondGirl,
          hairBrownBoy,  hairBlackBoy,  hairBlondBoy,
          eyeBlue, eyeBrown, eyeBlack,
          glasses, face, hands, feet, smile;

    public ImageLibs() {
        try {
            hairBrownGirl = ImageIO.read(this.getClass().getResource("hair_brown_girl.png"));
            hairBrownBoy = ImageIO.read(this.getClass().getResource("hair_brown_boy.png"));
            hairBlackGirl = ImageIO.read(this.getClass().getResource("hair_black_girl.png"));
            hairBlackBoy = ImageIO.read(this.getClass().getResource("hair_black_boy.png"));
            hairBlondGirl = ImageIO.read(this.getClass().getResource("hair_blond_girl.png"));
            hairBlondBoy = ImageIO.read(this.getClass().getResource("hair_blond_boy.png"));
            eyeBlue = ImageIO.read(this.getClass().getResource("eye_blue.png"));
            eyeBrown = ImageIO.read(this.getClass().getResource("eye_brown.png"));
            eyeBlack = ImageIO.read(this.getClass().getResource("eye_black.png"));

            glasses = ImageIO.read(this.getClass().getResource("glasses.png"));
            face = ImageIO.read(this.getClass().getResource("face.png"));
            hands = ImageIO.read(this.getClass().getResource("hands.png"));
            feet = ImageIO.read(this.getClass().getResource("feet.png"));
            smile = ImageIO.read(this.getClass().getResource("smile.png"));

        } catch (IOException e) {
            System.out.println("Failed to load images!");
        }
    }
}

// blond : #dbaf00
// brown : #bb7b00
// black : #000000
// blue : #0036ff
