package citis;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import java.io.Serializable;


/**
 * The class of governmet  of the city
 */
@XmlEnum (String.class)
public enum Governmet implements Serializable {
    @XmlEnumValue("GERONTOCRACY") GERONTOCRACY,
    @XmlEnumValue("MERITOCRACY")MERITOCRACY,
    @XmlEnumValue("DEMOCRACY")DEMOCRACY;


}
