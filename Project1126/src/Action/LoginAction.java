package Action;

import Entity.UserEntity;
import Utils.HibernateSessionFactory;
import com.opensymphony.xwork2.ActionSupport;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class LoginAction extends ActionSupport {
    private UserEntity user;
    List<UserEntity> users;

    @Override
    public void validate() {
        System.out.println("validate~");
    }
//    这个不起作用
    public void validateExecute(){
        try{
            if(user.getName()==null || user.getName().isEmpty()){
                addFieldError("user.name","用户名不能为空！");
            }
            if(user.getIdentity()==null || user.getIdentity().isEmpty()){
                addFieldError("user.password","密码不能为空！");
            }
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    @Override
    public String execute() throws Exception {
        int flag = isidentity();
        //int flag = 1;
        if(flag>0){
            System.out.println("Login success!");
            this.users = Find();
            if(flag==1){
                System.out.println("admin login~");
                return "admin";
            }
            else{
                System.out.println("user login~");
                return "user";
            }
        }else{
            //添加消息框弹出
            this.addActionMessage("未查到此成员，请联系管理员添加信息！");
            return ERROR;
        }
    }

    public List<UserEntity> Find(){
        List<UserEntity> userEntities = null;
        SessionFactory sessionFactory = new Configuration().configure("/hibernate.cfg.xml").buildSessionFactory();
        Session session = sessionFactory.openSession();
        System.out.println("===find");
        userEntities = (List<UserEntity>)session.createQuery("from UserEntity ").list();
        session.close();
//        for(int i=0; i<userEntities.size(); ++i){
//            System.out.println(userEntities.get(i).getName()+" "+userEntities.get(i).getSex());
//        }
        return userEntities;
    }

    public int isidentity(){
        UserEntity userEntity = null;
        Session session = HibernateSessionFactory.getSession();
        Transaction tx = session.beginTransaction();
        userEntity = (UserEntity)session.createQuery("from UserEntity where name = '"+user.getName()+"'").uniqueResult();
        tx.commit();
        System.out.println(user.getName());
        System.out.println(user.getIdentity());
        System.out.println(userEntity.getName());
        System.out.println(userEntity.getIdentity());
        if(userEntity.getIdentity().equals(user.getIdentity())){
            if(user.getIdentity().equals("admin")){
                return 1;
            }else{
                return 2;
            }
        }
        session.close();
        return 0;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }

    public UserEntity getUser() {
        return user;
    }

    public List<UserEntity> getUsers() {
        return users;
    }

    public void setUsers(List<UserEntity> users) {
        this.users = users;
    }

}
