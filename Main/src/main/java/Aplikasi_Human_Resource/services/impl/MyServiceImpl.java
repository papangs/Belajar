package Aplikasi_Human_Resource.services.impl;

import Aplikasi_Human_Resource.dto.Menu;
import Aplikasi_Human_Resource.services.MyService;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS)
public class MyServiceImpl implements MyService<Menu> {

    private JdbcTemplate jdbcTemplate;
//    private List<Menu> carList = new LinkedList<Menu>();

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    @Transactional
    public void saveMenus(Menu save) {
        String query = "INSERT INTO menu_coba (nama, jabatan) values (?,?)";
        jdbcTemplate.update(query, new Object[]{save.getNama_menu(), save.getJabatan()});
    }

//    public int updateMenu(Menu update) {
//        String query = "update menu_coba set name='" + update.getNama_menu() + "', " +
//                "jabatan='" + update.getJabatan() + "' where id='" + update.getId() + "'";
//        return (jdbcTemplate.update(query));
//    }
//
//    public int deleteMenu(Menu delete) {
//        String query = "delete from menu_coba where id = '" + delete.getId() + "'";
//        return (jdbcTemplate.update(query));
//    }

//    public List<Menu> findAll() {
//        return carList;
//    }
//
//    public List<Menu> search(String keyword) {
//        List<Menu> result = new LinkedList<Menu>();
//        if (keyword == null || "".equals(keyword)) {
//            result = carList;
//        } else {
//            for (Menu c : carList) {
//                if (c.getNama_menu().toLowerCase().contains(keyword.toLowerCase())
//                        || c.getJabatan().toLowerCase().contains(keyword.toLowerCase())) {
//                    result.add(c);
//                }
//            }
//        }
//        return result;
//    }
}
