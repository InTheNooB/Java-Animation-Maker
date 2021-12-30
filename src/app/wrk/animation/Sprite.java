package app.wrk.animation;

import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import javax.imageio.ImageIO;

/**
 *
 * @author lione_000
 */
public class Sprite implements Serializable {

    private transient Image sprite;
    private String spritePath;
    private float cooldown;
    private int id;

    public Sprite(Image sprite, float cooldown, int id, String spritePath) {
        this.sprite = sprite;
        this.cooldown = cooldown;
        this.id = id;
        this.spritePath = spritePath;
    }

    public Sprite(Image sprite, int id, String spritePath) {
        this.sprite = sprite;
        this.id = id;
        this.cooldown = -1;
        this.spritePath = spritePath;
    }


    private void readObject(java.io.ObjectInputStream in) throws IOException, ClassNotFoundException {
        in.defaultReadObject();
        System.out.println(cooldown);
        try {
            sprite = ImageIO.read(new File(spritePath));
        } catch (IOException ex) {
            System.out.println("Image Not Found : " + spritePath);
        }
    }


    public Image getSprite() {
        return sprite;
    }

    public void setSprite(Image sprite) {
        this.sprite = sprite;
    }

    public float getCooldown() {
        return cooldown;
    }

    public void setCooldown(float cooldown) {
        this.cooldown = cooldown;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSpritePath() {
        return spritePath;
    }

    public void setSpritePath(String spritePath) {
        this.spritePath = spritePath;
    }

}
