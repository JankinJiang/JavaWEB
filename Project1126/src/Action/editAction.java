package Action;

import Dao.impl.UserEntityDaoimpl;
import Entity.UserEntity;
import com.opensymphony.xwork2.ActionSupport;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.List;

public class editAction extends ActionSupport {
    private int id = -1;
    private String name;
    private String sex;
    private String phone;
    private String identity;
    private UserEntityDaoimpl userEntityDaoimpl = new UserEntityDaoimpl();

    private List<UserEntity> users = new ArrayList<UserEntity>();
    private boolean issuccess = false;

    public String addUser(){
        System.out.println("adduser execute~");
        UserEntity userEntity = new UserEntity();
        userEntity.setId(id);
        userEntity.setName(name);
        userEntity.setSex(sex);
        userEntity.setPhone(phone);
        userEntity.setIdentity(identity);
        if(userEntityDaoimpl.addUser(userEntity)){
            Find();
            System.out.println("add success~");
            return "editsuccess";
        }
        return "error";
    }

    public String delUser(){
        if(userEntityDaoimpl.delUserByid(id)){
            Find();
            System.out.println("del success~");
            return "editsuccess";
        }else
            return "error";
    }

    private UserEntity userEntity;
    public String findUser(){
        if(id!=-1){
            userEntity = userEntityDaoimpl.getByid(id);
            users.add(userEntity);
            //this.users.set(users.size(),userEntity);
            System.out.println("findbyid success~");
            return "findsuccess";
        }else if(!name.isEmpty()){
            userEntity = userEntityDaoimpl.getByname(name);
            users.add(userEntity);
            //this.users.set(users.size(),userEntity);
            System.out.println("findbyname success~");
            return "findsuccess";
        }else if(!phone.isEmpty()){
            userEntity = userEntityDaoimpl.getByphone(phone);
            users.add(userEntity);
            //this.users.set(users.size(),userEntity);
            System.out.println("findbyphone success~");
            return "findsuccess";
        }else if(!sex.isEmpty()){
            users = userEntityDaoimpl.getBysex(sex);
            //users.add(userEntity);
            //this.users.set(users.size(),userEntity);
            System.out.println("findbysex success~");
            return "findsuccess";
        }
        return "error";
    }

    public String updtUser(){
        UserEntity userEntity = new UserEntity();
        userEntity.setId(id);
        userEntity.setName(name);
        userEntity.setSex(sex);
        userEntity.setPhone(phone);
        userEntity.setIdentity(identity);
        if(userEntityDaoimpl.updateUser(userEntity)){
            Find();
            System.out.println("updt success~");
            return "editsuccess";
        }else
            return "error";
    }

    public boolean Find(){
        SessionFactory sessionFactory = new Configuration().configure("/hibernate.cfg.xml").buildSessionFactory();
        Session session = sessionFactory.openSession();
        System.out.println("===find");
        try {
            setUsers((List<UserEntity>)session.createQuery("from UserEntity ").list());
//            users = (List<UserEntity>)session.createQuery("from UserEntity ").list();
            session.close();
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    public void setIssuccess(boolean issuccess) {
        this.issuccess = issuccess;
    }

    public List<UserEntity> getUsers() {
        return users;
    }

    public void setUsers(List<UserEntity> users) {
        this.users = users;
    }

    public void setUserEntityDaoimpl(UserEntityDaoimpl userEntityDaoimpl) {
        this.userEntityDaoimpl = userEntityDaoimpl;
    }

    public List<UserEntity> getUserEntities() {
        return users;
    }

    public UserEntityDaoimpl getUserEntityDaoimpl() {
        return userEntityDaoimpl;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setIdentity(String identity) {
        this.identity = identity;
    }

    public String getSex() {
        return sex;
    }

    public String getPhone() {
        return phone;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public String getIdentity() {
        return identity;
    }
}
