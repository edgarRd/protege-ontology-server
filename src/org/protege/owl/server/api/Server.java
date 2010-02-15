package org.protege.owl.server.api;

import java.io.File;
import java.io.IOException;
import java.io.Writer;
import java.util.List;
import java.util.Set;

import org.protege.owl.server.exception.RemoteOntologyChangeException;
import org.protege.owl.server.exception.RemoteOntologyCreationException;
import org.protege.owl.server.exception.RemoteOntologyException;
import org.semanticweb.owlapi.model.IRI;
import org.semanticweb.owlapi.model.OWLOntologyChange;
import org.semanticweb.owlapi.model.OWLOntologyManager;
import org.semanticweb.owlapi.model.OWLOntologySetProvider;

/**
 * This interface defines the server side responsibilities for managing versions of ontologies.  Essentially 
 * it must be able to provide the raw content of `marked' revisions of the ontology and it must be able to
 * provide a set of changes to go from any revision of an ontology to any other revision of that ontology.  
 * Implementations of this class need not concern themselves with the problem of how the server capabilities are
 * made available on the internet - this is done by implementations of the ServerTransport class.
 * 
 * @author tredmond
 *
 */
public interface Server extends OWLOntologySetProvider {
    
    OWLOntologyManager getOntologyManager();
    
    Set<RemoteOntologyRevisions> getOntologyList();
    
    Writer getOntologyWriter(RemoteOntology ontology) throws RemoteOntologyCreationException;
    
    void save(IRI version, File location) throws IOException;
    
    List<OWLOntologyChange> getChanges(RemoteOntology version1, RemoteOntology version2) throws RemoteOntologyException;

    void applyChanges(List<OWLOntologyChange> changes) throws RemoteOntologyChangeException;
    
    void setConflictManager(ConflictManager conflictManager);
}