package lastprt;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Scanner;

public class user  implements Serializable{
    private String user_password;
    private String user_id;
    private int mark;
    private boolean have_answer=false;
    private boolean is_manager=false;//是否为管理员账号
    public user (String user_id,String user_password){
        this.user_password=user_password;
        this.user_id=user_id;
    }
    public String toString(){
        return user_id+user_password;
    }
    public String get_user_id(){
        return user_id;
    }
    public  String get_user_password(){
        return user_password;
    }
    public void set_user_mark(int mark){
        this.mark=mark;
    }
    public int get_user_mark(){
        return this.mark;
    }
    public void set_have_answer(boolean a){
        this.have_answer=a;
    }
    public boolean get_have_answer(){
        return this.have_answer;
    }
    public boolean get_is_manager(){
        return is_manager;
    }
    public void set_is_manager(boolean a){
        this.is_manager=a;
    }
    public void set_user_passwrod(String a){
        this.user_password=a;

    }
    public boolean deleteAccount(String user_id){
            Scanner input = new Scanner(System.in);
            File file=new File(user_id+".txt");
            if(file.exists()){
                System.out.println("您确定要删除该用户信息吗？（请输入“是”或“否”）");
                String answer =input.nextLine();
                if(answer.equals("是")){
                    file.delete();
                    System.out.println("删除成功!");
                    input.close();
                    return true;
                }
                
                else{
                    input.close();
                    return true;
                    
                }
                
                    
            }
            else{
                System.out.println("该用户名并不存在，请重新输入!");
                input.close();
                return false;
            }
        

    }
    public boolean set_manager(String user_id) throws FileNotFoundException, IOException, ClassNotFoundException{
        Scanner input = new Scanner(System.in);
            try{
                
                ObjectInputStream ois = new ObjectInputStream(new FileInputStream(user_id+".txt"));
                
                user user1=(user)ois.readObject();
                ois.close();
                ObjectOutputStream oos =new ObjectOutputStream(new FileOutputStream(user_id+".txt",false));
                if(!user1.get_is_manager()){
                    System.out.println("您确定要设定该用户为管理员吗？（请输入“是”或“否”）");
                String answer =input.nextLine();
                while(true){
                    if(answer.equals("是")){

                        user1.set_is_manager(true);
                        oos.writeObject(user1);
                        oos.close();
                        System.out.println("更改成功!");
                        return true;
                       
                    } 
                    else if(answer.equals("否")){
                        oos.close();
                        return true;  
                    }
                    else{
                        System.out.println("输入格式有误,请重新输入!");
                    }
                }
                
                }
                else{
                    System.out.println("该用户已经为管理员用户!");
                    ois.close();
                    oos.close();
                    input.close();
                    return true;
                }
                
                    
            }
            catch(Exception  ex){
                System.out.println("该用户名并不存在，请重新输入!");
                input.close();
                return false;

            }
     
        
            
        
    
    

    }
    public boolean set_password(String user_id) throws FileNotFoundException, IOException, ClassNotFoundException{
            Scanner input = new Scanner(System.in);
            try{
                System.out.println("请输入该用户新密码!");
                String new_password=input.nextLine();
                ObjectInputStream ois = new ObjectInputStream(new FileInputStream(user_id+".txt"));
                user user1=(user)ois.readObject();
                ois.close();
                ObjectOutputStream oos =new ObjectOutputStream(new FileOutputStream(user_id+".txt",false));
                
                System.out.println("您确定要更改该用户密码吗？（请输入“是”或“否”）");
                String answer =input.nextLine();
                while(true){
                    if(answer.equals("是")){
                        user1.set_user_passwrod(new_password);
                        oos.writeObject(user1);
                        oos.close();
                        System.out.println("更改成功!");
                        return true;
                       
                    } 
                    else if(answer.equals("否")){
                        oos.close();
                        input.close();
                        return true;  
                    }
                    else{
                        System.out.println("输入格式有误,请重新输入!");
                    }

                }
                
                    
            }
            catch(Exception ex){
                System.out.println("该用户名并不存在，请重新输入!");
                return false;

            }
        
        
            
        
    
    

    }
}
