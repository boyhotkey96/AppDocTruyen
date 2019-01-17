package com.boyhotkey96.funnystories.Fragment.RSSTruyen;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;

public class MySaxHandler extends DefaultHandler {

    ArrayList<Item> items;
    Item item_tam;
    String chuoi_tam;
    boolean vaoitem = false;

    public MySaxHandler() {
        items = new ArrayList<Item>();
    }

    public ArrayList<Item> getItems() {
        return items;
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        super.startElement(uri, localName, qName, attributes);
        if (qName.equalsIgnoreCase("item")) {
            vaoitem = true;
            item_tam = new Item();
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        super.characters(ch, start, length);
        if (vaoitem == true) {
            chuoi_tam = new String(ch, start, length);
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        super.endElement(uri, localName, qName);
        if (qName.equalsIgnoreCase("item")) {
            items.add(item_tam);
        } else if (vaoitem == true) {
            if (qName.equalsIgnoreCase("title"))
                item_tam.title = chuoi_tam;
            if (qName.equalsIgnoreCase("link"))
                item_tam.link = chuoi_tam;
            if (qName.equalsIgnoreCase("image"))
                item_tam.imgHinh = chuoi_tam;
            if (qName.equalsIgnoreCase("description"))
                item_tam.description = chuoi_tam;
            if (qName.equalsIgnoreCase("pubDate"))
                item_tam.pubDate = chuoi_tam;
        }
    }
}
