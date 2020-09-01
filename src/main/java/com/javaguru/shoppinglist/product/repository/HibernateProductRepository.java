package com.javaguru.shoppinglist.product.repository;

import com.javaguru.shoppinglist.product.domain.ProductEntity;
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
public class HibernateProductRepository implements ProductRepository<ProductEntity>{

    private final SessionFactory sessionFactory;

    public HibernateProductRepository(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    @Transactional
    public ProductEntity save(ProductEntity productEntity) {
        sessionFactory.getCurrentSession().save(productEntity);
        return productEntity;
    }

    @Override
    public void remove(long id) {
        Session session = sessionFactory.getCurrentSession();
        ProductEntity entity = session.load(ProductEntity.class, id);
        if(entity != null){
            session.remove(entity);
        }
    }

    @Override
    public void editProduct(ProductEntity productEntity) {
        Session session = sessionFactory.getCurrentSession();
        ProductEntity entity = session.load(ProductEntity.class, productEntity.getId());
        if (entity != null){
            session.update(productEntity);
        }
    }

    @Override
    public Optional<ProductEntity> findProductById(long id) {
        ProductEntity productEntity = sessionFactory.getCurrentSession().find(ProductEntity.class, id);
        return Optional.ofNullable(productEntity);
    }

    @Override
    public List<ProductEntity> findAllProducts() {
        Session session = sessionFactory.getCurrentSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<ProductEntity> query = builder.createQuery(ProductEntity.class);
        Root<ProductEntity> root = query.from(ProductEntity.class);
        query.select(root);
        return session.createQuery(query).getResultList();
    }
}