package XML;

import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;
import java.util.List;

public class P229_parse {
    public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
        //1、获取解析工厂
        SAXParserFactory factory = SAXParserFactory.newInstance();
        //2、从解析工厂获取解析器
        SAXParser parser = factory.newSAXParser();
        //3、加载文档Document注册处理器
        //4、编写处理器
        PersonHandler handler = new PersonHandler();
        parser.parse(Thread.currentThread().getContextClassLoader()
                .getResourceAsStream("XML\\Person.xml"),handler);

        List<P229> persons = handler.getPersons();
        persons.forEach(x-> System.out.println(x.getName()+"-->"+x.getAge()));
    }
}
