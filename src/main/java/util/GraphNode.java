package util;

import java.util.ArrayList;
import java.util.List;

public class GraphNode {
  public int data;
  public List<GraphNode> adjacent;
  public State state;

  public GraphNode(int d) {
    data = d;
    state = State.Unvisited;
    adjacent = new ArrayList<>();
  }

  public void addAdjacent(GraphNode node) {
    adjacent.add(node);
  }

  public enum State { Unvisited, Visited }
}
