package LeveL5;

import Level1_2.Student;

public class Stuer extends Student {
    private int grade;
    public Stuer(String stuid, String name,int grade) {
        super(stuid,name);
        this.grade =grade;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }
//买东西
    public void buy(Goods good,Store store) {
        for (Goods g: store.getGoods()
             ) {
            if ( g.getGodName().equals(good.getGodName()) ) {
                this.grade = grade - good.getPrice();
            }
        }
    }
}


