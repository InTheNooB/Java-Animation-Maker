/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app;

import java.awt.Image;
import javax.swing.ImageIcon;

/**
 *
 * @author dingl01
 */
public class PreviewRenderer implements Runnable {

    public Ihm ihm;

    public PreviewRenderer(Ihm ihm) {
        this.ihm = ihm;
    }

    public void updatePreview() {
        while (true) {
            try {
                Thread.sleep(1);
                if (ihm.isPreviewing()) {
                    ihm.getAnimationSet().setCurrentCategorie(ihm.getTable().getSelectedColumn());
                    ihm.getAnimationSet().updateAnimation();
                    ImageIcon icon;
                    Image imageIc;
                    if (ihm.getSwitching().isSelected()) {
                        icon = new ImageIcon(ihm.getAnimationSet().getSpriteToDraw());
                    } else {
                        icon = new ImageIcon(ihm.getSelectedSprite());
                    }
                    imageIc = icon.getImage().getScaledInstance(200, 200, Image.SCALE_SMOOTH);
                    ihm.getPreview().setIcon(new ImageIcon(imageIc));
                }
            } catch (Exception e) {

            }
        }
    }

    public void setIhm(Ihm ihm) {
        this.ihm = ihm;
    }

    @Override
    public void run() {
        updatePreview();
    }

}
