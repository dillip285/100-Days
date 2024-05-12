



public class EnumExample {

    enum Color {
        RED("red"), GREEN("green"), BLUE("blue");
        private String value;

        Color(String value){
            this.value = value;
        }

        public String getValue() {
            return value;
        }
    }
    public static void main(String[] args) {

        for (Color color: Color.values()){
            System.out.println(color.name()+":"+color.getValue());
        }
    }
}