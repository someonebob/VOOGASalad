package game_data;
import java.io.File;
import java.util.*;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
public class LevelSaver {

	private List<String> entityfilepaths;
	private String folderpath;
	private DocumentBuilderFactory docFactory;
	private DocumentBuilder docBuilder;
	private Document doc;
	private int levelnumber;
	public LevelSaver(List<String> inputentityfilepaths, String inputfolderpath,int inputlevelnumber){
		entityfilepaths=inputentityfilepaths;
		folderpath=inputfolderpath;
		levelnumber=inputlevelnumber;
		
	}
	
	
	public void saveLevel(){
		
		docFactory = DocumentBuilderFactory.newInstance();
		try {
			docBuilder = docFactory.newDocumentBuilder();
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		}
		doc = docBuilder.newDocument();
		
		
		Element rootElement = doc.createElement("Entities");
		doc.appendChild(rootElement);
		
		
		for(int i=0;i<entityfilepaths.size();i++){
			addLevelEntity(i+1, entityfilepaths.get(i),rootElement);
		}
		
		
		
		writeContent(levelnumber);
		
		}
	private void addLevelEntity(int entitynumber, String entityfilepath, Element rootElement){
		

			Element levelpath = doc.createElement("LevelPath");
			rootElement.appendChild(levelpath);

			Attr attr = doc.createAttribute("id");
			attr.setValue(Integer.toString(entitynumber));
			levelpath.setAttributeNode(attr);

			Element pathname = doc.createElement("path");
			pathname.appendChild(doc.createTextNode(entityfilepath));
			levelpath.appendChild(pathname);
		
	}
	
	
	private void writeContent(int levelnumber){
		
		
		File leveldirectory = new File(folderpath+"/levels");
		if(!leveldirectory.exists()){
			leveldirectory.mkdirs();
		}
		
		
		try{
			System.out.println("trying");
		TransformerFactory transformerFactory = TransformerFactory.newInstance();
		Transformer transformer = transformerFactory.newTransformer();
		DOMSource source = new DOMSource(doc);
		StreamResult result = new StreamResult(new File(folderpath+"/levels/level"+levelnumber+".xml"));

		// Output to console for testing
		// StreamResult result = new StreamResult(System.out);

		transformer.transform(source, result);

	
		}
		catch (TransformerException e){
			e.printStackTrace();
		}
		
		}
}