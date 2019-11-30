package olx;
import java.util.*;

public class Main {

    public static void main(String[] args) {
    	QueryBuilder builder = new QueryBuilder();
    	Filter<Integer> filter1 = new RangeFilter<>("Pirce", 100, 200);
    	Filter<String> filter2 = new EqualityFilter<>("Category", "Pets");
    	builder.addIntFilter(filter1);
    	builder.addStringFilter(filter2);
    	
    	System.out.println(filter1.check(220));
    	System.out.println(filter2.check("Pets"));
    	
    }
}
