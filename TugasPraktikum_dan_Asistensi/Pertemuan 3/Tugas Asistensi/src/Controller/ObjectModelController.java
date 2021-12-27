package Controller;

import Model.AdminModel;
import Model.PembeliModel;
import Model.TransaksiModel;

public class ObjectModelController {
    public static PembeliModel pembeliMo = new PembeliModel();
    public static TransaksiModel transaksiMo = new TransaksiModel();
    public static AdminModel adminMo = new AdminModel();
    public static TransaksiController transaksiCon = new TransaksiController();
    public static PembeliController pembeliCon = new PembeliController();
    public static AdminContorller AdminCon = new AdminContorller();

}