public class XMLDoc {

    private Element root;

    public XMLDoc(String name){
        this.root = new Element(name);
    }

    public void addToDoc(Element e){
        this.root.addSub(e);
    }

    public void printDoc(){
        this.root.printElement();
    }

    public static void main(String[] args) {
        XMLDoc doc = new XMLDoc("course");

        Element code = new Element("code");
        code.setText("SYSC3110");
        doc.addToDoc(code);


        Element prof = new Element("prof");
        prof.setText("Babak");
        doc.addToDoc(prof);


        Element classEle = new Element("class");
        Element student1 = new Element("student");
        student1.setText("Michael");
        classEle.addSub(student1);
        Element student2 = new Element("student");
        student2.setText("Alan");
        classEle.addSub(student2);

        doc.addToDoc(classEle);

        doc.printDoc();
    }
}
