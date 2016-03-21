package apress.spring.pulku.service;


import apress.spring.pulku.config.MyDocumentsContext;
import apress.spring.pulku.model.Document;
import apress.spring.pulku.model.Type;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class MyDocumentsBeanConfigurationTest {

    private ApplicationContext context;
    private SearchEngine engine;
    private Type webType;

    @Before
    public void setup() {
        context = new AnnotationConfigApplicationContext(MyDocumentsContext.class);
        engine = context.getBean(SearchEngine.class);
        webType = context.getBean(Type.class);
    }

    @Test
    public void testWithBeanConfigurationFindByType() {
        List<Document> documents = engine.findByType(webType);

        assertNotNull(documents);
        assertTrue(documents.size() == 1);
        assertEquals(webType.getName(), documents.get(0).getType().getName());
        assertEquals(webType.getDesc(), documents.get(0).getType().getDesc());
        assertEquals(webType.getExtension(), documents.get(0).getType().getExtension());
    }

    @Test
    public void testWithBeanConfigurationListAll() {
        List<Document> documents = engine.listAll();

        assertNotNull(documents);
        assertTrue(documents.size() == 4);
    }
}
