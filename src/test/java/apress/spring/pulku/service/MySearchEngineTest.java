package apress.spring.pulku.service;

import apress.spring.pulku.model.Document;
import apress.spring.pulku.model.Type;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;


public class MySearchEngineTest {

    private SearchEngine engine = new MySearchEngine();

    @Test
    public void testFindByType() throws Exception {

        Type documentType = new Type();
        documentType.setName("WEB");
        documentType.setDesc("Web Link");
        documentType.setExtension(".url");

        List<Document> documents = engine.findByType(documentType);
        assertNotNull(documents);
        assertTrue(documents.size() == 1);
        assertEquals(documentType.getName(), documents.get(0).getType().getName());
        assertEquals(documentType.getDesc(), documents.get(0).getType().getDesc());
        assertEquals(documentType.getExtension(), documents.get(0).getType().getExtension());

    }

    @Test
    public void testListAll() throws Exception {

        List<Document> documents = engine.listAll();

        assertNotNull(documents);
        assertTrue(documents.size() == 4);

    }
}