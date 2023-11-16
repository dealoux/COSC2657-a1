package ducle.fieldFinder.models.field;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
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
    private float length;

    public Field(String id, Centre centre, String type) {
        super(id);
        prefixId("FIE");
        this.centre = centre;
        this.type = type;
        this.price = 0f;
        this.width = 0f;
        this.length = 0f;
    }

    public Field(String id, Centre centre, String type, float price, float width, float length) {
        super(id);
        prefixId("FIE");
        this.centre = centre;
        this.type = type;
        this.price = price;
        this.width = width;
        this.length = length;
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

    public float getLength() {
        return length;
    }

    public void setLength(float length) {
        this.length = length;
    }

    /**
     *  This method calculates and returns the area of the field
     *  */
    public float area(){
        return getWidth()* getLength();
    }

    /**
     *  This method returns true if the field is available during the given time slot on the given date
     * @param slot
     * @param date up to 7 days from today
     *  */
    public boolean isAvailable(String slot, Date date){
        boolean result = true;
        return result;
    }

    /**
     *  This method returns true if the field is available during the given time slot today
     * @param slot
     *  */
    public boolean isAvailable(String slot){
        return isAvailable(slot, new Date());
    }

    /**
     *  This method returns true if the field is available on given date
     * @param date up to 7 days from today
     *  */
    public boolean isAvailable(Date date){
        return isAvailable(null, date);
    }

    /**
     *  This method returns true if the field is available today
     *  */
    public boolean isAvailable(){
        return isAvailable(new Date());
    }

    @Override
    public String toString() {
        return "Field{" +
                "id='" + id + '\'' +
                ", type='" + type + '\'' +
                ", price=" + price +
                ", width=" + width +
                ", length=" + length +
                '}';
    }
}
