package apress.spring.pulku.config;

import apress.spring.pulku.data.DocumentDAO;
import apress.spring.pulku.data.DocumentRepository;
import apress.spring.pulku.model.Document;
import apress.spring.pulku.model.Type;
import apress.spring.pulku.service.SearchEngine;
import apress.spring.pulku.service.SearchEngineService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class MyDocumentsContext {

    private Map<String, Document> documents = new HashMap<>();
    private Map<String, Type> types = new HashMap<>();

    @Bean
    public Type webType() {
        return getTypeFromMap("web");
    }

    @Bean
    public SearchEngine engine() {
        SearchEngineService engine = new SearchEngineService();
        engine.setDocumentDAO(documentDAO());
        return engine;
    }

    public MyDocumentsContext() {
        Type type = new Type();
        type.setName("PDF");
        type.setDesc("Portable Document Format");
        type.setExtension(".pdf");

        Document document = new Document();
        document.setName("Book Template");
        document.setType(type);
        document.setLocation("/Documents/Book Template.pdf");

        documents.put("doc1", document);
        types.put("pdf", type);

        document = new Document();
        document.setName("Sample Contract");
        document.setType(type);
        document.setLocation("/Documents/Sample Contract.pdf");

        documents.put("doc2", document);

        type = new Type();
        type.setName("NOTE");
        type.setDesc("Text Notes");
        type.setExtension(".txt");

        document = new Document();
        document.setName("Clustering with RabbitMQ");
        document.setType(type);
        document.setLocation("/Documents/Clustering with RabbitMQ.txt");

        documents.put("doc3", document);
        types.put("note", type);

        type = new Type();
        type.setName("WEB");
        type.setDesc("Web Link");
        type.setExtension(".url");

        document = new Document();
        document.setName("Pro Spring Security Book");
        document.setType(type);
        document.setLocation("http://www.apress.com/9781430248187");

        documents.put("doc4", document);
        types.put("web", type);
    }

    private DocumentDAO documentDAO() {
        DocumentRepository documentDAO = new DocumentRepository();
        documentDAO.setDoc1(getDocumentFromMap("doc1"));
        documentDAO.setDoc2(getDocumentFromMap("doc2"));
        documentDAO.setDoc3(getDocumentFromMap("doc3"));
        documentDAO.setDoc4(getDocumentFromMap("doc4"));
        return documentDAO;
    }

    private Document getDocumentFromMap(String documentKey) {
        return documents.get(documentKey);
    }

    private Type getTypeFromMap(String typeKey) {
        return types.get(typeKey);
    }
}
