package models;

public class Connection {

    private Boolean connectsBeginning;
    private Integer beginningCharacters;
    private Boolean connectsEnding;
    private Integer endingCharacters;

    public Connection() {
    }

    public Connection(Boolean connectsBeginning, Integer beginningCharacters, Boolean connectsEnding, Integer endingCharacters) {
        this.connectsBeginning = connectsBeginning;
        this.beginningCharacters = beginningCharacters;
        this.connectsEnding = connectsEnding;
        this.endingCharacters = endingCharacters;
    }

    public Boolean connectsBeginning() {
        return connectsBeginning;
    }

    public void setConnectsBeginning(Boolean connectsBeginning) {
        this.connectsBeginning = connectsBeginning;
    }

    public Boolean connectsEnding() {
        return connectsEnding;
    }

    public void setConnectsEnding(Boolean connectsEnding) {
        this.connectsEnding = connectsEnding;
    }

    public Integer getBeginningCharacters() {
        return beginningCharacters;
    }

    public void setBeginningCharacters(Integer beginningCharacters) {
        this.beginningCharacters = beginningCharacters;
    }

    public Integer getEndingCharacters() {
        return endingCharacters;
    }

    public void setEndingCharacters(Integer endingCharacters) {
        this.endingCharacters = endingCharacters;
    }

    @Override
    public String toString() {
        return "Connection{" +
                "connectsBeginning=" + connectsBeginning +
                ", beginningCharacters=" + beginningCharacters +
                ", connectsEnding=" + connectsEnding +
                ", endingCharacters=" + endingCharacters +
                '}';
    }
}
