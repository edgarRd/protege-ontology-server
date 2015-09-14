package org.protege.owl.server.server_config;

import org.protege.owl.server.api.User;

import java.util.Map;
import java.util.Set;

/**
 * A policy associates users and roles
 *
 * @author Rafael Gonçalves <br>
 * Stanford Center for Biomedical Informatics Research
 */
public interface Policy {

    /**
     * Get the name of the policy
     *
     * @return Name of the policy
     */
    String getName();

    /**
     * Set the name of the policy
     *
     * @param name  Policy name
     */
    void setName(String name);

    /**
     * Get the description of the policy
     *
     * @return Description of the policy
     */
    String getDescription();

    /**
     * Set the description of the policy
     *
     * @param description   Policy description
     */
    void setDescription(String description);

    /**
     * Add a user to the user-role-project registry with default role
     *
     * @param user  User to be added
     */
    void addUser(User user);

    /**
     * Add a user to the user-role registry with the specified role
     *
     * @param user  User to be added
     * @param role  Role for the user
     */
    void addUser(User user, Role role);

    /**
     * Add a user to the user registry with the specified set of roles
     *
     * @param user  User to be added
     * @param roles  Set of roles for the user
     */
    void addUser(User user, Set<Role> roles);

    /**
     * Remove a user from the user-role registry
     *
     * @param user  User to be removed
     */
    void removeUser(User user);

    /**
     * Get the set of all users in the user-role registry
     *
     * @return Set of users
     */
    Set<User> getUsers();

    /**
     * Check if a given user has the specified role
     *
     * @param user  User
     * @param role  Role
     * @return true if user has specified role, false otherwise
     */
    boolean hasRole(User user, Role role);

    /**
     * Get the set of all roles associated with a user
     *
     * @param user  User
     * @return Set of roles the user has
     */
    Set<Role> getRoles(User user);

    /**
     * Get a map of users with their corresponding roles
     *
     * @return Map of users to their roles
     */
    Map<User,Set<Role>> getUserRoleMappings();

    /**
     * Add a role for the given user to user-role registry
     *
     * @param role  Role
     * @param user  User
     */
    void addRole(Role role, User user);

    /**
     * Remove a role from the given user's role registry
     *
     * @param role  Role
     * @param user  User
     */
    void removeRole(Role role, User user);

}