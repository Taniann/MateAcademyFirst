package ua.mateacademy.tania.lesson12.json;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.File;

/**
 * Created by Tania Nebesna on 24.01.2019.
 */
public class MainClazzToXml {
    public static void main(String[] args) {

        MateGroup mateGroup = MateGroup.mateGroupExampleCreator();

        try {
            File file = new File("src/main/resources/xml/MateGroup.xml");
            JAXBContext jaxbContext = JAXBContext.newInstance(MateGroup.class);
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

            // output pretty printed
            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

            jaxbMarshaller.marshal(mateGroup, file);
            jaxbMarshaller.marshal(mateGroup, System.out);

        } catch (JAXBException e) {
            e.printStackTrace();
        }

    }
}
