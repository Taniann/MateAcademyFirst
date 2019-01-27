package ua.mateacademy.tania.lesson12.json;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;

/**
 * Created by Tania Nebesna on 24.01.2019.
 */
public class MainXmlToClazz {
    public static void main(String[] args) {
        try {
            File file = new File("src/main/resources/xml/MateGroup.xml");
            JAXBContext jaxbContext = JAXBContext.newInstance(MateGroup.class);

            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            MateGroup mateGroup = (MateGroup) jaxbUnmarshaller.unmarshal(file);
            System.out.println(mateGroup);

        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }
}
