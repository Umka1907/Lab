package citis;

import javax.xml.bind.annotation.adapters.XmlAdapter;
import java.time.LocalDateTime;


/**
 * Class for serializing xml data fields
 */
public class LocalDateTimeAdapter extends XmlAdapter<String, LocalDateTime> {
    public LocalDateTime unmarshal(String v) throws Exception {
        return LocalDateTime.parse(v);
    }

    public String marshal(LocalDateTime v) throws Exception {
        return v.toString();
    }
}
