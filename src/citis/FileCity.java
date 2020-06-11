package citis;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.*;

public class FileCity {
    public static void convertObjectToXml(DataCities cities, String nameFail ) throws JAXBException{
        File file = new File(nameFail);
        try {
            FileWriter fileWriter = new FileWriter(file);
            BufferedWriter writer = new BufferedWriter(fileWriter);

            JAXBContext context = JAXBContext.newInstance(DataCities.class);
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            marshaller.marshal(cities, writer);




        } catch (JAXBException | IOException e) {
            e.printStackTrace();
        }
    }

    public static DataCities readFromXML(String filePath) throws JAXBException {

        String xmldata = "";
        File file = new File(filePath);
        try {
            FileInputStream fis = new FileInputStream(file);
            BufferedInputStream bis = new BufferedInputStream(fis);
            while (bis.available() > 0) {
                xmldata += (char) bis.read();
            }

        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        } catch (IOException e) {
            System.out.println("Error while reading file");
        }


        StringReader reader = new StringReader(xmldata);

        JAXBContext context = JAXBContext.newInstance(DataCities.class);
        Unmarshaller unmarshaller = context.createUnmarshaller();

        DataCities data = (DataCities) unmarshaller.unmarshal(reader);
        return data;
    }
}
