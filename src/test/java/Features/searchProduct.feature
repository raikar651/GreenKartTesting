Feature: Search and Place order for Products
	
	@OffersPage
	Scenario Outline: Search Experience for product search in both home are offer page
		Given User is on GreenCart Landing Page
		When User searched with shortname <Name> and extracted actual name of product
		Then User searched for <Name> shortname in offer page
		And Validate the product in landing page and offer page are same or not
		
		
		
		Examples:
			| Name |
			| Tom  |
			| Beet |