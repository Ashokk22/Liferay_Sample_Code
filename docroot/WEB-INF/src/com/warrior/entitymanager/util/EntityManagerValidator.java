package com.warrior.entitymanager.util;

import java.util.List;

import com.liferay.portal.kernel.util.Validator;
import com.warrior.entitymanager.model.EntityManager;
public class EntityManagerValidator extends Validator{

	public static boolean validateEntityManager(EntityManager entityManager, List errors) {

        boolean valid = true;

        if (Validator.isNull(entityManager.getTitle()) || "".equals(entityManager.getTitle())) {
            valid = false;
            errors.add("entity-title-required");
        }
        if (Validator.isNull(entityManager.getDescription()) || "".equals(entityManager.getDescription())) {
            valid = false;
            errors.add("entity-description-required");
        }
        if (entityManager.getVocubalaryId()== -1) {
            valid = false;
            errors.add("entity-vocabulary-required");
        }
        if (entityManager.getCategoryId()==-1) {
            valid = false;
            errors.add("entity-category-required");
        }
        return valid;
    }
}