package org.nuxeo.ecm.platform.importer.xml.parser;

import java.io.File;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

import org.nuxeo.ecm.core.api.DocumentModel;

/**
 * Interface for importer service
 *
 * @author <a href="mailto:tdelprat@nuxeo.com">Tiry</a>
 *
 */
public interface XMLImporterService {

    /**
     * Imports {@link DocumentModel} in Nuxeo from an XML or a Zip archive.
     *
     * @param root target container {@link DocumentModel}
     * @param source source file, can be XML or Zip with XML index
     * @return
     * @throws Exception
     */
    public List<DocumentModel> importDocuments(DocumentModel root, File source)
            throws Exception;

    /**
     * Imports {@link DocumentModel} in Nuxeo from an XML Stream.
     *
     * @param root target container {@link DocumentModel}
     * @param xmlStream stream source for Xml contnt
     * @return
     * @throws Exception
     */
    public List<DocumentModel> importDocuments(DocumentModel root,
            InputStream xmlStream) throws Exception;

    /**
     * Same as {@link #importDocuments(DocumentModel, File)} with map
     * injected into mvel contexts used during parsing
     *
     * @param root target container {@link DocumentModel}
     * @param source source file, can be XML or Zip with XML index
     * @param mvelContext Context added each time a mvel expression is resolved
     * @return
     * @throws Exception
     */
    public List<DocumentModel> importDocuments(DocumentModel root, File source,
            Map<String, Object> mvelContext) throws Exception;

    /**
     * Same as {@link #importDocuments(DocumentModel, InputStream)} with map
     * injected into mvel contexts used during parsing
     *
     * @param root target container {@link DocumentModel}
     * @param xmlStream stream source for Xml contnt
     * @param mvelContext Context added each time a mvel expression is resolved
     * @return
     * @throws Exception
     */
    public List<DocumentModel> importDocuments(DocumentModel root,
            InputStream xmlStream, Map<String, Object> mvelContext)
            throws Exception;

}
