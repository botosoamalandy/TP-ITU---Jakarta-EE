package fr.grin.tpcustomerapplication.session;

import fr.grin.tpcustomerapplication.entities.DiscountCode;
import javax.ejb.Stateless;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Stateless
public class DiscountCodeManager {

    @PersistenceContext(unitName = "customerPU")
    private EntityManager em;

    public List<DiscountCode> getAllDiscountCodes() {
        Query query = em.createNamedQuery("DiscountCode.findAll");
        return query.getResultList();
    }

    public DiscountCode update(DiscountCode discountCode) {
        return em.merge(discountCode);
    }

    public DiscountCode findById(String discountCode) {
        return em.find(DiscountCode.class, discountCode);
    }

    public void persist(DiscountCode discountCode) {
        em.persist(discountCode);
    }
}
