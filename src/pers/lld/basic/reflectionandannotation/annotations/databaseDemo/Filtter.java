package pers.lld.basic.reflectionandannotation.annotations.databaseDemo;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

@Table("user")
public class Filtter {
    @Column("id")
    private int id;
    @Column("userName")
    private String userName;
    @Column("nickName")
    private String nickName;
    private int age;
    private String city;
    @Column("Email")
    private String email;

    public int getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        email = email;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String naickName) {
        this.nickName = naickName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    private static String query(Filtter f) {
        StringBuilder sb = new StringBuilder();
        // 1.获取到Class 对象
        Class c = f.getClass();
        // 2.获取到table的名字
        boolean exists = c.isAnnotationPresent(Table.class);

        if (!exists) {
            return null;

        }
        Table t = (Table) c.getAnnotation(Table.class);
        String tableName = t.value();

        sb.append("select * from ").append(tableName).append(" where1=1 ");

        // 3.历遍所有的字段
        Field[] fArray = c.getDeclaredFields();
        for (Field field : fArray) {
            // 4.处理每个字段对应的sql
            // 4.1拿到字段名
            boolean fExists = field.isAnnotationPresent(Column.class);
            if (!fExists) {
                continue;

            }
            Column column = field.getAnnotation(Column.class);
            String columnName = column.value();
            // 4.2拿到字段的值
            String filedName = field.getName();
            String getMethodName = "get" + filedName.substring(0, 1).toUpperCase() + filedName.substring(1);
            Object fieldValue = null;
            //调用对应的get方法，获取当前的数值
            try {
                Method getMethod = c.getMethod(getMethodName);

                fieldValue = getMethod.invoke(f);

            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            // 4.3拼装sql
            if (fieldValue == null || (fieldValue instanceof Integer && (Integer) fieldValue == 0)) {
                continue;
            }
            sb.append(" and ").append(filedName);
            if (fieldValue instanceof String) {
                if (((String) fieldValue).contains(",")) {// 代表子查询
                    String[] values = ((String) fieldValue).split(",");
                    sb.append(" in(");
                    for (String v : values) {
                        sb.append("'").append(v).append("'").append(",");
                    }
                    sb.deleteCharAt(sb.length() - 1);
                    sb.append(")");
                } else {
                    sb.append("=").append("\"").append(fieldValue).append("\"");
                }
            } else {
                sb.append("=").append(fieldValue);
            }
        }

        return sb.toString();

    }

    public static void main(String[] args) {
        Filtter filtter = new Filtter();
        filtter.setNickName("lld");
        String str = query(filtter);
        System.out.println(str);
    }


}


/**
 * 创建一个table注解
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@interface Table {
    String value();
}

/**
 * Column，用于标记元素
 */
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@interface Column {
    String value();
}