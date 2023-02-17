public class Main {
      /**
     * Input Process - Only Positive Integer
     * @see <a href="https://blog.naver.com/jihogrammer/222281999239">...</a>
     */
    private static int read() throws Exception {
        int c, n = System.in.read() - 48;
        while ((c = System.in.read()) > 32) n = 10 * n + c - 48;
        return n;
    }
}
