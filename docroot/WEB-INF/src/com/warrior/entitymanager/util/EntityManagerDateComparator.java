package com.warrior.entitymanager.util;


import com.liferay.portal.kernel.util.OrderByComparator;
/* _asc Should be true for Ascending
_asc Should be true for Ascending */
import com.warrior.entitymanager.model.EntityManager;

public class EntityManagerDateComparator extends OrderByComparator {

		public static String ORDER_BY_ASC = "ASCENDING";

		public static String ORDER_BY_DESC = "DESCENDING";

		public EntityManagerDateComparator() {
		this(false);
		}

		public EntityManagerDateComparator(boolean asc) {
			System.out.println("LessonPlanDateComparator");
		_asc = asc;
		}

		public int compare(Object obj1, Object obj2) {
			EntityManager project1 = (EntityManager) obj1;
			EntityManager project2 = (EntityManager) obj2;

		int value = project1.getEntityAddDate().compareTo(project2.getEntityAddDate()) > 0 ? 1 : 0;

		if (_asc) {
		return value;
		} else {
		return -value;
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