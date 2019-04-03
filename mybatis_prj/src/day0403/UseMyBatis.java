package day0403;

import java.io.IOException;
import java.io.Reader;
import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class UseMyBatis {

	public SqlSessionFactory getSessionFactory() throws IOException {

		// 1.ȯ�ἳ�� xml�� stream����.
		Reader reader = Resources.getResourceAsReader("day0403/mybatis_config.xml");

		// 2.MyBatis Framework����.
		SqlSessionFactoryBuilder ssfb = new SqlSessionFactoryBuilder();

		// 3. MyBatis Framework�� DB������ ��ü ���. - (��ü�� �ϳ��� �����ؾ� ��.)
		SqlSessionFactory ssf = ssfb.build(reader);
		if (reader != null) {
			reader.close();
		} // end if

		return ssf;
	}// getSessionFactory

	public void insertCpDept(DeptVO d_vo) throws IOException, SQLException {
		// �ڵ鷯 ���
		SqlSession ss = getSessionFactory().openSession();

		// �ڵ鷯 ���
		int cnt = ss.insert("insertCpDept", d_vo);
		ss.commit();
		System.out.println("�߰� �۾� �Ϸ� : " + cnt);
	}// insertCpDept

	public void selectAllDept() throws IOException {

		// 4. MyBatis Handler ���
		SqlSession ss = getSessionFactory().openSession();

		// 5.Handler�� ����Ͽ� DB�۾� ����.
		List<DeptDomain> list = ss.selectList("kr.co.sist.selectAllDept");
		DeptDomain dd = null;
		for (int i = 0; i < list.size(); i++) {
			dd = list.get(i);
			System.out.println(dd.getDeptno() + " / " + dd.getDname() + " / " + dd.getLoc());
		} // end for

		// 6. ����� ����� SqlSession �ݴ´�.
		ss.close();
	}// selectAllDept

	public void updateCpDept(DeptVO d_vo) throws IOException, SQLException {
		SqlSession ss = getSessionFactory().openSession();
		int cnt = ss.update("updateCpDept", d_vo);
		ss.commit();
		System.out.println("���� ���� : " + cnt);
	}// updateCpDept

	public void deleteCpDept(int deptno) throws IOException, SQLException {
		SqlSession ss = getSessionFactory().openSession();
		int cnt = ss.delete("deleteCpDept", deptno);
		ss.commit();
		if (cnt == 1) {
			System.out.println(deptno + "�� �μ� ������ ���� �߽��ϴ�.");
		} else {
			System.out.println(deptno + "�ش� �μ��� �������� �ʽ��ϴ�.");
		} // end else
	}// deleteCpDept

	public static void main(String[] args) {
		UseMyBatis umb = new UseMyBatis();
		DeptVO d_vo = new DeptVO(11, "SM����", "����");
		try {

			// �߰�
			// umb.insertCpDept(d_vo);
			// ����
			// umb.updateCpDept(d_vo);
			// ����
			umb.deleteCpDept(11);
			// ��ȸ
			umb.selectAllDept();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		} // end catch

	}// main.

}// class.
