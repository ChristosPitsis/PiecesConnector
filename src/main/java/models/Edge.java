package models;

public class Edge {

    private Integer index;
    private Integer weight;

    public Edge(Integer index, Integer weight) {
        this.index = index;
        this.weight = weight;
    }

    public Integer getIndex() {
        return index;
    }

    public void setIndex(Integer index) {
        this.index = index;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Edge{" +
                "index=" + index +
                ", weight=" + weight +
                '}';
    }
}
