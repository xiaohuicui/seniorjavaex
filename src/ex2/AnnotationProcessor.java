package ex2;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.annotation.processing.SupportedSourceVersion;
import javax.lang.model.SourceVersion;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.PrintWriter;
import java.lang.reflect.Field;

/**
 * Created by cuixiaohui on 16/5/12.
 */
@SupportedSourceVersion(SourceVersion.RELEASE_8)

public class AnnotationProcessor {

    public static void processAnnotations(String clazz){
        try{
            Class entityClass = Class.forName(clazz);
            if(entityClass.isAnnotationPresent(Entity.class)) {
                DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
                DocumentBuilder builder = factory.newDocumentBuilder();
                Document document = builder.newDocument();
                Element root = document.createElement("hibernate-mapping");
                Element classElement = document.createElement("class");
                Entity entity = (Entity)entityClass.getAnnotation(Entity.class);
                classElement.setAttribute("name",entity.tablename());
                root.appendChild(classElement);
                for (Field field : entityClass.getDeclaredFields()) {


                    if (field.isAnnotationPresent(Identity.class)) {
                        Identity identity = field.getAnnotation(Identity.class);
                        Element identityElement = document.createElement("id");
                        identityElement.setAttribute("name",field.getName());
                        identityElement.setAttribute("column",identity.columnName());
                        identityElement.setAttribute("type",identity.columnType());
                        Element genertorElement = document.createElement("generator");
                        genertorElement.setAttribute("class",identity.generator());
                        identityElement.appendChild(genertorElement);
                        classElement.appendChild(identityElement);


                    }
                    if (field.isAnnotationPresent(Property.class)) {
                        Property property = field.getAnnotation(Property.class);
                        Element propertyElement = document.createElement("property");
                        propertyElement.setAttribute("name",field.getName());
                        propertyElement.setAttribute("column",property.columnName());
                        propertyElement.setAttribute("type",property.columnType());
                        classElement.appendChild(propertyElement);
                    }

                }
                document.appendChild(root);

                TransformerFactory tf = TransformerFactory.newInstance();
                Transformer transformer = tf.newTransformer();
                DOMSource source = new DOMSource(document);
                PrintWriter pw = new PrintWriter(clazz+".xml");
                StreamResult result = new StreamResult(pw);
                transformer.transform(source,result);

            }else{
                System.out.println(clazz+" is not a Entity!");
            }

        }catch (Exception ex){
            ex.printStackTrace();
        }
    }

    public static void main(String[] args){
        AnnotationProcessor.processAnnotations("ex2.Student");
    }
}
