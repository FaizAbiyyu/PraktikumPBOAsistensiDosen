package Model_07293;

import Helper_07293.KoneksiDB_07293;

import java.sql.Connection;

public abstract class ModelAbstrack_07293 {
    public String sql,sql2;
    Connection conn = KoneksiDB_07293.getconnection();

//    public abstract void updatePassword(String password, int id);
//    public abstract int cekLogin(String npm, String password);
}
