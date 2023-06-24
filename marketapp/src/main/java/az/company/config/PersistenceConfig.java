package az.company.config;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public abstract class PersistenceConfig {
    private static EntityManagerFactory emf = null;

    public static EntityManager entityManager() {

        if (emf == null) {
            emf = Persistence.createEntityManagerFactory("orxan");
        }
        EntityManager entityManager = emf.createEntityManager();
        return entityManager;
    }

    public void emfClose() {
        emf.close();
    }
}
