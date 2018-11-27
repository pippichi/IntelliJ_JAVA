package XML;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;
import java.util.List;

/**
 * 存储对象
 */
public class PersonHandler extends DefaultHandler {

    private List<P229> persons;
    private P229 person;
    private String tag;//记录标签名
    @Override
    public void startDocument() throws SAXException {
        super.startDocument();
        System.out.println("处理开始");
        persons = new ArrayList<>();
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        super.characters(ch, start, length);
        String str = new String(ch,start,length);
        if(tag!=null&&tag.equals("name")){
            person.setName(str);
        }else if(tag!=null&&tag.equals("age")){
            Integer age = Integer.valueOf(str);
            person.setAge(age);
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        super.endElement(uri, localName, qName);
//        System.out.println("结束一个元素"+qName);
        if(qName.equals("person")){
            this.persons.add(person);
        }
        tag = null;
    }

    @Override
    public void endDocument() throws SAXException {
        super.endDocument();
        System.out.println("处理结束");
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        super.startElement(uri, localName, qName, attributes);
        System.out.println("开始一个元素"+qName);
        if(null!=qName){
            tag = qName;
        }
        if(null!=qName&&qName.equals("person")){
            person = new P229();
        }
    }

    public List<P229> getPersons() {
        return persons;
    }

    public void setPersons(List<P229> persons) {
        this.persons = persons;
    }
}
