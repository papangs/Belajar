package Aplikasi_Human_Resource.koneksi;

import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class koneksi {
    Connection con;
    Statement st;
    ResultSet rs;

    public koneksi() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/db_hrd", "root", "");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<String[]> tampil_karyawan() {
        try {
            st = con.createStatement();
            ResultSet rs = st.executeQuery("select * from tb_karyawan");
            List<String[]> listData = new ArrayList<String[]>();

            while (rs.next()) {
                String[] data = new String[7];
                data[0] = rs.getString("nik");
                data[1] = rs.getString("nama");
                data[2] = rs.getString("posisi");
                data[3] = rs.getString("alamat");
                data[4] = rs.getString("telpon");
                data[5] = rs.getString("jk");
                data[6] = rs.getString("email");
                listData.add(data);
            }
            con.close();
            return listData;

        } catch (Exception e) {
        }
        return null;
    }

    public List<String[]> tampil_absensi() {
        try {
            st = con.createStatement();
            ResultSet rs = st.executeQuery("select a.nik, a.nama, b.tgl_masuk, b.jam_masuk, b.jam_keluar, b.telat from tb_karyawan a, tb_absen b where a.nik=b.nik");
            List<String[]> listData = new ArrayList<String[]>();

            while (rs.next()) {
                String[] data1 = new String[6];
                data1[0] = rs.getString("nik");
                data1[1] = rs.getString("nama");
                data1[2] = rs.getString("tgl_masuk");
                data1[3] = rs.getString("jam_masuk");
                data1[4] = rs.getString("jam_keluar");
                data1[5] = rs.getString("telat");
                listData.add(data1);
            }
            con.close();
            return listData;

        } catch (Exception e) {
        }
        return null;
    }

    public void hapus_Karyawan(String nik) throws SQLException {
        st = con.createStatement();
        String sql = "delete from tb_karyawan where nik='" + nik + "'";
        st.executeUpdate(sql);
        con.close();
    }

    public void hapus_Absensi(String nik) throws SQLException {
        st = con.createStatement();
        String sql = "delete from tb_absen where nik='" + nik + "'";
        st.executeUpdate(sql);
        con.close();
    }

    public void insert_Karyawan(String nik, String nama, String posisi, String alamat, String telpon, String jk, String email) throws SQLException {
        st = con.createStatement();
        st.executeUpdate("insert into tb_karyawan values('" + nik + "', '" + nama + "', '" + posisi + "', '" + alamat + "', '" + telpon + "', '" + jk + "', '" + email + "')");
        con.close();
    }

    public void insert_Absensi(String nik) throws SQLException {
        st = con.createStatement();
        Date d1 = new Date();
        DateFormat f = new SimpleDateFormat("yyyy-MM-dd");
        DateFormat s = new SimpleDateFormat("HH:mm:ss");

        String tgl_masuk = f.format(d1);
        String jam_masuk = s.format(d1);
        String jam_keluar = s.format(d1);
        String telat = s.format(d1);
        st.executeUpdate("insert into tb_absen (tgl_masuk, jam_masuk, jam_keluar, telat, nik) values ('" + tgl_masuk + "', '" + jam_masuk + "', '" + jam_keluar + "', '" + telat + "', '" + nik + "')");

        con.close();
    }

    public void update_Karyawan(String nik, String nama, String posisi, String alamat, String telpon, String jk, String email) throws SQLException {
        st = con.createStatement();
        String sql = "UPDATE db_absensi.tb_karyawan SET nama='" + nama + "', posisi='" + posisi + "', alamat='" + alamat + "', telpon='" + telpon + "', jk='" + jk + "', email'" + email + "' where tb_karyawan nik='" + nik + "'";
        st.executeUpdate(sql);
        con.close();
    }


    public void update_Absensi(String nik) throws SQLException {
        st = con.createStatement();
        Date d1 = new Date();
        DateFormat f = new SimpleDateFormat("yyyy-mm-dd");
        //DateFormat s = new SimpleDateFormat("HH:mm:ss");
        try {
            String tgl_masuk = f.format(d1);

            String sql = "update tb_absen set jam_keluar, telat where tgl_masuk = '" + tgl_masuk + "' and nik = '" + nik + "' ";
            st.executeUpdate(sql);
        } catch (Exception e) {
            e.printStackTrace();
        }

        con.close();
    }

    @SuppressWarnings("unused")
    public String select(String nik) throws SQLException {
        String nama = null;

        st = con.createStatement();
        Date d1 = new Date();
        DateFormat f = new SimpleDateFormat("yyyy-MM-dd");
        DateFormat s = new SimpleDateFormat("HH:mm:ss");
        try {
            String tgl_masuk = f.format(d1);
            String jam_masuk = s.format(d1);
            String jam_keluar = s.format(d1);
            String telat = s.format(d1);
        } catch (Exception e) {
            e.printStackTrace();
        }

        String jam_masuk = null;
        String tgl_masuk = null;
        String jam_keluar = null;
        String telat = null;

        ResultSet rs = st.executeQuery("select a.nik, a.nama, b.tgl_masuk, b.jam_masuk, b.jam_keluar, b.telat from tb_karyawan a, tb_absen b where a.nik=b.nik and a.nik = '" + nik + "'");
        while (rs.next()) {
            nama = rs.getString("nama");
            tgl_masuk = rs.getString("tgl_masuk");
            jam_masuk = rs.getString("jam_masuk");
            jam_keluar = rs.getString("jam_keluar");
            telat = rs.getString("telat");
        }
        con.close();
        return nama;
    }
}
