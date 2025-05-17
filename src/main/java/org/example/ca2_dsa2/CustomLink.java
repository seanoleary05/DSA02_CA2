package org.example.ca2_dsa2;

public class CustomLink {
    private CustomNode from;
    private CustomNode to;
    private String line;
    private String color;


    public CustomLink(CustomNode from, CustomNode to, String line, String color) {
        this.from = from;
        this.to = to;
        this.line = line;
        this.color = color;
    }

    public CustomNode getFrom() { return from; }
    public CustomNode getTo() { return to; }
    public String getLine() { return line; }
    public String getColor() { return color; }


    @Override
    public String toString() {
        return from + " -> " + to + " (" + line + ", " + color + ")";
    }
}
