package org.protege.owl.server.api_new.configuration;

import org.protege.owl.server.api.User;
import org.protege.owl.server.api_new.Project;
import org.protege.owl.server.api_new.Role;

import java.util.Set;

/**
 * Manager for server-side configurations
 *
 * @author Rafael Gonçalves <br>
 * Stanford Center for Biomedical Informatics Research
 */
public interface ServerConfigurationManager extends ConfigurationManager {

    /**
     * Get the set of all projects
     *
     * @return Set of projects
     */
    Set<Project> getProjects();

    /**
     * Get the set of all roles
     *
     * @return Set of roles
     */
    Set<Role> getRoles();

    /**
     * Get the set of all users
     *
     * @return Set of users
     */
    Set<User> getUsers();

    /**
     * Generate a new concept identifier
     *
     * @return New concept identifier
     */
    int getNewConceptIdentifier();

}
