
import apress.spring.pulku.data.DocumentRepository
import apress.spring.pulku.model.Document
import apress.spring.pulku.model.Type
import apress.spring.pulku.service.SearchEngineService

beans {

    engine(SearchEngineService) {
        documentDAO = ref("documentDAO")
    }

    documentDAO(DocumentRepository){
        doc1 = ref("doc1")
        doc2 = ref("doc2")
        doc3 = ref("doc3")
        doc4 = ref("doc4")
    }

    doc1(Document) {
        name = "Book Template"
        type = ref("pdfType")
        location = "/Documents/Book Template.pdf"
    }

    doc2(Document) {
        name = "Sample Contract"
        type = ref("pdfType")
        location = "/Documents/Sample Contract.pdf"
    }

    doc3(Document) {
        name = "Clustering with RabbitMQ"
        type = ref("noteType")
        location = "/Documents/Clustering with RabbitMQ.txt"
    }

    doc4(Document) {
        name = "Pro Spring Security Book"
        type = ref("webType")
        location = "http://www.apress.com/9781430248187"
    }

    webType(Type) {
        name = "WEB"
        desc = "Web Link"
        extension = ".url"
    }

    noteType(Type) {
        name = "NOTE"
        desc = "Text Notes"
        extension = ".txt"
    }

    pdfType(Type) {
        name = "PDF"
        desc = "Portable Document Format"
        extension = ".pdf"
    }
}