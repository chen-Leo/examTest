 package  Level1_2;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        String filePath = "students.txt";
        Student[] students = null;
      Scanner scan = new Scanner(System.in);
       String sid = scan.next();
        try {
           students = FileUtil.parseStudents(filePath);
        } catch (IOException e) {
        e.printStackTrace();
        }
         find(students, sid);
//        findMost(students);
    }


    public static void find(Student[] stduents, String sid) {
        int model = 0;
        int n;
        for (n = 0; n < stduents.length; n++) {
            if (stduents[n].getStuid().equals(sid)) {
                model = 1;
                break;
            }
        }
        if (model == 1) {
            System.out.println(stduents[n].getName());
        } else System.out.print("not find");
    }


    public static void findMost(Student[] students) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        int a[] = null;
        int n = 0;
        for (Student stu : students) {
            a[n] = Integer.parseInt(stu.getStuid());
            n++;
        }
        for (int i = 0; i < a.length; i++) {
            if (map.containsKey(a[i])) {
                int temp = map.get(a[i]);

                map.put(a[i], temp + 1);
            } else {
                map.put(a[i], 1);
            }
        }
        Collection<Integer> count = map.values();
        int maxCount = Collections.max(count);
        int maxNumber = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (maxCount == entry.getValue()) {
                maxNumber = entry.getKey();
            }
        }
        System.out.println("出现次数最多为：" + students[maxNumber].getName());
        System.out.println("该一共出现" + maxCount + "次");
    }

}

