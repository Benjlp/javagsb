package gsb.tests;

import gsb.modele.dao.VisiteDao;

public class VisiteDaoTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int result = VisiteDao.supprimer("test");
		System.out.println(result);
	}

}
