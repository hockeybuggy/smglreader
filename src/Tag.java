package toke;

public class Tag{
    private String name;
    private String value;
    //TODO all tags can have Tag children

    public Tag(String name, String value){
        this.name = name;
        this.value = value;
    }
    public String toString(){
        return this.name + ": " +this.value;
    }
}
