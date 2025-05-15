import java.util.*;

public class Main {

    public static boolean ehGrafoNaoDirecionadoValido(List<List<Integer>> grafo) {
        int V = grafo.size();

        for (int no = 0; no < V; no++) {
            Set<Integer> vizinhos = new HashSet<>();

            for (int adj : grafo.get(no)) {
                if (adj < 0 || adj >= V) {
                    System.out.println("Erro: Nó " + adj + " inválido.");
                    return false;
                }

                if (adj == no) {
                    System.out.println("Erro: Auto-loop detectado no nó " + no);
                    return false;
                }

                if (!vizinhos.add(adj)) {
                    System.out.println("Erro: Aresta duplicada no nó " + no);
                    return false;
                }

                if (!grafo.get(adj).contains(no)) {
                    System.out.println("Erro: Conexão não bidirecional entre " + no + " e " + adj);
                    return false;
                }
            }
        }

        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite o número de vértices: ");
        int V = scanner.nextInt();
        scanner.nextLine(); // limpar buffer

        List<List<Integer>> grafo = new ArrayList<>();

        for (int i = 0; i < V; i++) {
            System.out.print("Digite os vizinhos do vértice " + i + " (separados por espaço): ");
            String linha = scanner.nextLine().trim();
            List<Integer> vizinhos = new ArrayList<>();

            if (!linha.isEmpty()) {
                String[] partes = linha.split("\\s+");
                for (String p : partes) {
                    vizinhos.add(Integer.parseInt(p));
                }
            }

            grafo.add(vizinhos);
        }

        boolean resultado = ehGrafoNaoDirecionadoValido(grafo);
        System.out.println("O grafo é válido? " + (resultado ? "Sim" : "Não"));

        scanner.close();
    }
}
