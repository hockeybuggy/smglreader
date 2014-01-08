package toke;

public class Tag {
    private String name;
    private Boolean opening; // True if name does not start with /
    private int start;
    private int end;

    public Tag(String name, int start, int end){
        this.name = name;
        this.opening = (name.charAt(0) != '/');
        this.start = start;
        this.end = end;
    }

    public String getName(){
        return this.name;
    }

    public Boolean isOpen(){
        return this.opening;
    }

    public String toString(){
        return String.format("%s found at: %d to %d", this.name, this.start, this.end);
    }
}
