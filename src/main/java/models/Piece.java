package models;

import java.util.ArrayList;
import java.util.List;

public class Piece {

    private String pieceString;
    // List with indexes of pieces that can merge on any side
    private List<Integer> connectsAny;
    // List with indexes of pieces that can merge at the beginning
    private List<Edge> connectsFrom;
    // List with indexes of pieces that can merge at the end
    private List<Edge> connectsTo;

    public Piece() {
    }

    public Piece(String pieceString) {
        this.pieceString = pieceString;
        this.connectsAny = new ArrayList();
        this.connectsFrom = new ArrayList();
        this.connectsTo = new ArrayList();
    }

    public String getPieceString() {
        return pieceString;
    }

    public void setPieceString(String pieceString) {
        this.pieceString = pieceString;
    }

    public List<Integer> getConnectsAny() {
        return connectsAny;
    }

    public void setConnectsAny(List<Integer> connectsAny) {
        this.connectsAny = connectsAny;
    }

    public List<Edge> getConnectsFrom() {
        return connectsFrom;
    }

    public void setConnectsFrom(List<Edge> connectsFrom) {
        this.connectsFrom = connectsFrom;
    }

    public List<Edge> getConnectsTo() {
        return connectsTo;
    }

    public void setConnectsTo(List<Edge> connectsTo) {
        this.connectsTo = connectsTo;
    }

    @Override
    public String toString() {
        return "Piece{" +
                "pieceString='" + pieceString + '\'' +
                ", connectsAny=" + connectsAny +
                ", connectsFrom=" + connectsFrom +
                ", connectsTo=" + connectsTo +
                '}';
    }
}
