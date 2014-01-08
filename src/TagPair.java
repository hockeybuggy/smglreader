package toke;
import java.util.ArrayList;

public class TagPair {
    private Tag open;
    private Tag close;
    private String body;
    private ArrayList<TagPair> children = new ArrayList<TagPair>();

    public TagPair(Tag open){
        this.open = open;
    }

    public TagPair(Tag open, Tag close){
        this.open = open;
        this.close = close;
    }

    public void addChild(TagPair child){
        this.children.add(child);
    }

    public void setClose(Tag close){
        if (this.close == null){
            this.close = close;
        }
    }

    public String toString(){
        return String.format("Tag: %s", this.open.getName());
    }
}
