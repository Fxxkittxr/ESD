import javax.swing.*;
import java.awt.*;
import java.util.List;

class PainelGrafo extends JPanel {
    private final List<List<Integer>> grafo;

    public PainelGrafo(List<List<Integer>> grafo) {
        this.grafo = grafo;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        int V = grafo.size();
        int raio = 200;
        int centroX = getWidth() / 2;
        int centroY = getHeight() / 2;
        Point[] posicoes = new Point[V];

        // Calcula posições em círculo
        for (int i = 0; i < V; i++) {
            double ang = 2 * Math.PI * i / V;
            int x = (int) (centroX + raio * Math.cos(ang));
            int y = (int) (centroY + raio * Math.sin(ang));
            posicoes[i] = new Point(x, y);
        }

        // Desenha arestas
        g.setColor(Color.BLACK);
        for (int i = 0; i < V; i++) {
            for (int j : grafo.get(i)) {
                if (i < j) {
                    g.drawLine(posicoes[i].x, posicoes[i].y, posicoes[j].x, posicoes[j].y);
                }
            }
        }

        // Desenha vértices
        for (int i = 0; i < V; i++) {
            int x = posicoes[i].x;
            int y = posicoes[i].y;
            g.setColor(Color.BLUE);
            g.fillOval(x - 15, y - 15, 30, 30);
            g.setColor(Color.WHITE);
            g.drawString(String.valueOf(i), x - 5, y + 5);
        }
    }
}
