package service;

import dao.UserDao;
import domain.PageBean;
import domain.User;

import java.util.Map;

public class PageService {

    UserDao dao = new UserDao();

    public PageBean<User> PageShow(int currentPage,int pageSize){
        PageBean<User> pb = new PageBean<User>();
        //设置当前页面
        pb.setCurrentPage(currentPage);
        //设置每页显示条数
        pb.setPageSize(pageSize);
        //设置总记录数
        int totalCount = dao.findTotalCount();
        pb.setTotalCount(totalCount);
        //设置当前页显示的数据集合

        int start = (currentPage - 1) * pageSize;
        pb.setList(dao.findByPage(start,pageSize));

        //总页数
        int totalPage = totalCount % pageSize == 0 ? totalCount / pageSize : (totalCount / pageSize) + 1;
        pb.setTotalPage(totalPage);
        return pb;
    }

    public PageBean<User> queryPage(int currentPage, int pageSize, Map<String, String[]> wd ) {
        PageBean<User> pb = new PageBean<User>();
        //设置当前页面
        pb.setCurrentPage(currentPage);
        //设置每页显示条数
        pb.setPageSize(pageSize);
        //设置总记录数
        int totalCount = dao.findTotalCount(wd);
        pb.setTotalCount(totalCount);
        //设置当前页显示的数据集合

        int start = (currentPage - 1) * pageSize;
        pb.setList(dao.findByPage(start,pageSize,wd));

        //总页数
        int totalPage = totalCount % pageSize == 0 ? totalCount / pageSize : (totalCount / pageSize) + 1;
        pb.setTotalPage(totalPage);
        return pb;
    }
}
