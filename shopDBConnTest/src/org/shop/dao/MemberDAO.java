package org.shop.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.shop.model.Member;

public class MemberDAO {

	private static MemberDAO memberdao = new MemberDAO();

	public static MemberDAO getInstance() {
		return memberdao;
	}

	private MemberDAO() {
	}

//	private static final String url = "jdbc:oracle:thin:@//localhost:1521/xe";
//	private static final String user = "scott";
//	private static final String password = "tiger";

	private Connection getConnection() {
		try {
//			Class.forName("oracle.jdbc.OracleDriver");
			return DriverManager.getConnection("jdbc:apache:commons:dbcp:shop");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	private void close(Connection conn, Statement st, ResultSet rs) {
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if (st != null) {
			try {
				st.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public Member[] listMembers() {

		Connection conn = getConnection();

		if (conn == null) {
			return null;
		}

		Statement st = null;
		ResultSet rs = null;

		try {

			rs = conn.createStatement().executeQuery("select * from shopmember");

			List<Member> list = new ArrayList<>();

			while (rs.next()) {
				Member m = new Member();
				m.setId(rs.getInt(1));
				m.setName(rs.getString(2));
				m.setPhone(rs.getString(3));
				String add = rs.getString(4);
				m.setAddress(add == null ? "" : add);

				list.add(m);
			}

			return list.toArray(new Member[0]);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(conn, st, rs);
		}

		return null;

	}

	public boolean addMember(Member m) {

		Connection conn = getConnection();

		if (conn == null) {
			return false;
		}

		PreparedStatement st = null;
		ResultSet rs = null;

		try {
			st = conn.prepareStatement(
					"insert into shopmember (id, name, phone, address) values (seq.nextval, ?, ?, ?)");
			st.setString(1, m.getName());
			st.setString(2, m.getPhone());
			st.setString(3, m.getAddress());

			int result = st.executeUpdate();

			if (result > 0) {
				return true;
			} else {
				return false;
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(conn, st, rs);
		}

		return false;
	}

	public boolean updateMember(Member m) {

		Connection conn = getConnection();

		if (conn == null) {
			return false;
		}

		PreparedStatement st = null;
		ResultSet rs = null;

		try {

			st = conn.prepareStatement("update shopmember set name=?, phone=?, address=? where id=?");
			st.setString(1, m.getName());
			st.setString(2, m.getPhone());
			st.setString(3, m.getAddress());
			st.setInt(4, m.getId());

			int u = st.executeUpdate();

			if (u > 0) {
				return true;
			} else {
				return false;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(conn, st, rs);
		}
		return false;
	}

	public boolean deleteMember(int id) {

		Connection conn = getConnection();

		if (conn == null) {
			return false;
		}

		PreparedStatement st = null;
		ResultSet rs = null;

		try {

			st = conn.prepareStatement("delete from shopmember where id=?");
			st.setInt(1, id);

			int d = st.executeUpdate();

			if (d > 0) {
				return true;
			} else {
				return false;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(conn, st, rs);
		}
		return false;
	}

}
