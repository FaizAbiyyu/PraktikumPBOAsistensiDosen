package Model;

import Helper.KoneksiDB;

import java.sql.Connection;

public abstract class ModelAbstrack {
    public String sql,sql2;
    Connection conn = KoneksiDB.getconnection();

//    public abstract void updatePassword(String password, int id);
//    public abstract int cekLogin(String npm, String password);
}
