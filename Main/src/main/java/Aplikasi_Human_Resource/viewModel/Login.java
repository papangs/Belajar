package Aplikasi_Human_Resource.viewModel;

import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.NotifyChange;
import org.zkoss.zk.ui.Executions;

import java.io.IOException;

public class Login {

    private String username;
    private String password;

    @Command
    @NotifyChange({"username", "password"})
    public void logIn() throws IOException {

//	if(loginCheck(username, password)){
//		Messagebox.show("login berhasil");
//		Executions.sendRedirect("index.zul");
//	}else Messagebox.show("login gagal");

//        Messagebox.show("login berhasil");
        Executions.sendRedirect("index.zul");

    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
