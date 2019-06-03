package com.warrior.entitymanager.util;

import com.liferay.portal.kernel.util.OrderByComparator;
import com.warrior.entitymanager.model.EntityManager;
/* _asc Should be true for Ascending
_asc Should be true for Ascending */

public class EntityManagerVocabularyComparator extends OrderByComparator {

		public static String ORDER_BY_ASC = "ASCENDING";

		public static String ORDER_BY_DESC = "DESCENDING";

		public EntityManagerVocabularyComparator() {
		this(false);
		}

		public EntityManagerVocabularyComparator(boolean asc) {
			System.out.println("LessonPlanVocabularyComparator");
		_asc = asc;
		}

		public int compare(Object obj1, Object obj2) {
			EntityManager project1 = (EntityManager) obj1;
			EntityManager project2 = (EntityManager) obj2;

		Long value = project1.getVocubalaryId() - project2.getVocubalaryId();

		if (_asc) {
		return Integer.parseInt(value.toString());
		} else {
		return -(Integer.parseInt(value.toString()));
		}
		}

		public String getOrderBy() {
		if (_asc) {
		return ORDER_BY_ASC;
		} else {
		return ORDER_BY_DESC;
		}
		}

		private boolean _asc;

}