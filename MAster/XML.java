import javax.swing.*;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.*;
import java.awt.*;
import java.io.File;

public class XML {
//Tworzy okno i nadaje mu rozmair nazwe i z kąd pobiera xml
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            try {
                // Tworzymy nowe okno
                JFrame frame = new JFrame("Kalkulator w XMLaa");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

                // Wczytujemy układ z XML
                JPanel panel = loadLayoutFromXML("window.xml");
                frame.add(panel);

                // Ustawiamy rozmiar okna i jego widoczność
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    private static JPanel loadLayoutFromXML(String fileName) throws Exception {
        File xmlFile = new File(fileName);
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.parse(xmlFile);

        Element root = document.getDocumentElement();
        NodeList panelNodes = root.getElementsByTagName("panel");
        JPanel panel = new JPanel(new GridLayout(2, 2)); // Przyjmujemy prosty GridLayout dla 2x2 układu

        if (panelNodes.getLength() > 0) {
            Element panelElement = (Element) panelNodes.item(0);
            NodeList rowNodes = panelElement.getElementsByTagName("row");

            for (int i = 0; i < rowNodes.getLength(); i++) {
                Node rowNode = rowNodes.item(i);

                if (rowNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element rowElement = (Element) rowNode;
                    NodeList childNodes = rowElement.getChildNodes();

                    for (int j = 0; j < childNodes.getLength(); j++) {
                        Node childNode = childNodes.item(j);

                        if (childNode.getNodeType() == Node.ELEMENT_NODE) {
                            Element element = (Element) childNode;

                            switch (element.getTagName()) {
                                case "label":
                                    JLabel label = new JLabel(element.getAttribute("text"));
                                    panel.add(label);
                                    break;
                                case "textfield":
                                    JTextField textField = new JTextField(Integer.parseInt(element.getAttribute("columns")));
                                    panel.add(textField);
                                    break;
                            }
                        }
                    }
                }
            }
        }
        return panel;
    }
}