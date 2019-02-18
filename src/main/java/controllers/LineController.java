package controllers;

import es.usc.citius.hipster.algorithm.Algorithm;
import es.usc.citius.hipster.algorithm.Hipster;
import es.usc.citius.hipster.graph.GraphBuilder;
import es.usc.citius.hipster.graph.GraphSearchProblem;
import es.usc.citius.hipster.graph.HipsterDirectedGraph;
import es.usc.citius.hipster.model.problem.SearchProblem;
import models.Edge;
import models.Piece;
import utils.Utils;

import java.util.List;

public class LineController {

    private static Utils utils = new Utils();

    /**
     * <p>The method that processes a list of pieces
     * and returns the original document</p>
     * @param  inputList: the list of all the pieces
     * @return originalDocument: String of the original document
     */
    public String processLine(List<String> inputList) {

        // Lets initialize connectionController with the list, like a stateful bean
        ConnectionController connectionController = new ConnectionController(inputList);

        GraphBuilder<String, Integer> graph = GraphBuilder.<String, Integer>create();

        // Find the beginning piece as the piece that has no connections at its beginning
        // If there are many, lets keep the shortest one
        // Do the same for the ending piece
        Integer startingPieceIndex = 0; // start with the first one of the list
        Integer endingPieceIndex = 0; // same as above

        for (int i = 0; i < inputList.size(); i++) {
            // Find any possible connections of the specific piece
            Piece piece = connectionController.findConnectionsForPiece(i);
            // Connect the pieces in a weighted and directed graph, use only the ones that connect at the end
            for (Edge edge : piece.getConnectsTo()) {
                // Use negative weights so to maximize the number of nodes it will pass through
                graph.connect(utils.getPointFromIndex(i)).to(utils.getPointFromIndex(edge.getIndex())).withEdge(edge.getWeight() * -1);
            }
            // To find the Initial Piece, it should start with a capital letter
            if (piece.getConnectsFrom().isEmpty() && Character.isUpperCase(inputList.get(i).charAt(0))) {
                // It is a beginning string, lets check which one is shorter
                if (inputList.get(i).length() < inputList.get(startingPieceIndex).length())
                    startingPieceIndex = i;
            }
            if (piece.getConnectsTo().isEmpty()) {
                if (inputList.get(i).length() < inputList.get(endingPieceIndex).length())
                    endingPieceIndex = i;
            }
        }

        HipsterDirectedGraph<String, Integer> directedGraph = graph.createDirectedGraph();

        // We have the starting point
        SearchProblem p = GraphSearchProblem
                .startingFrom(utils.getPointFromIndex(startingPieceIndex))
                .in(directedGraph)
                .takeCostsFromEdges()
                .build();

        // Use A Star algorigthm as it can work fine with negative weights due to "closed nodes" logic
        Algorithm.SearchResult result = Hipster.createAStar(p).search(utils.getPointFromIndex(endingPieceIndex));
        List<String> resultList = (List<String>) result.getOptimalPaths().get(0);

        // Initialize the Document with the first piece
        String originalDocument = inputList.get(utils.getIndexFromPoint(resultList.get(0)));
        // Then iterate from the second one to connect the pieces
        for (int i = 1; i < resultList.size(); i++) {
            originalDocument = utils.mergeString(originalDocument, inputList.get(utils.getIndexFromPoint(resultList.get(i))));
        }

        return originalDocument;
    }
}