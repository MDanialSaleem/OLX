package com.company;

import java.util.List;

public class Electronics extends Advertisement {
	Condition condition;
	String Make;


	public Electronics( String tittle, int price, String description, Location loc,UserAccount creator, Condition condition, String make) {
		super(tittle, price,"Electronics", description, loc, creator);
		this.condition = condition;
		Make = make;
	}


	public Electronics(int views, int shares, int likes, String tittle, int price, String description, Status status, Location loc, List<Report> rep, AdminAccount admin, UserAccount creator, Condition condition, String make) {
		super(views, shares, likes, tittle, price,"Electronics", description, status, loc, rep, admin, creator);
		this.condition = condition;
		Make = make;
	}

	@Override
	public boolean satisfyQuery(QueryBuilder builder) {

		boolean satisfies = true;
		for(Filter<String> filter : builder.getStringFilters()) {
			if(filter.getName().equalsIgnoreCase("Condition")) {
				satisfies = satisfies && filter.check(this.condition.name());
			}
			if(filter.getName().equalsIgnoreCase("Make")) {
				satisfies = satisfies && filter.check(this.Make);
			}
		}
		return satisfies && super.satisfyQuery(builder);
	}
}
