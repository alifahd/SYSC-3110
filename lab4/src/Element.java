import java.util.ArrayList;

public class Element {
    private String tag;
    private String text;
    private ArrayList<Element>  subElements = new ArrayList<Element>();

    public Element(String tag){
        this.tag = tag;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void addSub(Element e){
        this.subElements.add(e);
    }

    public void printElement(){
        if(this.text == null){
            System.out.println(getTag());
            for (Element e : subElements){
                e.printElement();
            }
            System.out.println(getEndTag());
        }else{
            System.out.println(getPrint());
        }
    }

    public String getTag(){ return "<"+tag+">"; }
    public String getEndTag(){
        return "</"+this.tag+">";
    }
    public String getPrint(){
        return "<" + this.tag + ">" + this.text + "</" + this.tag + ">";
    }


}
