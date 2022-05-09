public class CompareUser implements Comparable<CompareUser>{
    private String name;

    public CompareUser(String userName){
        name = userName;
    }

    @Override
    public int compareTo(CompareUser o) {
        int compareInt = this.name.compareTo(o.name);
        if(compareInt<0){
            return -1;
        }
        if(compareInt>0){
            return 1;
        }
        return 0;
    }

    public String getUserName(){
        return name;
    }
}
