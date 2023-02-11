### 방문처리를 했는데 스택오버플로우 에러가 발생하는 경우

```Java
class Main {

    static final int ROW = 1000, COL = 1000;

    public static void main(String[] args) {
        boolean[][] visited = new boolean[ROW + 1][COL + 1];
        dfs(0, 0, visited);
    }

    private static void dfs(int x, int y, boolean[][] visited) {

        if (x < 0 || x > ROW || y < 0 || y > COL || visited[x][y]) {
            return;
        }

        visited[x][y] = true;

        dfs(x - 1, y, visited);
        dfs(x + 1, y, visited);
        dfs(x, y - 1, visited);
        dfs(x, y + 1, visited);
    }
}

```

<br>

+ 2차원 boolean형 배열에서 깊이 우선 탐색을 하는 경우 중복 방문 처리를 제외한 별도의 가지 치기가 없는 경우 최대 106 * 106 크기의 배열을 스택오버플로우 에러 없이 탐색할 수 있다.
  + 그 이상의 경우 스택이 가득차 스택오버플로우가 발생하므로 필요 시 너비 우선 탐색을 진행하자.
  + 아래의 경우 탐색을 정상적으로 완료

```Java
class Main {

    static final int ROW = 106, COL = 106;

    public static void main(String[] args) {
        boolean[][] visited = new boolean[ROW + 1][COL + 1];
        dfs(0, 0, visited);
    }

    private static void dfs(int x, int y, boolean[][] visited) {

        if (x < 0 || x > ROW || y < 0 || y > COL || visited[x][y]) {
            return;
        }

        visited[x][y] = true;

        dfs(x - 1, y, visited);
        dfs(x + 1, y, visited);
        dfs(x, y - 1, visited);
        dfs(x, y + 1, visited);
    }
}
```
