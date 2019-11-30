package olx;

import java.util.*;

public class QueryBuilder {
	List<Filter<? extends Comparable<?>>> filters = new ArrayList<>();
	List<Advertisement> results;
	
	public QueryBuilder(List<Advertisement> initialResults) {
		results = initialResults; 
		//It may look like copying the list here is necessary but it is not because the filter methods do not modify 
		//this list.
	}
	
	private void apply() {
		
	}
	public void addIntFilter(Filter<? extends Comparable<?>> filter) {
		filters.add(filter);
		apply();
	}
	public void removeFilter(Filter<? extends Comparable<?>> filter)
	{
		filters.remove(filter);
		apply();
	}
	
	
	
	public void sortByPrice() {
		//tobeimplemened.
	}
	
	public void sortByTime() {
		//tobeimplemented.
	}
}
