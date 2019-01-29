package ua.mateacademy.tania.lesson12.json;

import org.eclipse.persistence.jaxb.UnmarshallerProperties;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.transform.stream.StreamSource;

/**
 * Created by Tania Nebesna on 27.01.2019.
 */
public class MainJsonToClazzWithUnmarshaller {
    public static void main(String[] args) {
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(MateGroup.class);

            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            jaxbUnmarshaller.setProperty(UnmarshallerProperties.MEDIA_TYPE, "application/json");
            jaxbUnmarshaller.setProperty(UnmarshallerProperties.JSON_INCLUDE_ROOT, false);
            StreamSource json = new StreamSource("src/main/resources/json/MateGroupWithMarshaller.json");
            MateGroup mateGroup = jaxbUnmarshaller.unmarshal(json, MateGroup.class).getValue();

            System.out.println(mateGroup);

        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }
}
