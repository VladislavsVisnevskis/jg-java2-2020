package com.javaguru.shoppinglist.shoppingcart.repository;

import com.javaguru.shoppinglist.shoppingcart.domain.ShoppingCartEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;
import java.util.Optional;

@Repository
@Profile("hibernate")
@Transactional
public class HibernateShoppingCartRepository implements ShoppingCartRepository<ShoppingCartEntity>{

    private final SessionFactory sessionFactory;

    public HibernateShoppingCartRepository(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public ShoppingCartEntity save(ShoppingCartEntity shoppingCartEntity) {
        sessionFactory.getCurrentSession().save(shoppingCartEntity);
        return shoppingCartEntity;
    }

    @Override
    public void deleteShoppingCart(long id) {
        Session session = sessionFactory.getCurrentSession();
        ShoppingCartEntity shoppingCartEntity = session.load(ShoppingCartEntity.class, id);
        if(shoppingCartEntity != null){
            session.remove(shoppingCartEntity);
        }
    }

    @Override
    public void editShoppingCart(ShoppingCartEntity shoppingCartEntity) {
        Session session = sessionFactory.getCurrentSession();
        ShoppingCartEntity shoppingCart = session.load(ShoppingCartEntity.class, shoppingCartEntity.getId());
        if (shoppingCart != null){
            session.update(shoppingCartEntity);
        }
    }

    @Override
    public Optional<ShoppingCartEntity> findById(long id) {
        ShoppingCartEntity shoppingCartEntity = sessionFactory.getCurrentSession().find(ShoppingCartEntity.class, id);
        return Optional.ofNullable(shoppingCartEntity);
    }

    @Override
    public List<ShoppingCartEntity> findAllShoppingCarts() {
        Session session = sessionFactory.getCurrentSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<ShoppingCartEntity> query = builder.createQuery(ShoppingCartEntity.class);
        Root<ShoppingCartEntity> root = query.from(ShoppingCartEntity.class);
        query.select(root);
        return session.createQuery(query).getResultList();
    }

    @Override
    public void update(ShoppingCartEntity shoppingCartEntity) {
        sessionFactory.getCurrentSession().update(shoppingCartEntity);
    }
}
