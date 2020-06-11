package citis;

/**
 * The class of person to the Governor of the city
 */

import javax.xml.bind.annotation.XmlElement;
import java.io.Serializable;


/**
 * Age of the Governor. Can't be null
 */
public class Human implements Serializable {
    @XmlElement
    private long age; //Значение поля должно быть больше 0


    public void setAge(long age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "age= " + age;
    }
}
