package chromium.proj1;

public class Test {
    public static void main(String[] args) {

    }

}

class Bug {
    int k, l;
}

class M {
    static Bug k;

    public M(Bug m) {
        k = m;
    }
}