package olx;

import java.util.*;

public class QueryBuilder {
	List<Filter<Integer>> intFilters = new ArrayList<>();
	List<Filter<String>> stringFilters = new ArrayList<>();

	List<Advertisement> results;
	
	public QueryBuilder() {
		
	}
	public QueryBuilder(List<Advertisement> initialResults) {
		results = initialResults; 
		//It may look like copying the list here is necessary but it is not because the filter methods do not modify 
		//this list.
	}
	
	private void apply() {
		
	}
	public void addIntFilter(Filter<Integer> filter) {
		intFilters.add(filter);
		apply();
	}
	public void addStringFilter(Filter<String> filter) {
		stringFilters.add(filter);
		apply();
	}
	
	
	
	public List<Filter<Integer>> getIntFilters() {
		return intFilters;
	}
	public List<Filter<String>> getStringFilters() {
		return stringFilters;
	}
	
	public List<Advertisement> getResults() {
		return results;
	}
	public void sortByPrice() {
		//tobeimplemened.
	}
	
	public void sortByTime() {
		//tobeimplemented.
	}
}
