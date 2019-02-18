package controllers;

import models.Connection;
import models.Edge;
import models.Piece;
import utils.Utils;

import java.util.List;

public class ConnectionController {

    private List<String> piecesList;
    private static Utils utils = new Utils();

    public ConnectionController(List<String> piecesList) {
        this.piecesList = piecesList;
    }

    /**
     * <p>This method returns a Piece Object for a specific element of the list
     * with all the possible connections from and to that piece</p>
     * @param pieceIndex
     * @return a Piece Object
     */
    public Piece findConnectionsForPiece(Integer pieceIndex) {

        Piece piece = new Piece(this.piecesList.get(pieceIndex));

        // Iterate the list to find any possible connections
        for (int i = 0; i < this.piecesList.size(); i++) {
            // Skip itself
            if (i == pieceIndex)
                continue;

            // Check if it can merge and how with any other piece
            Connection canMerge = checkMerge(piece.getPieceString(), this.piecesList.get(i));
            if (canMerge.connectsBeginning()) {
                // Probably we don't need the weight here as we use it only to find the Beginning piece
                piece.getConnectsFrom().add(new Edge(i, canMerge.getBeginningCharacters()));
            }

            if (canMerge.connectsEnding()) {
                piece.getConnectsTo().add(new Edge(i, canMerge.getEndingCharacters()));
            }

            if (canMerge.connectsEnding() || canMerge.connectsBeginning()) {
                piece.getConnectsAny().add(i);
            }
        }

        return piece;
    }

    /**
     * <p>This method returns a Connection Object
     * if string a can connect to b, how and the "merge weight"</p>
     * @param a
     * @param b
     * @return a Connection type Object
     */
    private Connection checkMerge(String a, String b) {

        // First check if a can extend b
        Integer connectsBeginningWeight = utils.canExtend(b, a);
        // Then check if b can extend a
        Integer connectsEndingWeight = utils.canExtend(a, b);

        return new Connection(connectsBeginningWeight > 0, connectsBeginningWeight, connectsEndingWeight > 0, connectsEndingWeight);
    }
}
