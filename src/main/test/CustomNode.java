public class CustomNode {
    public String name;



    public CustomNode(String name){
        this.name = name;


    }

    public String getName() {
        return name;
    }



    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        CustomNode other = (CustomNode) obj;
        return name.equals(other.name);
    }

    public int hashCode(){
        return name.hashCode();
    }

    public String toString() {
        return name;
    }



}
