package org.hair_studio.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hair_studio.model.Booking;
import org.hair_studio.model.Designer;
import org.hair_studio.model.Member;

public class StudioDAO {

	private static final String url = "jdbc:oracle:thin:@//localhost:1521/xe";
	private static final String user = "hair_mgr";
	private static final String password = "1111";

	private Connection getConnection() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			return DriverManager.getConnection(url, user, password);
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

	public boolean addMember(Member m) {

		Connection conn = getConnection();

		if (conn == null) {
			return false;
		}

		PreparedStatement st = null;
		ResultSet rs = null;

		try {
			st = conn.prepareStatement("insert into members (m_name, m_id, m_pw, m_num) values (?, ?, ?, ?)");
			st.setString(1, m.getName());
			st.setString(2, m.getId());
			st.setString(3, m.getPw());
			st.setString(4, m.getNum().replaceAll("[^0-9]", ""));

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

	public boolean login(String id, String pw) {

		Connection conn = getConnection();

		if (conn == null) {
			return false;
		}

		PreparedStatement st = null;
		ResultSet rs = null;

		try {
			st = conn.prepareStatement("select m_pw from members where m_id = ?");
			st.setString(1, id);
			rs = st.executeQuery();

			if (rs.next()) {
				String strPw = rs.getString(1);
				if (pw.equals(strPw)) {
					return true;
				} else {
					return false;
				}
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

	public Designer[] getDesigners() {

		Connection conn = getConnection();

		if (conn == null) {
			return null;
		}

		Statement st = null;
		ResultSet rs = null;
		List<Designer> list = new ArrayList<>();

		try {
			rs = conn.createStatement().executeQuery("select * from designers");

			while (rs.next()) {
				Designer d = new Designer();
				d.setName(rs.getString(1));
				d.setPart1(rs.getString(2));
				d.setPart2(rs.getString(3));
				d.setPart3(rs.getString(4));
				d.setPart4(rs.getString(5));
				d.setPart5(rs.getString(6));
				d.setPart6(rs.getString(7));
				d.setPart7(rs.getString(8));
				d.setPart8(rs.getString(9));
				d.setPart9(rs.getString(10));
				d.setPart10(rs.getString(11));
				d.setPart11(rs.getString(12));
				d.setPart12(rs.getString(13));
				d.setPart13(rs.getString(14));
				d.setPart14(rs.getString(15));
				d.setPart15(rs.getString(16));
				d.setPart16(rs.getString(17));

				list.add(d);
			}

			return list.toArray(new Designer[0]);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(conn, st, rs);
		}
		return null;
	}

	public Designer getDesigner(String name) {

		Connection conn = getConnection();

		if (conn == null) {
			return null;
		}

		PreparedStatement st = null;
		ResultSet rs = null;

		try {
			st = conn.prepareStatement("select * from designers where d_name = ?");
			st.setString(1, name);
			rs = st.executeQuery();

			if (rs.next()) {
				Designer d = new Designer();
				d.setName(rs.getString(1));
				d.setPart1(rs.getString(2));
				d.setPart2(rs.getString(3));
				d.setPart3(rs.getString(4));
				d.setPart4(rs.getString(5));
				d.setPart5(rs.getString(6));
				d.setPart6(rs.getString(7));
				d.setPart7(rs.getString(8));
				d.setPart8(rs.getString(9));
				d.setPart9(rs.getString(10));
				d.setPart10(rs.getString(11));
				d.setPart11(rs.getString(12));
				d.setPart12(rs.getString(13));
				d.setPart13(rs.getString(14));
				d.setPart14(rs.getString(15));
				d.setPart15(rs.getString(16));
				d.setPart16(rs.getString(17));

				return d;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(conn, st, rs);
		}

		return null;
	}

	public boolean addSchedule(String str, String id) {

		Connection conn = getConnection();

		if (conn == null) {
			return false;
		}

		PreparedStatement st = null;
		ResultSet rs = null;

		try {
			st = conn.prepareStatement(
					"update designers set " + str.split("-")[1] + " = '" + id + "님 cut' where d_name = ?");
			st.setString(1, str.split("-")[0]);
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

	public boolean addBooking(String id, String str) {
		Connection conn = getConnection();

		if (conn == null) {
			return false;
		}

		PreparedStatement st = null;
		ResultSet rs = null;

		try {
			st = conn.prepareStatement("insert into bookings (m_id, b_time, b_part, d_name) values (?, ?, ?, ?)");
			st.setString(1, id);
			st.setString(2, str.split("-")[2]);
			st.setString(3, str.split("-")[1]);
			st.setString(4, str.split("-")[0]);
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

	public Booking[] getBookings(String id) {

		Connection conn = getConnection();

		if (conn == null) {
			return null;
		}

		PreparedStatement st = null;
		ResultSet rs = null;
		List<Booking> list = new ArrayList<>();

		try {
			st = conn.prepareStatement("select * from bookings where m_id = ?");
			st.setString(1, id);
			rs = st.executeQuery();

			while (rs.next()) {
				Booking b = new Booking();
				b.setName(rs.getString(1));
				b.setTime(rs.getString(2));
				b.setdName(rs.getString(3));
				b.setPart(rs.getString(4));

				list.add(b);
			}

			return list.toArray(new Booking[0]);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(conn, st, rs);
		}
		return null;
	}

	public Member infoMember(String id) {

		Connection conn = getConnection();

		if (conn == null) {
			return null;
		}

		PreparedStatement st = null;
		ResultSet rs = null;

		try {
			st = conn.prepareStatement("select m_name, m_num from members where m_id = ?");
			st.setString(1, id);
			rs = st.executeQuery();

			if (rs.next()) {
				Member m = new Member();
				m.setName(rs.getString(1));
				m.setId(id);
				m.setNum(rs.getString(2));

				return m;
			} else {
				return null;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(conn, st, rs);
		}

		return null;
	}

	public boolean updateMember(Member m) {

		Connection conn = getConnection();

		if (conn == null) {
			return false;
		}

		PreparedStatement st = null;
		ResultSet rs = null;

		try {
			st = conn.prepareStatement("update members set m_name=?, m_pw=?, m_num=? where m_id=?");
			st.setString(1, m.getName());
			st.setString(2, m.getPw());
			st.setString(3, m.getNum());
			st.setString(4, m.getId());

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

	public boolean deleteMember(String id) {

		Connection conn = getConnection();

		if (conn == null) {
			return false;
		}

		PreparedStatement st = null;
		ResultSet rs = null;

		try {
			st = conn.prepareStatement("select b_part, d_name from bookings where m_id=?");
			st.setString(1, id);
			rs = st.executeQuery();

			while (rs.next()) {

				int u = conn.createStatement().executeUpdate(
						"update designers set " + rs.getString(1) + " = null where d_name = '" + rs.getString(2) + "'");

				if (u <= 0) {
					return false;
				}
			}

			st = conn.prepareStatement("delete from bookings where m_id=?");
			st.setString(1, id);

			int d = st.executeUpdate();

			if (d <= 0) {
				return false;
			}

			st = conn.prepareStatement("delete from members where m_id=?");
			st.setString(1, id);

			d = st.executeUpdate();

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

	public boolean cancelSchedule(String can) {

		Connection conn = getConnection();

		String part = can.split("-")[1];
		String name = can.split("-")[0];

		if (conn == null) {
			return false;
		}

		PreparedStatement st = null;
		ResultSet rs = null;

		try {
			int u = conn.createStatement()
					.executeUpdate("update designers set " + part + " = null where d_name = '" + name + "'");

			if (u <= 0) {
				return false;
			}

			st = conn.prepareStatement("delete from bookings where d_name = ? and b_part = ?");
			st.setString(1, name);
			st.setString(2, part);

			u = st.executeUpdate();

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

	public void timeToDB(String date) {

		Connection conn = getConnection();

		PreparedStatement st = null;
		ResultSet rs = null;

//		(Thu May 30 10:07:46 KST 2019)

		String today = date.split(" ")[0];

		String hour = date.split(" ")[3].split(":")[0];

		String dbday = null;

		try {
			rs = conn.createStatement().executeQuery("select lasttime from times");

			if (rs.next()) {
				dbday = rs.getString(1);
			}

			if (Integer.parseInt(hour) >= 19 && !today.equalsIgnoreCase(dbday)) {

				st = conn.prepareStatement("update times set lasttime = ? where login = 'last'");

				st.setString(1, today);

				st.executeUpdate();

				conn.createStatement()
						.executeUpdate("update designers set part_time1 = null, part_time2 = null, part_time3 = null, "
								+ "part_time4 = null, part_time5 = null, part_time6 = null, part_time7 = null, "
								+ "part_time8 = null, part_time9 = null, part_time10 = null, part_time11 = null, "
								+ "part_time12 = null, part_time13 = null, part_time14 = null, part_time15 = null, "
								+ "part_time16 = null");

				conn.createStatement().executeUpdate("delete bookings");
			}

			if (dbday.equalsIgnoreCase("mon") && !today.equalsIgnoreCase("tue")) {
				
				st = conn.prepareStatement("update times set lasttime = ? where login = 'last'");

				st.setString(1, today);

				st.executeUpdate();

				conn.createStatement()
						.executeUpdate("update designers set part_time1 = null, part_time2 = null, part_time3 = null, "
								+ "part_time4 = null, part_time5 = null, part_time6 = null, part_time7 = null, "
								+ "part_time8 = null, part_time9 = null, part_time10 = null, part_time11 = null, "
								+ "part_time12 = null, part_time13 = null, part_time14 = null, part_time15 = null, "
								+ "part_time16 = null");

				conn.createStatement().executeUpdate("delete bookings");
				
			} else if (dbday.equalsIgnoreCase("tue") && !today.equalsIgnoreCase("wed")) {
				
				st = conn.prepareStatement("update times set lasttime = ? where login = 'last'");

				st.setString(1, today);

				st.executeUpdate();

				conn.createStatement()
						.executeUpdate("update designers set part_time1 = null, part_time2 = null, part_time3 = null, "
								+ "part_time4 = null, part_time5 = null, part_time6 = null, part_time7 = null, "
								+ "part_time8 = null, part_time9 = null, part_time10 = null, part_time11 = null, "
								+ "part_time12 = null, part_time13 = null, part_time14 = null, part_time15 = null, "
								+ "part_time16 = null");

				conn.createStatement().executeUpdate("delete bookings");
				
			} else if (dbday.equalsIgnoreCase("wed") && !today.equalsIgnoreCase("thu")) {
				
				st = conn.prepareStatement("update times set lasttime = ? where login = 'last'");

				st.setString(1, today);

				st.executeUpdate();

				conn.createStatement()
						.executeUpdate("update designers set part_time1 = null, part_time2 = null, part_time3 = null, "
								+ "part_time4 = null, part_time5 = null, part_time6 = null, part_time7 = null, "
								+ "part_time8 = null, part_time9 = null, part_time10 = null, part_time11 = null, "
								+ "part_time12 = null, part_time13 = null, part_time14 = null, part_time15 = null, "
								+ "part_time16 = null");

				conn.createStatement().executeUpdate("delete bookings");
				
			} else if (dbday.equalsIgnoreCase("thu") && !today.equalsIgnoreCase("fri")) {
				
				st = conn.prepareStatement("update times set lasttime = ? where login = 'last'");

				st.setString(1, today);

				st.executeUpdate();

				conn.createStatement()
						.executeUpdate("update designers set part_time1 = null, part_time2 = null, part_time3 = null, "
								+ "part_time4 = null, part_time5 = null, part_time6 = null, part_time7 = null, "
								+ "part_time8 = null, part_time9 = null, part_time10 = null, part_time11 = null, "
								+ "part_time12 = null, part_time13 = null, part_time14 = null, part_time15 = null, "
								+ "part_time16 = null");

				conn.createStatement().executeUpdate("delete bookings");
				
			}  else if (dbday.equalsIgnoreCase("fri") && !today.equalsIgnoreCase("sat")) {
				
				st = conn.prepareStatement("update times set lasttime = ? where login = 'last'");

				st.setString(1, today);

				st.executeUpdate();

				conn.createStatement()
						.executeUpdate("update designers set part_time1 = null, part_time2 = null, part_time3 = null, "
								+ "part_time4 = null, part_time5 = null, part_time6 = null, part_time7 = null, "
								+ "part_time8 = null, part_time9 = null, part_time10 = null, part_time11 = null, "
								+ "part_time12 = null, part_time13 = null, part_time14 = null, part_time15 = null, "
								+ "part_time16 = null");

				conn.createStatement().executeUpdate("delete bookings");
				
			} else if (dbday.equalsIgnoreCase("sat") && !today.equalsIgnoreCase("sun")) {
				
				st = conn.prepareStatement("update times set lasttime = ? where login = 'last'");

				st.setString(1, today);

				st.executeUpdate();

				conn.createStatement()
						.executeUpdate("update designers set part_time1 = null, part_time2 = null, part_time3 = null, "
								+ "part_time4 = null, part_time5 = null, part_time6 = null, part_time7 = null, "
								+ "part_time8 = null, part_time9 = null, part_time10 = null, part_time11 = null, "
								+ "part_time12 = null, part_time13 = null, part_time14 = null, part_time15 = null, "
								+ "part_time16 = null");

				conn.createStatement().executeUpdate("delete bookings");
				
			} else if (dbday.equalsIgnoreCase("sun") && !today.equalsIgnoreCase("mon")) {
				
				st = conn.prepareStatement("update times set lasttime = ? where login = 'last'");

				st.setString(1, today);

				st.executeUpdate();

				conn.createStatement()
						.executeUpdate("update designers set part_time1 = null, part_time2 = null, part_time3 = null, "
								+ "part_time4 = null, part_time5 = null, part_time6 = null, part_time7 = null, "
								+ "part_time8 = null, part_time9 = null, part_time10 = null, part_time11 = null, "
								+ "part_time12 = null, part_time13 = null, part_time14 = null, part_time15 = null, "
								+ "part_time16 = null");

				conn.createStatement().executeUpdate("delete bookings");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(conn, st, rs);
		}
	}

}
