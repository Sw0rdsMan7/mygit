package javaprt12;

public class product {
    private String name;
    private String number;
    private String publish;
    product(String name,String number,String publish){
        this.name=name;
        this.number=number;
        this.publish=publish;

    }
    public String toString(){
        return number+" "+name+" "+publish+"\n";
    }
    public String getnumber(){
        return this.number;
    }
}
