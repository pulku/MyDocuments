package apress.spring.pulku.service;


import apress.spring.pulku.model.Document;
import apress.spring.pulku.model.Type;

import java.util.List;

public interface SearchEngine {

    public List<Document> findByType(Type documentType);
    public List<Document> listAll();
}
