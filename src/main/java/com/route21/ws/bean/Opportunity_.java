package com.route21.ws.bean;

import java.util.Date;

import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(Opportunity.class)
public class Opportunity_ {
	
	public static volatile SingularAttribute<Opportunity, Long> id;
	public static volatile SingularAttribute<Opportunity, Party> party;
	public static volatile SingularAttribute<Opportunity, String> title;
	public static volatile SingularAttribute<Opportunity, String> location;
	public static volatile SingularAttribute<Opportunity, String> desiredSkills;
	public static volatile SingularAttribute<Opportunity, String> type;
	public static volatile SingularAttribute<Opportunity, Category> category;
	public static volatile SingularAttribute<Opportunity, OpportunityType> opportunityType;
	public static volatile SingularAttribute<Opportunity, String> status;
	public static volatile SingularAttribute<Opportunity, String> role;
	public static volatile SingularAttribute<Opportunity, String> department;
	public static volatile SingularAttribute<Opportunity, Double> minWage;
	public static volatile SingularAttribute<Opportunity, String> liveOrFuture;
	public static volatile SingularAttribute<Opportunity, Date> startDate;
	public static volatile SingularAttribute<Opportunity, Date> endDate;
	public static volatile SingularAttribute<Opportunity, String> duration;
	public static volatile SingularAttribute<Opportunity, Qualification> qualification;
	public static volatile SingularAttribute<Opportunity, Long> minAge;
	public static volatile SingularAttribute<Opportunity, String> howToApply;
	public static volatile SingularAttribute<Opportunity, String> linkRef;
	public static volatile SingularAttribute<Opportunity, String> description;
	

}
