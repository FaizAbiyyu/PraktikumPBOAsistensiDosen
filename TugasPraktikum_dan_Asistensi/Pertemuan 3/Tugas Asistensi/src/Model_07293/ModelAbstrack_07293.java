package Model_07293;

import Helper_07293.KoneksiDB_07293;

import java.sql.Connection;

public abstract class ModelAbstrack_07293 {
    public String sql;
    Connection conn = KoneksiDB_07293.getconnection();
}
