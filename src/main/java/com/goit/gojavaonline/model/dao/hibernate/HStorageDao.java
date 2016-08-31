package com.goit.gojavaonline.model.dao.hibernate;

import com.goit.gojavaonline.model.Ingredient;
import com.goit.gojavaonline.model.StorageIngredient;
import com.goit.gojavaonline.model.dao.StorageDao;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

/**
 * Created by tamila on 8/31/16.
 */
public class HStorageDao implements StorageDao {
    private SessionFactory sessionFactory;

    @Override
    public void insertIngredientToStorage(StorageIngredient storageIngredient) {
        sessionFactory.getCurrentSession().save(storageIngredient);
    }

    @Override
    public void deleteIngredientFromStorage(int id) {
        sessionFactory.getCurrentSession().delete(getStorageIngredientById(id));
    }

    @Override
    public void changeIngredientQuantity(int id, float newQuantity) {
        StorageIngredient storageIngredient = getStorageIngredientById(id);
        storageIngredient.setQuantity(newQuantity);
        sessionFactory.getCurrentSession().update(storageIngredient);
    }

    @Override
    public StorageIngredient getIngredientFromStorage(String name) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select i from StorageIngredient i where i.ingredient.title like :title");
        query.setParameter("title", name);
        return (StorageIngredient) query.uniqueResult();
    }

    @Override
    public List<StorageIngredient> getAll() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("select i from StorageIngredient i").list();
    }

    @Override
    public Ingredient getIngredientByName(String name) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select i from Ingredient i where i.title like :title");
        query.setParameter("title", name);
        return (Ingredient) query.uniqueResult();
    }

    private StorageIngredient getStorageIngredientById(int id) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select i from StorageIngredient i where i.id like :id");
        query.setParameter("id", id);
        return (StorageIngredient) query.uniqueResult();
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
}
