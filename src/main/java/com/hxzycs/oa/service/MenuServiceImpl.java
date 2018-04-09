package com.hxzycs.oa.service;

import org.springframework.stereotype.Service;

import com.hxzycs.oa.dao.MenuDao;
import com.hxzycs.oa.entity.Menu;
import com.hxzycs.oa.pojo.CrudServiceImpl;
@Service("menuService")
public class MenuServiceImpl extends CrudServiceImpl<MenuDao, Menu> implements MenuService{

}
