package LeveL5;

public class Store {

    private String name;
    private Goods[] Goods;

    public Store (String name ,Goods[] Goods){
        this.name = name;
        this.Goods = Goods;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LeveL5.Goods[] getGoods() {
        return Goods;
    }

    public void setGoods(LeveL5.Goods[] goods) {
        Goods = goods;
    }
}
