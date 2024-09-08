package questoes;
import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

    public class Questao3 {

    public static void main(String[] args) {
        try {
            // Carregar o arquivo XML
            File inputFile = new File("D:\\Web Developer\\Target-Sistemas-Estagio\\Questoes\\src\\dados.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(inputFile);
            doc.getDocumentElement().normalize();

            // Obter todos os valores de faturamento
            NodeList nodeList = doc.getElementsByTagName("valor");

            double menorValor = Double.MAX_VALUE;
            double maiorValor = Double.MIN_VALUE;
            double somaValores = 0.0;
            int diasComFaturamento = 0;

            // Calcular menor, maior valor e soma total considerando apenas dias com faturamento
            for (int i = 0; i < nodeList.getLength(); i++) {
                double valor = Double.parseDouble(nodeList.item(i).getTextContent());

                if (valor > 0) { // Considerar apenas dias com faturamento
                    diasComFaturamento++;
                    somaValores += valor;
                    if (valor < menorValor) {
                        menorValor = valor;
                    }
                    if (valor > maiorValor) {
                        maiorValor = valor;
                    }
                }
            }

            // Calcular a média mensal considerando apenas os dias com faturamento
            double mediaMensal = somaValores / diasComFaturamento;
            int diasAcimaDaMedia = 0;

            // Calcular o número de dias com faturamento superior à média
            for (int i = 0; i < nodeList.getLength(); i++) {
                double valor = Double.parseDouble(nodeList.item(i).getTextContent());
                if (valor > mediaMensal) { // Considerar apenas dias com faturamento superior à média
                    diasAcimaDaMedia++;
                }
            }

            // Exibir resultados
            System.out.println("Menor valor de faturamento: " + menorValor);
            System.out.println("Maior valor de faturamento: " + maiorValor);
            System.out.println("Dias com faturamento acima da média: " + diasAcimaDaMedia);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

