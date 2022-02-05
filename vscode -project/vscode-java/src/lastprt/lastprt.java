package lastprt;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;

public class lastprt {
    public static void zhuce() throws FileNotFoundException, IOException, ClassNotFoundException {
        String user_id;
        String user_password;
        String answer;
        Scanner input = new Scanner(System.in);
        System.out.print("请输入您的用户名:");
        user_id = input.nextLine();
        try { // 检测该用户名是否已经注册
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(user_id + ".txt"));
            System.out.println("该用户名已被注册!请尝试登录或重新输入用户名");
            System.out.println("1.重新输入用户名");
            System.out.println("2.进行登录");
            
            while (true) {
                answer = input.next();
                if (answer.equals("1")) {
                    ois.close();
                    zhuce();
                    break;
                } else if (answer.equals("2")) {
                    ois.close();
                    return;
                } else {
                    System.out.println("输入格式有误! 请重新输入!");
                }
                
            }

        } catch (FileNotFoundException ex) {
            System.out.print("请输入您的密码:");
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(user_id + ".txt"));
            user_password = input.nextLine();
            user user1 = new user(user_id, user_password);
            oos.writeObject(user1);
            oos.close();
            System.out.println("注册成功!请尝试登录!");
        }
        input.close();

    }

    public static user denglu() throws FileNotFoundException, ClassNotFoundException, IOException {

        String user_id;
        String user_password;
        String answer;
        Scanner input = new Scanner(System.in);
        System.out.print("请输入您的用户名:");
        user_id = input.next();
        user user1;
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(user_id + ".txt")); // 检测该用户名是否已经注册
            user1 = (user) ois.readObject();
            while (true) {
                System.out.print("请输入密码:");
                user_password = input.next();
                if (user_password.equals(user1.get_user_password()))
                    break;
                else
                    System.out.println("密码输入错误请重新输入!");
            }
            ois.close();
            return user1;
        } catch (FileNotFoundException ex) {
            System.out.println("未检测到指定用户名，请选择重新输入用户名或进行注册!（请输入'1' 或'2'）");
            System.out.println("1.重新输入用户名");
            System.out.println("2.进行注册");
            while (true) {
                answer = input.next();
                if (answer.equals("1")) {
                    user1 = denglu();
                    break;
                } else if (answer.equals("2")) {
                    zhuce();
                    user1 = denglu();
                    break;
                } else {
                    System.out.println("输入格式有误! 请重新输入!");
                }

            }
        }
        input.close();
        return user1;
    }

    public static void answermod(user user1) throws IOException {
        Scanner input = new Scanner(System.in);
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(user1.get_user_id() + ".txt"));
        // byte[] bs = new byte[10240];
        // BufferedInputStream i = new BufferedInputStream(new
        // FileInputStream("test.txt"));
        // i.read(bs);
        // String line = new String(bs, "UTF-8");
        // System.out.println(line);
        // i.close();
        int mark = 0;
        BufferedReader bufferedReader = new BufferedReader(
                new InputStreamReader(new FileInputStream("test.txt"), "UTF-8"));
        String a = bufferedReader.readLine();
        String answer;
        while (a != null) {
            if (!a.startsWith("答案")) {
                System.out.println(a);
                a = bufferedReader.readLine();
            } else {
                System.out.print("请输入答案:");
                answer = input.nextLine();
                if (answer.equals(a.substring(3)))
                    mark += 5;
                a = bufferedReader.readLine();
            }
        }
        System.out.printf("\n\n您本次的成绩为:%d\n", mark);
        user1.set_have_answer(true);
        if (user1.get_user_mark() < mark)
            user1.set_user_mark(mark);
        oos.writeObject(user1);
        oos.close();
        bufferedReader.close();
        input.close();
    }
    public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
        System.out.print("欢迎使用《学党史，知党情，跟党走》系统! \n请问你是否已经注册过账户呢？\n请输入“是” 或 “否” :");
        String answer;
        user user1 = new user("1", "2");
        Scanner input = new Scanner(System.in);
        while (true) { // 登录模块（含注册）
            answer = input.nextLine();
            if (answer.equals("是")) {
                user1 = denglu();
                break;
            } else if (answer.equals("否")) {
                zhuce();
                user1 = denglu();
                break;
            } else {
                System.out.println("输入格式有误! 请重新输入!");
            }
        }

        if (!user1.get_is_manager()) {
            System.out.println("欢迎您的到来!尊敬的" + user1.get_user_id() + "用户\n请输入“1”或“2”或“3”进入指定功能");

            while (true) { // 答题模块
                System.out.println("1.开始答题\n2.查询历史最高得分\n3.退出系统");
                answer = input.nextLine();
                if (answer.equals("1")) {

                    answermod(user1);
                } else if (answer.equals("2")) {
                    if (user1.get_have_answer()) {
                        System.out.printf("您的历史最高的分为:%d\n", user1.get_user_mark());
                        System.out.println("1.再次答题\n2.退出系统");
                        while (true) {
                            answer = input.nextLine();
                            if (answer.equals("1")) {

                                answermod(user1);
                                break;

                            } else if (answer.equals("2")) {
                                input.close();
                                System.exit(0);
                            } else {
                                System.out.println("输入格式有误! 请重新输入!");
                            }
                        }
                    }

                    else {
                        System.out.println("您尚未进行过答题!");
                        System.out.println("1.开始答题\n2.退出系统");

                        while (true) {
                            answer = input.nextLine();
                            if (answer.equals("1")) {

                                answermod(user1);
                                break;

                            } else if (answer.equals("2")) {
                                input.close();
                                System.exit(0);
                            } else {
                                System.out.println("输入格式有误! 请重新输入!");
                            }

                        }

                    }
                } else if (answer.equals("3")) {
                    input.close();
                    System.exit(0);
                } else {
                    System.out.println("输入格式有误! 请重新输入!");
                }
            }

        }

        else { // 管理员模式
            System.out.println("欢迎您的到来!尊敬的" + user1.get_user_id() + "管理员用户");

            while (true) {
                System.out.println("1.删除用户\n2.更改用户密码\n3.给予管理员权限\n4.退出系统");
                answer = input.nextLine();
                if (answer.equals("1")) {
                    while (true) {
                        System.out.print("请输入需要删除的用户名:");
                        String user_id = input.nextLine();
                        if (user1.deleteAccount(user_id)) {
                            break;
                        } else
                            ;
                    }

                } else if (answer.equals("2")) {
                    while (true) {
                        System.out.print("请输入需要更改密码的用户名:");
                        String user_id = input.nextLine();
                        if (user1.set_password(user_id)) {
                            break;
                        } else
                            ;
                    }
                } else if (answer.equals("3")) {
                    while (true) {
                        System.out.print("请输入需要给予权限的用户名:");
                        String user_id = input.nextLine();
                        if (user1.set_manager(user_id)) {
                            break;
                        } else
                            ;
                    }
                } else if (answer.equals("4")) {
                    input.close();
                    System.exit(0);
                } else {
                    System.out.println("输入格式有误!请重新输入");
                    
                }
            }

        }

    }
}