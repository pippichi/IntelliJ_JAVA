package 手写服务器.P231_server;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class P230_P228_WebHandler extends DefaultHandler {
    private List<P230_Entity> entityList;
    private List<P230_Mapping> mappingList;
    private P230_Entity entity;
    private P230_Mapping mapping;
    private String beginTag;
    private boolean isMap;

    @Override
    public void startDocument() throws SAXException {
        super.startDocument();
        //文档解析开始
        entityList = new ArrayList<>();
        mappingList = new ArrayList<>();
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        super.startElement(uri, localName, qName, attributes);
        //开始元素
        if(null!=qName){
            beginTag = qName;
            if(qName.equals("servlet")){
                isMap = false;
                entity = new P230_Entity();
            }else if(qName.equals("servlet-mapping")){
                isMap = true;
                mapping = new P230_Mapping();
            }
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        super.characters(ch, start, length);
        //处理内容
        if(beginTag!=null){
            String str = new String(ch,start,length);
            if(isMap){
                if(beginTag.equals("servlet-name")){
                    mapping.setName(str);
                }else if(beginTag.equals("url-pattern")){
                    mapping.getUrlPattern().add(str);
                }
            }else{
                if(beginTag.equals("servlet-name")){
                    entity.setName(str);
                }else if(beginTag.equals("servlet-class")){
                    entity.setClz(str);
                }
            }
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        super.endElement(uri, localName, qName);
        //结束元素
        if(null!=qName){
            if(qName.equals("servlet")){
                entityList.add(entity);
            }else if(qName.equals("servlet-mapping")){
                mappingList.add(mapping);
            }
        }
        beginTag = null;
    }

    @Override
    public void endDocument() throws SAXException {
        super.endDocument();
        //文档解析结束
    }

//    public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
//        //获取解析工厂
//        SAXParserFactory factory = SAXParserFactory.newInstance();
//        //获取解析器
//        SAXParser sax = factory.newSAXParser();
//        //指定xml+处理器
//        P230_P228_WebHandler web = new P230_P228_WebHandler();
//        sax.parse(Thread.currentThread().getContextClassLoader()
//                        .getResourceAsStream("手写服务器\\P229_xml.xml"),web);
//
//        System.out.println(web.getEntityList());
//    }

    public List<P230_Entity> getEntityList() {
        return entityList;
    }

    public void setEntityList(List<P230_Entity> entityList) {
        this.entityList = entityList;
    }

    public List<P230_Mapping> getMappingList() {
        return mappingList;
    }

    public void setMappingList(List<P230_Mapping> mappingList) {
        this.mappingList = mappingList;
    }
}
