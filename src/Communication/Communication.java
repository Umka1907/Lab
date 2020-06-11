package Communication;

import citis.City;
import com.sun.org.apache.xerces.internal.impl.dv.util.Base64;

import java.io.*;

public class Communication implements Serializable {
    private String type;

    private String params;

    private String cityArgument;

    public Communication(String type, String params, String cityArgument) {
        this.params = params;
        this.cityArgument = cityArgument;
        this.type = type;
    }

    public String getCityArgument() {
        return cityArgument;
    }

    public void setCityArgument(String cityArgument) {
        this.cityArgument = cityArgument;
    }

    public  String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getParams() {
        return params;
    }

    public void setParams(String params) {
        this.params = params;
    }

    public String serializeToString() throws IOException {
        ByteArrayOutputStream bo = new ByteArrayOutputStream();
        ObjectOutputStream so = new ObjectOutputStream(bo);
        so.writeObject(this);
        so.flush();
        return Base64.encode(bo.toByteArray());
    }

    public static Communication deserializeFromString(String serialized) throws IOException, ClassNotFoundException {
        byte b[] = Base64.decode(serialized);
        ByteArrayInputStream bi = new ByteArrayInputStream(b);
        ObjectInputStream si = new ObjectInputStream(bi);
        return (Communication) si.readObject();
    }

    public static City deserializeCity(String city) throws IOException, ClassNotFoundException {
        byte b[] = Base64.decode(city);
        ByteArrayInputStream bi = new ByteArrayInputStream(b);
        ObjectInputStream si = new ObjectInputStream(bi);
        return (City) si.readObject();

    }


    @Override
    public String toString() {
        return "Communication.Communication{" +
                "type='" + type + '\'' +
                ", params=" + params +
                '}';
    }
}
