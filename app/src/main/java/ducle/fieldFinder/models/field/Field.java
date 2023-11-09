package ducle.fieldFinder.models.field;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import ducle.fieldFinder.models.Entity;

public class Field extends Entity {
    public final static List<String> TYPES = new ArrayList<>(
            Arrays.asList("Badminton", "Soccer", "Basketball", "Tennis", "Volleyball")
    );

    private Centre centre; // the centre this field belongs to
    private String type; // type of field
    private float price;
    private float width;
    private float height;

    public Field(String id, Centre centre, String type) {
        super("FID_" + id);
        this.centre = centre;
        this.type = type;
        this.price = 0f;
        this.width = 0f;
        this.height = 0f;
    }

    public Field(String id, Centre centre, String type, float price, float width, float height) {
        super("FID_" + id);
        this.centre = centre;
        this.type = type;
        this.price = price;
        this.width = width;
        this.height = height;
    }

    public Centre getCentre() {
        return centre;
    }

    public void setCentre(Centre centre) {
        this.centre = centre;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public float getWidth() {
        return width;
    }

    public void setWidth(float width) {
        this.width = width;
    }

    public float getHeight() {
        return height;
    }

    public void setHeight(float height) {
        this.height = height;
    }

    /**
     *  This method calculates and returns the area of the field
     *  */
    public float area(){
        return getWidth()*getHeight();
    }
}
