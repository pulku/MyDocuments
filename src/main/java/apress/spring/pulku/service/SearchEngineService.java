package apress.spring.pulku.service;


import apress.spring.pulku.data.DocumentDAO;
import apress.spring.pulku.model.Document;
import apress.spring.pulku.model.Type;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SearchEngineService implements SearchEngine {

    private DocumentDAO documentDAO;

    public DocumentDAO getDocumentDAO() {
        return documentDAO;
    }

    public void setDocumentDAO(DocumentDAO documentDAO) {
        this.documentDAO = documentDAO;
    }

    @Override
    public List<Document> findByType(Type documentType) {
        List<Document> result = new ArrayList<>();
        for(Document document : listAll()) {
            if(document.getType().getName().equals(documentType.getName()))
                result.add(document);
        }
        return result;
    }

    @Override
    public List<Document> listAll() {
        return Arrays.asList(documentDAO.getAll());
    }
}
