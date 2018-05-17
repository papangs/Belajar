package Aplikasi_Human_Resource.viewModel;

import Aplikasi_Human_Resource.dto.Menu;
import Aplikasi_Human_Resource.services.MyService;
import org.zkoss.bind.annotation.*;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zk.ui.select.Selectors;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zk.ui.select.annotation.WireVariable;
import org.zkoss.zul.Textbox;
import org.zkoss.zul.Window;

public class Usulan_Dan_KenaikanVM extends SelectorComposer<Window> {

//    @Wire("#win")
//    private Window win;

    @WireVariable
    private MyService service;

    @Wire
    Textbox nama;

    @Wire
    Textbox jabatan;

//    @Init
//    public void init(@ContextParam(ContextType.VIEW) Component view,
//                     @ExecutionArgParam("map") HashMap<String, Object> map) {
//        Selectors.wireComponents(view, this, false);
////        this.nama = "";
//    }

    @AfterCompose
    public void afterCompose(@ContextParam(ContextType.VIEW) Component view){
        Selectors.wireComponents(view, this, false);
    }

    @Command
    @NotifyChange("menuList")
    public void save() {
        Menu menu = new Menu();
        menu.setNama_menu(nama.getValue());
        menu.setJabatan(jabatan.getValue());

        service.saveMenus(menu);
    }

}