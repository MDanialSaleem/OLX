package olx;

public class RangeFilter<T extends Comparable<T>> extends Filter<T>{

	//BY DEFAULT INCLUSIVE RANGE FILTER
	T up;
	T low;
	public RangeFilter(String name, T low, T up) {
		super(name);
		this.low = low;
		this.up = up;
	}
	
	
	public boolean check(T value) {
		int upcmp = up.compareTo(value);
		int lowcmp = low.compareTo(value);
		
		return lowcmp >=0 && upcmp <= 0;
	}
	
}
