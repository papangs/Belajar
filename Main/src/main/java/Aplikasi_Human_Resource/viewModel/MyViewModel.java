package Aplikasi_Human_Resource.viewModel;

import Aplikasi_Human_Resource.services.impl.MyServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.Init;
import org.zkoss.bind.annotation.NotifyChange;
import org.zkoss.zk.ui.select.annotation.VariableResolver;
import org.zkoss.zk.ui.select.annotation.WireVariable;

@VariableResolver(org.zkoss.zkplus.spring.DelegatingVariableResolver.class)
public class MyViewModel {

//    @Wire
//    TextBox misal;

    ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");

    @WireVariable
    private MyServiceImpl dao;
    private int answer;

    @Init
    public void init() {
        answer = 0;
        dao = (MyServiceImpl) ctx.getBean("pank");
    }

    @Command
    @NotifyChange("answer")
    public void cmd() {
//        org.zkoss.zul.Messagebox.show(misal/)
//        answer = dao.saveMenus(new Menu("Irawan", "Bos"));
    }

    public int getAnswer() {
        return answer;
    }
}
